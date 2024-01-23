from stack import Stack
from refBinTree import BinaryTree


def postbuildParseTree(fpexp):
    pStack = Stack()
    eTree = BinaryTree('')
    pStack.push(eTree)

    for c in fpexp:

        if is_operator(c):
            tempTree = BinaryTree(c)
            tempTree.rightChild = pStack.pop()
            tempTree.leftChild = pStack.pop()

            pStack.push(tempTree)

        elif is_function(c):
            tempTree = BinaryTree(c)
            tempTree.rightChild = pStack.pop()

            pStack.push(tempTree)

        else:
            pStack.push(BinaryTree(c))

    return tempTree


def diffTree(parseTree, var):
    current = parseTree.getRootVal()
    F = parseTree.leftChild
    G = parseTree.rightChild

    if current == '+' or current == '-':
        tempTree = BinaryTree(current)
        tempTree.leftChild = diffTree(F, var)
        tempTree.rightChild = diffTree(G, var)
        return tempTree

    elif current == '*':
        tempTree = BinaryTree('+')
        tempTree.insertLeft('*')
        tempTree.insertRight('*')
        tempTree.leftChild.leftChild = diffTree(F, var)
        tempTree.leftChild.rightChild = G
        tempTree.rightChild.leftChild = F
        tempTree.rightChild.rightChild = diffTree(G, var)
        return tempTree

    elif current == '/':
        tempTree1 = BinaryTree('-')
        tempTree1.insertLeft('*')
        tempTree1.insertRight('*')
        tempTree1.leftChild.leftChild = diffTree(F, var)
        tempTree1.leftChild.rightChild = G
        tempTree1.rightChild.leftChild = F
        tempTree1.rightChild.rightChild = diffTree(G, var)

        tempTree2 = BinaryTree('^')
        tempTree2.leftChild = G
        tempTree2.insertRight('2')

        tempTree = BinaryTree('/')
        tempTree.leftChild = tempTree1
        tempTree.rightChild = tempTree2

        return tempTree

    elif current == "sin":
        tempTree = BinaryTree('*')
        tempTree.insertLeft('cos')
        tempTree.leftChild.rightChild = G
        tempTree.rightChild = diffTree(G, var)
        return tempTree

    elif current == "cos":
        tempTree = BinaryTree('-')
        tempTree.insertLeft('0')
        tempTree.insertRight('*')
        tempTree.rightChild.insertLeft('sin')
        tempTree.rightChild.leftChild.rightChild = G
        tempTree.rightChild.rightChild = diffTree(G, var)
        return tempTree

    elif current == "tan":
        tempTree = BinaryTree('/')
        tempTree.leftChild = diffTree(G, var)
        tempTree.insertRight('^')
        tempTree.rightChild.insertLeft('cos')
        tempTree.rightChild.leftChild.rightChild = G
        tempTree.rightChild.insertRight('2')
        return tempTree

    elif current == "exp":
        tempTree = BinaryTree('*')
        tempTree.insertLeft('exp')
        tempTree.leftChild.rightChild = G
        tempTree.rightChild = diffTree(G, var)
        return tempTree

    elif current == "log":
        tempTree = BinaryTree('/')
        tempTree.leftChild = diffTree(G, var)
        tempTree.rightChild = G

        return tempTree

    elif current == "^":
        tempTree1 = BinaryTree('*')
        tempTree1.insertLeft('^')
        tempTree1.insertRight('*')
        tempTree1.leftChild.leftChild = F
        tempTree1.leftChild.rightChild = G
        tempTree1.rightChild.leftChild = diffTree(G, var)
        tempTree1.rightChild.insertRight('log')
        tempTree1.rightChild.rightChild.rightChild = F

        tempTree2 = BinaryTree('*')
        tempTree2.leftChild = G
        tempTree2.insertRight('*')
        tempTree2.rightChild.leftChild = diffTree(F, var)
        tempTree2.rightChild.insertRight('^')
        tempTree2.rightChild.rightChild.leftChild = F
        tempTree2.rightChild.rightChild.insertRight('-')
        tempTree2.rightChild.rightChild.rightChild.leftChild = G
        tempTree2.rightChild.rightChild.rightChild.insertRight('1')

        tempTree = BinaryTree('+')
        tempTree.leftChild = tempTree1
        tempTree.rightChild = tempTree2

        return tempTree

    elif current == var:
        return BinaryTree('1')

    else:
        return BinaryTree('0')


def infixTree(tree):
    if is_operator(tree.getRootVal()):
        if tree.getRootVal() == '-' and tree.leftChild.getRootVal() == '0':
            return "(" + tree.getRootVal() + infixTree(tree.rightChild) + ")"
        else:
            return "(" + infixTree(tree.leftChild) + tree.getRootVal() + infixTree(tree.rightChild) + ")"
    elif is_function(tree.getRootVal()):
        return tree.getRootVal() + "(" + infixTree(tree.rightChild) + ")"
    else:
        return tree.getRootVal()


def postfix(expr):
    stack = []
    queue = []

    for i in range(len(expr)):
        token = expr[i]
        if not is_operator(token) and not is_function(token) and not is_symbol(token):
            queue.append(token)
        elif is_operator(token):

            while precedence(token, stack):
                queue.append(stack[-1])
                stack.pop(-1)
            stack.append(token)
        elif is_function(token):
            stack.append(token)

        elif is_symbol(token):

            if token in ["(", "["]:
                stack.append(token)
            else:
                while not (stack[-1] in ["(", "["]):
                    queue.append(stack[-1])
                    stack.pop(-1)
                stack.pop(-1)
                if not (not stack):
                    while is_function(stack[-1]):
                        queue.append(stack[-1])
                        stack.pop(-1)
                        if (not stack):
                            break

    while not (not stack):
        queue.append(stack[-1])
        stack.pop(-1)
    return queue


def simplifyTree(parseTree):

    if not isinstance(parseTree, BinaryTree):
        return parseTree

    else:
        current = parseTree.getRootVal()
        LTree = parseTree.leftChild
        RTree = parseTree.rightChild

        if is_function(current):
            tempTree = BinaryTree(current)
            tempTree.rightChild = simplifyTree(RTree)

            return tempTree

        else:
            if current == '*':
                if LTree.getRootVal() == '1':
                    return simplifyTree(RTree)
                elif RTree.getRootVal() == '1':
                    return simplifyTree(LTree)
                elif LTree.getRootVal() == '0':
                    return BinaryTree('0')
                elif RTree.getRootVal() == '0':
                    return BinaryTree('0')
                elif is_operand(LTree.getRootVal()) and is_operand(RTree.getRootVal()) and RTree.getRootVal() == LTree.getRootVal():
                    tempTree = BinaryTree('^')
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.insertRight('2')
                    return tempTree
                else:
                    tempTree = BinaryTree(current)
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.rightChild = simplifyTree(RTree)
                    return tempTree

            if current == '/':
                if RTree.getRootVal() == '1':
                    return simplifyTree(LTree)
                elif LTree.getRootVal() == '0':
                    return BinaryTree('0')
                else:
                    tempTree = BinaryTree(current)
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.rightChild = simplifyTree(RTree)
                    return tempTree

            elif current == '+':
                if isinstance(LTree.getRootVal(), str) and isinstance(RTree.getRootVal(), str) and LTree.getRootVal().isnumeric() and RTree.getRootVal().isnumeric():
                    return BinaryTree(str(int(LTree.getRootVal())+int(RTree.getRootVal())))
                elif LTree.getRootVal() == '0':
                    return simplifyTree(RTree)
                elif RTree.getRootVal() == '0':
                    return simplifyTree(LTree)
                elif is_operand(LTree.getRootVal()) and is_operand(RTree.getRootVal()) and RTree.getRootVal() == LTree.getRootVal():
                    tempTree = BinaryTree('*')
                    tempTree.insertLeft('2')
                    tempTree.rightChild = simplifyTree(LTree)
                    return tempTree
                else:
                    tempTree = BinaryTree(current)
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.rightChild = simplifyTree(RTree)
                    return tempTree

            elif current == '-':
                if isinstance(LTree.getRootVal(), str) and isinstance(RTree.getRootVal(), str) and LTree.getRootVal().isnumeric() and RTree.getRootVal().isnumeric() and int(LTree.getRootVal()) >= int(RTree.getRootVal()):
                    return BinaryTree(str(int(LTree.getRootVal())-int(RTree.getRootVal())))
                if isinstance(LTree.getRootVal(), str) and isinstance(RTree.getRootVal(), str) and LTree.getRootVal().isnumeric() and RTree.getRootVal().isnumeric() and int(LTree.getRootVal()) < int(RTree.getRootVal()):
                    tempTree = BinaryTree('-')
                    tempTree.insertLeft('0')
                    tempTree.insertRight(
                        str(int(RTree.getRootVal())-int(LTree.getRootVal())))
                    return tempTree
                if LTree.getRootVal() == '0' and RTree.getRootVal() == '0':
                    return BinaryTree('0')
                if RTree.getRootVal() == '0':
                    return simplifyTree(LTree)
                else:
                    tempTree = BinaryTree(current)
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.rightChild = simplifyTree(RTree)
                    return tempTree

            elif current == '^':
                if RTree.getRootVal() == '1':
                    return simplifyTree(LTree)
                if LTree.getRootVal() == '1':
                    return BinaryTree('1')
                elif RTree.getRootVal() == '0':
                    return BinaryTree('1')
                elif LTree.getRootVal() == '0':
                    return BinaryTree('0')
                else:
                    tempTree = BinaryTree(current)
                    tempTree.leftChild = simplifyTree(LTree)
                    tempTree.rightChild = simplifyTree(RTree)
                    return tempTree

            else:
                tempTree = BinaryTree(current)
                tempTree.leftChild = simplifyTree(LTree)
                tempTree.rightChild = simplifyTree(RTree)
                return tempTree


def identicalTrees(a, b):
    # 1. Both empty
    if a is None and b is None:
        return True
    # 2. Both non-empty -> Compare them
    if a is not None and b is not None:
        return ((a.getRootVal() == b.getRootVal()) and
                identicalTrees(a.leftChild, b.leftChild) and
                identicalTrees(a.rightChild, b.rightChild))

    # 3. one empty, one not -- false
    return False

##################################################################################################
# Funciones Auxiliares
##################################################################################################


def is_operand(car):
    operand_list = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    if car in operand_list:
        return 1
    else:
        return 0


def is_operator(car):
    operator_list = ["+", "-", "*", "/", "^"]
    if car in operator_list:
        return 1
    else:
        return 0


def is_function(car):
    function_list = ["cos", "sin", "tan", "exp", "log"]
    if car in function_list:
        return 1
    else:
        return 0


def is_symbol(car):
    symbol_list = ["(", ")", "[", "]"]
    if car in symbol_list:
        return 1
    else:
        return 0


def precedence(token, stack):
    if not stack:
        return 0
    else:
        element = [token, stack[-1]]
        priority = [0, 0]

        for i in range(len(element)):
            if element[i] == "^":
                priority[i] = 4
            elif element[i] in ["*", "/"]:
                priority[i] = 3
            elif element[i] in ["+", "-"]:
                priority[i] = 2

        if priority[1] >= priority[0]:
            return 1
        else:
            return 0

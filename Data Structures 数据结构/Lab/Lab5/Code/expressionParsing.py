from stack import *
from refBinTree import *
import operator


def buildParseTree(fpexp):
    fplist = fpexp.split()
    pStack = Stack()
    eTree = BinaryTree('')
    pStack.push(eTree)
    currentTree = eTree
    for i in fplist:
        if i == '(':
            currentTree.insertLeft('')
            pStack.push(currentTree)
            currentTree = currentTree.getLeftChild()
        elif i in 'abcdefghijklmnopqrstuvwxyz':
            currentTree.setRootVal(i)
            parent = pStack.pop()
            currentTree = parent
        elif i in '+-*/':
            currentTree.setRootVal(i)
            currentTree.insertRight('')
            pStack.push(currentTree)
            currentTree = currentTree.getRightChild()
        elif i == ')':
            currentTree = pStack.pop()
        else:
            currentTree.setRootVal(eval(i))
            parent = pStack.pop()
            currentTree = parent
    return eTree


def evaluate(parseTree):
    opers = {'+': operator.add, '-': operator.sub,
             '*': operator.mul, '/': operator.truediv}
    leftC = parseTree.getLeftChild()
    rightC = parseTree.getRightChild()

    if leftC and rightC:
        fn = opers[parseTree.getRootVal()]
        return fn(evaluate(leftC), evaluate(rightC))
    else:
        return parseTree.getRootVal()


def postOrderEvaluate(parseTree):
    opers = {'+': operator.add, '-': operator.sub,
             '*': operator.mul, '/': operator.truediv}
    res1 = None
    res2 = None
    if parseTree:
        res1 = postOrderEvaluate(parseTree.getLeftChild())
        res2 = postOrderEvaluate(parseTree.getRightChild())
        if res1 and res2:
            return opers[parseTree.getRootVal()](res1, res2)
        else:
            return parseTree.getRootVal()


def printExpression(ParseTree):
    sVal = ""
    if ParseTree:
        sVal = '(' + printExpression(ParseTree.getLeftChild())
        sVal = sVal + str(ParseTree.getRootVal())
        sVal = sVal + printExpression(ParseTree.getRightChild()) + ')'
    return sVal
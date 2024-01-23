def preOrder(tree):
    if tree:
        print(tree.getRootVal(), end=' ')
        preOrder(tree.getLeftChild())
        preOrder(tree.getRightChild())


def inOrder(tree):
    if tree != None:
        inOrder(tree.getLeftChild())
        print(tree.getRootVal(), end=' ')
        inOrder(tree.getRightChild())


def postOrder(tree):
    if tree != None:
        postOrder(tree.getLeftChild())
        postOrder(tree.getRightChild())
        print(tree.getRootVal(), end=' ')

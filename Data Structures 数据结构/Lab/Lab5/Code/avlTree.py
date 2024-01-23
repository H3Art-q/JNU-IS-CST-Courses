from binarySearchTree import *


class AVLTree(BinarySearchTree):
    def __init__(self):
        super(AVLTree, self).__init__()

    def leftRotate(self, currentNode):
        if not currentNode:
            return
        newRoot = currentNode.rightChild
        currentNode.rightChild = newRoot.leftChild
        if newRoot.leftChild:
            newRoot.leftChild.parent = currentNode

        if currentNode.isLeftChild():
            newRoot.parent = currentNode.parent
            currentNode.parent.leftChild = newRoot
        elif currentNode.isRightChild():
            newRoot.parent = currentNode.parent
            currentNode.parent.rightChild = newRoot
        else:
            newRoot.parent = None
            self.root = newRoot

        newRoot.leftChild = currentNode
        currentNode.parent = newRoot

        currentNode.balanceFactor = currentNode.balanceFactor - \
            min(0, newRoot.balanceFactor) + 1
        newRoot.balanceFactor = newRoot.balanceFactor + \
            max(currentNode.balanceFactor, 0) + 1

    def rightRotate(self, currentNode):
        if not currentNode:
            return
        newRoot = currentNode.leftChild
        currentNode.leftChild = newRoot.rightChild
        if newRoot.rightChild:
            newRoot.rightChild.parent = currentNode

        if currentNode.isLeftChild():
            newRoot.parent = currentNode.parent
            currentNode.parent.leftChild = newRoot
        elif currentNode.isRightChild():
            newRoot.parent = currentNode.parent
            currentNode.parent.rightChild = newRoot
        else:
            newRoot.parent = None
            self.root = newRoot

        newRoot.rightChild = currentNode
        currentNode.parent = newRoot

        currentNode.balanceFactor = currentNode.balanceFactor - \
            max(newRoot.balanceFactor, 0) - 1
        newRoot.balanceFactor = newRoot.balanceFactor + \
            min(0, currentNode.balanceFactor) - 1

    def _put(self, key, value, currentNode: TreeNode):
        if key == currentNode.key:
            currentNode.value = value
        elif key < currentNode.key:
            if not currentNode.hasLeftChild():
                currentNode.leftChild = TreeNode(
                    key, value, parent=currentNode)
                self.put_updateBalanceFactor(currentNode.leftChild)
            else:
                currentNode = currentNode.leftChild
                self._put(key, value, currentNode)
        else:
            if not currentNode.hasRightChild():
                currentNode.rightChild = TreeNode(
                    key, value, parent=currentNode)
                self.put_updateBalanceFactor(currentNode.rightChild)
            else:
                currentNode = currentNode.rightChild
                self._put(key, value, currentNode)

    def put_updateBalanceFactor(self, currentNode):
        if currentNode.balanceFactor > 1 or currentNode.balanceFactor < -1:
            self.put_rotateTree(currentNode)
            return

        if not currentNode.isRoot():
            if currentNode.isLeftChild():
                currentNode.parent.balanceFactor += 1
            else:
                currentNode.parent.balanceFactor -= 1
            if currentNode.parent.balanceFactor != 0:
                self.put_updateBalanceFactor(currentNode.parent)

    def put_rotateTree(self, currentNode):
        if currentNode.balanceFactor > 1:
            if currentNode.leftChild.balanceFactor >= 0:    # 情况1：直接右旋
                self.rightRotate(currentNode)
            else:                                    # 情况2：先左旋右子树，再右旋当前树
                self.leftRotate(currentNode.rightChild)
                self.rightRotate(currentNode)
        elif currentNode.balanceFactor < -1:
            if currentNode.rightChild.balanceFactor <= 0:   # 情况3：直接左旋
                self.leftRotate(currentNode)
            else:
                self.rightRotate(currentNode.leftChild)     # 情况4：先右旋左子树，再左旋当前树
                self.leftRotate(currentNode)

    def delete(self, key):
        if not self.root:  # 空树
            raise KeyError("It is empty bts!")
        if self.size == 1:  # 只有根节点
            if self.root.key == key:
                self.root = None
                self.size = 0
            else:
                raise KeyError("No key in the bts!")
        else:
            currentNode = self._get(key, self.root)
            if not currentNode:  # 未找到key
                raise KeyError("No key in the bts!")
            elif currentNode.isLeaf():  # 叶子节点,且肯定不为根节点，因此肯定有父节点
                if currentNode.isLeftChild():
                    currentNode.parent.leftChild = None
                    self.delete_updateBalanceFactor(currentNode)
                else:
                    currentNode.parent.rightChild = None
                    self.delete_updateBalanceFactor(currentNode)
            elif not currentNode.hasBothChildren():  # 只有一个子树
                if currentNode.hasLeftChild():  # 情况1：只有左子树,且子树只有1个根节点
                    if currentNode.isRoot():  # 情况1.1：情况当前节点为根节点
                        currentNode.replaceNodeData(currentNode.leftChild.key, currentNode.leftChild.value,
                                                    currentNode.leftChild.leftChild, currentNode.leftChild.rightChild)
                    elif currentNode.isLeftChild():  # 情况1.2：当前节点为左节点
                        currentNode.parent.leftChild = currentNode.leftChild
                        currentNode.leftChild.parent = currentNode.parent
                        self.delete_updateBalanceFactor(currentNode)
                    else:  # 情况1.3：当前节点右节点
                        currentNode.parent.rightChild = currentNode.leftChild
                        currentNode.leftChild.parent = currentNode.parent
                        self.delete_updateBalanceFactor(currentNode)
                else:  # 情况2：只有右子树
                    if currentNode.isRoot():  # 情况2.1：情况当前节点为根节点
                        currentNode.replaceNodeData(currentNode.rightChild.key, currentNode.rightChild.value,
                                                    currentNode.rightChild.leftChild, currentNode.rightChild.rightChild)
                    elif currentNode.isLeftChild():  # 情况1.2：当前节点为左节点
                        currentNode.parent.leftChild = currentNode.rightChild
                        currentNode.rightChild.parent = currentNode.parent
                        self.delete_updateBalanceFactor(currentNode)
                    else:  # 情况1.3：当前节点为右节点
                        currentNode.parent.rightChild = currentNode.rightChild
                        currentNode.rightChild.parent = currentNode.parent
                        self.delete_updateBalanceFactor(currentNode)
            else:  # 存在左右两棵子树，所以其后继节点必然为右子树上的最小值
                successor = self._findSuccessor(currentNode)  # 该后继节点最多只有一棵子树
                if successor.isLeaf():  # 叶子节点
                    if successor.isLeftChild():
                        successor.parent.leftChild = None
                    else:
                        successor.parent.rightChild = None
                else:  # 左子树的最低层左节点，或者右子树的根节点
                    successor.parent.rightChild = successor.rightChild
                    successor.rightChild.parent = successor.parent
                currentNode.replaceNodeData(
                    successor.key, successor.value, currentNode.leftChild, currentNode.rightChild)
                self.delete_updateBalanceFactor(successor)   # 物理本质上真正删除的是后继节点
            self.size -= 1

    def delete_updateBalanceFactor(self, currentNode):
        if not currentNode.isRoot():
            if currentNode.isLeftChild():
                currentNode.parent.balanceFactor -= 1
            else:
                currentNode.parent.balanceFactor += 1
            if currentNode.parent.balanceFactor == 0:
                self.delete_updateBalanceFactor(currentNode.parent)
            if currentNode.parent.balanceFactor < -1 or currentNode.parent.balanceFactor > 1:
                self.delete_rotateTree(currentNode.parent)
                self.delete_updateBalanceFactor(
                    currentNode.parent.parent)    # 经过旋转，当前节点的父节点变为了新的孩子节点
        if currentNode.balanceFactor in [1, -1]:       # 主要顺序，要先更新父节点平衡因子
            return

    def delete_rotateTree(self, currentNode):
        if currentNode.balanceFactor > 1:
            self.rightRotate(currentNode)
        elif currentNode.balanceFactor < -1:
            self.leftRotate(currentNode)

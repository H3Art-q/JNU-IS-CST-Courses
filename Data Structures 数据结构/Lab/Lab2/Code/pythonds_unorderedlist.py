from unorderedlist import *


class Stack_unordlist:
    def __init__(self):
        self.items = UnorderedList()

    def isEmpty(self):
        return self.items.isEmpty()

    def push(self, item):
        self.items.add(item)

    def pop(self):
        return self.items.pop(0)

    def peek(self):
        return self.items.head.getData()

    def size(self):
        return self.items.length()
    
    def travel(self):
        self.items.travel()


class Queue_unordlist:
    def __init__(self):
        self.items = UnorderedList()

    def isEmpty(self):
        return self.items.isEmpty()

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        return self.items.pop(0)

    def size(self):
        return self.items.length()

    def travel(self):
        self.items.travel()


class Deque_unordlist:
    def __init__(self):
        self.items = UnorderedList()

    def isEmpty(self):
        return self.items.isEmpty()

    def addFront(self, item):
        self.items.add(item)

    def addRear(self, item):
        self.items.append(item)

    def removeFront(self):
        return self.items.pop(0)

    def removeRear(self):
        return self.items.pop()

    def size(self):
        return self.items.length()

    def travel(self):
        self.items.travel()

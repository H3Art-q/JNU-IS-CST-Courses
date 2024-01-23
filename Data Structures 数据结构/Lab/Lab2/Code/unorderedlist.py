class Node:
    def __init__(self, initdata):
        self.data = initdata
        self.next = None

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def setData(self, newdata):
        self.data = newdata

    def setNext(self, newnext):
        self.next = newnext


class UnorderedList:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    def add(self, item):
        temp = Node(item)
        temp.setNext(self.head)
        self.head = temp

    def length(self):
        current = self.head
        count = 0
        while current != None:
            count = count + 1
            current = current.getNext()
        return count

    def search(self, item):
        current = self.head
        found = False
        while current != None and not found:
            if current.getData() == item:
                found = True
            else:
                current = current.getNext()
        return found

    def remove(self, item):
        current = self.head
        previous = None
        found = False
        while not found:
            if current.getData() == item:
                found = True
            else:
                previous = current
                current = current.getNext()
        if found == True:
            if previous == None:
                self.head = current.getNext()
            else:
                previous.setNext(current.getNext())
        else:
            print("Item isn' t in the list")

    def append(self, item):
        temp = Node(item)
        if self.isEmpty():
            self.head = temp
        else:
            current = self.head
            while current.getNext() != None:
                current = current.getNext()
            current.setNext(temp)

    def index(self, item):
        current = self.head
        found = False
        pos = 0
        while current != None and not found:
            if current.getData() == item:
                found = True
            else:
                current = current.getNext()
                pos = pos + 1
        if found == True:
            return pos
        else:
            print("Item isn' t in the list")

    def pop(self, pos=''):
        if pos == '':
            current = self.head
            previous = None
            while current.getNext() != None:
                previous = current
                current = current.getNext()
            if previous == None:
                self.head = current.getNext()
            else:
                previous.setNext(current.getNext())
            return current.getData()
        elif pos > self.length() - 1 or pos < 0:
            print("This index is out of range")
        else:
            current = self.head
            previous = None
            while pos > 0:
                previous = current
                current = current.getNext()
                pos = pos - 1
            if previous == None:
                self.head = current.getNext()
            else:
                previous.setNext(current.getNext())
            return current.getData()

    def insert(self, pos, item):
        if pos > self.length() - 1 or pos < 0:
            print("This index is out of range")
        else:
            temp = Node(item)
            current = self.head
            previous = None
            while pos > 0:
                previous = current
                current = current.getNext()
                pos = pos - 1
            if previous == None:
                self.head = temp
            else:
                previous.setNext(temp)
            temp.setNext(current)

    def travel(self):
        print('[', end='')
        current = self.head
        while current.getNext() != None:
            print(current.getData(), end=', ')
            current = current.getNext()
        print(current.getData(), end='')
        print(']')

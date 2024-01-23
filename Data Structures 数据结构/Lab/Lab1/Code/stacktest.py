from pythonds import Stack
from pythonds import Stack_modified
import time


s1 = Stack()
start = time.time()
for i in range(100000):
    s1.push(i)
while not s1.isEmpty():
    s1.pop()
print("Time used:", time.time() - start, "s")


s2 = Stack_modified()
start = time.time()
for i in range(100000):
    s2.push(i)
while not s2.isEmpty():
    s2.pop()
print("Time used:", time.time() - start, "s")

# 实验一

## 一. 背景知识
算法分析、大O描述法、栈、python语言描述


## 二. 目的要求
1. 针对python列表和字典的常见操作
2. 理解用大O符号表示的执行时间
3. 理解python数据的实现如何影响算法分析
4. 掌握python中栈的实现
5. 理解如何对简单的python程序进行基准测试


## 三. 实验内容
1. 计算前n个整数之和
a)调用time()函数测试计算不同数量级所需运行时间
b)不使用循环操作时，进行上述操作所需运行时间
2. 异序词（变位词）检测：假设要检查的两个字符串长度相同，并且都是由26个英文字母的小写形式组成
a)使用计数法（逐字检查）实现
b)使用排序法实现
c)使用暴力法实现
d)使用计数法实现
3. 用python实现栈，并包含以下方法：判空isEmpty()、进栈push()、出栈pop()、查看栈顶元素peek()、查看栈大小size()
4. 将列表的头部作为栈顶，实现栈的相关操作
5. 实现括号匹配算法
6. 实现将十进制转化成二进制的算法
7. 实现将中序表达式转换成后序表达式的算法


### 进阶：
1. 在5、6、7的基础上，实现：包含“[]”、“{}”的括号匹配；任意进制间的互相转化；后序表达式的计算。
2. 除了本章所举的例子，HTML中也存在括号匹配问题。标签有开始和结束两种形式，并且需要互相匹配才能正确描述网页内容。下面是简单的HTML文档，用于展示标签的匹配和嵌套。写一个程序来检查HTML文档中的标签是否正确匹配。
```html
<html>
    <head>
        <title>
            Example
        </title>
    </head>

    <body>
        <h1>hello, world</h1>
    </body>
</html>
```


## 四. 测试过程
1. 计算前n个整数之和
- 使用循环操作的代码：
```python
def SumofN_loop(n): 
    sumofn = 0 
    for i in range(1, n+1): 
        sumofn = sumofn + i 
return sumofn
```

- 不使用循环操作的代码：
```python
def SumofN_formula(n): 
    return (n * (n + 1)) / 2
```

- 调用time()函数测试计算不同数量级所需运行时间的代码
```python
import time 

def SumofN_loop(n):
    start = time.time()
    sumofn = 0
    for i in range(1, n+1):
        sumofn = sumofn + i
    end = time.time()
    return sumofn, end - start
    # 返回值是一个tuple


def SumofN_formula(n):
    start = time.time()
    return (n * (n + 1)) / 2, time.time() - start
```

2. 异序词（变位词）检测：假设要检查的两个字符串长度相同，并且都是由26个英文字母的小写形式组成
- 使用计数法（逐字检查）实现的代码
```python
def AnagramJudge1(str1, str2):
    if len(str1) != len(str2):
        return False
    strlist = list(str1)
    position1 = 0
    status = True
    while position1 < len(str2) and status:
        position2 = 0
        found = False
        while position2 < len(strlist) and not found: 
            if str2[position1] == [position2]: 
                found = True 
            else: 
                position2 = position2 + 1 
            if found: 
                strlist[position2] = None 
            else: 
                status = False 
            position1 = position1 + 1 
    return status
```

- 使用排序法实现的代码
```python
def AnagramJudge2(str1, str2):
    if len(str1) != len(str2):
        return False
    strlist1 = list(str1)
    strlist2 = list(str2)
    strlist1.sort()
    strlist2.sort()
    position = 0
    status = True
    while position < len(strlist1) and status:
        if strlist1[position] == strlist2[position]:
            position = position + 1
        else:
            status = False
    return status
```

- 使用暴力法实现的代码
```python
import itertools
# 用迭代器求全排列

def AnagramJudge3(str1, str2):
    strlist = list(str1)
    strlen = len(str1)
    for possibility in itertools.permutations(strlist, strlen):
        if str2 == "".join(possibility):
            return True
    return False
```

- 使用计数法实现的代码
```python
def AnagramJudge4(str1, str2): 
    if len(str1) != len(str2):
        return False
    bucket1 = [0] * 26 
    bucket2 = [0] * 26 
    for i in range(len(str1)): 
        position = ord(str1[i]) - ord('a') 
        bucket1[position] = bucket1[position] + 1 
    for i in range(len(str2)): 
        position = ord(str2[i]) - ord('a') 
        bucket2[position] = bucket2[position] + 1 
    letter = 0
    status = True
    while letter < 26 and status: 
        if bucket1[letter] == bucket2[letter]:
            letter = letter + 1 
        else: 
            status = False 
    return status
```

3. 用python实现栈，并包含以下方法：判空isEmpty()、进栈push()、出栈pop()、查看栈顶元素peek()、查看栈大小size()
```python
class Stack: 
    def __init__(self): 
        self.items = [] 
    def isEmpty(self): 
        return self.items == [] 
    def push(self, item): 
        self.items.append(item) 
    def pop(self): 
        return self.items.pop()
    def peek(self): 
        return self.items[len(self.items)-1] 
    def size(self):
        return len(self.items)
```

4. 将列表的头部作为栈顶，实现栈的相关操作
```python
class Stack: 
    def __init__(self): 
        self.items = [] 
    def isEmpty(self): 
        return self.items == [] 
    def push(self, item): 
        self.items.insert(0, item) 
    def pop(self): 
        return self.items.pop(0) 
    def peek(self): 
        return self.items[0] 
    def size(self): 
        return len(self.items)
```

5. 实现括号匹配算法
```python
from pythonds import Stack 

def ParChecker(symbolString): 
    s = Stack() 
    balanced = True 
    index = 0 
    while index < len(symbolString) and balanced:
        symbol = symbolString[index] 
        if symbol == "(": 
            s.push(symbol) 
        else: 
            if s.isEmpty(): 
                balanced = False 
            else: 
                s.pop() 
        index = index + 1 
    if balanced and s.isEmpty(): 
        return True 
    else: 
        return False
```

6. 实现将十进制转化成二进制的算法
```python
from pythonds import Stack 

def DecToBin(decNumber): 
    remstack = Stack() 
    while decNumber > 0: 
        rem = decNumber % 2 
        remstack.push(rem) 
        decNumber = decNumber // 2 
    binString = "" 
    while not remstack.isEmpty(): 
        binString = binString + str(remstack.pop()) 
    return binString
```

7. 实现将中序表达式转换成后序表达式的算法
```python
from pythonds import Stack
import string 

def infixToPostfix(infixexpr): 
    prec = {"*":3, "/":3, "+":2, "-":2, "(":1} 
    opStack = Stack() 
    postfixList = [] 
    tokenList = infixexpr.split() 
    for token in tokenList: 
        if token in string.ascii_uppercase: 
            postfixList.append(token) 
        elif token == '(': 
            opStack.push(token) 
        elif token == ')': 
            topToken = opStack.pop() 
            while topToken != '(': 
                postfixList.append(topToken) 
                topToken = opStack.pop() 
        else: 
            while (not opStack.isEmpty()) and \ 
            (prec[opStack.peek()] >= prec[token]): 
                postfixList.append(opStack.pop()) 
            opStack.push(token) 
    while not opStack.isEmpty(): 
        postfixList.append(opStack.pop())
    return " ".join(postfixList)
```

8. 在5、6、7的基础上，实现：包含“[]”、“{}”的括号匹配；任意进制间的互相转化；后序表达式的计算
- 包含“[]”、“{}”的括号匹配代码
```python
from pythonds import Stack 

def ParChecker(symbolString): 
    s = Stack() 
    balanced = True 
    index = 0 
    while index < len(symbolString) and balanced: 
        symbol = symbolString[index] 
        if symbol in "([{": 
            s.push(symbol) 
        else: 
            if s.isEmpty(): 
                balanced = False 
            else: 
                top = s.pop() 
                if not matches(top, symbol): 
                    balanced = False 
        index = index + 1 
    if balanced and s.isEmpty(): 
        return True 
    else: 
        return False 
    
def matches(open, close): 
    opens = "([{" 
    closers = ")]}"
    return opens.index(open) == closers.index(close)
```

- 任意进制间的互相转化
```python
from pythonds import Stack 

def baseConverter(decNumber, base):
    digits = "0123456789ABCDEF" 
    remstack = Stack() 
    while decNumber > 0:
        rem = decNumber % base 
        remstack.push(rem) 
        decNumber = decNumber // base 
    newString = "" 
    while not remstack.isEmpty(): 
        newString = newString + digits[remstack.pop()] 
    return newString
```

- 后序表达式的计算
```python
from pythonds import Stack 

def postfixEval(postfixExpr): 
    operandStack = Stack() 
    tokenList = postfixExpr.split() 
    for token in tokenList: 
        if token in "0123456789": 
            operandStack.push(int(token)) 
        else: 
            operand2 = operandStack.pop() 
            operand1 = operandStack.pop() 
            result = doMath(token, operand1, operand2) 
            operandStack.push(result) 
    return operandStack.pop() 
    
def doMath(op, op1, op2): 
    if op == "*": 
        return op1 * op2 
    elif op == "/":
        return op1 / op2 
    elif op == "+": 
        return op1 + op2 
    else: 
        return op1 - op2
```

9. 检查HTML文档中的标签是否正确匹配
```python
from pythonds import Stack

def HtmlChecker(html):
    elements = html.split()
    contentstack = Stack()
    bracketmatch = True
    balanced = True
    for tag in elements:
        index = 0
        while index < len(tag) and balanced:
            if tag[index] == "<":
                if bracketmatch == True:
                    bracketmatch = False
                    tempstring = ""
                else:
                    balanced = False
            elif tag[index] == ">":
                if bracketmatch == False:
                    bracketmatch = True
                    if contentstack.isEmpty():
                        contentstack.push(tempstring)
                    else:
                    if contentstack.peek() == tempstring:
                        contentstack.pop()
                    else:
                        contentstack.push(tempstring)
                else:
                    balanced = False
            elif bracketmatch == False:
                if tag[index] != "/":
                    tempstring = tempstring + tag[index]
            index = index + 1

    if contentstack.isEmpty() and balanced:
        return True
    else:
        return False
```


## 五. 实验结果
1. 计算前n个整数之和
a)调用time()函数测试计算不同数量级所需运行时间
b)不使用循环操作时，进行上述操作所需运行时间

| n的规模   | 使用循环操作计算用时  | 不使用循环操作计算用时  |
| --------- | --------------------- | ----------------------- |
| 100000    | 0.003947734832763672s | 9.5367431640625e-07s    |
| 1000000   | 0.04157710075378418s  | 9.5367431640625e-07s    |
| 10000000  | 0.4180891513824463s   | 2.1457672119140625e-06s |
| 100000000 | 4.142664909362793s    | 1.9073486328125e-06s    |

显然，不使用循环操作，时间复杂度为O(1)的算法，比使用循环操作，时间复杂度为O(n)的算法在解决问题所用的时间上耗时更短——因为O(1)的算法解决问题的开销不会随着问题规模的增大而增大，而O(n)的算法解决问题的开销会随着问题规模的增大而线性增长

2. 异序词（变位词）检测：假设要检查的两个字符串长度相同，并且都是由26个英文字母的小写形式组成
a)使用计数法（逐字检查）实现
b)使用排序法实现
c)使用暴力法实现
d)使用计数法实现

| 测试用例                    | 计数法（逐字检查）用时  | 排序法用时              | 暴力法用时             | 计数法用时              |
| --------------------------- | ----------------------- | ----------------------- | ---------------------- | ----------------------- |
| macbook makbook             | 5.0067901611328125e-06s | 2.86102294921875e-06s   | 0.0008871555328369141s | 5.9604644775390625e-06s |
| helloworld orlwhldelo       | 1.0967254638671875e-05s | 4.0531158447265625e-06s | 0.31003785133361816s   | 1.4066696166992188e-05s |
| datastructure structuredata | 1.5020370483398438e-05s | 4.76837158203125e-06s   | 416.46160888671875s    | 1.6927719116210938e-05s |

计数法（逐字检查）为一个O(n^2)的算法，排序法（python内置排序）一般的时间复杂度为O(nlogn)，剩余的比对操作仅为O(n)，因此该方法的时间复杂度为O(nlogn)，而暴力法为了求解第一个字符串所有的情况，需要不停搜索每个位置的字母情况，时间复杂度达到了O(n!)，在运行具有13个字母的字符串测试时用时达到了400s+，最后的计数法利用了桶排序算法，时间复杂度降低至O(n)，在字符串长度不断增加之后表现出最快的执行效率


3. 假设list的尾部是栈的顶端，push与pop操作都在list的末尾进行
4. 假设list的头部是栈的顶端，push与pop操作都在list的头部进行
根据3、4实现的不同，且4中无法直接使用pop方法和append方法，而必须要用pop方法和insert方法显式地访问下标为0的元素。又因为insert(0)与pop(0)在python中时间复杂度为O(n)，push()和pop操作的时间复杂度为O(1)，进行对两种实现以一定规模的测试——分别先push一定规模的元素，再全部pop出

```python
# 测试代码
s = Stack()
start = time.time()
for i in range(1000000):
    s.push(i)
while not s.isEmpty():
    s.pop()
print("Time used:", time.time() - start, "s")
```

| 测试规模 | 3中的Stack用时         | 4中的Stack用时       |
| -------- | ---------------------- | -------------------- |
| 10000    | 0.0038383007049560547s | 0.05133819580078125s |
| 100000   | 0.03968310356140137s   | 5.439540863037109s   |
| 1000000  | 0.4056720733642578s    | 536.7386610507965s   |

可以看出

1. 实现括号匹配算法
```
测试用例：
(()))(()())(()
((((((()))))))
()()()()()()
(()()(()()))

输出：
False
True
True
True
```

2. 实现将十进制转化成二进制的算法
```
测试用例：
255
65536
114514
1919810

输出：
1111 1111
1 0000 0000 0000 0000
1 1011 1111 0101 0010
1 1101 0100 1011 0100 0010
```

3. 实现将中序表达式转换成后序表达式的算法
```
测试用例：
A + B * C
( A + B ) * ( C + D )
( ( A + B ) * C ) - D

输出：
A B C * +
A B + C D + *
A B + C * D -
```
4. 在5、6、7的基础上，实现：包含“[]”、“{}”的括号匹配；任意进制间的互相转化；后序表达式的计算
- 包含“[]”、“{}”的括号匹配代码
```
测试用例：
[{]}[()]{[]]}()
[[()()]]{[]()[]}
[[{()}][]][{()}]
{{[[(([][]))]]}}

输出：
False
True
True
True
```

- 任意进制间的互相转化
```
测试用例：
127 16
72 8
2022 4
255 2

输出：
7F
110
133212
11111111
```

- 后序表达式的计算
```
测试用例：
4 5 6 * +
7 8 + 3 2 + /
5 1 2 + 4 * + 3 -
3 4 + 5 * 6 -

输出：
34
3.0
14
29
```

9. 检查HTML文档中的标签是否正确匹配
测试用例：
样例1：
```
<html>
        <head>
        <title>
            Example
        </title>
    </head>

    <body>
        <h1>hello, world</h1>
    </body>
</html>
```

样例2：
```
>html<
>/html<
```

样例3：
```
<html>
    <<head>>
    </head>
</html>
```

样例4：
```
<html>
    <head> 
        <title>菜鸟教程(runoob.com)</title> 
    </head> 
    <body>

        <b>加粗文本</b><br><br>
        <i>斜体文本</i><br><br>
        <code>电脑自动输出</code><br><br>
        这是 <sub> 下标</sub> 和 <sup> 上标</sup>

    </body>
</html>
```

输出：
```
True
False
False
True
```


## 六. 实验总结
- 针对python列表和字典的常见操作 —— 常用的方法如append，list()，len()等
- 理解用大O符号表示的执行时间 —— O(1)、O(n)、O(logn)、O(nlogn)、O(n ^ 2)、O(2 ^ n)、O(n!)等常见的算法时间复杂度从左往右逐渐增大
- 理解python数据的实现如何影响算法分析 —— python自带方法的复杂度影响了构建算法的复杂度
- 掌握python中栈的实现 —— 利用list自带的方法实现
- 理解如何对简单的python程序进行基准测试 —— import time对程序主要运行部分进行计时
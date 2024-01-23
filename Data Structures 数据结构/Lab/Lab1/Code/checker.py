from pythonds import Stack

def ParChecker1(symbolString): 
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


def ParChecker2(symbolString):
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


HTML1 = '''<html>
    <head>
        <title>
            Example
        </title>
    </head>

    <body>
        <h1>hello, world</h1>
    </body>
</html>'''

HTML2 = '''>html<
    >/html<'''

HTML3 = '''<html>
        <<head>>
        </head>
    </html>'''

HTML4 = '''<html>
        <head> 
            <title>菜鸟教程(runoob.com)</title> 
        </head> 
        <body>

            <b>加粗文本</b><br><br>
            <i>斜体文本</i><br><br>
            <code>电脑自动输出</code><br><br>
            这是 <sub> 下标</sub> 和 <sup> 上标</sup>

        </body>
    </html>'''


print(ParChecker1("(()))(()())(()"))
print(ParChecker1("((((((()))))))"))
print(ParChecker1("()()()()()()"))
print(ParChecker1("(()()(()()))"))

print()

print(ParChecker2("[{]}[()]{[]]}()"))
print(ParChecker2("[[()()]]{[]()[]}"))
print(ParChecker2("[[{()}][]][{()}]"))
print(ParChecker2("{{[[(([][]))]]}}"))

print()

print(HtmlChecker(HTML1))
print(HtmlChecker(HTML2))
print(HtmlChecker(HTML3))
print(HtmlChecker(HTML4))
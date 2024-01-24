# Algorithm Homework 2

## HW2-1
A *contiguous subsequence* of a list $S$ is a subsequence made up of consecutive elements of $S$. For instance,if $S$ is $5, 15, -30, 10, -5, 40, 10$,then $15, -30, 10$ is a contiguous subsequence but $5, 15, 40$ is not. Give a **linear-time algorithm** forthe following task:

- *Input*: A list of numbers, $a_1, a_2, \dots, a_n$.
- *Output*: The contiguous subsequence of **maximum sum**(a subsequence of length zero has sum zero).

For the preceding example, the answer would be $10, -5, 40, 10$, with a sum of $55$.
(Hint: For each $j \in \{1, 2, \dots, n\}$, consider contiguous subsequences ending exactly at position $j$.)

### IDEA
- We can use the **online processing** method to find the contiguous subsequence of maximum sum. The online requirement is that you don’t need to know all the operations(such like query and modification) in advance, and execute them while reading.
- The online processing algorithm for finding the subsequence of maximum sum is also a **dynamic programming** algorithm. By traversing the sequence, the subsequence of maximum sum can be obtained every time at the current traversal position:
  1. Firstly, set the **max begin index** and **max end index** of subesequence, both are $0$
  2. When meeting a new number, add it to the subsequence, and judge whether its sum greater than the maximum sum(initial sum is $0$) or lower than $0$
  3. If we get the new maximum sum, update the **max begin index** and **max end index** of subsequence
  4. If the sum < $0$, update the **temporary begin index** to the next element's index

### CODE(Python)
Since this algorithm only needs to travel of input sequence once, it time complexity is $O(n)$.

```python
def find_contiguous_subsequence_of_max_sum(numList: list) -> list:
    tempBeginIndex = maxBeginIndex = maxEndIndex = 0

    maxSum = tempSum = 0
    for index, element in enumerate(numList):
        tempSum += element
        # Dispose the subsequence when its sum < 0, because
        # the next contiguous elements cannot form a bigger sum
        if (tempSum < 0):
            tempSum = 0
            tempBeginIndex = index + 1
        # Update the max sum and the corresponding index
        elif (tempSum > maxSum):
            maxBeginIndex = tempBeginIndex
            maxEndIndex = index + 1
            maxSum = tempSum

    return numList[maxBeginIndex:maxEndIndex]
```

<div STYLE="page-break-after: always;"></div>

# Algorithm Homework 2

## HW2-2
Assume $aa=ab=bb=b$, $ac=bc=ca=a$, $ba=cb=cc=c$ on the set $A= \{a, b, c\}$ .Given a string $x = x_1x_2\dots x_n$, design a dynamic programming algorithm to check whether there is a computational order such that thefinal result is $a$.

For example,
$x=bbbba$ $\Rightarrow$ **YES**. $(b(bb))(ba) = (bb)(ba) = b(ba) = bc = a$
$x=bca$ $\Rightarrow$ **NO**. $(bc)a = aa =b$, $b(ca)= ba =c$

### IDEA
- Calculate the most simplified result from the smallest substring (length $1$) to the total string, and **maintain a list** to store the most simplified result of every substring.
- As the scale increases, each larger-scale substring can be **divided** into $2$ smaller substrings, and the most simplified result of the small substring has been stored in the list.
- We can **find the most simplified result of the small substring combination** and compare with the operation table to get the most simplified representation of the current substring

From $x$[row] to $x$[col], what the expression can be reduced to are showed as follows(Example: $bbbba$)

The order of calculation is represented by symbols ①, ②...
| character |           | $b$      | $b$      | $b$      | $b$      | $a$       |
| --------- | --------- | -------- | -------- | -------- | -------- | --------- |
|           | **index** | $0$(col) | $1$(col) | $2$(col) | $3$(col) | $4$(col)  |
| $b$       | $0$(row)  | $(b)$①   | $(b)$⑥   | $(b)$⑩   | $(b)$⑬   | $(a, c)$⑮ |
| $b$       | $1$(row)  |          | $(b)$②   | $(b)$⑦   | $(b)$⑪   | $(a, c)$⑭ |
| $b$       | $2$(row)  |          |          | $(b)$③   | $(b)$⑧   | $(a, c)$⑫ |
| $b$       | $3$(row)  |          |          |          | $(b)$④   | $(c)$⑨    |
| $a$       | $4$(row)  |          |          |          |          | $(a)$⑤    |

### CODE(Python)
This algorithm needs to construct a 2-dimensional list, its time cost is $O(n^2)$. 

For initializing the single characters'results, it costs $O(n)$.

Calculating the results from length $2$ to total string, it takes $n-1$ times, and for every scale $s$, it takes $n - s + 1$ times. When in a certain scale substring, suppose its length is $n'$, it takes $n' - 1$ times to find out every bi-partition result. Finally, this total part costs $O(n^3)$.

Therefore, the time complexity of this algorithm is $O(n^3)$.

```python
INDEX_a, INDEX_b, INDEX_c = 0, 1, 2

class Result:
    def __init__(self) -> None:
        self.results = [False, False, False]


def can_reduce2_a(expression: str) -> bool:
    return dp_result_calculation(expression)[0][len(expression-1)].results[INDEX_a]


def dp_result_calculation(expression: str) -> list:
    length = len(expression)
    # Initialize the total 2-dimensional list(actually can be optimized to 1-dimensional list)
    resultMap = [[Result() for col in range(length)] for row in range(length)]

    # Initialize the single character result
    for i in range(length):
        if (expression[i] == 'a'):
            resultMap[i][i].results[INDEX_a] = True
        elif (expression[i] == 'b'):
            resultMap[i][i].results[INDEX_b] = True
        elif (expression[i] == 'c'):
            resultMap[i][i].results[INDEX_c] = True
        
    # Start from substring containing 2 characters to the total string
    for r in range(2, length+1):
        for beginIndex in range(0, length-r+1):
            endIndex = beginIndex+r-1
            result_record(resultMap, beginIndex, endIndex)

    return resultMap


def result_record(resultMap: list, beginIndex: int, endIndex: int) -> None:
    # Part the substring into 2 parts and calculate the most simplified form
    for separatePosition in range(beginIndex, endIndex):

        for leftResult, leftReducible in enumerate(resultMap[beginIndex][separatePosition].results):
            # If the left part can be reduced to a, b or c, continue to find the most simplified form of right part
            if (leftReducible == True):
                for rightResult, rightReducible in enumerate(resultMap[separatePosition+1][endIndex].results):
                    if (rightReducible == True):
                        # Find the reduction form of the right and left parts'combination
                        result = result_classify(leftResult, rightResult)
                        resultMap[beginIndex][endIndex].results[result] = True

        # If the reduction result of the substring has already contained a, b and c, function returns directly
        if (resultMap[beginIndex][endIndex].results[INDEX_a] == True and
           resultMap[beginIndex][endIndex].results[INDEX_b] == True and
           resultMap[beginIndex][endIndex].results[INDEX_c] == True):
            return


def result_classify(leftResult: int, rightResult: int) -> int:
    # Redution Rules:
    # ac = bc = ca = a
    # aa = ab = bb = b
    # ba = cb = cc = c
    if (leftResult == INDEX_a and rightResult == INDEX_b
       or leftResult == INDEX_b and rightResult == INDEX_c
       or leftResult == INDEX_c and rightResult == INDEX_a):
        return INDEX_a
    elif (leftResult == INDEX_a and rightResult == INDEX_a
          or leftResult == INDEX_a and rightResult == INDEX_b
          or leftResult == INDEX_b and rightResult == INDEX_b):
        return INDEX_b
    else:
        return INDEX_c            
```
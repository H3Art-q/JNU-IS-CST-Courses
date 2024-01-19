# Course 4

**independence独立**：Two event $A$ and $B$ are independence **if $P(A|B) = P(A)$** and are dependent otherwise

- $P(B|A) = P(B)$
- $A'$ and $B$, $A$ and $B'$, $A'$ and $B'$ are also independent
- disjoint($P(A\cap B) = P(\emptyset) = 0$) $\rightarrow$ dependant 不相容是有关系的(互斥)，而不是相对独立
- $A$ and $B$ are independent **if and only if** $P(A\cap{B}) = P(A)P(B)$

>   **Proof Example**:
>   $\displaystyle{P}(A) = \frac{1}{2}, P(B) = \frac{1}{2}$
>   $\displaystyle{P}(A|B) = \frac{P(A\cap{B})}{P(B)} = \frac{1}{3} \not= P(A)$
>   So $A$ and $B$ are dependant
>
>   **Proof disjoint/mutually exclusive -> dependent**:
>
>   Since $A$ and $B$ are disjoint/mutually exclusive, then $\displaystyle{A}\cap B = \emptyset, P(A \cap B) = 0, P(A|B) = \frac{P(A\cap B)}{P(B)} = 0 \not = P(A)$

**discrete random variable离散随机变量**

- 一般记作$X()$，是一个离散变量函数，括号中的内容可以是某个事件

**probability distribution for discrete random variable离散随机变量的概率分布**

| $x$    | $x_1$    | $x_2$    | $\dots$ | $x_n$    |
| ------ | -------- | -------- | ------- | -------- |
| $P(x)$ | $P(x_1)$ | $P(x_2)$ | $\dots$ | $P(x_n)$ |

Find the probability distribution of $x_i$

**probability mass function(pmf)概率质量函数**
- 记作$P(x)$
- $p_i = P(x_i) ≥ 0$
- $\displaystyle\sum{p_i} = 1$

**Parameter of a Probability Distribution概率分布的参数**: Suppose $p(x)$ depends on a quantity that can be assigned any one of a number of possible values, with each different value determining a different probability distribution. Such a quantity is called a parameter of the distribution

概率分布的参数是用于描述和确定概率分布特性的数值或者符号

>   **Generate by GPT-4**:
>
>   **二项分布**(Binomial Distribution)：二项分布是描述在$n$次独立伯努利试验中成功次数的概率分布。它有两个参数：$n$(试验次数)和$p$(每次试验成功的概率)
>
>   **正态分布**(Normal Distribution)：正态分布，也称为高斯分布，是一种连续概率分布，用于描述许多自然现象。它有两个参数：$\mu$(均值，表示分布的中心)和$\sigma^2$(方差，表示分布的离散程度)
>
>   **指数分布**(Exponential Distribution)：指数分布用于描述在恒定平均速率下，两个独立随机事件之间的时间间隔。它有一个参数：$\lambda$(平均速率或强度，即单位时间内事件发生的次数)

**Bernoulli random variable伯努利随机变量**: outcomes $0$ or $1$

| $x$    | $0$        | $1$      |
| ------ | ---------- | -------- |
| $p(x)$ | $1-\alpha$ | $\alpha$ |

**cumulative distribution function(cdf)累计分布函数** 
- 记作$\displaystyle{F}(x) = P(X≤x) = \sum_{y≤x}p(y)$

$F(1) = P(y≤1) = p(1)$
$F(2) = P(y≤2) = p(1) + p(2)$
$F(3) = P(y≤3) = p(1) + p(2) + p(3)$
$\space\space\space\space\vdots$
$F(n) = P(y≤n) = p(1) + p(2) + p(3) + \dots + p(n) = 1$

## Homework
Section 2.5 71, 72, 80, 84
Section 3.1 4, 5, 8, 10
Section 3.2 12, 23, 25
# Course 2

**experiment试验**: An experiment is any action or process whose outcome is subject to uncertainty

**sample space样本空间**: the set $S$ of all possible outcomes of that experiment

Example: Filp a fair coin $3$ times is an sample space $S$, the coin has $2$ status $H$(head) and $T$(tail)

$$S = \{HHH, HHT, HTH, THH, THT, TTH, HTT, TTT\}$$

**event事件**: $E\in{S}$ 事件就是样本空间内的元素

- simple event(elementary event)简单/基本事件: An event consists of exactly one outcome
- compound event复合事件: 

**set theory集合理论**

- Union并 $$A\cup{B} = \{x|x\in{A}\space\mathrm{or}\space{x}\in{B}\}$$
- Intersection交 $$A\cap{B} = \{x|x\in{A}\space\mathrm{and}\space{x}\in{B}\}$$
  - If $A\cap{B} = \empty$, it is called *disjoint events/mutually exclusive*互斥事件
- complement补 $$A' = \bar{A} = \{x\in{U}|x\notin{A}\}$$

**probability概率**: 
- $P(A) ≥ 0$样本中任意事件的发生概率不为负数
- $P(S) = 1$总体的发生概率为1
- If $A_1, A_2, \dots$ are *disjoint/mutual exclusive* each other, $P(A_1\cup{A_2}\cup\dots\cup{A_n}) = \sum{P}(A_i)$互斥事件的概率满足该规律
- $P(\empty) = 0$
- $\displaystyle\lim_{n\rightarrow\infty}\frac{n(A)}{N}=P(A)$用频率估计概率，蒙特卡洛算法
- $P(A) = 1 - P(\bar{A})$
- $P(A\cup{B})=P(A)+P(B)-P(A\cap{B})$, if $A$ and $B$ are disjoint, then $P(A\cup{B})=P(A)+P(B)$

**equally likely outcomes等概率事件**: $p = P(E_i)$ for every $i$, then 

$$1 = \sum_{i = 1}^NP(E_i) = \sum_{i=1}^Np \rightarrow p = \frac{1}{N}$$

$$\displaystyle{P}(A) = \frac{N(A)}{N(S)}$$

**permutation排列**
- $\displaystyle{P}_{n, r} = \frac{n!}{(n-r)!}(0≤r≤n) = n\times(n-1)\times\dots\times(n-r+1)$
- $P_{n, n}=n!$

**combination组合**
- $\displaystyle{C}_{n, r} = \binom{n}{r}=\frac{P_{n, r}}{r!} = \frac{n!}{r!(n - r)!} = \frac{n\times(n-1)\times\dots\times(n-r+1)}{r!}$
- $C_{n, r} \sub P_{n, r}$

**counting techniques计数原理**:
- Addition principle加法原理: 单步多方式处理问题
- Multiplication principle乘法原理: 多步骤处理问题

## Homework
Section 2.1 2, 4, 9
Section 2.2 12, 18, 27
Section 2.3 30, 38, 40

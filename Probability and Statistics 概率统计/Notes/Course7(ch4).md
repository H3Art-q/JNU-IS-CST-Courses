# Course 7

*He said this chapter will be tough*🥵🥵🥵

**Continuous Random Variables连续随机变量**

Definition: Value is a entire interval of numbers 

eg: PH(酸碱度) $\rightarrow$ [0, 14]

**Probability Distribution概率分布**

- $f(x)$ represents the probability in exact $x$, namely, the **pdf**
- $f(x) > 0$ for all $x$
- $\displaystyle P(a≤X≤b) = \int_a^bf(x)\mathrm{d}x$
- $\displaystyle \int_{-\infty}^{\infty}f(x)\mathrm{d}x = 1$
- Difference between **discrete** & **continuous** RV
  - For discrete RV: $P(X=c) = p(c)$
  - For continuous RV: $\displaystyle P(X=c) = \int_c^cf(x)\mathrm{d}x = 0$, therefore $P(a≤X≤b) = P(a≤X<b) = P(a<X≤b) = P(a<X<b)$
- **cdf**: $\displaystyle F(X) = \int_{-\infty}^xf(y)\mathrm{d}y$
- **Uniform distribution**:
  $$P(X, A, B) = \begin{cases}
    \frac{1}{B-A} & A≤X≤B \\
    0 & \text{otherwise}
  \end{cases}$$
  $$F(X, A, B) = \begin{cases}
    0 & X < A \\
    \frac{x-A}{B-A} & A ≤ X < B \\
    1 & X ≥ B
  \end{cases}
  $$
  **Caution**: When the range is given, you need to write down all the conditions like above.
- Given $F(X)$ to find $P(X)$:
  $P(X>a) = 1 - F(a)$
  $P(a≤X≤b) = F(b) - F(a)$

**Percentiles of a Continuous Distribution连续随机变量分布的百分位表示**
Let $p$ be a number between $0$ and $1$. The ($100p$)th percentile of the distribution of a continuous rv $X$, denoted by $\eta (p)$, $\displaystyle p = F(\eta(p)) = \int_{-\infty}^{\eta(p)}f(y)\mathrm{d}y$

>   **Eg**:
>
>   根据“有6亿人每个月的收入也就1000元”这句话的内容，我们可知，在有大约14亿人口的国家，要统计个人的收入数据，有以下的结论
>
>   月收入$1000$这个数字，有这样的关系$\displaystyle F(1000) = \frac{6}{14} ≈ 43\%$，这代表，$1000$是当$p ≈ 0.43$时的结果，百分位数是$\eta(0.43) = 1000$

**Median中位数**
The median of a continuous distribution, denoted by $\tilde{µ}$, is the $50^{\mathrm{th}}$ percentile. $F(\tilde{µ}) = 0.5$. That is, half the area under the density curve is to the left of $\tilde{µ}$ and to the right of $\tilde{µ}$
- For symmetric distribution, $µ = \tilde{µ}$, but in general, $µ \not= \tilde{µ}$

**expected value期望**
- $\displaystyle µ = E(X) = \int_{-\infty}^{\infty}xf(x)\mathrm{d}x$
- $\displaystyle E(h(X)) = \int_{-\infty}^{\infty}h(x)f(x)\mathrm{d}x$
- $E(aX + b) = aE(X) + b$

**variance & standard difference方差与标准差**
- $\displaystyle\sigma^2 = V(X) = \int_{-\infty}^{\infty}(x-µ)^2f(x)\mathrm{d}x = E[(X - µ)^2]$
- $V(aX + b) = a^2V(X)$
- $\displaystyle V(X) = \int_{-\infty}^{\infty}[x - E(X)]^2f(x)\mathrm{d}x$
- $V(X) = E(X^2) - [E(X)]^2$

## Homework
Section 4.1 2, 5, 8
Section 4.2 12, 17, 22, 23
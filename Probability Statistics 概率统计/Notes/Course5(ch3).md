# Course 5

**expect value期望值**: Given **pmf** of $X$, then
- $\displaystyle{E}(X) = µ_X = \sum_{x\in{D}}x\cdot{p(x)}$
- $\displaystyle{E}[h(X)] = \sum{h(x)p(x)}$
- $\displaystyle{E}[aX+b] = aE(X) +b$

>  **Proof $E[aX+b] = aE(X) + b$**
>
>  $\displaystyle\space\space\space\space E[aX+b]$
>
>  $\displaystyle = \sum_D(ax+b)p(x)$
>
>  $\displaystyle = a\sum_Dxp(x) + b\sum_Dp(x)$
>
>  $\displaystyle = aE(X) + b$


**the variance of $X$ $X$的方差**
- $\displaystyle\sigma^2 = V(X) = \sum(x - µ_X)^2\cdot{p(x)}$
- $\sigma = \sqrt{\sigma^2}$
- $\displaystyle{V}(aX+b) = a^2V(X)$
- $\sigma_{aX+b}=|a|\sigma_X$

> **Proof $\displaystyle\sigma^2 = V(X) = \sum(x - µ_X)^2\cdot{p(x)} = E(X^2) - [E(X)]^2$**
>
> $\displaystyle\space\space\space\space\sum(x - µ)^2\cdot{p(x)}$
>
> $= \displaystyle\sum(x^2 - 2xµ + µ^2)\cdot{p(x)}$
>
> $= \displaystyle\sum{x^2\cdot{p(x)}}-2µ\sum{x\cdot{p(x)}}+µ^2\sum{p(x)}$
>
> **Because:** $\displaystyle\sum{x}\cdot{p(x)} = µ$, $\displaystyle\sum{p(x)}= 1$
>
> $= E(X^2) - 2µµ + µ^2$
>
> $= E(X^2) - µ^2$
>
> $= E(X^2) - [E(X)]^2$

**Some important distribution of discrete random variable**:
1. **binomial distribution二项分布**
   >  有放回抽样
   1. Definition: Given a binomial experiment consisting of $n$ trails, the binomial random variable $X$ associated with this experiment is defined as $X$ = the number of $S$’s among the $n$ trials
   2. . $n$ trials($n$ is fixed in advance)
   3. Only $2$ results: $S$(success) or $F$(faliure)
   4. Each trial is independent——有放回的标志
   5. $P(S) = p$($p$ is a constant)
   6. If the sample size(number of trials $n$) is at most $5\%$ of the total result $\rightarrow$ can be seen as binomial distribution
   不放回试验的次数为样本量的$5\%$及以下，可以近似视为二项分布处理
   7. **pmf** of binomial distribution = $b(x; n, p)$ 
   *注意字母b的大小写，此处为小写*
   8. **cdf** of binomial distribution = $B(x; n, p)$
   9. $\displaystyle{b}(x;n,p) = \binom{n}{x}p^x(1-p)^{n-x}$, when $x = 0, 1, 2,\dots, n$
   10. $\displaystyle{B}(x;n,p) = \sum_{i=0}^x{b(i;n,p)}$（查表）
   11. $E(X) = np$
   12. $V(X) = np(1-p) = npq$, where $q = 1 - p$
   13. For $n=1$, the binomial distribution became the **Bernoulli distribution**. The mean value of Bernoulli variables is $µ = p$

## Homework
Section 3.3 29, 33, 38, 41
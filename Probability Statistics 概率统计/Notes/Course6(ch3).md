# Course 6

**Some important distribution of discrete random variable**:
1.  **geometric distribution几何分布**
    >  有放回抽样
    1.  Definition: The probability that the first $k - 1$ times are all failures, and the probability that the $k$ times are successes
    2.  pmf of geometry distribution = $(1-p)^{x-1}p$
    3.  cdf of geometry distribution = $1 - (1 - p)^x$
    4.  $\displaystyle{E(X) = \frac{1}{p}}$

    >   Proof:
    >
    >   $\displaystyle E(X) = \sum_Dx\cdot p(x) = \sum_{x=1}^\infty xp(1-p)^{x-1} = p\sum_{x=1}^\infty\bigg[-\frac{\mathrm{d}}{\mathrm{d}p}(1-p)^x\bigg]$ 
    >
    >   $\displaystyle = -p\frac{\mathrm{d}}{\mathrm{d}p}\sum_{x=1}^\infty(1-p)^x= -p\frac{\mathrm{d}\bigg[\frac{1-p}{1-(1-p)}\bigg]}{\mathrm{d}p} = -p\bigg[\frac{1-p}{p}\bigg]' = \frac{1}{p}$

    5.  $\displaystyle{V(X) = \frac{1-p}{p^2}}$
2.  **hypergeometric distribution超几何分布**
    >  **不放回抽样!**
    1.  Sample consists $N$ individuals, objects or elements
    2.  Each individual can be characterized as a $S$(success) or $F$(failure), thera are $M$ success in the population
    3.  **A sample of $n$ individuals** is selected **without replacement** in such a way that each subset of size $n$ is equally likely to be chosen
    4.  $X$ = the number of $S$'s in the sample
    5.  $\displaystyle{P}(X = x) = h(x; n, M, N) = \frac{\binom{M}{x}\binom{N-M}{n-x}}{\binom{N}{n}}$
    6.  $E(X) = np$, where $\displaystyle p = \frac{M}{N}$
    7.  $\displaystyle V(X) = \bigg(\frac{N-n}{N-1}\bigg)np(1-p)$, where $\displaystyle p = \frac{M}{N}$
    跟二项分布的$V(X)$就相差$\displaystyle\bigg(\frac{N-n}{N-1}\bigg)$，这个项被称为有限总体校正因子(finite population correction factor)

3. **negative binomial distribution负二项分布**
    >  有放回抽样
   1. The experiment consists of a sequence of **independent** trials
   2. Only $2$ results: $S$(success) or $F$(faliure)
   3. $P(S) = p$($p$ is a constant)
   4. The experiment continues (trials are performed) until a total of **$r$ successes** have been observed
   5. $X$ = the number of $F$'s in the sample
   6. pmf of negative binomial distribution = $\displaystyle{n}b(x; r, p) = \binom{x+r-1}{r-1}p^r(1-p)^x$
   7. cdf of negative binomial distribution = $nB(x; r, p)$
   8. $\displaystyle{E}(X) = \frac{r(1-p)}{p}$
   9. $\displaystyle{V}(X) = \frac{r(1-p)}{p^2}$
4.  **Poisson probability distribution泊松分布**
    >  有放回抽样
    1. $\lambda = µ = E(X)$
    2. $\displaystyle{p}(x, \lambda) = \frac{e^{-\lambda}\lambda^x}{x!}$, $x = 0, 1, 2, 3, \dots$
    3.  $e ≈ 2.71828$
    > Since 
    > $\displaystyle{e}^\lambda = 1 + \lambda + \frac{\lambda^2}{2!} + \frac{\lambda^3}{3!} + \dots = \sum_{i = 0}^\infty \frac{\lambda^i}{i!}$
    >
    > $\displaystyle\sum_{i = 0}^\infty \frac{e^{-\lambda}\lambda^i}{i!} = e^{-\lambda}e^\lambda = 1$
    4. When $n≥100$, $p≤0.01$ and $np≤20$, a binomial distribution can be appximately seen as a Poisson distribution, $\lambda$ is $E(X)$
    5. $E(X) = V(X) = \lambda$

## Homework
Section 3.4 46, 47, 48, 54
Section 3.5 68, 69, 72, 75
Section 3.6 79, 84, 86, 87

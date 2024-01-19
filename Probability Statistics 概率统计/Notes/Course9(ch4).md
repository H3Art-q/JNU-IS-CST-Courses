# Course 9

**Gamma Distribution伽马分布**

For $\alpha > 0$, the gamma function $\Gamma(\alpha)$ is defined by:

$\displaystyle\Gamma(\alpha) = \int_0^\infty x^{\alpha-1}e^{-x}\mathrm{d}x$

- For any $\alpha > 1$, $\Gamma(\alpha) = (\alpha-1)\Gamma(\alpha-1)$
- For any positive integer, $n$, $\Gamma(n) = (n - 1)!$
- $\displaystyle\Gamma(\frac{1}{2}) = \sqrt{\pi}$
- **pdf** of $X$:
  $$
    f(x;\alpha,\beta) = \begin{cases}
        \frac{1}{\beta^\alpha\Gamma(\alpha)}x^{\alpha-1}e^{-\frac{x}{\beta}} & x ≥ 0 \\
        0 & \text{otherwise}
    \end{cases}
  $$
- Let $\beta = 1$, it becomes a **standard Gamma distribution**:
  $$
    f(x;\alpha) = \begin{cases}
        \frac{x^{\alpha-1}e^{-x}}{\Gamma(\alpha)} & x ≥ 0 \\
        0 & \text{otherwise}
    \end{cases}
  $$
- **cdf** of standard Gamma distribution $X$: Refer to **Appendix Table A.4**:
  $$
    F(x;\alpha) = \begin{cases}
        \int_0^x\frac{y^{\alpha-1}e^{-y}}{\Gamma(\alpha)}\mathrm{d}y & x ≥ 0 \\
        0 & x < 0
    \end{cases}
  $$

- $\beta$代表伽马分布曲线在$x$轴上的拉升和压缩，$\alpha$代表曲线的走向
  - $\beta$越大，$x$轴上的范围越长
  - $\alpha ≤ 1$时，减函数
  - $\alpha > 1$时，先增后减
- $E(X) = µ = \alpha\beta$
- $V(X) = \sigma^2 = \alpha\beta^2$
- For any Gamma distribution with parameter $\alpha$ and $\beta$, its **cdf** is $\displaystyle P(X≤x) = F(x;\alpha,\beta) = F(\frac{x}{\beta};\alpha)$(like standard Gamma distribution)

**Exponential Distribution指数分布**

Let $\alpha = 1$, $\displaystyle\beta = \frac{1}{\lambda}(\lambda > 0)$, Gamma distribution becomes an exponential distribution

- **pdf** of $X$:
  $$
    f(x;\lambda) = \begin{cases}
        \lambda e^{-\lambda x} & x ≥ 0 \\
        0 & \text{otherwise}
    \end{cases}
  $$
- $\displaystyle E(X) = \frac{1}{\lambda}$
- $\displaystyle V(X) = \frac{1}{\lambda^2}$
- **cdf** of $X$:
  $$
    F(x;\lambda) = \begin{cases}
        0 & x < 0 \\
        1 - e^{-\lambda x} & x ≥ 0
    \end{cases}
  $$

**Chi-Squared Distribution卡方分布**

Let $\displaystyle\alpha = \frac{v}{2}(v > 0)$, $\displaystyle\beta = 2$, Gamma distribution becomes an Chi-Squared distribution

**Weibull Distribution韦布尔分布**

A random variable $X$ is said to have a Weibull distribution with parameters $α$ and $β$ ($α > 0$, $β > 0$) if the pdf of $X$ is:

$$
  f(x;\alpha,\beta) = \begin{cases}
    \frac{\alpha}{\beta^\alpha}x^{\alpha-1}e^{-(x/\beta)^\alpha} & x ≥ 0 \\
    0 & x < 0
  \end{cases}
$$

When $\alpha = 1$, the pdf of Weibull distribution reduces to the exponential distribution (with $\displaystyle\beta = \frac{1}{\lambda}$), so the exponential distribution is a special case of both the gamma and Weibull distributions

- Mean: $\displaystyle µ = \beta\Gamma(1 + \frac{1}{\alpha})$
- Variance: $\sigma^2 = \beta^2\bigg\{\Gamma\bigg(1+\frac{2}{\alpha}\bigg)-\bigg[\Gamma\bigg(1+\frac{1}{\alpha}\bigg)\bigg]^2\bigg\}$
- cdf: 
  $$
    F(x;\alpha,\beta) = \begin{cases}
      0 & x < 0 \\
      1 - e^{-(x/\beta)^\alpha} & x ≥ 0
    \end{cases}
  $$

**Lognormal Distribution对数分布**

**Beta Distribution贝塔分布**

**Probability Plots概率绘图**
Select the dot $(x, y)$ by $x = [100(i - 0.5)/n]\text{th}$ percentile of the distribution, $y = i\text{th}$ smallest sample observation

- 只有满足正态分布才会绘制出一条近似直线

## Homework
Section 4.4 59, 67, 70
Section 4.6 87, 88
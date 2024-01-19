# Course 8

**Normal (Gaussian)Distribution正态分布(高斯分布)**

- If $E(X) = µ$ and $V(X) = \sigma^2$, $X \sim N(µ, \sigma^2)$
- **pdf**: 
  $\displaystyle f(x;µ,\sigma) = \frac{1}{\sqrt{2\pi}\sigma}e^{-\frac{(x-µ)^2}{2\sigma^2}}\space\space\space(-\infty<x<\infty)$

**standard normal distribution标准正态分布**

The normal distribution with parameter values $µ = 0$ and $\sigma = 1$ is called the **standard normal distribution**.A random variable having a standard normal distribution is called a **standard normal random variable** and will be denoted by $Z$.

- **pdf**:
  $\displaystyle f(z;µ,\sigma) = \frac{1}{\sqrt{2\pi}}e^{-\frac{x^2}{2}}$, $Z \sim N(0, 1)$
- **cdf**:
  $\displaystyle\Phi(z) = \int_{-\infty}^zf(t)\mathrm{d}t = \int_{-\infty}^z\frac{1}{\sqrt{2\pi}}e^{-\frac{t^2}{2}}\mathrm{d}t$
  $\Phi(-z) = 1 - \Phi(z)$
  $\Phi(0) = 0.5$
  $P(|x| ≤ z) = 2\Phi(z) - 1$
  $P(|x| ≥ z) = 2[1 - \Phi(z)]$
  > Proof of $p(|x| ≤ z) = 2\Phi(z) - 1$:
  >
  > $P(-z≤x≤z)=\Phi(z) - \Phi(-z) = \Phi(z) - (1 - \Phi(z)) = 2\Phi(z) - 1$

  $p = F(\eta) - F(z)$

**$Z_\alpha$ notation $Z_\alpha$表示法**
$z_\alpha$ will denote the values on the measurement axis for which $\alpha$ of the area under the $z$ curve lies to the right of $z_\alpha$.

$Z_\alpha$ is the $100(1-\alpha)$th percentile of the standard normal distribution

- $\displaystyle Z = \frac{X-µ}{\sigma}$
- $\displaystyle X = µ + Z\sigma$
> **Proof**:
>
> $X \sim N(µ, \sigma^2)$
  $\displaystyle F(X) = \frac{1}{\sqrt{2\pi}\sigma}\int_{-\infty}^xe^{-\frac{(x-µ)^2}{2\sigma^2}}\mathrm{d}x$
  Let $\displaystyle\frac{x-µ}{\sigma} = t$, then $x = µ + \sigma t$, $\mathrm{d}x = \sigma\mathrm{d}t$
  $\displaystyle F(X) = \frac{1}{\sqrt{2\pi}\sigma}\int_{-\infty}^{\frac{x-µ}{\sigma}}e^{-\frac{t^2}{2}}\sigma\mathrm{d}t$

**STANDARDIZATION标准化**
利用$P(a≤X≤b)$构造$\displaystyle P(\frac{a-µ}{\sigma}≤Z≤\frac{b-µ}{\sigma})$，接下来就可以查**Standard normal density curve**的表了

- $\displaystyle P(a≤X≤b) = P(\frac{a-µ}{\sigma}≤Z≤\frac{b-µ}{\sigma}) = \Phi(\frac{b-µ}{\sigma}) - \Phi(\frac{a-µ}{\sigma})$
- $\displaystyle P(X≤a) = \Phi(\frac{a-µ}{\sigma})$
- $\displaystyle P(X≥b) = 1 - \Phi(\frac{b-µ}{\sigma})$

**The Normal Approximation to the Binomial Distribution利用正态分布逼近二项分布**
- **Rule**: In practice, the approximation is adequate provided that both $np≥10$ and $nq≥10$.(where $q=1-p$)
- $\displaystyle p(X≤x) = B(x;n,p) ≈ \text{(area under the normal curve to the left of } x + 0.5) = \Phi\bigg(\frac{x+0.5-np}{\sqrt{npq}}\bigg)$
- **Caution**: the $a-1$
  $\displaystyle p(a≤X≤b) = p(a-1<X≤b) = B(b;n,p) - B(a-1;n,p) ≈ p(\frac{(a-1)+0.5-np}{\sqrt{npq}} ≤ Z ≤ \frac{b+0.5-np}{\sqrt{npq}}) = \Phi\bigg(\frac{b+0.5-np}{\sqrt{npq}}\bigg) - \Phi\bigg(\frac{(a-1)+0.5-np}{\sqrt{npq}}\bigg)$

## Homework
Section 4.3 30, 44, 48, 53, 56
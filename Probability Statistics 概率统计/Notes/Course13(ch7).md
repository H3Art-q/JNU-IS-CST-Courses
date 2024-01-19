# Course 13

**Confidence Interval(CI)置信区间**: The probability of the interval **cover the true value** is confidence level(CL)

Problem: Given CL, find CI
- **Case1**: Population distribution is normal, $\sigma$ is known, estimate $µ$
  - Since $X \sim N(µ, \sigma^2)$, then $\displaystyle\bar{X} \sim N(µ, \frac{\sigma}{\sqrt{n}})$, $\displaystyle\frac{\bar{X}-µ}{\sigma/\sqrt{n}} \sim N(0,1)$
  - $\displaystyle P(-Z_{\frac{\alpha}{2}} < \frac{\bar{X}-µ}{\sigma/\sqrt{n}} < Z_{\frac{\alpha}{2}}) = 1 - \alpha = P(\bar{X} - \frac{\sigma}{\sqrt{n}}Z_{\frac{\alpha}{2}} < µ < \bar{X} + \frac{\sigma}{\sqrt{n}}Z_{\frac{\alpha}{2}})$


- **Case2**: Any population distribution(normal or abnormal), $\sigma$ is unknown, $n$ is sufficiently large($n ≥ 40$)
  - Use CLT(Central Limit Theorem)
  - $S \rightarrow \sigma(s ≈ \sigma)$
  - Sample variance: $\displaystyle S^2 = \frac{\sum(x_i - \bar{x})^2}{n-1}$
  - $\displaystyle Z = \frac{\bar{X} - µ}{S / \sqrt{n}}$
  - $\displaystyle µ = \bar{X} ± \frac{S}{\sqrt{n}} - Z_{\frac{\alpha}{2}}$


- **Case3**: Population is normal, both $µ$ and $\sigma$ are unknown, and $n$ is small
  - Use **T distribution**: $\displaystyle T = \frac{\bar{X} - µ}{S / \sqrt{n}}$
    - The only one parameter in T is **the number of df(degrees of freedom)**: $v = n - 1$, when $n ≥ 40$, $T \sim N(0, 1)$
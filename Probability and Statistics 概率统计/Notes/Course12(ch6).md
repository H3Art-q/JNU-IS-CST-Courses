# Course 12

**Point Estimation点估计**

Assuming that the form of the distribution function of the population $X$ is known, but one or more of its parameters are unknown, the problem of estimating the value of the population's unknown parameters by means of a sample of the population is called the point estimation problem of parameters.

设总体$X$的分布函数的形式已知，但它的一个或多个参数未知，借助于总体的一个样本来估计总体未知参数的值的问题称为参数的点估计问题

- $\theta$: true value(unknown)
- $\hat\theta$: estimate value
- $\displaystyle\hat{p} = \frac{X}{n}$
- $\displaystyle\bar{X} = \frac{\sum{x_i}}{n}$
- Sample variance: $\displaystyle s^2 = \frac{\sum(x_i-\bar{x})^2}{n-1}$

**Estimation Error Analysis估计误差分析**

- **Unbiased Estimator无偏估计**
  - A point estimator $\hat{\theta}$ is said to be an unbiased estimator of $θ$ if $E(\hat{\theta}) - \theta = 0$, namely $E(\hat{\theta}) = \theta$
  - If $X_1, X_2, \dots, X_n$ is a random sample from a distribution with mean $μ$, then $\bar{X}$ is an unbiased estimator of $μ$. If in addition the distribution is **continuous** and **symmetric**, then $\tilde{X}$ and any trimmed mean are also unbiased estimator of $μ$
  - When $X$ is a **binomial rv** with parameters $n$ and $p$, the sample proportion $\hat{p}=X/n$ is an unbiased estimator of $p$
    - $\displaystyle E(\hat{p}) = E(\frac{X}{n}) = \frac{1}{n}E(X) = \frac{1}{n}(np) = p$
  - For any rv $Y$, $V(Y) = E(Y^2) - [E(Y)]^2$, so $E(Y^2) = V(Y) + [E(Y)]^2$, applying this to:
    $$
      \begin{align}
        E(S^2) &= \frac{1}{n-1}\bigg\{\sum E(X_i^2) - \frac{1}{n}E(\sum X_i)^2 \bigg\} \\
        &= \frac{1}{n-1}\bigg\{\sum(\sigma^2+µ^2)-\frac{1}{n}\{V(\sum X_i) + [E(\sum X_i)]^2\}\bigg\} \\
        &= \frac{1}{n-1}\bigg\{n\sigma^2 + nµ^2 - \frac{1}{n}n\sigma^2 - \frac{1}{n}(nµ)^2\bigg\} \\
        &= \frac{1}{n-1}\{n\sigma^2 - \sigma^2\} = \sigma^2
      \end{align}
    $$
    Therefore, Let $X_1, X_2, \dots , X_n$ be a random sample from a distribution with mean $µ$ and variance $\sigma^2$. Then the estimator $\displaystyle\hat\sigma^2 = S^2 = \frac{\sum(X_i-\bar{X})^2}{n-1}$ is **unbiased** for estimating $\sigma^2$

- **Minimum Variance方差最小**
  - Choose the estimator with minimum variance.

- **Minimum Variance Unbiased Estimator(MVUE)最小方差无偏估计量**
  - When choosing among several different estimators of $\theta$, select one that is **unbiased**.
  - Among all estimators of $\theta$ that are unbiased, choose the one that has minimum variance. The resulting is called the **minimum variance unbiased estimator(MVUE)** of $\theta$.

- **Estimator Selection估计量的选择**
  - $\bar{X}$ is the best estimator of **normal distribution**
  - $\bar{X}$ and $\bar{X_e}$(the average of the two extreme observations) are terrible for $µ$ of **Cauchy distribution**, but $\widetilde{X}$ is good fit.
  - $\bar{X_e}$ is the best estimator of **uniform distribution**
  - $\bar{X_{tr}}$(trimmed mean) is a **robust** estimator for above 3 distributions, but it is not the best estimator among them.

- **Standard Error标准误**
  The standard error of an estimator $\hat\theta$ is its standard deviation $\sigma_{\hat\theta} = \sqrt{V(\hat\theta)}$.


**Methods of Point Estimation点估计的方法**

- **Moment Estimator矩估计量**
  - **Moment矩**
    - $k$th moment: $\displaystyle E(X^k) = \frac{1}{n}\sum_{i=1}^nX_i^k$, when $k=1$, $\displaystyle E(X) = \frac{1}{n}\sum_{i=1}^nX_i = \bar{X}$

- **Maximum Likelihood Estimation极大似然估计**


## Homework
Section 6.1 1, 8, 9, 13
Section 6.2 20, 21, 29, 32
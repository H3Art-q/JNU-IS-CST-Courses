# Course 10

**Joint Probablity Distribution**

- **Discrete RV**
  - Joint pmf: $p(x, y) = P(X = x \text{ and } Y = y)$
  - $p(x, y) ≥ 0$
  - $\displaystyle\sum_x\sum_yp(x, y) = 1$
  - **Marginal pmf**:
    - $\displaystyle p_X(x) = \sum_{y:p(x,y)>0}p(x,y)$
    - $\displaystyle p_Y(y) = \sum_{x:p(x,y)>0}p(x,y)$

- **Continuous RV**
  - Joint pmf $\displaystyle f(x, y) = {\int_A\int} f(x, y)\mathrm{d}x\mathrm{d}y$
  - $f(x, y) ≥ 0$
  - $\displaystyle\int_{-\infty}^{\infty}\int_{-\infty}^{\infty}f(x, y)\mathrm{d}x\mathrm{d}y = 1$
  - **Marginal pmf**:
    - $\displaystyle f_X(x) = \int_{-\infty}^{\infty}f(x, y)\mathrm{d}y$, $-\infty < x < \infty$
    - $\displaystyle f_Y(y) = \int_{-\infty}^{\infty}f(x, y)\mathrm{d}x$, $-\infty < y < \infty$

- **Independent RV**
  - $p(x, y) = p_X(x)\cdot p_Y(y)$, when $X$ and $Y$ are discrete
  - $f(x, y) = f_X(x)\cdot f_Y(y)$, when $X$ and $Y$ are continuous

**More than two variable**
- For discrete RV, $p(x_1,x_2,\dots,x_n)=P(X_1=x_1,X_2=x_2,\dots,X_n=x_n)$
- For continuous RV, $\displaystyle P(a_1≤X_1≤b_1,\dots,a_n≤X_n≤b_n)=\int_{a_1}^{b_1}\cdots\int_{a_n}^{b^n}f(x_1\dots,x_n)\mathrm{d}x_n\dots\mathrm{d}x_1$

**Conditional Distributions**
Let $X$ and $Y$ be two continuous rv’s with joint pdf $f(x, y)$ and marginal $X$ pdf $f_X(x)$. Then for any $X$ value $x$ for which $f_X(x) > 0$, the **conditional probability density function of $Y$ given that $X = x$** is:

$$f_{Y|X}(y|x) = \frac{f(x, y)}{f_X(x)}\space\space-\infty < y < \infty$$

If $X$ and $Y$ are discrete, then:

$$f_{Y|X}(y|x) = \frac{p(x, y)}{p_X(x)}\space\space-\infty < y < \infty$$

is the conditional pmf of $Y$ when $X = x$

**Expected Value**
Let $X$ and $Y$ be jointly distributed rv’s with pmf $p(x, y)$ or pdf $f(x, y)$ according to whether the variables are discrete or continuous. Then the expected value of a function $h(X, Y)$, denoted by $E[h(X, Y)]$ or $µ_{h(X, Y)}$, is given by:

$$
  E[h(X, Y)] = \begin{cases}
    \sum_X\sum_Yh(x, y)\cdot p(x, y) & \text{if X and Y are discrete} \\
    \int_{-\infty}^{\infty}\int_{-\infty}^{\infty}h(x, y)\cdot f(x, y)\mathrm{d}x\mathrm{d}y & \text{if X and Y are continuous}
  \end{cases}
$$

**Covariance协方差**
When two random variables $X$ and $Y$ are **not independent**, it is frequently of interest to assess **how strongly they are related to one another**.

The covariance between two rv’s $X$ and $Y$ is:

$$
 \text{Cov}(X, Y) = E[(X-µ_X)(Y-µ_X)]= \begin{cases}
    \sum_x\sum_y(x-µ_X)(y-µ_Y)p(x, y) & X, Y\text{ discrete} \\
    \int_{-\infty}^{\infty}\int_{-\infty}^{\infty}(x-µ_X)(y-µ_Y)f(x, y)\mathrm{d}x\mathrm{d}y & X, Y\text{ continuous}
 \end{cases}
$$

$$µ_X = \begin{cases}
  \sum xp_X(x) & X\text{ is discrete} \\
  \int_{\infty}^{\infty}xp_X(x)\mathrm{d}x & X\text{ is continuous}
\end{cases}
$$

$$µ_Y = \begin{cases}
  \sum yp_Y(y) & Y\text{ is discrete} \\
  \int_{\infty}^{\infty}yp_Y(y)\mathrm{d}y & Y\text{ is continuous}
\end{cases}
$$

- $\text{Cov}(X, Y) = E(XY) - µ_X\cdotµ_Y$

**Correlation标准化的协方差/相关性**
The correlation coefficient of $X$ and $Y$, denoted by $\text{Corr}(X, Y)$, $\rho_{X,Y}$, or just $\rho$, is defined by

$$\rho_{X, Y} = \frac{\text{Cov}(X, Y)}{\sigma_X\cdot\sigma_Y}$$

- It is a normalization of $\text{Cov}(X, Y)$ (协方差的标准化)
- If $a$ and $c$ are either both positive or both negative, $\text{Corr}(aX+b, cY+d) = \text{Corr}(X, Y)$
- For any two rv’s $X$ and $Y$, $-1 ≤ \text{Corr}(X, Y) ≤ 1$.

## Homework
Section 5.1 9, 12, 18, 19
Section 5.2 24, 26, 33, 35

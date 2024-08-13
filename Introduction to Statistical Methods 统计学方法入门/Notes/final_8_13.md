# Introduction to Statistics Note (Final Exam)

*2024 Spring Semester*

$\text{21 CST H3Art}$

## Chapter 8: Inference for Proportions

### 8.1 Inference for a Single Proportion

We can construct a confidence interval for an unknown population proportion $p$:

$$
\textbf{statistic} \pm (\textbf{critical value}) \cdot (\textbf{standard deviation of statistic})
$$

The sample proportion $\hat{p}$ is the statistic we use to estimate $p$. When the independent condition is met, the **standard deviation** of the sampling distibution of $\hat{p}$ is:

$$
\sigma_{\hat{p}} = \sqrt{\frac{p(1-p)}{n}}
$$

Since we don’t know $p$, we replace it with the sample proportion $\hat{p}$. This gives us the **standard error (SE)** of the sample proportion:

$$
\textbf{SE} = \sqrt{\frac{\hat{p}(1-\hat{p})}{n}}
$$

Once we find the critical value $z^*$, our **confidence interval for the population proportion $p$** is:

$$
\hat{p} \pm z^*\sqrt{\frac{\hat{p}(1-\hat{p})}{n}}
$$

The z statistic has approximately the standard Normal distribution when $H_0$ is true. P-values therefore come from the standard Normal distribution. Here is a summary of the details for a **$z$ test for a proportion**, to test the hypothesis $H_0: p = p_0$, compute the $z$ statistic:

$$
z=\frac{\hat{p}-p}{\sqrt{\frac{p_0(1-p_0)}{n}}}
$$

To do Normal calculations, the sample size value should **at least $10$**.

**margin of error**:

$$
m = z^*\sqrt{\frac{\hat{p}(1-\hat{p})}{n}}
$$

To **determine the sample size $n$** that will yield a level $C$ confidence interval for a population proportion $p$ with a maximum margin of error, solve the following:

$$
n = \left( \frac{z^*}{m} \right)^2p^*(1-p^*)
$$

where $p^*$ is a **guessed value for the sample proportion**. The margin of error will always be less than or equal to $m$ if you take the guess $p^*$ to be $0.5$.

### 8.2 Comparing Two Proportions

Sampling distribution of $\hat{p_1}-\hat{p_2}$, its standard deviation is:

$$
\sigma_{\hat{p_1}-\hat{p_2}} = \sqrt{\frac{p_1(1-p_1)}{n_1} + \frac{p_2(1-p_2)}{n_2}}
$$

Because we don’t know the values of the parameters $p_1$ and $p_2$, we replace them in the standard deviation formula with the sample proportions. The result is the **standard error** of the statistic $\hat{p_1} - \hat{p_2}$:

$$
\textbf{SE} = \sqrt{\frac{\hat{p_1}(1-\hat{p_1})}{n_1} + \frac{\hat{p_2}(1-\hat{p_2})}{n_2}}
$$

When the **Random** and **Normal** conditions are met, an approximate level $C$ confidence interval for $(\hat{p_1} - \hat{p_2})$ is:

$$
(\hat{p_1} - \hat{p_2}) \pm z^* \sqrt{\frac{\hat{p_1}(1-\hat{p_1})}{n_1} + \frac{\hat{p_2}(1-\hat{p_2})}{n_2}}
$$

- **Random**: The data are produced by a **random sample** of size $n_1$ from Population 1 and a **random sample** of size $n_2$ from Population 2 or by two groups of sizes $n_1$ and $n_2$ in a randomized experiment.
- **Normal**: The counts of "successes" and "failures" in each sample or group——$n_1\hat{p_1}$, $n_1(1-\hat{p_1})$, $n_2\hat{p_2}$ and $n_2(1-\hat{p_2})$ are **all at least $10$**.

**Significance Test（显著性测试）** for Comparing Proportions: To do a test, standardize $\hat{p_1} - \hat{p_2}$ to get a $z$ statistic:

$$
\begin{align}
    \textbf{test statistic} &= \frac{\textbf{statistic} - \textbf{parameter}}{\textbf{standard deviation of statistic}} \nonumber\\
    z &= \frac{(\hat{p_1} - \hat{p_2}) - 0}{\textbf{standard deviation of statistic}} \nonumber
\end{align}
$$

This **pooled (or combined) sample proportion** is:

$$
\hat{p} = \frac{\textbf{count of successes in both samples combined}}{\textbf{count of individuals in both samples combined}}
$$

To test the hypothesis $H_0: p_1 − p_2 = 0$, first find the pooled proportion $\hat{p}$ of successes in both samples combined. Then compute the $z$ statistic:

$$
z = \frac{(\hat{p_1} - \hat{p_2})}{\sqrt{\hat{p}(1-\hat{p})\left(\frac{1}{n_1} + \frac{1}{n_2}\right)}}
$$

Note that the **standard deviation of pooled sample** is:

$$
\sigma_{\hat{p}} = \sqrt{\hat{p}(1-\hat{p})\left(\frac{1}{n_1} + \frac{1}{n_2}\right)}
$$

## Chapter 9: Analysis of Two-Way Tables

### 9.1 Inference for Two-Way Tables

**Two-Way Tables（双向表）** can be used to describe the **relationship** between **two categorical variables**. 
- When the data are obtained from random sampling, two-way tables of counts can be used to formally **test the hypothesis** that the two categorical variables are **independent** in the population from which the data were obtained.

To test this hypothesis, we compare **actual counts（实际计数）** from the sample data with **expected counts（预期计数）**, the expected count in any cell of a two-way table when $H_0$ is true is:

$$
\textbf{expected count} = \frac{\textbf{row total}\times\textbf{column total}}{n}
$$

where $\textbf{row total}$ represents **the sum of a cell row（单元格所在行的计数和）**, $\textbf{column total}$ represents **the sum of a cell column（单元格所在列的计数和）**

The **test statistic** that makes the comparison is the **chi-square statistic（卡方统计量）**, the chi-square statistic is a measure of **how far the observed counts are from the expected counts（检验观察值和期望值的差距）**. The formula for the statistic is:

$$
\mathcal{X}^2 = \sum\frac{(\textbf{observed} - \textbf{expected})^2}{\textbf{expected}}
$$

where $\textbf{observed}$ represents **an observed cell count（一个单元格的值）**

The **chi-square distributions（卡方分布）** are a family of distributions that take **only positive values** and are **skewed to the right**. A particular $\mathcal{X}^2$ distribution is specified by giving its **degrees of freedom（自由度）**.

The $\mathcal{X}^2$ test for a two-way table with $r$ rows and $c$ columns uses critical values from the $\mathcal{X}^2$ distribution with **$(r – 1)(c – 1)$ degrees of freedom**.

The **P-value is the area under the density curve** of this $\mathcal{X}^2$ distribution to the **right（右尾）** of the value of the test statistic.

**Cell Counts Required（单元格数量要求）** for the Chi-Square Test
- The average of the expected counts is **$5$ or more**
- All individual expected counts are **$1$ or greater**
- In a 2 × 2 table, all four expected cell counts should be **at least 5**.

The **expected count** in any cell of a two-way table when $H_0$ is true is:

$$
\textbf{expected count} = \frac{\textbf{row total}\cdot\textbf{column total}}{\textbf{table total}}
$$

**Testing for independence（独立性检验）**
Suppose we have a single sample from a single population. For each individual in this SRS of size $n$, we measure two categorical variables. The results are then summarized in a two-way table.

The **null hypothesis** is that the **row and column variables are independent（零假设是行列无关/独立）**. The **alternative hypothesis** is that the **row and column variables are dependent（备选假设是行列相关）**.

### 9.2 Goodness of Fit

The idea of the chi-square test for goodness of fit is this: 
We compare the **observed counts** from our sample with the counts that would be **expected** if $H_0$ is true. 
The **more** the **observed counts** differ from the **expected counts**, the more evidence we have against the null hypothesis.**（比较观测值和预测值的差值，差值越大就越能对抗原假设）**

**E.g.**

A categorical variable has $k$ possible outcomes, with probabilities $p_1, p_2, p_3, \dots , p_k$. That is, $p_i$ is the probability of the $i^{\text{th}}$ outcome. We have $n$ independent observations from this categorical variable.

To test the null hypothesis that the probabilities have specified values:

$$
H_0: p_1, p_2, \dots, p_k
$$

find the **expected count** for each category assuming that $H_0$ is true. Then calculate the chi-square statistic:

$$
\mathcal{X}^2 = \sum\frac{(\textbf{observed} - \textbf{expected})^2}{\textbf{expected}}
$$

where the sum is over the $k$ different categories. The P-value is the area to the right of $\mathcal{X}^2$ under the density curve of the chi-square distribution with $k-1$ degrees of freedom.

## Chapter 10: Inference for Regression

### 10.1 Simple Linear Regression

The **slope（斜率）** and **intercept（截距）** of the least-squares line are **statistics**.

These statistics would take somewhat different values if we repeated the data production process. To do inference, think of $b_0$ and $b_1$ as **estimates（估计量）** of unknown parameters $\beta_0$ and $β_1$ that describe the **population** of interest. **（记$b_0$和$b_1$为总体参数$\beta_0$和$\beta_1$的估计量）**

We have **$n$ observations** on an **explanatory variable $x$** and a **response variable $y$**. Our goal is to study or predict the behavior of $y$ for given values of $x$.
- For any fixed value of $x$, the **response $y$ varies according to a Normal distribution**. Repeated responses **$y$ are independent** of each other.
- The mean response $µ_y$ has a straight line relationship with $x$ given by a population regression line $µ_y = \beta_0 + β_1x$.
- The **slope** and **intercept** are **unknown parameters（斜率和截距是未知参数）**.
- The standard deviation of $y$ (call it $σ$) is the same for all values of $x$. The value of $σ$ is unknown.

In the **population**, the linear regression equation is:

$$
\mu_y = \beta_0 + \beta_1x
$$

Sample data fits **simple linear regression model**:

$$
\begin{align}
    \textbf{data} &= \textbf{fit} + \textbf{error} \nonumber\\
    y_i &= (\beta_0 + \beta_1x_i) + (\varepsilon_i) \nonumber
\end{align}
$$

where the $\varepsilon_i$ are **independent** and **Normally** distributed $N(0, \sigma)$.

The intercept $b_0$, the slope $b_1$, and the standard deviation $\sigma$ of $y$ are **the unknown parameters of the regression model**, and The value of $\hat{y}$ from the **least-squares regression line（最小二乘回归线）** is really a prediction of the mean value of $y (\mu_y)$ for a given value of $x$.

The least-squares regression line $(\hat{y} = b_0 + b_1x)$ obtained from sample data is the **best estimate（最佳拟合）** of the true population regression line $(\mu_y = b_0 + b_1x)$:
- $\hat{y}$ is an unbiased estimate for mean response $\mu_y$
- $b_0$ is an unbiased estimate for intercept $\beta_0$
- $b_1$ is an unbiased estimate for slope $\beta_1$

The **population standard deviation $\sigma$** for $y$ at any given value of $x$ represents **the spread of the normal distribution** of the $\varepsilon_i$ around the mean $\mu_y$.

The **predicted values（预测值，预测值是均值，代表任何拥有自变量为$x_i$的值会得到预测值$\hat{y_i}$）** are $\hat{y_i} = b_0 + b_1x_i$, $i = 1, \dots, n$ and the **residuals（残差）** are $y_i - \hat{y_i}$, $i = 1, \dots, n$. And the **regression standard error（回归标准差）**, $s$, for $n$ sample data points is calculated from the residuals $(y_i - \hat{y_i})$:

$$
s = \sqrt{\frac{\sum(\textbf{residual})^2}{n-2}} = \sqrt{\frac{\sum(y_i - \hat{y_i})^2}{n-2}}
$$

$s$ is an essentially **unbiased estimate（无偏估计量）** of the regression standard deviation $\sigma$.

Before you can trust the results of **regression inference（回归推理）**, you must check the conditions for inference one by one:
- The **relationship is linear（关系是线性的）** in the population
- The **response varies Normally（因变量是关于回归线正态分布的）** about the population regression line
- Observations are **independent**
- The **standard deviation** of the responses is the **same** for all values of $x$

The **slope** $β_1$ of the population regression line $µ_y = β_0 + β_1x$ is the **rate of change of the mean response** as the explanatory variable increases, the **confidence interval** for $β_1$ has the familiar form:

$$
\textbf{estimate} \pm t^* \cdot (\textbf{standard deviation of estimate})
$$

and because we use the statistic $b$ as our estimate, the confidence interval is:

$$
b_1 \pm t^*\cdot \textbf{SE}_{b_1}
$$

Here $t^*$ is the critical value for the $t$ distribution with $df = n – 2$ having area $C$ between $–t^*$ and $t^*$.

To test the hypothesis $H_0: β_1 = \textbf{hypothesized value}$, compute the test statistic and use the $t$ distribution with $df = n - 2$:

$$
t = \frac{b_1 - \textbf{hypothesized value}}{\textbf{SE}_{b_1}}
$$

We may look for evidence of a **significant relationship（关系显著性）**, we can test the hypothesis that the regression slope parameter $β_1$ is equal to zero:

$$
H_0: \beta_1 = 0 \text{ vs. } H_a: \beta_1\not=0 
$$

Testing $H_0: β_1 = 0$ is equivalent to testing the hypothesis of no correlation between $x$ and $y$ in the population:

$$
\textbf{slope }b_1 = r\times\frac{s_y}{s_x}
$$

We can also calculate a confidence interval for the **population mean $μ_y$** of all responses $y$:

$$
\hat{\mu_y} \pm t^* \cdot \textbf{SE}_{\hat{\mu}}
$$

where $t^*$ is the value such that the area under the $t(n – 2)$ density curve between $–t^*$ and $t^*$ is $C$.

To estimate an **individual response $y$** for a given value of $x$, we use a **prediction interval（预测区间）**, the level $C$ prediction interval for a single observation on $y$ is:

$$
\hat{y} \pm t^* \cdot \textbf{SE}_{\hat{y}}
$$

$t^*$ is the critical value for the $t(n – 2)$ distribution with area $C$ between $–t^*$ and $t^*$.

### 10.2 More Detail about Simple Linear Regression*

From 10.1, The regression model is:

$$
\begin{align}
    \textbf{data} &= \textbf{fit} + \textbf{error} \nonumber\\
    y_i &= (\beta_0 + \beta_1x_i) + (\varepsilon_i) \nonumber
\end{align}
$$

where the $\varepsilon_i$ are **independent** and **Normally** distributed $N(0, \sigma)$, and $\sigma$ is the same for all values of $x$.

It resembles an **ANOVA（方差分析/ANalysis Of VAriance）**, which also assumes equal variance, where:

$$
\begin{align}
    \textbf{SST} &= \textbf{SS model} + \textbf{SS error} \nonumber\\
    \textbf{DFT} &= \textbf{DF model} + \textbf{DF error} \nonumber
\end{align}
$$

**SS** means **Sum of Squares（平方和）**.

For a simple linear relationship, the ANOVA tests the hypotheses:

$$
H_0: \beta_1 = 0 \text{ vs. } H_a: \beta_1 \not= 0
$$

by comparing $\textbf{MSM}$ (model) to $\textbf{MSE}$ (error): $\displaystyle F = \frac{MSM}{MSE}$, when $H_0$ is true, $F$ follows the **$F(1, n-2)$ distribution**. The P-value is $P(F\geq f)$.

**The ANOVA test and the two-sided t-test for $H_0: β_1 = 0$ yield the same P-value. （方差分析和双尾t检验对于$H_0:\beta_1 = 0$的检验将会得到相同的p值）**

**The ANOVA Table**:

|Source|Sum of Squares($\textbf{SS}$)|$\textbf{DF}$|Mean Square(MS)|$F$|P-value|
|-|-|-|-|-|-|
|Model|$\textbf{SSM} = \sum_{i=1}^n(\hat{y_i} - \bar{y})^2$|$1$|$\textbf{MSM} = \textbf{SSM}/\textbf{DFM}$|$\textbf{MSM}/\textbf{MSE}$|Tail area above $F$|
|Error|$\textbf{SSE} = \sum_{i=1}^n(y_i - \hat{y_i})^2$|$n-2$|$\textbf{MSE}=\textbf{SSE}/\textbf{DFE}$|||
|Total|$\textbf{SST} = \sum_{i=1}^n(y_1 - \bar{y})^2$|$n-1$||||

$$
\begin{align}
    \textbf{SST} &= \textbf{SSM} + \textbf{SSE} \nonumber\\
    \textbf{DFT} &= \textbf{DFM} + \textbf{DFE} \nonumber\\
    F &= \textbf{MSM}/\textbf{MSE} \nonumber
\end{align}
$$

The standard deviation, $s$, of the $n$ residuals $e_i = y_i – \hat{y_i}$, $i = 1, \dots, n$, is calculated from the following quantity:

$$
s^2 = \frac{\sum e_i^2}{n-2} = \frac{\sum(y_i - \hat{y_i})^2}{n-2} = \frac{\textbf{SSE}}{\textbf{DFE}} = \textbf{MSE}
$$

$s$ is an approximately **unbiased estimate** of the regression standard deviation $σ$.

To assess variation in the estimates of $β_0$ and $β_1$, we calculate the standard errors for the estimated regression coefficients:
- The standard error of the slope estimate $b_1$ is:
$$
\textbf{SE}_{b_1} = \frac{s}{\sqrt{\sum(x_i - \bar{x_i})^2}}
$$
- The standard error of the intercept estimate $b_0$ is:
$$
\textbf{SE}_{b_0} = s\sqrt{\frac{1}{n} + \frac{\bar{x}^2}{\sum(x_i - \bar{x_i})^2}}
$$

To estimate mean responses or predict future responses, we calculate the following standard errors:
- The standard error of the estimate of the mean response $\mu_y$ is:
$$
\textbf{SE}_{\hat{\mu}} = s\sqrt{\frac{1}{n} + \frac{(x^*-\bar{x})^2}{\sum(x-\bar{x})^2}}
$$
- The standard error for predicting an individual response $y$ is:
$$
\textbf{SE}_{\hat{y}} = s\sqrt{1 + \frac{1}{n} + \frac{(x^*-\bar{x})^2}{\sum(x-\bar{x})^2}}
$$

To test the null hypothesis of no linear association, we have the choice of also using the correlation parameter $ρ$:

$$
b_1 = r \times \frac{s_y}{s_x}
$$

The test of significance for $ρ$ uses the one-sample t-test for: $H_0: ρ = 0$, compute the $t$ statistic for sample size $n$ and correlation coefficient $r$:

$$
t = \frac{r\sqrt{n-2}}{\sqrt{1-r^2}}
$$

The P-value is the area under $t(n – 2)$ for values of $t$ as or more extreme than $t$ in the direction of $H_a$.

## Chapter 11: Multiple Regression

### 11.1 Inference for Multiple Regression

The linear regression model in which the mean response, $μ_y$, is related to **one explanatory variable** $x$:

$$
\mu_y = \beta_0 + \beta_1x
$$

The data for a **simple linear regression** problem consist of $n$ observations $(x_i, y_i)$ of **two variables**.

In multiple regression, the response variable $y$ depends on **$p$ explanatory variables** $x_1, x_2, \dots, x_p$:

$$
\mu_y = \beta_0 + \beta_1x_1 + \beta_2x_2 + \cdots + \beta_px_p
$$

Data for **multiple linear regression** consist of the value of a response variable $y$ and **$p$ explanatory variables** $(x_1, x_2, \dots, x_p)$ on each of $n$ cases.

The **statistical model for multiple linear regression** is:

$$
y_i = \beta_0 + \beta_1x_{i1} + \cdots + \beta_p x_{ip} + \varepsilon_i
$$

for $i = 1, 2, \dots, n$

The **mean response $\mu_y$** is a linear function of the explanatory variables:

$$
\mu_y = \beta_0 + \beta_1x_1 + \beta_2x_2 + \cdots + \beta_px_p
$$

The **deviations $\varepsilon_i$（偏差）** are independent and Normally distributed $N(0, \sigma)$

The **parameters of the model（模型参数）** are $\beta_0, \beta_1, \dots, \beta_p$ and $\sigma$.

The coefficient $\beta_i$($i = 1, \dots, p$) represents **the average change in the response** when the variable $x_i$ increases by one unit and all other $x$ variables are held constant. **（每个$x_i$对应的系数$\beta_i$只代表了该变量变化单位值且其他变量$x_j$($j\not=i$)保持不变时，响应变量变化的值）**

**Estimation of the Parameters（参数值估计）**

Select a **random sample of $n$ individuals** on which $p+1$ variables $(x_1,\dots, x_p, y)$ are measured. The **least-squares regression method** chooses $b_0, b_1, \dots, b_p$ to minimize the sum of squared deviations $(y_i – \hat{y_i})^2$, where:

$$
\hat{y_i} = b_0 + b_1x_{i1} + \cdots + b_p x_{ip}
$$

As with simple linear regression, the constant $b_0$ is the **y-intercept**.

The parameter $\sigma^2$ measures the variability of the responses about the population response mean. The estimator of $σ^2$ is:

$$
s^2 = \frac{\sum e_i^2}{n-p-1} = \frac{\sum(y_i - \hat{y_i})^2}{n-p-1}
$$

**Confidence Interval for $\beta_i$** rely on the $t$-distribution, with **$n - p - 1$ degrees of freedom**, a level $C$ confidence interval for $\beta_j$ is:

$$
b_j \pm t^* \cdot \textbf{SE}_{b_j}
$$

where $\textbf{SE}_{b_j}$ is the standard error of $b_j$ and $t^*$ is the $t$ critical for the $t(n-p-1)$ distribution with area $C$ between $-t^*$ and $t^*$

**Significance Test for $β_j$（$\beta_j$的显著性检验）**:
- Null hypothesis $H_0: \beta_j = 0$, calculate the $t$ statistic:

    $$
    t = \frac{b_j}{\textbf{SE}_{b_j}}
    $$
which has the $t(n - p - 1)$ distribution.

- Alternative hypothesis:
  - $H_a: \beta_j > 0$ is $P(T\geq t)$
  - $H_a: \beta_j < 0$ is $P(T\leq t)$
  - $H_a: \beta_j \not= 0$ is $2P(T \geq |t|)$
  - **Note**: Software typically provides **two-sided** P-values

**Significance Test for $β_j$**
- Suppose we test $H_0: β_j = 0$ for each $j$ and find that **none of the $p$ tests is significant**, we **should not** conclude that **none of the explanatory variables is related to the response（不应得出结论认为所有解释变量均与响应无关）**.
- When we fail to reject $H_0: β_j = 0$, this means that we **probably don't need $x_j$ in the model with all the other variables（我们可能不需要在模型中包含$x_j$）**, so it merely means that it's **safe to throw away at least one of the variables（安全地丢弃至少一个变量）**.

**ANOVA $F$-test for Multiple Regression（对多变量回归的ANOVA $F$检验）**
In multiple regression, the ANOVA $F$ statistic tests the hypotheses:

$$
H_0: \beta_1 = \beta_2 = \cdots = \beta_p = 0 \text{ vs. } H_a: \text{ at least one }\beta_j\not=0
$$

by computing the $F$ statistic $F = \textbf{MSM} / \textbf{MSE}$, When $H_0$ is true, $F$ follows the $F(p, n - p - 1)$ distribution. The P-value is $P(F \geq f)$.

**$p$ is number of predictors（$p$是自变量/预测变量的数量）**

*A significant P-value doesn’t mean that all $p$ explanatory variables have a significant influence on $y$——**only that at least one does**.*

**ANOVA Table for Multiple Regression**

|Source|Sum of Squares $\textbf{SS}$|$df$|Mean square $\textbf{MS}$|$F$|P-value|
|-|-|-|-|-|-|
|Model|$\sum(\hat{y_i}-\bar{y})^2$|$p$|$\textbf{MSM}=\textbf{SSM}/\textbf{DFM}$|$\textbf{MSM}/\textbf{MSE}$|Tail area above $F$|
|Error|$\sum(y_i - \hat{y_i})^2$|$n-p-1$|$\textbf{MSE}=\textbf{SSE}/\textbf{DFE}$|||
|Total|$\sum(y_i - \bar{y})^2$|$n-1$||||

$\textbf{SSM} =$model sum of squares, $\textbf{SSE} =$error sum of squares

$\textbf{SST} =$total sum of squares, $\textbf{SST} = \textbf{SSM} + \textbf{SSE}$

$\textbf{DFM} = p$, $\textbf{DFE} = n - p - 1$, $\textbf{DFT} = n - 1$, $\textbf{DFT} = \textbf{DFM} + \textbf{DFE}$

**Squared Multiple Correlation $R^2$（多变量相关系数$R$方）**
$R^2$, the squared multiple correlation, is **the proportion of the variation in the response variable** $y$ that is explained by the model.

$$
R^2 = \frac{\sum(\hat{y_i} - \bar{y})^2}{\sum(y_i - \bar{y})^2} = \frac{\textbf{SSM}}{\textbf{SST}}
$$

The square root of $R^2$, namely $R$, called the **multiple correlation coefficient（多变量相关系数）**, is the **correlation between the observations and the predicted values（观测值和预测值的相关性）**.

## Chapter 12: One-Way Analysis of Variance

### 12.1 Inference for One-Way Analysis of Variance

Compare any number of means using **analysis of variance(ANOVA/方差分析)**.

The Idea of ANOVA:
- Analysis of variance (ANOVA) is the technique used to **compare several means（比较多个均值）**.
- **One-way ANOVA（单因子方差分析）** is used for situations in which there is **only one factor（单因子）**, or **only one way to classify the populations（单向总体分类）** of interest.
- **Two-way ANOVA（双因子方差分析）** is used to analyze the effect of **two factors（双因子）**.
- Analysis of variance(ANOVA) compares the variation due to specific sources with the variation among individuals who should be similar. In particular, ANOVA tests whether several populations **have the same means（具有相同的均值）** by comparing **how far apart the sample means are（样本均值之间相距/组间均方）** with **how much variation there is within a sample（样本的变异程度/组内均方）**.

- An **overall test（整体测试）** to find any differences among the parameters we want to compare **（找出我们想要比较的参数的差异）**
- A detailed **follow-up analysis（后续分析）** to decide which groups differ and how large the differences are **（确定哪些组存在差异，以及差异的大小）**

Random sampling always produces chance variations. Any "**factor effect（因素效应）**" would thus show up in our data as the **factor-driven differences（因素驱动的差异）** plus **chance variations ("error")（机会变化/偶然差异）**:

$$
\textbf{data} = \textbf{factor effect} + \textbf{error}
$$

And the one-way ANOVA model analyzes data $x_{ij}$ where **chance variations are normally distributed（偶然差异满足正态分布）** $N(0,σ)$, and we take random samples from each of **$I$ different populations（总体大小为$I$）**:

$$
\begin{align}
    x_{ij} &= \mu_i + \varepsilon_{ij} \nonumber\\
    &= \mu + \alpha_i + \varepsilon_{ij} \nonumber
\end{align}
$$

for $i = 1, \dots, I$ and $j = 1, \dots, n_i$. The $ε_{ij}$ are assumed to be from a $N(0,σ)$ distribution. The **parameters of the model（模型参数）** are the **population means（总体均值）$μ_1, μ_2, \dots, μ_I$** and the **common standard deviation（共同标准差）$σ$**.

$μ_i$ can be broken into the overall mean $μ$ and the effect of level $i$ of the factor. **（$\mu_i$可以分解为总体均值$\mu$和$i$水平下因子的效应）**

Test the **null hypothesis（零假设）** that there are **no differences among the means（均值之间没有差异）** of the populations, and the **alternative hypothesis（备选假设）** is that there is **some difference, namely not all means are equal, the hypothesis is not one-sided or two-sided. It is "many-sided"（均值之间存在差异，这个假设是多尾的）**.

The above test is called the **analysis of variance $F$ test（ANOVA $F$检验）**.

The conditions under which we can use ANOVA are:
- Conditions for ANOVA Inference
  - We have **$I$ independent SRSs（有$I$个独立的简单随机抽样样本）**, one from each population. We **measure the same response variable for each sample（测量每个样本中同样的相应变量）**.
  - The $i$-th population has a **Normal distribution** with unknown **mean $μ_i$**. **（均值$\mu_i$满足正态分布）**
  - All the populations **have the same standard deviation $σ$**, whose **value is unknown**. **（所有总体有同样的方差，但方差值未知）**
- Checking Standard Deviations in ANOVA
  - The results of the ANOVA $F$ test are approximately correct **when the largest sample standard deviation is no more than twice as large as the smallest sample standard deviation（当最大样本标准差不超过最小样本标准差的两倍时）**.

To determine statistical significance, we need a test statistic—the ANOVA $F$ Statistic, it has this form:

$$
F = \frac{\textbf{variation among the sample means}}{\textbf{variation among individuals in the same sample}}
$$

- $F$ is always **zero or positive（$F$值大于等于$0$）**
    - $F$ is **zero** only when **all sample means are the same（所有样本均值相同时$F$值为$0$）**.
    - $F$ gets **larger** as **means move further apart（样本均值偏差越大，$F$值越大）**.
- Large values of $F$ are evidence against $H_0: \textbf{equal means}$
- The $F$ test is **upper-one-sided（$x$坐标轴上方的单尾检验）**.

When describing an $F$ distribution, always give the **numerator degrees of freedom first（分子作为$F$分布的第一个自由度参数）**. $F(df_1, df_2)$ with 
- $df_1$ degrees of freedom in the **numerator（分子）**
- $df_2$ degrees of freedom in the **denominator（分母）**
- We want to compare the means of $I$ populations. We have an SRS of size $n_i$ from the $i$-th population, so that the total number of observations in all samples combined is:
    $$
    N = n_1 + n_2 + \cdots + n_I
    $$
If the null hypothesis is all population means are equal, the ANOVA $F$ statistic has the F distribution with **$I – 1$ degrees of freedom in the numerator** and **$N – I$ degrees of freedom in the denominator**.
    $$
    F(I - 1, N - I)
    $$

The **measures of variation** in the numerator and denominator are **mean squares**:
- Numerator: **Mean Square for Groups** ($\textbf{MSG}$)
    $$
    \textbf{MSG} = \frac{n_1(\bar{x_1} - \bar{x})^2 + n_2(\bar{x_2} - \bar{x})^2 + \cdots + n_I(\bar{x_I - \bar{x}})^2}{I - 1}
    $$
- Denominator: **Mean Square for Error** ($\textbf{MSE}$)
    $$
    \textbf{MSE} = \frac{(n_1 - 1)s_1^2 + (n_2 - 1)s_2^2 + \cdots + (n_I - 1)s_I^2}{N - I}
    $$
    - MSE is also called the **pooled sample variance**, written as $s_p^2$ ($s_p$ is the **pooled standard deviation**)
    - $s_p^2$ estimates the **common variance（共同方差）** $\sigma^2$

**The ANOVA Table**

|Source of variation|Sum of squares$\textbf{SS}$|$df$|Mean square$\textbf{MS}$|$F$|P-value|$F$ crit|
|-|-|-|-|-|-|-|
|Among or between "groups"|$\sum n_i(\bar{x_i} - \bar{x})^2$|$I - 1$|$\textbf{MSG} = \textbf{SSG}/\textbf{DFG}$|$\textbf{MSG}/\textbf{MSE}$|Tail area above $F$|Value of $F$ for $\alpha$|
|Within groups or "error"|$\sum (n_i - 1)s_i^2$|$N - I$|$\textbf{MSE} = \textbf{SSE}/\textbf{DFE}$||||
|Total|$\textbf{SST} = \textbf{SSG} + \textbf{SSE}\\\sum(x_{ij} - \bar{x})^2$|$N - 1$|||||

Coefficient of determination: 
$$
R^2 = \textbf{SSG}/\textbf{SST}
$$

Pooled standard deviation:
$$
\sqrt{\textbf{MSE}} = s_p
$$

The sums of squares represent different sources of variation in the data:
$$
\textbf{SST} = \textbf{SSG} + \textbf{SSE}
$$

The degrees of freedom mirror the sums of squares:
$$
\textbf{DFT} = \textbf{DFG} + \textbf{DFE}
$$

$$
\textbf{data(``Total")} = \textbf{factor effect(``Groups")} + \textbf{error(``Error")}
$$

### 12.2 Comparing the Means

**Contrasts（对比）** can be used only when there are clear expectations **BEFORE starting an experiment**, and these are reflected in the experimental design. Contrasts are **planned comparisons（有计划的比较）**.
  - It is **NOT appropriate to use a contrast** test when that test is suggested only **AFTER the data are collected**. **（在数据收集后进行对比是不合适的）**
  - To **test a specific hypothesis that some treatments are different from other treatments（测试特定假设中的一些不同措施）**, we can use a contrast to test for significant differences
  - Contrasts are more powerful than multiple comparisons because they are more specific. **（对比相比多重比较更有说服力，因为它更具体）**
  - Use a **$t$-test** on the contrast or calculate a $t$ confidence interval
  - Since the hypothesis is **pre-specified（假设是预先指定的）**, the corresponding $t$-test is typically done in lieu of the multiple sample ANOVA test **（通常会进行相应的$t$检验来代替多样本方差分析检验）**

A contrast is **a combination of population means（总体均值的组合）** of the form, where the coefficients $a_i$ have sum $0$:

$$
\psi = \sum a_i\mu_i
$$

To test the null hypothesis $H_0: \psi = 0$ use the $t$ statistic with degrees of freedom $\textbf{DFE}$ that is associated with $s_p$. The alternative hypothesis can be **one- or two-sided**:

$$
t = \frac{c}{\text{SE}_c}
$$

The corresponding sample contrast is:

$$
c = \sum a_i\bar{x_i}
$$

The standard error of $c$ is:

$$
\textbf{SE}_c = s_p\sqrt{\sum\frac{a_i^2}{n_i}} = \sqrt{\textbf{MSE}\times\sum\frac{a_i^2}{n_i}}
$$


A level $C$ confidence interval for the difference $\psi$, where $t^*$ is the critical value defining the middle $C$% of the $t$ distribution with $\textbf{DFE}$ degrees of freedom:

$$
c \pm t^*\times \textbf{SE}_c
$$

**Multiple comparisons（多重比较）** should be used when **the pattern of differences between means is unknown beforehand（平均值差异事先未知）**. Such comparisons are **pair-wise（成对比较）** tests of significance.

**Planned vs. Post-Hoc Tests（计划测试与事后测试）**:
- **Planned tests** are tests formulated **prior to the data collection（计划测试是在数据收集之前制定的测试）**. These are **contrasts** that are of interest to the researchers on top of the overall F-test
- **Post-hoc tests** are tests formulated **after ANOVA has been performed（事后测试是在执行方差分析后制定的测试）**
- After a significant F-test has been obtained, different contrasts that are of interest to the researchers may be formulated. **In most cases, contrasts in the form of pairwise comparisons（大多数情况下以成对比较的形式进行对比）** are formulated
- Some people proceed with testing the different contrasts **without considering when the contrasts were formulated – before or after the data collection – or how many contrasts involved（不考虑对比何时制定或涉及多少对比）**
    - This approach **inflates the overall Type I error（夸大了总体的I类误差）** (i.e., **false positive rate（假阳性率）**) because it only **controls for what is called the testwise Type I error rate（仅控制所谓的 testwise I类错误率）**
    - This means that the **test for each contrast will have an error rate of $α$（每个对比的测试都会有$α$的错误率）**
    - However, the error rate for all the different tests taken together (known as familywise Type I error rate) is not known, but can be assumed to be higher than $α$
    - To **keep the familywise Type I error at most at $α$（保持在最多$α$的familywise的I类误差）**, some adjustments need to be adopted to **make the individual tests more conservative（使个体测试更加保守）**

**The Bonferroni Procedure（邦费罗尼校正）**

The Bonferroni procedure is an example of **a procedure that adjusts for simultaneously performing many tests at the same time（调整同时执行多个测试的过程）**.

The Bonferroni procedure can be done in either of two equivalent ways. In either approach, one **chooses an overall significance level $α$** and then does a number of pair-wise **$t$-tests**. Let **$k$ be the total number of $t$-tests performed**.

- Use the procedure with $t^*$ being the $t$-value with degrees of freedom $\textbf{DFE}$ and **an area of $α/(2k)$ to its right（右侧面积为 $α/(2k)$，即总体显著性水平$\alpha$除以$2\times$进行$t$检验的次数$k$）**
- Compute a P-value for each $t$-test in the usual way. Conclude that a particular pair of means is significantly different only when $k$ times that P-value is no larger than $α$ **（仅当 $k$ 乘以 P 值不大于 $α$ 时，得出结论，特定的均值对/pair of means，其存在显著的不同）**
- When one does multiple comparisons the chance of committing at least one **type I error** increases with the number of tests done **（当进行多次比较时，犯至少一个I类错误的机会会随着完成的测试次数的增加而增加）**
- To compensate for this tendency, the Bonferroni procedure lowers the working significance level of each test to control the probability of making at least one type I error among all tests performed **（降低了每个测试的显著性水平，以控制在所有执行的测试中至少出现一个I类错误的概率）**
- As a consequence, the more pair-wise comparisons you perform, the more difficult it will be to show statistical significance for each test **（执行的成对比较越多，显示每个测试的统计显着性就越困难）**
- The Bonferroni procedure is **typically used with planned contrasts（通常与计划对比一起使用）**

**Scheffé's Method（薛费氏事后比较法）**

- Scheffé's method **keeps the Type I error at α for all possible (post-hoc) contrasts（将所有可能的、事后对比的I类误差保持在$α$）**
- Consequently, **sleuthing or fishing for significant results is allowed（因此，允许探寻或捞取重大成果？）**
- That is, we can try as many contrasts as we want after getting a significant $F$-test
- However, there's no guarantee that the significant results for the contrasts would be particularly interesting
- Scheffé's method **requires that a different distribution by used（要求使用不同的分布）**
- Scheffé's method **adjust the critical $t^*$ as a function of the $F$ distribution $F(I -1, N - I)$ and the number of groups $I$ （将临界$t^*$调整为$F$分布$F(I -1, N - I)$和组数$I$的函数）**
- Scheffé's method is **the most conservative method（最保守的方法）** that can be used without getting more conservative than necessary
- A related method for post-hoc tests is **Tukey's method**
    - This gives a Type I experimentwise error rate of $α$ for all possible pairwise comparisons
    - Is less conservative than Scheffé's method **（Tukey's method不如Scheffé's method那么保守）**
- As long as we adjust for (1) the number of contrasts or (2) when the contrasts are formulated, the procedure will be more conservative (e.g., more likely to retain the null) than if we do not make any adjustments at all

## Chapter 13: Two-Way Analysis of Variance

### 13.1 The Two-Way ANOVA Model

**Two-Way Designs（双因子）**

In a two-way design, **two factors (independent variables)** are studied in **conjunction（结合）** with **the response (dependent) variable**. There are thus two ways of organizing the data, as shown in a two-way table.

When the dependent variable is **quantitative**, the data are **analyzed with a two-way ANOVA procedure**. A **chi-square test** is used instead if the dependent variable is **categorical**. **（当因变量是定量的时，使用双向方差分析分析数据。如果因变量是分类变量，则使用卡方检验）**

**Two-Way ANOVA（双因子方差分析）**
- It is **more efficient to study two factors at once（同时研究两个因子更有效）** than separately.
  - A two-way design requires smaller sample sizes per condition than does a series of one-way designs because the samples for all levels of factor $\textbf{B}$ contribute to sampling for factor $\textbf{A}$. **（与一系列单向设计相比，双向设计每个条件所需的样本量更小，因为因子$\textbf{B}$所有级别的样本都有助于因子$\textbf{A}$的采样。）**
- Including a second factor thought to influence the response variable helps reduce the residual variation in a model of the data.
  - In a **one-way ANOVA** for factor $\textbf{A}$, any effect of factor $\textbf{B}$ is assigned to the $\textbf{residual}$ ($\textbf{``error"}$ term). In a **two-way ANOVA**, **both factors** contribute to the $\textbf{``fit"}$ part of the model.
- **Interactions between factors（因子间相互作用）** can be investigated.
  - The two-way ANOVA breaks down the fit part of the model between each of the **main components (the two factors)** and an **interaction effect**. The interaction cannot be tested with a series of one-way ANOVAs. **（交互作用无法被单因子方差分析测试）**

**The Two-Way ANOVA Model**

- We record a quantitative variable in a two-way design with **$I$ levels of factor $\textbf{A}$** and **$J$ levels of factor $\textbf{B}$**.

- There are $I × J$ combinations of the two sets of factor levels. We'll use $(i,j)$ to denote the population for which **factor $\textbf{A}$ is at level $i$** and **factor $\textbf{B}$ is at level $j$**.

- We assume that we have **$I × J$ independent SRSs**, one from each population, and that each population is **Normal**. The **population means may be different** but **all populations have the same $σ$**.

- Let $x_{ijk}$ represent the $k$-th observation from population $(i,j)$. The statistical model is:
$$
\begin{align}
    x_{ijk} &= \mu_{ij} &+ \varepsilon_{ijk} \nonumber\\
    &= \mu + \alpha_i + \beta_j + (\alpha\beta)_{ij} &+ \varepsilon_{ijk} \nonumber
\end{align}
$$
where **$μ_{ij}$ is the mean of population $(i,j)$** and **$ε_{ijk}$ is an error term**. 
$μ_{ij}$, the mean of combination $(i,j)$, **can be broken down into** the **overall mean $μ$**, **plus $α_i$**, the effect of level $i$ of Factor $\textbf{A}$, **plus $β_i$**, the effect of level $j$ of Factor $\textbf{B}$, **plus $(αβ)_{ij}$**, the interaction effect of the two levels

**Interaction（相互作用）**: Two variables interact if a particular combination of variables leads to results that **would not be anticipated on the basis of the main effects of those variables（根据这些变量的主要影响却无法被预期的的结果）**. An interaction implies that the effect of one variable is different at different levels of another variable.

**Main Effects（主要影响）**: This is the impact on the response (dependent variable) of varying levels of that factor, **regardless of the other factor** (i.e., pooling together the levels of the other factor). **（只却决于单个解释变量的变化水平）**
- When there is **no clear interaction**, the **main effects are enough** to describe the data. In the **presence of interaction**, the **main effects could mask what is really going on with the data**.

In a two-way design, statistical significance can be found for each factor, for the interaction effect, or for any combination of these:

|Neither factor is significant|Neither factor is significant|Only one factor is significant|Both factors are significant|
|-|-|-|-|
|No interaction|Interaction effect is significant|No interaction|With or without significant interaction|

### 13.2 Inference for Two-Way ANOVA

**Inference for Two-Way ANOVA（双因子方差分析推断）**:
- A one-way ANOVA tests the following model of your data:
$$
\textbf{data(``Total")} = \textbf{fit(``Groups")} + \textbf{residual(``Error")}
$$
so that the sums of squares and degrees of freedom are:
$$
\begin{align}
    \textbf{SST} &= \textbf{SSG} + \textbf{SSE} \nonumber\\
    \textbf{DFT} &= \textbf{DFG} + \textbf{DFE} \nonumber
\end{align}
$$
- When the **sample sizes are equal（样本大小相同）**, a two-way design breaks down the "fit" part of the model into more specific subcomponents, so that:
$$
\begin{align}
    \textbf{SST} &= \textbf{SSA} + \textbf{SSB} + \textbf{SSAB} + \textbf{SSE} \nonumber\\
    \textbf{DFT} &= \textbf{DFA} + \textbf{DFB} + \textbf{DFAB} + \textbf{DFE} \nonumber
\end{align}
$$
where $\mathbf{A}$ and $\mathbf{B}$ are the two **main effects** from each of the two factors, and $\mathbf{AB}$ represents the **interaction** of factors $\mathbf{A}$ and $\mathbf{B}$.

**The Two-Way ANOVA Table（双因子方差分析表）**
|Source of variation|$df$|Sum of Square $\textbf{SS}$|Mean Square $\textbf{MS}$|$F$|P-value|
|-|-|-|-|-|-|
|Factor $\mathbf{A}$|$\mathbf{DFA} = I - 1$|$\textbf{SSA}$|$\textbf{MSA} = \textbf{SSA}/\mathbf{DFA}$|$F_\mathbf{A} = \textbf{MSA}/\textbf{MSE}$|for $F_\mathbf{A}$|
|Factor $\mathbf{B}$|$\mathbf{DFB} = J - 1$|$\textbf{SSB}$|$\textbf{MSB} = \textbf{SSB}/\mathbf{DFB}$|$F_\mathbf{B} = \textbf{MSB}/\textbf{MSE}$|for $F_\mathbf{B}$|
|Interaction|$\mathbf{DFAB} = (I - 1)(J - 1)$|$\textbf{SSAB}$|$\textbf{MSAB} = \textbf{SSAB}/\mathbf{DFAB}$|$F_\mathbf{AB} = \textbf{MSAB}/\textbf{MSE}$|for $F_\mathbf{AB}$|
|Error|$\textbf{DFE} = N - IJ$|$\textbf{SSE}$|$\textbf{MSE} = \textbf{SSE}/\textbf{DFE}$|||
|Total|$\textbf{DFT} = N - 1 =\textbf{DFA}+\textbf{DFB}+\textbf{DFAB}+\textbf{DFE}$|$\textbf{SST} =\textbf{SSA}+\textbf{SSB}+\textbf{SSAB}+\textbf{SSE}$||||

- **Main effects（主要效应）**: P-value for factor $\textbf{A}$, P-value for factor $\textbf{B}$.
- **Interaction**: P-value for the interaction effect of $\textbf{A}$ and $\textbf{B}$.
- **Error**: Represents variability in the measurements within the groups.
- $\textbf{MSE}$ is an unbiased estimate of the population variance $\sigma^2$.

**Cautions for Two-Way ANOVA（双因子方差分析注意事项）**:
1. Always **construct a plot of factor level means（构建因子水平均值图）**. Examine for possible interaction.
2. **Examine the test for interaction first（首先检验交互作用）**. Presence of a strong interaction may influence the interpretation of the main effects. **（强相互作用的存在可能会影响主要效应的解释）**
3. When an interaction is present, carefully examine the means to properly interpret the data. **（当存在相互作用时，需要仔细检验均值以合理解释数据）**
    - The marginal means do not tell the whole story **（边界均值不能说明所有情况）**
    - An examination of treatment means may provide a better interpretation than the ANOVA F tests for main effects. (A treatment mean is the mean response to a particular combination of factor levels.)**（对措施均值的检验也许会提供比ANOVA F检验更好的对主要效应的解释，因为采取某种措施的均值是特定因素水平组合下的响应均值，其可以更好地解释主要效应）**
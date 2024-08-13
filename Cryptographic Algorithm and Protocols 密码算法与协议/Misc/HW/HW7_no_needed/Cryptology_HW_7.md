# Cryptography Homework 7

*2024 Spring Semester*

$\text{21 CST H3Art}$

<!-- TOC -->

- [Cryptography Homework 7](#cryptography-homework-7)
  - [Exercise 8.3](#exercise-83)
  - [Exercise 8.8 (for the cases of the ElGamal Signature Scheme)](#exercise-88-for-the-cases-of-the-elgamal-signature-scheme)

<!-- /TOC -->

## Exercise 8.3

Suppose that Alice is using the *ElGamal Signature Scheme*. In order to save time in generating the random numbers $k$ that are used to sign messages, Alice chooses an initial random value $k_0$, and then signs the $i$th message using the value $k_i = k_0 + 2i\text{ mod }(p − 1)$. Therefore,

$$
k_i = k_{i-1} + 2\text{ mod }(p - 1)
$$

for all $i ≥ 1$. (This is not a recommended method of generating $k$-values!)

(a) Suppose that Bob observes two consecutive signed messages, say $(x_i, \textbf{sig}(x_i, k_i))$ and $(x_{i+1}, \textbf{sig}(x_{i+1}, k_{i+1}))$. Describe how Bob can easily compute Alice’s secret key, $a$, given this information, without solving an instance of the $\textbf{Discrete Logarithm}$ problem. (Note that the value of $i$ does not have to be known for the attack to succeed.)

(b) Suppose that the parameters of the scheme are $p = 28703$, $α = 5$, and $β = 11339$, and the two messages observed by Bob are

$$
\begin{align}
    &x_i = 12000 &\textbf{sig}(x_i, k_i) = (26530, 19862) \nonumber\\
    &x_{i+1} = 24567 &\textbf{sig}(x_{i+1}, k_{i+1}) = (3081, 7604) \nonumber
\end{align}
$$

Find the value of $a$ using the attack you described in part (a).

> **Solution**: 

## Exercise 8.8 (for the cases of the ElGamal Signature Scheme)

We showed that using the same value $k$ to sign two messages in the *ElGamal Signature Scheme* allows the scheme to be broken (i.e., an adversary can determine the secret key without solving an instance of the $\textbf{Discrete Logarithm}$ problem). Show how similar attacks can be carried out for the *Schnorr Signature Scheme*, the *DSA*, and the *ECDSA*.

> **Solution**:
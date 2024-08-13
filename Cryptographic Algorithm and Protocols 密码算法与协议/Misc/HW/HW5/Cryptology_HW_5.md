# Cryptography Homework 5

*2024 Spring Semester*

$\text{21 CST H3Art}$

<!-- TOC -->

- [Cryptography Homework 5](#cryptography-homework-5)
  - [Exercise 6.3](#exercise-63)
  - [Exercise 6.4](#exercise-64)
  - [Exercise 6.5](#exercise-65)
  - [Exercise 6.7](#exercise-67)
  - [Exercise 6.11](#exercise-611)
  - [Exercise 6.13 (No Needed)](#exercise-613-no-needed)
  - [Exercise 6.15](#exercise-615)
  - [Exercise 6.16](#exercise-616)

<!-- /TOC -->

## Exercise 6.3

Use the $\text{EXTENDED EUCLIDEAN ALGORITHM}$ to compute the following multiplicative inverses:

(a) $17^{-1}\text{ mod }101$

(b) $357^{-1}\text{ mod }1234$

(c) $3125^{-1}\text{ mod }9987$

> **Solution**:
> 
> (a)
> $$
> \begin{align}
>     101 &= 17 \times 5 + 16 \nonumber\\
>     17 &= 16 \times 1 + 1 \nonumber\\
>     \nonumber\\
>     1 &= 17 - 16 \times 1 \nonumber\\
>     &= 17 - (101 - 5\times 17) \nonumber\\
>     &= 6\times 17 - 101 \nonumber
> \end{align}
> $$
> 
> Therefore, the inverse of $17$ under modulo $101$ is $6$.
> 
> (b)
> $$
> \begin{align}
>     1234 &= 357 \times 3 + 163 \nonumber\\
>     357 &= 163 \times 2 + 31 \nonumber\\
>     163 &= 31 \times 5 + 8 \nonumber\\
>     31 &= 8 \times 3 + 7 \nonumber\\
>     8 &= 7 \times 1 + 1 \nonumber\\
>     \nonumber\\
>     1 &= 8 - 7 \times 1 \nonumber\\
>     &= 8 - (31 - 8\times 3) \nonumber\\
>     &= 4 \times 8 - 31 \nonumber\\
>     &= 4 \times (163 - 31\times 5) - 31 \nonumber\\
>     &= 4 \times 163 - 31 \times 21 \nonumber\\
>     &= 4 \times 163 - (357 - 163 \times 2) \times 21 \nonumber\\
>     &= 46 \times 163 - 357 \times 21 \nonumber\\
>     &= 46 \times (1234 - 357 \times 3) - 357 \times 21 \nonumber\\
>     &= 46 \times 1234 - 159 \times 357 \nonumber
> \end{align}
> $$
> 
> Therefore, the inverse of $357$ under modulo $1234$ is $-159$.
> 
> (c)
> $$
> \begin{align}
>     9987 &= 3125 \times 3 + 612 \nonumber\\
>     3125 &= 612 \times 5 + 65 \nonumber\\
>     612 &= 65 \times 9 + 27 \nonumber\\
>     65 &= 27 \times 2 + 11 \nonumber\\
>     27 &= 11 \times 2 + 5 \nonumber\\
>     11 &= 5 \times 2 + 1 \nonumber\\
>     \nonumber\\
>     1 &= 11 - 5 \times 2 \nonumber\\
>     &= 11 - (27 - 11 \times 2) \times 2 \nonumber\\
>     &= 11 \times 5 - 27 \times 2 \nonumber\\
>     &= (65 - 27 \times 2) \times 5 - 27 \times 2 \nonumber\\
>     &= 65 \times 5 - 27 \times 12 \nonumber\\
>     &= 65 \times 5 - (612 - 65 \times 9) \times 12 \nonumber\\
>     &= 65 \times 113 - 612 \times 12 \nonumber\\
>     &= (3125 - 612 \times 5) \times 113 - 612 \times 12 \nonumber\\
>     &= 3125 \times 113 - 612 \times 577 \nonumber\\
>     &= 3125 \times 113 - (9987 - 3125 \times 3) \times 577 \nonumber\\
>     &= 3125 \times 1844 - 9987 \times 577 \nonumber
> \end{align}
> $$
> 
> Therefore, the inverse of $3125$ under modulo $9987$ is $1844$.

## Exercise 6.4

Compute $\gcd(57, 93)$, and find integers $s$ and $t$ such that $57s + 93t = \gcd(57, 93)$.

> **Solution**:
> 
> To compute $\gcd(57, 93)$, we use the $\text{EUCLIDEAN ALGORITHM}$ as follows:
> 
> $$
> \begin{align}
>     93 &= 57 \times 1 + 36 \nonumber\\
>     57 &= 36 \times 1 + 21 \nonumber\\
>     36 &= 21 \times 1 + 15 \nonumber\\
>     21 &= 15 \times 1 + 6 \nonumber\\
>     15 &= 6 \times 2 + 3 \nonumber\\
>     6 &= 3 \times 2 + 0 \nonumber
> \end{align}
> $$
> 
> So $\gcd(57, 93) = 3$, and to find integers $s$ and $t$ such that $57s + 93t = \gcd(57, 93)$, we use the $\text{EXTENDED EUCLIDEAN ALGORITHM}$:
> 
> $$
> \begin{align}
>     3 &= 15 - 6 \times 2 \nonumber\\
>     &= 15 - (21 - 15) \times 2 \nonumber\\
>     &= 15 \times 3 - 21 \times 2 \nonumber\\
>     &= (36 - 21) \times 3 - 21 \times 2 \nonumber\\
>     &= 36 \times 3 - 21 \times 5 \nonumber\\
>     &= 36 \times 3 - (57 - 36) \times 5 \nonumber\\
>     &= 36 \times 8 - 57 \times 5 \nonumber\\
>     &= (93 - 57) \times 8 - 57 \times 5 \nonumber\\
>     &= 93 \times 8 - 57 \times 13 \nonumber
> \end{align}
> $$
> 
> Finally we find the corresponding integers for $57s + 93t = \gcd(57, 93)$ are $s = -13$, $t = 8$.

## Exercise 6.5

Suppose $\mathcal{X}:\mathbb{Z}_{105}\rightarrow\mathbb{Z}_3\times\mathbb{Z}_5\times\mathbb{Z}_7$ is defined as

$$
\mathcal{X}(x) = (x\text{ mod }3, x\text{ mod }5, x\text{ mod }7)
$$

Give an explicit formula for the function $\mathcal{X}^{−1}$, and use it to compute $\mathcal{X}^{−1}(2, 2, 3)$.

> **Solution**:
> 
> According to the problem description, we suppose $m_1 = 3$, $m_2 = 5$, $m_3 = 7$, and $M = 3\times 5\times 7 = 105$, so:
> 
> $$
> \begin{align}
>     M_1 &= \frac{105}{3} = 35 \nonumber\\
>     M_2 &= \frac{105}{5} = 21 \nonumber\\
>     M_3 &= \frac{105}{7} = 15 \nonumber
> \end{align}
> $$
> 
> Finally we can find the inverse factors are:
> 
> $$
> \begin{align}
>     y_1 &= 35^{-1}\text{ mod }3 = 2 \nonumber\\
>     y_2 &= 21^{-1}\text{ mod }5 = 1 \nonumber\\
>     y_3 &= 15^{-1}\text{ mod }7 = 1 \nonumber
> \end{align}
> $$
> 
> Therefore, the explicit formula for the function $\mathcal{X}^{-1}$ is:
> 
> $$
> \begin{align}
>     \mathcal{X}^{-1}(a_1, a_2, a_3) &= (35\times 2a_1 + 21\times 1a_2 + 15\times 1a_3)\text{ mod }105 \nonumber\\
>     &= (70a_1 + 21a_2 + 15a_3)\text{ mod }105 \nonumber
> \end{align}
> $$
> 
> and for $\mathcal{X}^{−1}(2, 2, 3)$, the result is as follows:
> 
> $$
> \begin{align}
>     \mathcal{X}^{−1}(2, 2, 3) &= (70\times 2 + 21\times 2 + 15\times 3)\text{ mod }105 \nonumber\\
>     &= 227\text{ mod }105 \nonumber\\
>     &= 17 \nonumber   
> \end{align}
> $$

## Exercise 6.7

Solve the following system of congruences:

$$
\begin{align}
    13x &\equiv 4(\text{mod }99) \nonumber\\
    15x &\equiv 56(\text{mod }101) \nonumber
\end{align}
$$

**HINT**: First use the $\text{EXTENDED EUCLIDEAN ALGORITHM}$, and then apply the Chinese remainder theorem.

> **Solution**:
> 
> Firstly we compute the $13^{-1}\text{ mod }99$ and $15^{-1}\text{ mod }101$ using the $\text{EXTENDED EUCLIDEAN ALGORITHM}$.
> 
> For $13^{-1}\text{ mod }99$:
> 
> $$
> \begin{align}
>     99 &= 13\times 7 + 8 \nonumber\\
>     13 &= 8\times 1 + 5 \nonumber\\
>     8 &= 5\times 1 + 3 \nonumber\\
>     5 &= 3\times 1 + 2 \nonumber\\
>     3 &= 2\times 1 + 1 \nonumber\\
>     \nonumber\\
>     1 &= 3 - 2\times1 \nonumber\\
>     &= 3 - (5 - 3) \nonumber\\
>     &= 3\times 2 - 5 \nonumber\\
>     &= (8 - 5)\times 2 - 5 \nonumber\\
>     &= 8\times 2 - 5 \times 3 \nonumber\\
>     &= 8\times 2 - (13 - 8)\times 3 \nonumber\\
>     &= 8\times 5 - 13 \times 3 \nonumber\\
>     &= (99 - 13\times 7)\times 5 - 13 \times 3 \nonumber\\
>     &= 99\times 5 - 13\times 38 \nonumber
> \end{align}
> $$
> 
> So the inverse of $13$ under modulo $99$ is $-38$, for $15^{-1}\text{ mod }101$:
> 
> $$
> \begin{align}
>     101 &= 15\times 6 + 11 \nonumber\\
>     15 &= 11\times 1 + 4 \nonumber\\
>     11 &= 4\times 2 + 3 \nonumber\\
>     4 &= 3\times 1 + 1 \nonumber\\
>     \nonumber\\
>     1 &= 4 - 3\times1 \nonumber\\
>     &= 4 - (11 - 4\times 2) \nonumber\\
>     &= 4\times 3 - 11 \nonumber\\
>     &= (15 - 11)\times 3 - 11 \nonumber\\
>     &= 15\times 3 - 11 \times 4 \nonumber\\
>     &= 15\times 3 - (101 - 15\times 6)\times 4 \nonumber\\
>     &= 15\times 27 - 101 \times 4 \nonumber
> \end{align}
> $$
> 
> So the inverse of $15$ under modulo $101$ is $27$.
> 
> Nextly, since $13 \times (-38) \equiv 1\text{ mod }99$, we can multiply $4$ on both sides, then we get:
> 
> $$
> 13\times (-38)\times 4 \equiv 4\text{ mod }99
> $$
> 
> So for $13x_1 \equiv 4(\text{mod }99)$, $x_1 = -38\times 4\text{ mod }99 = 46$.
> 
> Similarly, since $15\times 27 \equiv 1\text{ mod }101$, we multiply $56$ on both sides then get:
> 
> $$
> 15\times 27 \times 56 \equiv 56 \text{ mod }101
> $$
> 
> For $15x_2 \equiv 56(\text{mod }101)$, $x_2 = 27\times 56\text{ mod }101 = 98$.
> 
> Finally, by applying the Chinese remainder theorem, suppose $M = 99\times 101 = 9999$, $\displaystyle M_1 = \frac{9999}{99} = 101$, $\displaystyle M_2 = \frac{9999}{101} = 99$.
> 
> Hence, $y_1 = 101^{-1}\text{ mod }99 = 50$, $y_2 = 99^{-1}\text{ mod }101 = 50$, the solution of the given system of congruences is:
> 
> $$
> \begin{align}
>     x^{-1}(a_1, a_2) &= (50\times 101\times a_1 + 50\times 99\times a_2)\text{ mod }9999 \nonumber\\
>     &= (5050a_1 + 4950a_2)\text{ mod }9999 \nonumber
> \end{align}
> $$
> 
> Substitute $a_1 = 46$, $a_2 = 98$ to the above formula, the solution value is:
> 
> $$
> \begin{align}
>     x^{-1}(46, 98) &= (5050\times 46 + 4950\times 98)\text{ mod }9999 \nonumber\\
>     &= 717400\text{ mod }9999 \nonumber\\
>     &= 7471 \nonumber
> \end{align}
> $$

## Exercise 6.11

Suppose that $n = pq$, where $p$ and $q$ are distinct odd primes and $ab ≡ 1 (\text{mod }(p − 1)(q − 1))$. The RSA encryption operation is $e(x) = x^b\text{ mod }n$ and the decryption operation is $d(y) = y^a\text{ mod }n$. We proved that $d(e(x)) = x$ if $x ∈ \mathbb{Z}_n^∗$. Prove that the same statement is true for any $x ∈ \mathbb{Z}_n$.

**HINT**: Use the fact that $x_1 ≡ x_2 (\text{mod }pq)$ if and only if $x_1 ≡ x_2 (\text{mod }p)$ and $x_1 ≡ x_2 (\text{mod }q)$. This follows from the Chinese remainder theorem.

> **Solution**:
> 
> Suppose $x \not\equiv 0 \ (\text{mod} \ p)$. Then, for some integer $k > 0$, it holds that
> 
> $$
> x^{ab} = x^{1 + k(p - 1)(q - 1)} \equiv x \cdot x^{k(p - 1)(q - 1)} \equiv x \ (\text{mod} \ p)
> $$
> 
> If $x \equiv 0 \ (\text{mod} \ p)$, then $x^{ab} \equiv x \equiv 0 \ (\text{mod} \ p)$. Therefore, $x^{ab} \equiv x \ (\text{mod} \ p)$ for any $x \in \mathbb{Z}_p$. Similarly, $x^{ab} \equiv x \ (\text{mod} \ q)$ for any $x \in \mathbb{Z}_q$. Now, applying the Chinese Remainder Theorem, $x^{ab} \equiv x \ (\text{mod} \ n)$ for any $x \in \mathbb{Z}_n$.

## Exercise 6.13 (No Needed)

Two samples of RSA ciphertext are presented in $\textbf{Tables 6.2}$ and $\textbf{6.3}$. Your task is to decrypt them. The public parameters of the system are $n = 18923$ and $b = 1261$ (for $\textbf{Table 6.2}$) and $n = 31313$ and $b = 4913$ (for $\textbf{Table 6.3}$). This can be accomplished as follows. First, factor $n$ (which is easy because it is so small). Then compute the exponent $a$ from $φ(n)$, and, finally, decrypt the ciphertext. Use the $\text{SQUARE-AND-MULTIPLY ALGORITHM}$ to exponentiate modulo $n$.

In order to translate the plaintext back into ordinary English text, you need to know how alphabetic characters are "encoded" as elements in $\mathbb{Z}_n$. Each element of $\mathbb{Z}_n$ represents three alphabetic characters as in the following examples:

$$
\begin{align}
    \text{DOG} &\rightarrow 3\times26^2 + 14\times26 + 6 = 2398 \nonumber\\
    \text{CAT} &\rightarrow 2\times26^2 + 0\times26 + 19 = 1371 \nonumber\\
    \text{ZZZ} &\rightarrow 25\times26^2 + 25\times26 + 25 = 17575 \nonumber
\end{align}
$$

You will have to invert this process as the final step in your program.

$$
\textbf{TABLE 6.2}:\text{RSA ciphertext}
$$

$$
\begin{array}{rrrrrrrr}
12423 &  11524 &  7243  &  7459  &  14303 &  6127  &  10964 &  16399 \\
9792  &  13629 &  14407 &  18817 &  18830 &  13556 &  3159  &  16647 \\
5300  &  13951 &  81    &  8986  &  8007  &  13167 &  10022 &  17213 \\
2264  &  961   &  17459 &  4101  &  2999  &  14569 &  17183 &  15827 \\
12693 &  9553  &  18194 &  3830  &  2664  &  13998 &  12501 &  18873 \\
12161 &  13071 &  16900 &  7233  &  8270  &  17086 &  9792  &  14266 \\
13236 &  5300  &  13951 &  8850  &  12129 &  6091  &  18110 &  3332 \\
15061 &  12347 &  7817  &  7946  &  11675 &  13924 &  13892 &  18031 \\
2620  &  6276  &  8500  &  201   &  8850  &  11178 &  16477 &  10161 \\
3533  &  13842 &  7537  &  12259 &  18110 &  44    &  2364  &  15570 \\
3460  &  9886  &  8687  &  4481  &  11231 &  7547  &  11383 &  17910 \\
12867 &  13203 &  5102  &  4742  &  5053  &  15407 &  2976  &  9330 \\
12192 &  56    &  2471  &  15334 &  841   &  13995 &  17592 &  13297 \\
2430  &  9741  &  11675 &  424   &  6686  &  738   &  13874 &  8168 \\
7913  &  6246  &  14301 &  1144  &  9056  &  15967 &  7328  &  13203 \\
796   &  195   &  9872  &  16979 &  15404 &  14130 &  9105  &  2001 \\
9792  &  14251 &  1498  &  11296 &  1105  &  4502  &  16979 &  1105 \\
56    &  4118  &  11302 &  5988  &  3363  &  15827 &  6928  &  4191 \\
4277  &  10617 &  874   &  13211 &  11821 &  3090  &  18110 &  44 \\
2364  &  15570 &  3460  &  9886  &  9988  &  3798  &  1158  &  9872 \\
16979 &  15404 &  6127  &  9872  &  3652  &  14838 &  7437  &  2540 \\
1367  &  2512  &  14407 &  5053  &  1521  &  297   &  10935 &  17137 \\
2186  &  9433  &  13293 &  7555  &  13618 &  13000 &  6490  &  5310 \\
18676 &  4782  &  11374 &  446   &  4165  &  11634 &  3846  &  14611 \\
2364  &  6789  &  11634 &  4493  &  4063  &  4576  &  17955 &  7965 \\
11748 &  14616 &  11453 &  17666 &  925   &  56    &  4118  &  18031 \\
9522  &  14838 &  7437  &  3880  &  11476 &  8305  &  5102  &  2999 \\
18628 &  14326 &  9175  &  9061  &  650   &  18110 &  8720  &  15404 \\
2951  &  722   &  15334 &  841   &  15610 &  2443  &  11056 &  2186
\end{array}
$$

$$
\textbf{TABLE 6.3}:\text{RSA ciphertext}
$$

$$
\begin{array}{rrrrrrrr}
    6340  &  8309  &  14010 &  8936  &  27358 &  25023 &  16481 &  25809 \\
    23614 &  7135  &  24996 &  30590 &  27570 &  26486 &  30388 &  9395 \\
    27584 &  14999 &  4517  &  12146 &  29421 &  26439 &  1606  &  17881 \\
    25774 &  7647  &  23901 &  7372  &  25774 &  18436 &  12056 &  13547 \\
    7908  &  8635  &  2149  &  1908  &  22076 &  7372  &  8686  &  1304 \\
    4082  &  11803 &  5314  &  107   &  7359  &  22470 &  7372  &  22827 \\
    15698 &  30317 &  4685  &  14696 &  30388 &  8671  &  29956 &  15705 \\
    1417  &  26905 &  25809 &  28347 &  26277 &  7897  &  20240 &  21519 \\
    12437 &  1108  &  27106 &  18743 &  24144 &  10685 &  25234 &  30155 \\
    23005 &  8267  &  9917  &  7994  &  9694  &  2149  &  10042 &  27705 \\
    15930 &  29748 &  8635  &  23645 &  11738 &  24591 &  20240 &  27212 \\
    27486 &  9741  &  2149  &  29329 &  2149  &  5501  &  14015 &  30155 \\
    18154 &  22319 &  27705 &  20321 &  23254 &  13624 &  3249  &  5443 \\
    2149  &  16975 &  16087 &  14600 &  27705 &  19386 &  7325  &  26277 \\
    19554 &  23614 &  7553  &  4734  &  8091  &  23973 &  14015 &  107 \\
    3183  &  17347 &  25234 &  4595  &  21498 &  6360  &  19837 &  8463 \\
    6000  &  31280 &  29413 &  2066  &  369   &  23204 &  8425  &  7792 \\
    25973 &  4477  &  30989 &
\end{array}
$$

The first plaintext was taken from *The Diary of Samuel Marchbanks*, by Robertson Davies, 1947, and the second was taken from *Lake Wobegon Days*, by Garrison Keillor, 1985.

> **Solution**:

## Exercise 6.15

Prove that the *RSA Cryptosystem* is insecure against a chosen ciphertext attack. In particular, given a ciphertext $y$, describe how to choose a ciphertext $\hat{y} \not= y$, such that knowledge of the plaintext $\hat{x} = d_K(\hat{y})$ allows $x = d_K(y)$ to be computed.

**HINT**: Use the multiplicative property of the *RSA Cryptosystem*, i.e., that

$$
e_K(x_1)e_K(x_2)\text{ mod }n = e_K(x_1x_2\text{ mod }n)
$$

> **Solution**:
> 
> Suppose we have a random $x_0$, then $y_0 = e_K(x_0)$, let $\hat{y} = y_0y\text{ mod }n$.
> 
> Then we take $e_K(x_0)e_K(x)\text{ mod }n = e_K(x_0x\text{ mod }n)$, $\hat{x} = d_K(e_K(x_0x\text{ mod }n)) = x_0x\text{ mod }n$.
> 
> Thus, $x = \hat{x}x_0^{-1}\text{ mod }n$.

## Exercise 6.16

This exercise exhibits what is called a ***protocol failure***. It provides an example where ciphertext can be decrypted by an opponent, without determining the key, if a cryptosystem is used in a careless way. The moral is that it is not sufficient to use a "secure" cryptosystem in order to guarantee "secure" communication.

Suppose Bob has an *RSA Cryptosystem* with a large modulus $n$ for which the factorization cannot be found in a reasonable amount of time. Suppose Alice sends a message to Bob by representing each alphabetic character as an integer between $0$ and $25$ (i.e., $A ↔ 0$, $B ↔ 1$, etc.), and then encrypting each residue modulo $26$ as a separate plaintext character.

(a) Describe how Oscar can easily decrypt a message that is encrypted in this way.

(b) Illustrate this attack by decrypting the following ciphertext (which was encrypted using an *RSA Cryptosystem* with $n = 18721$ and $b = 25$) without factoring the modulus:

$$
365, 0, 4845, 14930, 2608, 2608, 0.
$$

> **Solution**:
> 
> (a) Oscar can encrypt each of the $26$ possible plaintext characters and record the corresponding ciphertext values in a table. This table would map each plaintext character to its encrypted form. Once this table is precomputed, any given ciphertext string can be decrypted by looking up each character in the table and substituting it with the corresponding plaintext character.
> 
> (b) Since $n = 18721$, $b = 25$, by iterating $0$ to $25$ to compute ciphertext, we can get a table:
> 
> $$
> \def\arraystretch{1.5}
>     \begin{array}{|c|c|c|c|c|c|c|c|c|c|c|c|c|}
>     \hline
>     \text{a} & \text{b} & \text{c} & \text{d} & \text{e} & \text{f} & \text{g} & \text{h} & \text{i} & \text{j} & \text{k} & \text{l} & \text{m} \\
>     \hline
>     0 & 1 & 6400 & 18718 & 17173 & 1759 & 18242 & 12359 & 14930 & 9 & 6279 & 2608 & 4644 \\
>     \hline
>     \text{n} & \text{o} & \text{p} & \text{q} & \text{r} & \text{s} & \text{t} & \text{u} & \text{v} & \text{w} & \text{x} & \text{y} & \text{z} \\
>     \hline
>     4845 & 1375 & 13444 & 16 & 13663 & 1437 & 2940 & 10334 & 365 & 10789 & 8945 & 11373 & 5116 \\
>     \hline
> \end{array}
> $$
> 
> Thus, we can find the plaintext is:
> 
> $$
> \text{vanilla}
> $$
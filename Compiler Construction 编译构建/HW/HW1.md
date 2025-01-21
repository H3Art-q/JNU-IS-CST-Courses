# Compiler Construction HW 1

$\text{21 CST H3Art}$

*2024 Fall Semester*

## Write regular expressions for the following character sets, or give reasons why no regular expression can be written:

1. All strings of digits such that all the 2's occur before all the 9's.

```regex
[^9]*[^2]*
```

2. All strings of a's and b's that contain no three consecutive b's.

```regex
(a|(bb|b)?a)*(bb|b)?
```

3. All strings of a's and b's that contain an even number of a's and an even number of b's.

```regex
(aa|bb)*((ab|ba)(aa|bb)*(ab|ba)(aa|bb)*)*
```

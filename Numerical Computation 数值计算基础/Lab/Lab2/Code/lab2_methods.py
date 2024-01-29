import numpy as np


def nest(coef, x, x_data=None):
    """
    Evaluate Newton's polynomial using Horner's method.
    """
    n = len(coef) - 1
    p = coef[n]
    for i in range(n - 1, -1, -1):
        p = coef[i] + (x - x_data[i]) * p
    return p


def newton_divided_difference(x_data, y_data):
    """
    Generate the Newton interpolating polynomial.
    """
    n = len(x_data)
    F = np.zeros((n, n))
    F[:, 0] = y_data

    for j in range(1, n):
        for i in range(n - j):
            F[i][j] = (F[i + 1][j - 1] - F[i][j - 1]) / (x_data[i + j] - x_data[i])

    coef = F[0]

    def polynomial(x):
        return nest(coef, x, x_data)

    return polynomial


def uniform_points(n, a=-1, b=1):
    """
    Generate n uniform points in the interval [a, b].
    """
    return np.linspace(a, b, n)


def chebyshev_points(n, a=-1, b=1):
    """
    Generate n Chebyshev points in the interval [a, b].
    """
    i = np.arange(1, n + 1)
    x_cheb = np.cos((2 * i - 1) * np.pi / (2 * n))
    return 0.5 * (a + b) + 0.5 * (b - a) * x_cheb


def func(x):
    return np.exp(-2 * x)

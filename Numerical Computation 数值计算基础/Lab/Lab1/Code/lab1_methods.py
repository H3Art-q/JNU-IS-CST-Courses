import numpy as np


def jacobi(A, b, exact_sol, iter_num):
    n = len(b)
    x = np.zeros(n)
    D_inverse = np.diag(1 / np.diag(A))
    Rest = A - np.diag(np.diag(A))  # Rest part = Lower triangle + Upper triangle
    errors = []

    for k in range(iter_num):
        x_new = D_inverse @ (b - Rest @ x)
        error = np.sum(x_new**2 - exact_sol**2)
        errors.append(error)
        x = x_new

    return x, errors


def gauss_seidel(A, b, exact_sol, iter_num):
    n = len(b)
    x = np.zeros(n)
    errors = []

    for k in range(iter_num):
        x_new = np.copy(x)
        for i in range(n):
            x_new[i] = (b[i] - A[i, :i] @ x_new[:i] - A[i, i + 1 :] @ x[i + 1 :]) / A[i, i]

        error = np.sum(x_new**2 - exact_sol**2)
        errors.append(error)
        x = x_new

    return x, errors


def sor(A, b, omega, exact_sol, iter_num):
    n = len(b)
    x = np.zeros(n)
    errors = []

    for k in range(iter_num):
        x_new = np.copy(x)
        for i in range(n):
            x_new[i] = (
                    (1 - omega) * x[i] + (omega / A[i, i]) * (b[i] - A[i, :i] @ x_new[:i] - A[i, i + 1 :] @ x[i + 1 :])
            )

        error = np.sum(x_new**2 - exact_sol**2)
        errors.append(error)
        x = x_new

    return x, errors


def conjugate_gradient(A, b, exact_sol, iter_num):
    n = len(b)
    x = np.zeros(n)
    r = b - A @ x
    p = r
    errors = []

    for k in range(iter_num):
        Ap = A @ p
        alpha = (r.T @ r) / (p.T @ Ap)
        x_new = x + alpha * p
        r_new = r - alpha * Ap

        error = np.sum(x_new**2 - exact_sol**2)
        errors.append(error)

        beta = (r_new.T @ r_new) / (r.T @ r)
        p = r_new + beta * p
        r, x = r_new, x_new

    return x, errors


def conjugate_gradient_preconditioned(A, b, exact_sol, iter_num):
    n = len(b)
    x = np.zeros(n)
    M_inv = np.diag(1 / np.diag(A))
    r = b - A @ x
    z = M_inv @ r
    p = z
    errors = []

    for k in range(iter_num):
        Ap = A @ p
        alpha = (r.T @ z) / (p.T @ Ap)
        x_new = x + alpha * p
        r_new = r - alpha * Ap

        error = np.sum(x_new**2 - exact_sol**2)
        errors.append(error)

        z_new = M_inv @ r_new
        beta = (r_new.T @ z_new) / (r.T @ z)
        p = z_new + beta * p
        z, r, x = z_new, r_new, x_new

    return x, errors

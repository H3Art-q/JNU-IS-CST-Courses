import matplotlib.pyplot as plt
import numpy as np

from lab1_methods import jacobi, gauss_seidel, sor, conjugate_gradient, conjugate_gradient_preconditioned

n = 1000  # Matrix size
iteration_num = 15

# Define the matrix A
A = np.zeros((1000, 1000))
A += np.diag(0.5 * np.ones(999), 1)  # Diagonal values at 1, 2, -1, -2 offsets
A += np.diag(0.5 * np.ones(998), 2)
A += np.diag(0.5 * np.ones(999), -1)
A += np.diag(0.5 * np.ones(998), -2)
A += np.diag(np.arange(1, 1001))  # Main diagonal

# Define vector b
b = np.ones(n)

# Calculate the exact solution of Ax = b, y denotes the exact solution
y = np.array(np.matrix(A).I @ b)

# Run the methods and record the errors
sol_jacobi, errs_jacobi = jacobi(A, b, y, iteration_num)
sol_gs, errs_gs = gauss_seidel(A, b, y, iteration_num)
sol_sor, errs_sor = sor(A, b, 1.1, y, iteration_num)
sol_cg, errs_cg = conjugate_gradient(A, b, y, iteration_num)
sol_cg_preconditioned, errs_cg_preconditioned = conjugate_gradient_preconditioned(A, b, y, iteration_num)

# Print the final time solutions
print("The solution of A_inv @ b(exact solution):", y)
print("The solution of Jacobi Method:", sol_jacobi)
print("The solution of Gauss-Seidel Method:", sol_gs)
print("The solution of SOR Method:", sol_sor)
print("The solution of Conjugate Gradient Method:", sol_cg)
print("The solution of Conjugate Gradient Method with Jacobi Preconditioner:", sol_cg_preconditioned)

# Plot the error at each iteration
plt.figure(figsize=(12, 8))
plt.plot(errs_jacobi, marker="o", label="Jacobi Method")
plt.plot(errs_gs, marker="x", label="Gauss-Seidel Method")
plt.plot(errs_sor, marker="s", label="SOR Method")
plt.plot(errs_cg, marker="d", label="Conjugate Gradient Method")
plt.plot(errs_cg_preconditioned, marker="*", label="Conjugate Gradient Method with Jacobi Preconditioner")

plt.xlabel("Iteration")
plt.ylabel("Error (First Element of Residual)")
plt.title("Convergence of Various Methods")
plt.legend()
plt.grid(True)

plt.show()

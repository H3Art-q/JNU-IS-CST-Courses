from lab3_define_matrices_and_methods import *

# Solve the least squares problem (a) using the QR decomposition from Gram-Schmidt
Q_a_gs, R_a_gs = gram_schmidt(A_a)
x_a_ls_gs = np.linalg.solve(R_a_gs[:n_a, :n_a], Q_a_gs.T[:n_a, :] @ b_a)  # Only use the first n rows of Q and R
error_a_gs = np.linalg.norm(b_a - A_a @ x_a_ls_gs, 2)

# Solve the least squares problem (a) using the QR decomposition from Householder reflections
Q_a_h, R_a_h, _ = householder_reflections(A_a)
x_a_ls_h = np.linalg.solve(R_a_h[:n_a, :n_a], Q_a_h.T[:n_a, :] @ b_a)
error_a_h = np.linalg.norm(b_a - A_a @ x_a_ls_h, 2)

print('The least squares solution for problem (a) '
      'using the QR decomposition from Gram-Schmidt is:\n', x_a_ls_gs, '\n')
print('The 2-norm error of it is:\n', error_a_gs, '\n')
print('The least squares solution for problem (a) '
      'using the QR decomposition from Householder transformation is:\n', x_a_ls_h, '\n')
print('The 2-norm error of it is:\n', error_a_h, '\n')

# Solve the least squares problem (b) using the QR decomposition from Gram-Schmidt
Q_b_gs, R_b_gs = gram_schmidt(A_b)
x_b_ls_gs = np.linalg.solve(R_b_gs[:n_b, :n_b], Q_b_gs.T[:n_b, :] @ b_b)
error_b_gs = np.linalg.norm(b_b - A_b @ x_b_ls_gs, 2)

# Solve the least squares problem (b) using the QR decomposition from Householder reflections
Q_b_h, R_b_h, _ = householder_reflections(A_b)
x_b_ls_h = np.linalg.solve(R_b_h[:n_b, :n_b], Q_b_h.T[:n_b, :] @ b_b)
error_b_h = np.linalg.norm(b_b - A_b @ x_b_ls_h, 2)

print('The least squares solution for problem (b) '
      'using the QR decomposition from Gram-Schmidt is:\n', x_b_ls_gs, '\n')
print('The 2-norm error of it is:\n', error_b_gs, '\n')
print('The least squares solution for problem (b) '
      'using the QR decomposition from Householder transformation is:\n', x_b_ls_h, '\n')
print('The 2-norm error of it is:\n', error_b_h, '\n')

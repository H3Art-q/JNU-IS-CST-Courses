from lab3_define_matrices_and_methods import A_a, A_b, gram_schmidt

# Perform QR decomposition using Gram-Schmidt for matrix A_a
Q_a_GS, R_a_GS = gram_schmidt(A_a)

print('(a). Q matrix using Gram-Schmidt:\n', Q_a_GS, '\n')
print('(a). R matrix using Gram-Schmidt:\n', R_a_GS, '\n')

# Perform QR decomposition using Gram-Schmidt for matrix A_b
Q_b_GS, R_b_GS = gram_schmidt(A_b)

print('(b). Q matrix using Gram-Schmidt:\n', Q_b_GS, '\n')
print('(b). R matrix using Gram-Schmidt:\n', R_b_GS, '\n')

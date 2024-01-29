from lab3_define_matrices_and_methods import A_a, A_b, householder_reflections

# Perform QR decomposition using Householder reflections for matrix A_a
Q_a_H, R_a_H, H_a_list = householder_reflections(A_a)

print('(a). Q matrix using Householder reflections:\n', Q_a_H, '\n')
print('(a). R matrix using Householder reflections:\n', R_a_H, '\n')
print('(a). H_i matrix in every Householder reflections steps are:')
for i, H_a_i in enumerate(H_a_list):
    print('H_{0} = \n{1}\n'.format(i, H_a_i))

# Perform QR decomposition using Householder reflections for matrix A_b
Q_b_H, R_b_H, H_b_list = householder_reflections(A_b)

print('(b). Q matrix using Householder reflections:\n', Q_b_H, '\n')
print('(b). R matrix using Householder reflections:\n', R_b_H, '\n')
print('(b). H_i matrix in every Householder reflections steps are:')
for i, H_b_i in enumerate(H_b_list):
    print('H_{0} = \n{1}\n'.format(i, H_b_i))

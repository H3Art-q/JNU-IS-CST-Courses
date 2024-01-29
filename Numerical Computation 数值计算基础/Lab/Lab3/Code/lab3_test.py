from scipy.linalg import qr
from lab3_question1_solution import *
from lab3_question2_solution import *

q_a, r_a = qr(A_a)[0], qr(A_a)[1]
q_b, r_b = qr(A_b)[0], qr(A_b)[1]

print(q_a)
print(r_a)
print(q_b)
print(r_a)

print('\nscipy result:')
print()
print(q_a @ r_a)

print()
print(q_b @ r_b)

print('\nGS result:')
print()
print(Q_a_GS @ R_a_GS)

print()
print(Q_b_GS @ R_b_GS)

print('\nHouseholder result:')
print()
print(Q_a_H @ R_a_H)

print()
print(Q_b_H @ R_b_H)
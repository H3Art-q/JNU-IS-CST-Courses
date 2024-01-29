import numpy as np

# Define the matrices from the given linear equations
A_a = np.array([
    [3, -1, 2],
    [4, 1, 0],
    [-3, 2, 1],
    [1, 1, 5],
    [-2, 0, 3]
], dtype=float)

b_a = np.array([10, 10, -5, 15, 0], dtype=float)

n_a = A_a.shape[1]

A_b = np.array([
    [4, 2, 3, 0],
    [-2, 3, -1, 1],
    [1, 3, -4, 2],
    [1, 0, 1, -1],
    [3, 1, 3, -2]
], dtype=float)

b_b = np.array([10, 0, 2, 0, 5], dtype=float)

n_b = A_b.shape[1]


# Function to perform the Gram-Schmidt process
def gram_schmidt(A):
    m, n = A.shape
    Q = np.zeros((m, m))  # Q is an m by m orthogonal matrix
    R = np.zeros((m, n))  # R is an m by n upper triangular matrix

    # Use the Gram-Schmidt process for the first n steps
    for j in range(n):
        # Start with the j-th column of A
        v = A[:, j]

        # Subtract the projection of v onto the previous vectors
        for i in range(j):
            q = Q[:, i]
            R[i, j] = np.dot(q, v)
            v = v - R[i, j] * q

        # Normalize v to get the j-th orthogonal vector
        R[j, j] = np.linalg.norm(v)
        Q[:, j] = v / R[j, j]

    # Extend Q to an m by m orthogonal matrix
    for k in range(n, m):
        # Start with a random vector
        v = np.random.rand(m)
        # Make v orthogonal to the previous vectors
        for i in range(k):
            v -= np.dot(Q[:, i], v) * Q[:, i]
        # Normalize v
        v /= np.linalg.norm(v)
        Q[:, k] = v

    return Q, R


# Function to perform QR decomposition using Householder reflections
def householder_reflections(A):
    m, n = A.shape
    R = A.copy()
    Q = np.eye(m)
    H_list = []

    for k in range(n):
        # Extract the vector to reflect on
        x = R[k:, k]
        e = np.zeros_like(x)
        e[0] = np.copysign(np.linalg.norm(x), -A[k, k])
        u = x + e
        u = u / np.linalg.norm(u)
        # Form the Householder reflector H
        H = np.eye(m)
        H[k:, k:] -= 2.0 * np.outer(u, u)
        # Apply the reflector to R
        R = np.dot(H, R)
        # Update Q as well
        Q = np.dot(Q, H.T)
        # Record every each Householder reflector
        H_list.append(H)

    # Ensure R is upper triangular
    R = np.triu(R)

    return Q, R, H_list

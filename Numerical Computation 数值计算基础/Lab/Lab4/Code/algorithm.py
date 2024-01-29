import numpy as np


def power_iteration(matrix):
    num_nodes = matrix.shape[0]
    # Initialize vector: [1, 0, 0, ..., 0]
    rank_vector = np.zeros(num_nodes)
    rank_vector[0] = 1
    while True:
        new_rank_vector = np.dot(matrix, rank_vector)
        change = np.linalg.norm(new_rank_vector - rank_vector)
        # Convergence check (threshold set arbitrarily)
        if change < 1e-20:
            break
        else:
            rank_vector = new_rank_vector

    return new_rank_vector


def convert_to_google_matrix(adj_matrix, num_sites, alpha):
    for row in range(num_sites):
        row_sum = sum(adj_matrix[row])
        if row_sum == 0:
            for col in range(num_sites):
                adj_matrix[row][col] = 1 / num_sites
        else:
            for col in range(num_sites):
                random_surf = alpha * (1 / num_sites)
                outlink_surf = (1 - alpha) * (adj_matrix[row][col] / row_sum)
                adj_matrix[row][col] = random_surf + outlink_surf
    return adj_matrix

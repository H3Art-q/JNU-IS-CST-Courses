import matplotlib.pyplot as plt
import numpy as np
from json import dump, load

# Constants
DATA_FILE = 'crawled_data.json'
ALPHA = 0.15
NUM_TOP_PAGES = 20


def save_crawl_data(crawler, filename):
    data = {
        'adjacent_matrix': crawler.get_adjacent_matrix(),
        'directed_graph': crawler.link_graph,
        'num_site': crawler.site_count
    }
    with open(filename, 'w', encoding='utf-8') as file:
        dump(data, file, ensure_ascii=False, indent=4)


def load_data(filename):
    with open(filename, 'r') as file:
        return load(file)


def plot_sparsity(matrix):
    size = len(matrix)
    plt.figure(figsize=(10, 6))  # Set a larger figure size
    plt.spy(matrix, markersize=5, marker='o', color='blue')  # Increase marker size and change color
    plt.xlim([0, size])
    plt.ylim([size, 0])

    # Calculate sparsity
    non_zero_count = np.count_nonzero(matrix)
    sparsity_percentage = (non_zero_count / (size ** 2)) * 100
    plt.title(f'Sparsity: {sparsity_percentage:.3f}%', fontsize=14)
    plt.xlabel('Column Index', fontsize=12)
    plt.ylabel('Row Index', fontsize=12)
    plt.grid(color='gray', linestyle='--', linewidth=0.5)
    plt.show()


def plot_rank_distribution(rank_values):
    plt.figure(figsize=(10, 6))  # Set a larger figure size
    plt.scatter(range(len(rank_values)), rank_values, color='red', alpha=0.6,
                edgecolor='black')  # Adjust color, transparency, and edge
    plt.title('Page Rank Value Distribution', fontsize=14)
    plt.xlabel('Page Number', fontsize=12)
    plt.ylabel('Rank Value', fontsize=12)
    plt.grid(True, color='gray', linestyle='--', linewidth=0.5)
    plt.show()

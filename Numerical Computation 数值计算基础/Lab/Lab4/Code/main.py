from web_crawler import Web_Crawler, get_page_title
from algorithm import power_iteration, convert_to_google_matrix
from utils import *
from os.path import exists
from datetime import datetime
import numpy as np


def crawl_website(base_url, verbose=True):
    crawler = Web_Crawler(base_url=base_url, verbose=verbose)
    start_time = datetime.now()
    crawler.run()
    end_time = datetime.now()
    print('Crawling time used:', (end_time - start_time).total_seconds(), 'seconds')
    return crawler


def display_top_pages(page_rank, num_pages):
    for i, (url, rank) in enumerate(page_rank[:num_pages]):
        title = get_page_title(url)
        print(f'TOP {i + 1}: {title}\nURL: {url}\nRank Value: {rank}')


def main():
    # Crawl and save data if not already done
    if not exists(DATA_FILE):
        crawler = crawl_website('https://www.jnu.edu.cn')
        save_crawl_data(crawler, DATA_FILE)

    # Load data from file
    data = load_data(DATA_FILE)

    # Plotting and processing
    plot_sparsity(data['adjacent_matrix'])
    google_matrix = convert_to_google_matrix(np.array(data['adjacent_matrix'], dtype=float), data['num_site'], ALPHA)

    # Power iteration
    rank_values = power_iteration(google_matrix.transpose())
    plot_rank_distribution(rank_values)

    # Ranking and displaying top pages
    ranked_pages = [(key, rank_values[i]) for i, key in enumerate(data['directed_graph'].keys())]
    page_rank = sorted(ranked_pages, key=lambda x: x[1], reverse=True)
    display_top_pages(page_rank, NUM_TOP_PAGES)


if __name__ == "__main__":
    main()

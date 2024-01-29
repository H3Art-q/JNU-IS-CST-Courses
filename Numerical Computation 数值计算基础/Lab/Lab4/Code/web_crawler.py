from requests import get, head
from bs4 import BeautifulSoup
from random import sample
from urllib.parse import urljoin

# Constants for crawler configuration
MAX_SITES = 500
MAX_RELATIVE_LINKS = 20


class Web_Crawler:
    HEADERS = {
        'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36'
    }

    def __init__(self, base_url, verbose=False):
        self.to_crawl = [base_url]
        self.site_count = 1
        self.crawled = set()
        self.unreachable = set()
        self.link_graph = {}
        self.verbose = verbose

    def extract_links(self, url):
        try:
            response = head(url)
            if 'text/html' not in response.headers.get('Content-Type', ''):
                raise ValueError("No-HTML content")
            response = get(url, headers=self.HEADERS, timeout=10)
        except:
            self.crawled.remove(url)
            self.unreachable.add(url)
            self.site_count = self.site_count - 1
            return -1

        response.encoding = 'utf-8'
        soup = BeautifulSoup(response.text, 'lxml')

        # Collect and normalize links
        links = [link['href'] for link in soup.find_all('a', href=True)]
        links = self._normalize_links(url, links)

        for link in links:
            if link not in self.to_crawl and \
                    link not in self.crawled and \
                    link not in self.unreachable and \
                    self.site_count < MAX_SITES:
                self.to_crawl.append(link)
                self.site_count += 1

        self.link_graph[url] = links
        response.close()
        return response.status_code

    def _normalize_links(self, base_url, links):
        relative = [link for link in links if link.startswith('/')]
        absolute = [link for link in links if link.startswith('https')]
        relative = sample(relative, min(len(relative), MAX_RELATIVE_LINKS))
        links = [link.rstrip('/') for link in absolute + [urljoin(base_url, rel) for rel in relative]]
        return links

    def run(self):
        index = 1
        while self.to_crawl:
            current_url = self.to_crawl.pop(0)
            self.crawled.add(current_url)
            status = self.extract_links(current_url)
            if self.verbose:
                print('Crawling Page', index, ':', current_url, ', Status:',
                      'No-HTML content' if status == -1 else status)
                index += 1
        if self.verbose:
            print('Crawling completed. Total sites:', self.site_count)
            print('keys:', len(self.link_graph.keys()))

    def get_adjacent_matrix(self):
        keys = tuple(self.link_graph.keys())

        for key in keys:
            for site in self.link_graph[key]:
                if site not in keys or site == key:
                    self.link_graph[key] = [x for x in self.link_graph[key] if x != site]

        matrix = [[0] * self.site_count for _ in range(self.site_count)]

        for site, links in self.link_graph.items():
            site_index = keys.index(site)
            for link in links:
                link_index = keys.index(link)
                matrix[site_index][link_index] = 1

        return matrix


def get_page_title(url):
    try:
        response = get(url, headers=Web_Crawler.HEADERS)
        response.encoding = 'utf-8'
        soup = BeautifulSoup(response.text, 'lxml')
        title = soup.find('title').text
    finally:
        response.close()
    return title

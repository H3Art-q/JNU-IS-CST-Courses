package lab8.chapter12;
// 12.33
// 无法处理url重定向问题：代码302

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.net.URL;

public class SearchWeb {
    public static String searchCorrespondingWord(String startingURL, String word) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);

        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);

            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);

                try {
                    URL url = new URL(urlString);
                    Scanner input = new Scanner(url.openStream());
                    String line;
                    int current = 0;

                    while (input.hasNextLine()) {
                        line = input.nextLine();

                        if (line.contains(word)) {
                            return urlString;
                        }

                        current = line.indexOf("http:", current);

                        while (current > 0) {
                            // Set " as endIndex because in html,
                            // an url will be a key-value which store as value="url"
                            int endIndex = line.indexOf("\"", current);

                            // Ensure that a correct URL is found
                            if (endIndex > 0) {
                                // String.substring(begin, end) -> [begin, end)
                                String newUrl = line.substring(current, endIndex);
                                if (!listOfTraversedURLs.contains(newUrl)) {
                                    listOfPendingURLs.add(newUrl);
                                }
                                current = line.indexOf("http:", endIndex);
                            } else {
                                current = -1;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

        }

        return "None";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = input.nextLine();
        System.out.println("Enter a starting URL: ");
        String url = input.nextLine();


        // Traverse the Web from a starting url and search
        String result = searchCorrespondingWord(url, word);

        if (Objects.equals(result, "None")) {
            System.out.println("There are no URL that contains " + word);
        } else {
            System.out.println("The URL that contains \"" + word + "\" is " + result);
        }
    }
}

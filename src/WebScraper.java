import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "http://erdani.com/tdpl/hamlet.txt");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
        String[] words = contents.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("prince")) {
                count++;
            }
        }
        System.out.println("Prince appears in Hamlet for " + count + " times");
    }
}

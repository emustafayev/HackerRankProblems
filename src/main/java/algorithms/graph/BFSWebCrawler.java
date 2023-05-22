package algorithms.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFSWebCrawler {

    private Queue<String> queue;
    private List<String> visited;

    public BFSWebCrawler() {
        queue = new LinkedList<>();
        visited = new ArrayList<>();
    }


    public void crawl(String root) {

        queue.add(root);

        visited.add(root);


        while (!queue.isEmpty()) {
            String node = queue.poll();

            String rawHtml = readURL(node);
            String regexp = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String foundUrl = matcher.group();

                if (!visited.contains(foundUrl)) {
                    System.out.println("Found Vebsite: " + foundUrl);
                    visited.add(foundUrl);
                    queue.add(foundUrl);
                }
            }
        }


//
//        queue.add(root);
//        visited.add(root);
//
//        while (!queue.isEmpty()) {
//
//            String url = queue.poll();
//
//            String rawHtml = readURL(url);
//            String regexp = "https://(\\w+\\.)*(\\w+)";
//            Pattern pattern = Pattern.compile(regexp);
//            Matcher matcher = pattern.matcher(rawHtml);
//
//            while (matcher.find()){
//                String w = matcher.group();
//                if (!visited.contains(w)){
//                    visited.add(w);
//                    System.out.println("Website found: " + w);
//                    queue.add(w);
//                }
//            }
//
//            visited.add(url);
//        }


    }

    private String readURL(String node) {
        StringBuilder rawHtml = new StringBuilder();
        try {
            URL url = new URL(node);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                rawHtml.append(line);
            }
            reader.close();


        } catch (Exception exception) {
            System.out.println("Error occurred while reading website");
        }

        return rawHtml.toString();
    }
}

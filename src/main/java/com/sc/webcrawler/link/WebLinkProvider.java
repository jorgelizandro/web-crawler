package com.sc.webcrawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebLinkProvider implements LinkProvider {
    private static final int RESULT_SIZE = 15;
    private static final int TIMEOUT = 5000;
    //private static final String URL_REGEX = "/url\\?q=|&sa.*";
    private static String SEARCH_Q = "https://www.google.com/search?num=" + RESULT_SIZE + "&q=";

    @Override
    public List<String> getLinks(final String searchTerm) {
        final List<String> urls = new ArrayList<>();

        try {
            final Document document = Jsoup
                    .connect(SEARCH_Q + searchTerm)
                    .timeout(TIMEOUT)
                    .get();
            final Elements divList = document.select("div.g");

            for(final Element div : divList) {
                final Elements elements = div.getElementsByTag("a");
                final String rawUrl = elements.attr("href");
                //final String sanitizedUrl = rawUrl.replaceAll(URL_REGEX,  "");
                //final String decodedUrl = java.net.URLDecoder.decode(sanitizedUrl, UTF_8.displayName());

                if (rawUrl.startsWith("http")) {
                    urls.add(rawUrl);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return urls
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

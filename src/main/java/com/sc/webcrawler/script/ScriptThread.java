package com.sc.webcrawler.script;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class ScriptThread extends Thread {
    private static final String SCRIPT_REGEX = "\\?.*";
    private static final int TIMEOUT = 10000;
    private final String link;
    private final List<String> scripts;

    public ScriptThread(final String link, final List<String> scripts) {
        this.link = link;
        this.scripts = scripts;

        start();
    }

    @Override
    public void run() {
        try {
            final Document document = Jsoup
                    .connect(link)
                    .timeout(TIMEOUT)
                    .ignoreContentType(true)
                    .validateTLSCertificates(false)
                    .ignoreHttpErrors(true)
                    .get();

            final Elements elements = document.select("script");

            for (final Element element : elements) {
                final String src = element.attr("src");

                if (src != null && src.length() > 0 && src.contains(".js")) {
                    final String sanitizedScript = src
                            .substring(src.lastIndexOf("/") + 1)
                            .replaceFirst(SCRIPT_REGEX, "");

                    scripts.add(sanitizedScript);
                }
            }
        } catch (final IOException e) {
            //  Handle any exceptions.
        }
    }
}

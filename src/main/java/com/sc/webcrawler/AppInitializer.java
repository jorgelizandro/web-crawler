package com.sc.webcrawler;

import com.sc.webcrawler.analytics.Metric;
import com.sc.webcrawler.analytics.ScriptMetric;
import com.sc.webcrawler.link.LinkProvider;
import com.sc.webcrawler.link.WebLinkProvider;
import com.sc.webcrawler.model.Constant;
import com.sc.webcrawler.script.ScriptProvider;
import com.sc.webcrawler.script.WebScriptProvider;
import com.sc.webcrawler.terminal.ConsoleTermProvider;
import com.sc.webcrawler.terminal.TermProvider;

import java.util.List;

public class AppInitializer {
    private static final long TOP_N = 5L;

    private final TermProvider dataProvider = new ConsoleTermProvider();
    private final LinkProvider linkProvider = new WebLinkProvider();
    private final ScriptProvider scriptProvider = new WebScriptProvider();
    private final Metric scriptMetric = new ScriptMetric();

    public void showOption() {
        dataProvider.printMessage(Constant.WEB_CRAWLER);
        dataProvider.printMessage(Constant.INTRODUCE_SEARCH_TERM);
        final String searchTerm = dataProvider.getSearchTerm();

        dataProvider.printMessage(Constant.SEARCH);
        final List<String> links = linkProvider.getLinks(searchTerm);
        dataProvider.printMessage("\tFound " + links.size() + " links");
        //dataProvider.printMessages(links);

        dataProvider.printMessage(Constant.RETRIEVING_SCRIPTS);
        final List<String> scripts = scriptProvider.getScripts(links);
        dataProvider.printMessage("\tFound " + scripts.size() + " scripts");

        dataProvider.printMessage(Constant.GENERATING_METRICS);
        final List topFiveList = scriptMetric.getTop(TOP_N, scripts);

        dataProvider.printMessage(Constant.TOP_FIVE);
        dataProvider.printMessage(Constant.SPACER);
        dataProvider.printMessages(topFiveList);
        dataProvider.printMessage(Constant.SPACER);

        dataProvider.printMessage(Constant.EXECUTION_FINISHED);
    }

    public static void main(final String[] args) {
        final AppInitializer appInitializer = new AppInitializer();
        appInitializer.showOption();
    }
}

package com.sc;

import com.sc.analytics.Metric;
import com.sc.analytics.ScriptMetric;
import com.sc.dao.ConsoleTermProvider;
import com.sc.dao.LinkProvider;
import com.sc.dao.ScriptProvider;
import com.sc.dao.TermProvider;
import com.sc.dao.WebLinkProvider;
import com.sc.dao.WebScriptProvider;

import java.util.List;

import static com.sc.model.Constant.EXECUTION_FINISHED;
import static com.sc.model.Constant.GENERATING_METRICS;
import static com.sc.model.Constant.INTRODUCE_SEARCH_TERM;
import static com.sc.model.Constant.RETRIEVING_SCRIPTS;
import static com.sc.model.Constant.SEARCH;
import static com.sc.model.Constant.SPACER;
import static com.sc.model.Constant.TOP_FIVE;
import static com.sc.model.Constant.WEB_CRAWLER;

public class Main {
    public static void main(final String[] args) {
        final TermProvider dataProvider = new ConsoleTermProvider();

        dataProvider.printMessage(WEB_CRAWLER);
        dataProvider.printMessage(INTRODUCE_SEARCH_TERM);
        final String searchTerm = dataProvider.getSearchTerm();

        dataProvider.printMessage(SEARCH);
        final LinkProvider linkProvider = new WebLinkProvider();
        final List<String> links = linkProvider.getLinks(searchTerm);
        dataProvider.printMessage("\tFound " + links.size() + " links");

        dataProvider.printMessage(RETRIEVING_SCRIPTS);
        final ScriptProvider scriptProvider = new WebScriptProvider();
        final List<String> scripts = scriptProvider.getScripts(links);
        dataProvider.printMessage("\tFound " + scripts.size() + " scripts");

        dataProvider.printMessage(GENERATING_METRICS);
        final Metric metric = new ScriptMetric();
        final List topFiveList = metric.getTop(5L, scripts);

        dataProvider.printMessage(TOP_FIVE);
        dataProvider.printMessage(SPACER);
        dataProvider.printMessages(topFiveList);
        dataProvider.printMessage(SPACER);

        dataProvider.printMessage(EXECUTION_FINISHED);
    }
}

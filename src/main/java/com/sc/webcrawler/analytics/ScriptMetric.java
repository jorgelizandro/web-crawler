package com.sc.webcrawler.analytics;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ScriptMetric implements Metric {

    @Override
    public List<Entry<String, Long>> getTop(final long n, final List<String> elements) {
        final Map<String, Long> groupedElements = elements
                .stream()
                .collect(groupingBy(element->element, counting()));

        return groupedElements
                .entrySet()
                .stream()
                .sorted((o1, o2) ->  o2.getValue().compareTo(o1.getValue()))
                .limit(n)
                .collect(Collectors.toList());
    }
}

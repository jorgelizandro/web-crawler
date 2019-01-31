package com.sc.webcrawler.analytics;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScriptMetricTest {
    private final Metric scriptMetric = new ScriptMetric();

    @Test
    public void testGetTopFive() {
        final List<String> scripts = Arrays.asList("a", "b", "c", "a", "a", "b","d", "e", "f");


        final List<Entry<String, Long>> topFiveList = scriptMetric.getTop(5L, scripts);

        final List<Entry<String, Long>> expectedTopFiveList = new ArrayList<>();
        expectedTopFiveList.add(new AbstractMap.SimpleEntry<>("a", 3L));
        expectedTopFiveList.add(new AbstractMap.SimpleEntry<>("b", 2L));
        expectedTopFiveList.add(new AbstractMap.SimpleEntry<>("c", 1L));
        expectedTopFiveList.add(new AbstractMap.SimpleEntry<>("d", 1L));
        expectedTopFiveList.add(new AbstractMap.SimpleEntry<>("e", 1L));

        assertThat(topFiveList, is(expectedTopFiveList));
    }
}
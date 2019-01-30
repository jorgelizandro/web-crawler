package com.sc.analytics;

import java.util.List;

import static java.util.Map.Entry;

public interface Metric {
    List<Entry<String, Long>> getTop(long n, List<String> elements);
}

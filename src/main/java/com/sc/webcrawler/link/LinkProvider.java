package com.sc.webcrawler.link;

import java.util.List;

public interface LinkProvider {

    List<String> getLinks(String searchTerm);
}

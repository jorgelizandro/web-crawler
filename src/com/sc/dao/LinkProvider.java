package com.sc.dao;

import java.util.List;

public interface LinkProvider {

    List<String> getLinks(String searchTerm);
}

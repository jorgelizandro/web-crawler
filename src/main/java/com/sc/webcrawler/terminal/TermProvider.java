package com.sc.webcrawler.terminal;

import java.util.List;

public interface TermProvider {
    String getSearchTerm();
    void printMessage(String message);
    void printMessages(List messages);
    void clearScreen();
}

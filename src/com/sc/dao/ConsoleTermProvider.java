package com.sc.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleTermProvider implements TermProvider {
    private static final String OS_NAME = System.getProperty("os.name");
    private final BufferedReader bufferedReader;

    public ConsoleTermProvider() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getSearchTerm() {
        try {
            return bufferedReader.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return getSearchTerm();
    }

    @Override
    public void printMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printMessages(List messages) {
        if (messages != null && messages.size() > 0) {
            messages.stream()
                    .forEach(System.out::println);
        }
    }

    @Override
    public void clearScreen() {
        try {
            if (OS_NAME.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
            //  Handle any exceptions.
        }
    }
}

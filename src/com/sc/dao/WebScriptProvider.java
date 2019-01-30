package com.sc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WebScriptProvider implements ScriptProvider {

    @Override
    public List<String> getScripts(final List<String> links) {
        final List<String> scripts = new Vector<>();
        final List<ScriptThread> threads = new ArrayList<>();

        for (final String link : links) {
            threads.add(new ScriptThread(link, scripts));
        }

        for (final ScriptThread scriptThread : threads) {
            while (scriptThread.isAlive()) {
                try {
                    Thread.sleep(500);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //Collections.sort(scripts);
        return scripts;
    }
}

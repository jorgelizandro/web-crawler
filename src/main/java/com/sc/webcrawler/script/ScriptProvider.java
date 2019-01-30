package com.sc.webcrawler.script;

import java.util.List;

public interface ScriptProvider {

    List<String> getScripts(List<String> links);
}

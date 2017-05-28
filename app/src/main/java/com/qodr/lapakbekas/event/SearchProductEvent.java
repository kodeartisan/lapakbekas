package com.qodr.lapakbekas.event;

import java.util.HashMap;

/**
 * Created by kodeartisan on 27/05/17.
 */

public class SearchProductEvent {

    private HashMap<String, String> queryData;

    public SearchProductEvent(HashMap<String, String> queryData) {
        this.queryData = queryData;
    }

    public HashMap<String, String> getQueryData() {
        return queryData;
    }

    public void setQueryData(HashMap<String, String> queryData) {
        this.queryData = queryData;
    }
}

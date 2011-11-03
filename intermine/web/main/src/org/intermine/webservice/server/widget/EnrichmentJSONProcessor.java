package org.intermine.webservice.server.widget;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class EnrichmentJSONProcessor implements EnrichmentResultProcessor {

    private static final EnrichmentResultProcessor instance = new EnrichmentJSONProcessor();

    private EnrichmentJSONProcessor() {
        // Not to be instantiated.
    }

    public static EnrichmentResultProcessor instance() {
        return instance;
    }

    @Override
    public List<String> formatRow(List<Object> row) {
        Map<String, Object> backingMap = new HashMap<String, Object>();
        backingMap.put("item", row.get(0));
        backingMap.put("description", row.get(1));
        backingMap.put("p-value", row.get(2));
        // Counts (index 3) are not necessary here, as it it trivial to
        // fetch from the matches array (as result.matches.length)
        backingMap.put("matches", row.get(4));
        JSONObject jo = new JSONObject(backingMap);
        return new LinkedList<String>(Arrays.asList(jo.toString()));
    }

}

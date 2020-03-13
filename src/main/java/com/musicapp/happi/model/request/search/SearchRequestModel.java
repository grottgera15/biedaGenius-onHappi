package com.musicapp.happi.model.request.search;

import java.util.HashMap;
import java.util.Map;

/* API PARAMS:
q* = <STRING> - text to search
limit = <INT> - limit of results
type  = track/artist
*/

public class SearchRequestModel {
    private Map<String,Object> apiParams = new HashMap<>();

    public Map<String, Object> getApiParams() {
        return apiParams;
    }

    public void setApiParams(Map<String, Object> apiParams) {
        this.apiParams = apiParams;
    }
}

package com.musicapp.happi.apiConsumers.happi;


import com.musicapp.happi.apiConsumers.happi.model.SearchArtist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HappiRequestParamMaker {
    private List<String> pathParams;
    private Map<String, String> apiParams;

    private void clearAllData(){
        this.pathParams.clear();
        this.apiParams.clear();
    }

    //q* - text to search, limit-max50, type - track/artist
    public ResponseEntity<SearchArtist> searchRequest(String q, int limit, String type){
        clearAllData();

        apiParams.put("q", q);
        apiParams.put("limit", new Integer(limit).toString());
        apiParams.put("type", type);

        HappiRequest happiRequest = new HappiRequest(pathParams, apiParams);

//        ResponseEntity<SearchArtist> response = happiRequest.getResponse();

        return null;
    }
}

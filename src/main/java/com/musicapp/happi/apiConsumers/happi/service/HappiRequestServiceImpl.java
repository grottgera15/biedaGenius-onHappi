package com.musicapp.happi.apiConsumers.happi.service;


import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HappiRequestServiceImpl implements  HappiRequestService{
    @Autowired
    HappiResponseGetterService happiResponse;
    //q* - text to search, limit-max50, type - track/artist
    @Override
    public ResponseEntity<ArtistList> searchRequest(String q, int limit, String type){

        Map<String,String> apiParams = new HashMap<>();

        apiParams.put("q", q);
        apiParams.put("limit", new Integer(limit).toString());
        apiParams.put("type", type);

        ResponseEntity<ArtistList> response = happiResponse.getResponseArtistList(apiParams);

        return response;
    }

}

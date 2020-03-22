package com.musicapp.happi.apiConsumers.happi.service;


import com.musicapp.happi.apiConsumers.happi.HappiRequest;
import com.musicapp.happi.apiConsumers.happi.model.DTO.AlbumFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import com.musicapp.happi.apiConsumers.happi.model.DTO.TrackFull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HappiRequestServiceImpl {
    @Autowired
    HappiRequest happiRequest;
    //q* - text to search, limit-max50, type - track/artist
    public ResponseEntity<ArtistList> searchRequest(String q, int limit, String type){

        Map<String,String> apiParams = new HashMap<>();

        apiParams.put("q", q);
        apiParams.put("limit", new Integer(limit).toString());
        apiParams.put("type", type);

        ResponseEntity<ArtistList> response = happiRequest.getResponseArtistList(apiParams);

        return response;
    }

}

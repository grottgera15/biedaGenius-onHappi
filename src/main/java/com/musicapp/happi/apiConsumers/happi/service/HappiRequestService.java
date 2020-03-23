package com.musicapp.happi.apiConsumers.happi.service;

import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import org.springframework.http.ResponseEntity;

//Interface to handle api and path params to send request
public interface HappiRequestService {
    public abstract ResponseEntity<ArtistList> searchRequest(String q, int limit, String type);
}

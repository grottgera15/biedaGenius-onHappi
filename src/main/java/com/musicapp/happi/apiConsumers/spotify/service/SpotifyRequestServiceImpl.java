package com.musicapp.happi.apiConsumers.spotify.service;

import com.musicapp.happi.apiConsumers.spotify.model.ArtistFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotifyRequestServiceImpl implements SpotifyRequestService {
    @Autowired
    SpotifyResponseGetterService response;

    @Override
    public ResponseEntity<ArtistFull> artistRequest(String artistId) {
        List<String> pathParams = new ArrayList<>();
        pathParams.add("artists");
        pathParams.add(artistId);

        return response.getResponseArtistFull(pathParams);
    }
}

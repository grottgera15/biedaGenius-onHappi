package com.musicapp.happi.apiConsumers.spotify.service;

import com.musicapp.happi.apiConsumers.spotify.model.ArtistFull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpotifyResponseGetterService {
    public abstract String requestUrlAddress(List<String> pathParams);
    public abstract ResponseEntity<ArtistFull> getResponseArtistFull(List<String> pathParams);
}

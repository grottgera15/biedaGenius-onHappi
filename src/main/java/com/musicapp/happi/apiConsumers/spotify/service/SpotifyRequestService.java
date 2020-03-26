package com.musicapp.happi.apiConsumers.spotify.service;

import com.musicapp.happi.apiConsumers.spotify.model.ArtistFull;
import org.springframework.http.ResponseEntity;

public interface SpotifyRequestService {
    public abstract ResponseEntity<ArtistFull> artistRequest(String artistId);
}

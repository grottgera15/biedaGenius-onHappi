package com.musicapp.happi.apiConsumers.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotifyArtistServiceImpl implements SpotifyArtistService {
    @Autowired
    SpotifyRequestService request;

    @Override
    public String getSporifyArtistUrlById(String spotifyArtistId) {
        return request.artistRequest(spotifyArtistId)
                      .getBody()
                      .getExternal_urls()
                      .getSpotify();
    }
}

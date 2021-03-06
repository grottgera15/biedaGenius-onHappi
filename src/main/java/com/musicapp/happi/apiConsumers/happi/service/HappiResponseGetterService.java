package com.musicapp.happi.apiConsumers.happi.service;

import com.musicapp.happi.apiConsumers.happi.model.DTO.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

//api consumer - constructing  uri and sending GET request
public interface HappiResponseGetterService {
    public abstract String requestUrlAddress(List<String> pathParams, Map<String, String> apiParams);
    public abstract ResponseEntity<ArtistList> getResponseArtistList(Map<String,String> apiParams);
    public abstract ResponseEntity<AlbumFull> getResponseAlbum(String api_album);
    public abstract ResponseEntity<ArtistFull> getResponseArtist(String api_artist);
    public abstract ResponseEntity<TrackFull> getResponseTrack(String api_artist);
}

package com.musicapp.happi.dataBase;

import com.musicapp.happi.apiConsumers.spotify.SpotifyProperties;
import com.musicapp.happi.apiConsumers.spotify.service.SpotifyArtistService;
import com.musicapp.happi.apiConsumers.spotify.service.SpotifyArtistServiceImpl;
import com.musicapp.happi.apiConsumers.spotify.service.SpotifyResponseGetterService;
import com.musicapp.happi.apiConsumers.spotify.service.SpotifyResponseGetterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Tester {
    private final SpotifyProperties properties;
    SpotifyArtistService service;
    SpotifyResponseGetterServiceImpl response;

    @Autowired
    public Tester(SpotifyProperties properties, SpotifyArtistService service, SpotifyResponseGetterServiceImpl response) {
        this.properties = properties;
        this.service = service;
        this.response = response;
    }

    //@EventListener(ApplicationReadyEvent.class)
    public void jakDoTegoDoszloNieWiem(){
        System.out.println("spotify.requestUrlAddress(xD)");
        System.out.println(service.getSporifyArtistUrlById("0TnOYISbd1XYRBk9myaseg"));
    }
}

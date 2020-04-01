package com.musicapp.happi.dataBase;

import com.musicapp.happi.apiConsumers.spotify.SpotifyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Tester {
    private final SpotifyProperties properties;

    @Autowired
    public Tester(SpotifyProperties properties) {this.properties = properties;}

    @EventListener(ApplicationReadyEvent.class)
    public void jakDoTegoDoszloNieWiem(){
        System.out.println("spotify.requestUrlAddress(xD)");

    }
}

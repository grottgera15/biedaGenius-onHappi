package com.musicapp.happi.apiConsumers.spotify;

import java.time.LocalDateTime;

public class SpotifyChangableProperties {
    public String accessToken;

    private LocalDateTime lastTokenGenerated = LocalDateTime.now().minusSeconds(4000);

    private boolean needNewAccessToken(){
        if(lastTokenGenerated == null){
            return true;
        }else if(lastTokenGenerated.plusSeconds(3600).isBefore(LocalDateTime.now()) || accessToken.length() < 5){

            return true;
        }
        return false;
    }
}

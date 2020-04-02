package com.musicapp.happi.apiConsumers.spotify;


import com.musicapp.happi.apiConsumers.spotify.model.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.ServerEndpoint;
import java.time.LocalDateTime;
import java.util.Base64;

@Configuration
@Getter
public class SpotifyProperties {

    @Value("${spotify.url}")
    public String urlAddress;

    @Value("${spotify.tokenUrl}")
    private String tokenUrlAdress;

    //@Value("${spotify.clientId}")
    private String clientId = System.getenv("CLIENT_ID");

    @Value("${spotify.clientSecret}")
    private String clientSecret;

    public HttpHeaders generateHeaderForAccess() {
        HttpHeaders headers = new HttpHeaders();
        StringBuilder builder = new StringBuilder();

        builder.append(getClientId())
               .append(":")
               .append(getClientSecret());

        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(builder.toString().getBytes()));
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        return headers;
    }
}

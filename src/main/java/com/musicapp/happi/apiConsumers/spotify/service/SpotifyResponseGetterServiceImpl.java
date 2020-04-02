package com.musicapp.happi.apiConsumers.spotify.service;

import com.musicapp.happi.apiConsumers.spotify.SpotifyProperties;
import com.musicapp.happi.apiConsumers.spotify.model.ArtistFull;
import com.musicapp.happi.apiConsumers.spotify.model.Token;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpotifyResponseGetterServiceImpl implements SpotifyResponseGetterService {
    private final SpotifyProperties properties;

    public SpotifyResponseGetterServiceImpl(SpotifyProperties properties) {this.properties= properties;}

    @Override
    public String requestUrlAddress(List<String> pathParams) {
        return properties.getUrlAddress() + addPathParams(pathParams);
    }

    private String addPathParams(List<String> pathParams) {
        StringBuilder result = new StringBuilder();

        if (pathParams.size() != 0) {
            result.append("/");
        }

        for (String param : pathParams) {
            if (param == pathParams.get(pathParams.size() - 1)) {
                result.append(param);
            } else {
                result.append(param)
                      .append("/");
            }
        }

        return result.toString();
    }

    @Override
    public ResponseEntity<ArtistFull> getResponseArtistFull(List<String> pathParams) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = addAuthorizationHeader();

        return rest.exchange(requestUrlAddress(pathParams), HttpMethod.GET, new HttpEntity<String>(headers), ArtistFull.class);
    }

    private HttpHeaders addAuthorizationHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccesToken());

        return headers;
    }

    private String getAccesToken(){
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers  = properties.generateHeaderForAccess();
        MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
        bodyParams.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<MultiValueMap<String, String>>(bodyParams, headers);

        return rest.postForEntity(properties.getTokenUrlAdress(), request, Token.class).getBody().getAccess_token();
    }

}

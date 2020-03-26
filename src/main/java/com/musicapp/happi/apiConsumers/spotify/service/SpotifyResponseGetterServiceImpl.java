package com.musicapp.happi.apiConsumers.spotify.service;

import com.musicapp.happi.apiConsumers.spotify.Properties;
import com.musicapp.happi.apiConsumers.spotify.model.ArtistFull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SpotifyResponseGetterServiceImpl implements SpotifyResponseGetterService {
    Properties properties;

    @Override
    public String requestUrlAddress(List<String> pathParams) {
        return properties.urlAddress + addPathParams(pathParams);
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
        HttpEntity<String> headers = addAuthorizationToHeaders();

        return rest.getForEntity(requestUrlAddress(pathParams), ArtistFull.class);
    }

    private HttpEntity<String> addAuthorizationToHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + properties.getActiveAccesToken());

        return new HttpEntity<String>(headers);
    }


}

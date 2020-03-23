package com.musicapp.happi.apiConsumers.happi.service;

import com.musicapp.happi.apiConsumers.happi.Properties;
import com.musicapp.happi.apiConsumers.happi.model.DTO.*;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HappiResponseGetterServiceImpl implements HappiResponseGetterService {
    private final Properties properties;

    @Autowired
    public HappiResponseGetterServiceImpl(Properties properties) {
        this.properties = properties;
    }

    private static String addPathParamsToString(List<String> pathParams) {
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

    private void addAuthorizationToApiParams(Map<String, String> apiParams) {
        apiParams.put("apikey", properties.getAuthorizationKey());
    }

    @Override
    public String requestUrlAddress(List<String> pathParams, Map<String, String> apiParams) {
        String url = properties.getUrl() + addPathParamsToString(pathParams);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        for (Map.Entry<String, String> param : apiParams.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }

        return builder.toUriString();
    }

    public String requestUrlAddress(Map<String, String> apiParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(properties.getUrl());
        for (Map.Entry<String, String> param : apiParams.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }

        return builder.toUriString();
    }


    @Override
    public ResponseEntity<ArtistList> getResponseArtistList(Map<String, String> apiParams) {
        RestTemplate rest = new RestTemplate();

        addAuthorizationToApiParams(apiParams);
        ResponseEntity<ArtistList> response = rest.getForEntity(requestUrlAddress(apiParams), ArtistList.class);
        return response;
    }

    private <T> ResponseEntity<T> getForEntity(String api_path, Class<T> tClass) {
        RestTemplate rest = new RestTemplate();
        Map<String, String> apiParams = new HashMap<>();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(api_path)
                                                           .queryParam("apikey", properties.getAuthorizationKey());

        return rest.getForEntity(builder.toUriString(), tClass);
    }

    @Override
    public ResponseEntity<AlbumFull> getResponseAlbum(String api_album) {
        return getForEntity(api_album, AlbumFull.class);
    }

    @Override
    public ResponseEntity<ArtistFull> getResponseArtist(String api_artist) {
        return getForEntity(api_artist, ArtistFull.class);
    }

    @Override
    public ResponseEntity<TrackFull> getResponseTrack(String api_artist) {
        return getForEntity(api_artist, TrackFull.class);
    }
}
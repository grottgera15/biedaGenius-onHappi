package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.happi.model.DTO.AlbumFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import com.musicapp.happi.apiConsumers.happi.model.DTO.TrackFull;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class HappiRequest {
    private String address = new String("https://api.happi.dev/v1/music");
    private List<String> pathParams;
    private Map<String, String> apiParams;
    private Pair<String, String> apikey = new Pair<>("apikey", "4728a2ukk9fAUKeoYWXbYPiQQ6YfAJNb60xRXSIwt3BITlwycdg2rVxH");

    public HappiRequest(List<String> pathParams, Map<String, String> apiParams) {
        this.pathParams = pathParams;
        this.apiParams = apiParams;
    }

    private static String addPathParamsToUrl(List<String> pathParams) {
        StringBuilder result = new StringBuilder();

        if(pathParams.size() != 0){
            result.append("/");
        }

        for(String param : pathParams){
            if(param == pathParams.get(pathParams.size()-1)){
                result.append(param);
            }else{
                result.append(param)
                      .append("/");
            }
        }

        return result.toString();
    }

    private void addAuthorizationToApiParams(Map<String, String> apiParams){
        apiParams.put(apikey.getKey(), apikey.getValue());
    }

    public String requestUrlAddress(){
        return address + addPathParamsToUrl(pathParams);
    }

    private <T> ResponseEntity<T> getForEntity (String api_path,Class<T> tClass){
        RestTemplate rest = new RestTemplate();
        addAuthorizationToApiParams(apiParams);
        return rest.getForEntity(api_path, tClass, apiParams);
    }

    public ResponseEntity<AlbumFull> getResponseAlbum(String api_album){
        return getForEntity(api_album,AlbumFull.class);
    }

    public ResponseEntity<ArtistList> getResponseArtistList(){
        RestTemplate rest = new RestTemplate();

        addAuthorizationToApiParams(apiParams);
        ResponseEntity<ArtistList>  response = rest.getForEntity(requestUrlAddress(), ArtistList.class, apiParams);
        return  response;
    }

    public ResponseEntity<ArtistFull> getResponseArtist(String api_artist){
        RestTemplate rest = new RestTemplate();

        addAuthorizationToApiParams(apiParams);
        ResponseEntity<ArtistFull>  response = rest.getForEntity(api_artist, ArtistFull.class, apiParams);
        return  response;
    }

    public ResponseEntity<TrackFull> getResponseTrack(String api_artist){
        RestTemplate rest = new RestTemplate();

        addAuthorizationToApiParams(apiParams);
        ResponseEntity<TrackFull>  response = rest.getForEntity(api_artist, TrackFull.class, apiParams);
        return  response;
    }
}
package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.happi.model.DTO.AlbumFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import com.musicapp.happi.apiConsumers.happi.model.DTO.TrackFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HappiRequestImpl implements HappiRequest{
    private final Properties properties;

    @Autowired
    public HappiRequestImpl(Properties properties) {
        this.properties = properties;
    }

    private static String pathParamsToString(List<String> pathParams) {
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
        apiParams.put("apikey", properties.getAuthorizationKey());
    }

    @Override
    public String requestUrlAddress(List<String> pathParams){
        return properties.getUrl() + pathParamsToString(pathParams);
    }

    public String requestUrlAddress(){
        return properties.getUrl();
    }

    @Override
    public ResponseEntity<ArtistList> getResponseArtistList(Map<String, String> apiParams){
        RestTemplate rest = new RestTemplate();

        addAuthorizationToApiParams(apiParams);
        ResponseEntity<ArtistList>  response = rest.getForEntity(requestUrlAddress(), ArtistList.class, apiParams);
        return  response;
    }

    private <T> ResponseEntity<T> getForEntity (String api_path,Class<T> tClass){
        RestTemplate rest = new RestTemplate();
        Map<String, String> apiParams = new HashMap<>();
        addAuthorizationToApiParams(apiParams);
        return rest.getForEntity(api_path, tClass, apiParams);
    }

    @Override
    public ResponseEntity<AlbumFull> getResponseAlbum(String api_album){
        return getForEntity(api_album,AlbumFull.class);
    }

    @Override
    public ResponseEntity<ArtistFull> getResponseArtist(String api_artist){
       return getForEntity(api_artist, ArtistFull.class);
    }

    @Override
    public ResponseEntity<TrackFull> getResponseTrack(String api_artist){
        return getForEntity(api_artist, TrackFull.class);
    }
}
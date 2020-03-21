package com.musicapp.happi.apiConsumers.happi;


import com.musicapp.happi.apiConsumers.happi.model.DTO.AlbumFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistFull;
import com.musicapp.happi.apiConsumers.happi.model.DTO.ArtistList;
import com.musicapp.happi.apiConsumers.happi.model.DTO.TrackFull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Getter
@Setter

public class HappiRequestBuilder {
    private List<String> pathParams;
    private Map<String, String> apiParams;

    //q* - text to search, limit-max50, type - track/artist
    public ResponseEntity<ArtistList> searchRequest(String q, int limit, String type){
        apiParams.put("q", q);
        apiParams.put("limit", new Integer(limit).toString());
        apiParams.put("type", type);

        HappiRequest request = new HappiRequest(pathParams, apiParams);
        return request.getResponseArtistList();
    }

}

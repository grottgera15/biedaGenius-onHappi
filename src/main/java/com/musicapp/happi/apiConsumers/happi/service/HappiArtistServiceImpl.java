package com.musicapp.happi.apiConsumers.happi.service;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Halbum;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Htrack;
import com.musicapp.happi.dataBase.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class HappiArtistServiceImpl implements  HappiArtistService {
    @Autowired
    HappiRequestService happiRequest;

    @Autowired
    HappiResponseGetterService happiResponse;

    @Override
    public Hartist getHartistByName(String artistName){
        Artist artist = new Artist();

        Hartist hArtist = new Hartist();

        hArtist = getHartist(artistName);

         List<Halbum> albumList = getAlbumList(hArtist);

         getTracks(albumList);

         hArtist.setAlbums(albumList);

        return hArtist;
    }

    private void getTracks(List<Halbum> albumList) {
        for(Halbum album : albumList){
            List<Htrack> trackList = new ArrayList<>();
            for(Htrack track : album.getTracks()){
                track = happiResponse.getResponseTrack(track.getApi_lyrics())
                                     .getBody()
                                     .getResult();
                trackList.add(track);
            }
            album.setTracks(trackList);
        }
    }

    private List<Halbum> getAlbumList(Hartist hArtist) {
        List<Halbum> albumList = new ArrayList<>();
        for(Halbum album : hArtist.getAlbums()){
            album = happiResponse.getResponseAlbum(album.getApi_album())
                                 .getBody()
                                 .getResult();
            albumList.add(album);
        }
        return albumList;
    }

    private Hartist getHartist(String artistName) {
        return happiResponse.getResponseArtist(
                happiRequest.searchRequest(artistName, 10, "artist")
                            .getBody()
                            .getResult()
                            .get(0)
                            .getApi_artist()
        )
                     .getBody()
                     .getResult();
    }
}

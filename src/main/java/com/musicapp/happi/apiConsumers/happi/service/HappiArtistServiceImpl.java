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
public class HappiArtistServiceImpl implements   HappiArtistService {
    @Autowired
    HappiRequestService happiRequest;

    @Autowired
    HappiResponseGetterService happiResponse;

    @Override
    public Hartist getHartistByName(String artistName){

        Hartist hArtist = new Hartist();

        hArtist = getHartist(artistName);

         List<Halbum> albumList = getAlbumList(hArtist);

         getTracks(albumList);

         hArtist.setAlbums(albumList);

        return hArtist;
    }

    private void getTracks(List<Halbum> albumList) {
        for(Halbum album : albumList){
            List<Htrack> result = new ArrayList<>();
            List<Htrack> trackList = happiResponse.getResponseAlbum(album.getApi_tracks())
                                                  .getBody()
                                                  .getResult()
                                                  .getTracks();
            for(Htrack track : trackList){
               if(track.isHaslyrics() == true){
                   track = happiResponse.getResponseTrack(track.getApi_lyrics())
                                        .getBody()
                                        .getResult();
               }else{
                   track = happiResponse.getResponseTrack(track.getApi_track())
                           .getBody()
                           .getResult();
                   track.setLyrics("No lyrics found :< sry m8");
               }
                result.add(track);
            }
            album.setTracks(result);
        }
    }

    private List<Halbum> getAlbumList(Hartist hArtist) {
        List<Halbum> albumList = happiResponse.getResponseArtist(hArtist.getApi_albums())
                                              .getBody()
                                              .getResult()
                                              .getAlbums();

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

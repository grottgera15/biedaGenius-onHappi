package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Halbum;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Htrack;
import com.musicapp.happi.dataBase.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class HappiArtistService {
    public Artist getArtistByName(String artistName){
        Artist artist = new Artist();

        Hartist hArtist = new Hartist();
        Halbum hAlbum = new Halbum();
        Htrack hTrack = new Htrack();

        return null;
    }



}

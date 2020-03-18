package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.dataBase.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HappiToArtistMaper {
    Artist artist = new Artist();

    // chain

    public Artist chainFromName(String artistName){


        return null;
    }



}

package com.musicapp.happi.dataBase.modelResponse;

import com.musicapp.happi.dataBase.model.Artist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArtistsResponse implements Serializable {
    private String artistName;
    private String artistId;
    private String aritstImg;

    public ArtistsResponse(Artist artist){
        this.artistName = artist.getName();
        this.artistId = artist.getId();
        this.aritstImg = artist.getImg();
    }

    public static List<ArtistsResponse> getAllArtistMetadata(Iterable<Artist> artistList){
        List<ArtistsResponse> artistResponses = new ArrayList<>();

        artistList.forEach( x -> artistResponses.add(new ArtistsResponse(x)) );

        return artistResponses;
    }
}

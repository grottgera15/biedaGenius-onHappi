package com.musicapp.happi.dataBase.modelResponse;

import com.musicapp.happi.dataBase.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ArtistResponse {
    private String artistName;
    private String artistId;
    private String aritstImg;

    public ArtistResponse(Artist artist){
        this.artistName = artist.getName();
        this.artistId = artist.getId();
        this.aritstImg = artist.getImg();
    }

    public static List<ArtistResponse> getAllArtistMetadata(Iterable<Artist> artistList){
        List<ArtistResponse> artistResponses = new ArrayList<>();

        artistList.forEach( x -> artistResponses.add(new ArtistResponse(x)) );

        return artistResponses;
    }
}

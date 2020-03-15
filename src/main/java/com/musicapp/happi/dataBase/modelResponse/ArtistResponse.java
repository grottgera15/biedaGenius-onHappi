package com.musicapp.happi.dataBase.modelResponse;

import com.musicapp.happi.dataBase.model.Artist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArtistResponse implements Serializable {
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

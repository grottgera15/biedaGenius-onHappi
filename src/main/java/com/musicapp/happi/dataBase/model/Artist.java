package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "ArtistsDataBase")
public class Artist {
    @Id
    @JsonView(View.metaDataArtist.class)
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView(View.metaDataArtist.class)
    private String artistName;

    @JsonView(View.metaDataArtist.class)
    private String artistImg;

    @JsonView(View.allDataArtist.class)
    private String artistDescription;

    @JsonView(View.allDataArtist.class)
    private String spotify;

    @DBRef
    @JsonView(View.allDataArtist.class)
    @JsonIgnoreProperties("tracks")
    private List<Album> albums;

    public Artist() {
        this.albums = new ArrayList<>();
    }

    public Artist(String name, String img, String description, String spotify, List<Album> albums) {
        this.artistName = name;
        this.artistImg = img;
        this.artistDescription = description;
        this.spotify = spotify;
        this.albums = albums;
    }
}
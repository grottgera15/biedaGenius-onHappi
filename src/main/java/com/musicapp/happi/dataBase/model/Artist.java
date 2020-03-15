package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "ArtistsDataBase")
public class Artist {
    @Id
    @JsonView(View.metaDataArtist.class)
    private String id;
    @JsonIgnore
    private String apiId;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView(View.metaDataArtist.class)
    private String name;

    @JsonView(View.metaDataArtist.class)
    private String img;

    @JsonIgnore
    private String apiAddress;

    @JsonView(View.allDataArtist.class)
    private String discription;

    @JsonIgnore
    private String apiAlbumsAddress;

    @DBRef
    @JsonView(View.allDataArtist.class)
    @JsonIgnoreProperties("tracks")
    private List<Album> albums;

    public Artist() {
        this.albums = new ArrayList<>();
    }

    public Artist(String apiId, String name, String img, String apiAddress, String discription, String apiAlbumsAddress, List<Album> albums) {
        this.apiId = apiId;
        this.name = name;
        this.img = img;
        this.apiAddress = apiAddress;
        this.discription = discription;
        this.apiAlbumsAddress = apiAlbumsAddress;
        this.albums = albums;
    }

    public String getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getApiAddress() {
        return apiAddress;
    }

    public String getDiscription() {
        return discription;
    }

    public String getApiAlbumsAddress() {
        return apiAlbumsAddress;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
package com.musicapp.happi.dataBase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "ArtistsDataBase")
public class Artist {
    @Id
    private String id;
    private String apiId;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String img;
    private String apiAddress;
    private String discription;
    private String apiAlbumsAddress;
    private List<Album> albums;

    public Artist() {
        this.albums = new ArrayList<>();
    }

    public Artist(String id, String apiId, String name, String img, String apiAddress, String discription, String apiAlbumsAddress, List<Album> albums) {
        this.id = id;
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
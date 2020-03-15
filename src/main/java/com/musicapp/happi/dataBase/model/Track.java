package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tracks")
public class Track {
    @Id
    @JsonView({View.allDataTrack.class, View.allDataAlbum.class})
    private String id;

    @JsonIgnore
    private String apiId;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView({View.allDataTrack.class, View.allDataAlbum.class})
    private String name;

    @JsonView({View.allDataTrack.class})
    private String lyrics;

    @JsonIgnore
    private String apiTrack;

    public Track(String apiId, String name, String lyrics, String apiTrack) {
        this.apiId = apiId;
        this.name = name;
        this.lyrics = lyrics;
        this.apiTrack = apiTrack;
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

    public String getLyrics() {
        return lyrics;
    }

    public String getApiTrack() {
        return apiTrack;
    }
}

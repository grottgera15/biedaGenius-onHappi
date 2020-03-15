package com.musicapp.happi.dataBase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class Track {
    @Id
    private String id;
    private String apiId;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String lyrics;
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

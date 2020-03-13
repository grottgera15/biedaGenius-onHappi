package com.musicapp.happi.dataBase;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

public class Track {
    @Id
    private int id;
    private int apiId;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String lyrics;
    private String apiTrack;

    public Track(int id, int apiId, String name, String lyrics, String apiTrack) {
        this.id = id;
        this.apiId = apiId;
        this.name = name;
        this.lyrics = lyrics;
        this.apiTrack = apiTrack;
    }

    public int getId() {
        return id;
    }

    public int getApiId() {
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

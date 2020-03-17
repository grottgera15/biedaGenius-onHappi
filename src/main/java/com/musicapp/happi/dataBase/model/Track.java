package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Tracks")
public class Track {
    @Id
    @JsonView({View.allDataTrack.class, View.allDataAlbum.class})
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView({View.allDataTrack.class, View.allDataAlbum.class})
    private String name;

    @JsonView({View.allDataTrack.class})
    private String lyrics;

    public Track(String name, String lyrics) {
        this.name = name;
        this.lyrics = lyrics;
    }
}

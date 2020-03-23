package com.musicapp.happi.apiConsumers.happi.model.responseClass;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Halbum {
    private String album;

    private String cover;

    private String api_album;

    private String api_tracks;

    private String realease;

    private List<Htrack> tracks;

    public Halbum(){
        this.tracks = new ArrayList<>();
    }
}

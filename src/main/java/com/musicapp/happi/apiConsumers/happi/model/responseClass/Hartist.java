package com.musicapp.happi.apiConsumers.happi.model.responseClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Hartist {
    private String artist;

    private String api_artist;

    private String cover;

    private String spotify;

    private String api_albums;

    private List<Halbum> albums;

    public Hartist(){
        this.albums = new ArrayList<>();
    }
}

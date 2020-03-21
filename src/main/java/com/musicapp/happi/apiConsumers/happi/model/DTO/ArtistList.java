package com.musicapp.happi.apiConsumers.happi.model.DTO;


import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArtistList {

    private boolean success;

    private int length;

    private String error;

    private List<Hartist> result;

    public ArtistList(){
        this.result = new ArrayList<>();
    }
}

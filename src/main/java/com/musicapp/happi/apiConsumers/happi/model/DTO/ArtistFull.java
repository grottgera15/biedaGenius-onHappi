package com.musicapp.happi.apiConsumers.happi.model.DTO;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistFull {
    private boolean success;

    private int length;

    private String error;

    private Hartist result;
}

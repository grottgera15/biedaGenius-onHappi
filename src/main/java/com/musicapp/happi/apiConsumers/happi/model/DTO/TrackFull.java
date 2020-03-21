package com.musicapp.happi.apiConsumers.happi.model.DTO;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Htrack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackFull {

    private boolean success;

    private int length;

    private String error;

    private Htrack result;
}

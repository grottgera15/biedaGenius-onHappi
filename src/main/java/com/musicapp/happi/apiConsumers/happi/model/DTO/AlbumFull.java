package com.musicapp.happi.apiConsumers.happi.model.DTO;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Halbum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumFull {

    private boolean success;

    private int length;

    private String error;

    private Halbum result;
}

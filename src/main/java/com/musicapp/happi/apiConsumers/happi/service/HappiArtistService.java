package com.musicapp.happi.apiConsumers.happi.service;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;

public interface HappiArtistService {
    public abstract Hartist getHartistByName(String artistName);
}

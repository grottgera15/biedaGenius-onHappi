package com.musicapp.happi.apiConsumers;

import com.musicapp.happi.dataBase.model.Artist;

public interface ApiConsumer {
    public abstract Artist getArtistByName(String artistName);
}

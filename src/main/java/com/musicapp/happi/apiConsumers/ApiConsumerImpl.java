package com.musicapp.happi.apiConsumers;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.apiConsumers.happi.service.HappiArtistService;
import com.musicapp.happi.dataBase.model.Artist;
import org.springframework.stereotype.Service;

@Service
public class ApiConsumerImpl implements  ApiConsumer{
    HappiArtistService happiApi;

    @Override
    public Artist getArtistByName(String artistName) {
        return HartistMapper.INSTANCE.hartistToArtist(happiApi.getHartistByName(artistName));
    }
}

package com.musicapp.happi.dataBase;

import com.musicapp.happi.apiConsumers.ApiConsumer;
import com.musicapp.happi.apiConsumers.HartistMapper;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.apiConsumers.happi.service.HappiArtistService;
import com.musicapp.happi.dataBase.model.Album;
import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.model.Track;
import com.musicapp.happi.dataBase.repository.AlbumRepository;
import com.musicapp.happi.dataBase.repository.ArtistReposiotry;
import com.musicapp.happi.dataBase.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder {
    private final ArtistReposiotry artistReposiotry;
    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    HappiArtistService hapi;

    @Autowired
    public DbSeeder(ArtistReposiotry artistReposiotry, TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.artistReposiotry = artistReposiotry;
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }


    private void saveArtist(Artist a){
        a.getAlbums().forEach(
                x -> trackRepository.saveAll(x.getTracks())
        );

        albumRepository.saveAll(a.getAlbums());

        artistReposiotry.save(a);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setDbInitData(){

        Artist caron = HartistMapper.INSTANCE.hartistToArtist(hapi.getHartistByName("Danny Caron"));
        Artist meek = HartistMapper.INSTANCE.hartistToArtist(hapi.getHartistByName("Meek, Oh Why"));
        Artist roksi = HartistMapper.INSTANCE.hartistToArtist(hapi.getHartistByName("Roksana Węgiel"));
        Artist kochanyMareczek = HartistMapper.INSTANCE.hartistToArtist(hapi.getHartistByName("Marek Grechuta"));



        this.artistReposiotry.deleteAll();
        this.albumRepository.deleteAll();
        this.trackRepository.deleteAll();

        saveArtist(caron);
        saveArtist(meek);
        saveArtist(roksi);
        saveArtist(kochanyMareczek);
    }
}

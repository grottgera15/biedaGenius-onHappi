package com.musicapp.happi.dataBase.repository;

import com.musicapp.happi.dataBase.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArtistsReposiotry extends MongoRepository <Artist, String> {
    // BY ARTIST
    Optional<Artist> findById(String id);
    Optional<Artist> findByApiId(String apiId);
    Optional<Artist> findByName(String name);

    // BY ALBUM



    // BY TRACK

}
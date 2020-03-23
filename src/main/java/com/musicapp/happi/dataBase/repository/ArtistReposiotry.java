package com.musicapp.happi.dataBase.repository;

import com.musicapp.happi.dataBase.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArtistReposiotry extends MongoRepository <Artist, String> {

}

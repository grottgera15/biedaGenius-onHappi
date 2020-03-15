package com.musicapp.happi.dataBase.repository;

import com.musicapp.happi.dataBase.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}

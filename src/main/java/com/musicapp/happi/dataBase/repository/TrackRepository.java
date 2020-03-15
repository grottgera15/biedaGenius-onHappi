package com.musicapp.happi.dataBase.repository;

import com.musicapp.happi.dataBase.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepository extends MongoRepository<Track, String> {
}

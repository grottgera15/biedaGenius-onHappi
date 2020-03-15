package com.musicapp.happi.dataBase.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.modelResponse.ArtistResponse;
import com.musicapp.happi.dataBase.repository.ArtistReposiotry;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private ArtistReposiotry artistRepository;

    public ArtistController(ArtistReposiotry artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Artist> artistsList = this.artistRepository.findAll();
        List<ArtistResponse> response = ArtistResponse.getAllArtistMetadata(artistsList);

        return ResponseEntity.ok(response);
    }
/*
    @GetMapping("/debug")
    public ResponseEntity<?> debug(){
        return ResponseEntity.ok(this.artistRepository.findAll());
    }
*/
 /*
 @GetMapping
    public ResponseEntity<?> getArtistsImRange(@RequestParam("size") int size, @RequestParam("page") int page) {
        Page<Artist> artistsList = this.artistRepository.findAll(QPageRequest.of(page, size));
        List<ArtistResponse> response = ArtistResponse.getAllArtistMetadata(artistsList);

        return ResponseEntity.ok(response);
    }
*/


}
package com.musicapp.happi.dataBase.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.model.View;
import com.musicapp.happi.dataBase.modelResponse.ArtistsResponse;
import com.musicapp.happi.dataBase.repository.ArtistReposiotry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistReposiotry artistRepository;

    public ArtistController(ArtistReposiotry artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping
    @JsonView(View.metaDataArtist.class)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.artistRepository.findAll());
    }

    @GetMapping("/{id}")
    @JsonView({View.allDataArtist.class})
    public ResponseEntity<?> getSingle(@PathVariable("id") String id){
        return ResponseEntity.ok(this.artistRepository.findById(id));
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
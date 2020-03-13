package com.musicapp.happi.dataBase.controller;

import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.repository.ArtistsReposiotry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private ArtistsReposiotry artistRepository;
    public ArtistController(ArtistsReposiotry artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Artist> artists = this.artistRepository.findAll();
        return ResponseEntity.ok(artists);
    }
}

package com.musicapp.happi.dataBase.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.musicapp.happi.dataBase.model.View;
import com.musicapp.happi.dataBase.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/{id}")
    @JsonView({View.allDataAlbum.class})
    public ResponseEntity<?> getSingle(@PathVariable("id") String albumId) {
        return ResponseEntity.ok(this.albumRepository.findById(albumId));
    }
}


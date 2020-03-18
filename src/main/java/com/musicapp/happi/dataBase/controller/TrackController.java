package com.musicapp.happi.dataBase.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.musicapp.happi.dataBase.model.View;
import com.musicapp.happi.dataBase.repository.TrackRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackRepository trackRepository;

    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @GetMapping("/{id}")
    @JsonView(View.allDataTrack.class)
    public ResponseEntity<?> getSingle(@PathVariable("id") String id){
        return ResponseEntity.ok(this.trackRepository.findById(id));
    }

}

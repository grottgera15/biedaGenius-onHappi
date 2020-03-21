package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "Albums")
public class Album {
   @Id
   @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String albumName;

    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String albumImg;

    @JsonView(View.allDataAlbum.class)
    private String albumDescription;

    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String realeaseDate;

    @DBRef
    @JsonView(View.allDataAlbum.class)
    @JsonIgnoreProperties("lyrics")
    private List<Track> tracks;

 public Album() {
  this.tracks = new ArrayList<>();
 }

 public Album(String name, String img, String description, String realeaseDate, List<Track> tracks) {
  this.albumName = name;
  this.albumImg = img;
  this.albumDescription = description;
  this.realeaseDate = realeaseDate;
  this.tracks = tracks;
 }
}

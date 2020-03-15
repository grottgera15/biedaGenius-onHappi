package com.musicapp.happi.dataBase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Albums")
public class Album {
   @Id
   @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String id;

   @JsonIgnore
    private String apiId;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String name;

    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String img;

    @JsonView({View.allDataAlbum.class, View.allDataArtist.class})
    private String realeaseDate;

    @JsonIgnore
    private String apiTracks;

    @DBRef
    @JsonView(View.allDataAlbum.class)
    @JsonIgnoreProperties("lyrics")
    private List<Track> tracks;

 public Album() {
  this.tracks = new ArrayList<>();
 }

 public Album(String apiId, String name, String img, String realeaseDate, String apiTracks, List<Track> tracks) {
  this.apiId = apiId;
  this.name = name;
  this.img = img;
  this.realeaseDate = realeaseDate;
  this.apiTracks = apiTracks;
  this.tracks = tracks;
 }

 public String getId() {
  return id;
 }

 public String getApiId() {
  return apiId;
 }

 public String getName() {
  return name;
 }

 public String getImg() {
  return img;
 }

 public String getRealeaseDate() {
  return realeaseDate;
 }

 public String getApiTracks() {
  return apiTracks;
 }

 public List<Track> getTracks() {
  return tracks;
 }
}

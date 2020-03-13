package com.musicapp.happi.dataBase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

public class Album {
   @Id
    private String id;
    private String apiId;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String img;
    private String realeaseDate;
    private String apiTracks;
    private List<Track> tracks;

 public Album() {
  this.tracks = new ArrayList<>();
 }

 public Album(String id, String apiId, String name, String img, String realeaseDate, String apiTracks, List<Track> tracks) {
  this.id = id;
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

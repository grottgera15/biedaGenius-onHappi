package com.musicapp.happi.apiConsumers.happi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hartist extends DataTransferObjectTemplate {
    @JsonProperty("name")
    private String artist;

    private String spotify;

    private String api_albums;
}

package com.musicapp.happi.apiConsumers.happi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Halbum implements DataTransferObjectTemplate {
    @JsonProperty("name")
    private String album;

    @JsonProperty("realeaseDate")
    private String realease;

    private String api_tracks;

}

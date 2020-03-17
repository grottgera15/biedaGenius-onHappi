package com.musicapp.happi.apiConsumers.happi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.musicapp.happi.apiConsumers.happi.HappiDataTransferObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchArtist extends HappiDataTransferObject {
    private String artist;

    private String api_artist;
}

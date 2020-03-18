package com.musicapp.happi.apiConsumers.happi.model;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchArtist implements DataTransferObjectTemplate {
    private String artist;

    private String api_artist;
}

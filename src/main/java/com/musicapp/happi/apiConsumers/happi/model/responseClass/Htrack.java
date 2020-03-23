package com.musicapp.happi.apiConsumers.happi.model.responseClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Htrack {
    private String track;

    private String api_lyrics;

    private String api_track;

    private boolean haslyrics;

    private String lyrics;

    private String copyright_label;

    private String copyright_notice;

    private String copyright_text;
}

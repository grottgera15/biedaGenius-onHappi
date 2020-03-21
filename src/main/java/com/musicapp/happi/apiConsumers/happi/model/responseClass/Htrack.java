package com.musicapp.happi.apiConsumers.happi.model.responseClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Htrack {
    @JsonProperty("trackName")
    private String track;

    private String api_lyrics;

    private String lyrics;

    private String copyright_label;

    private String copyright_notice;

    private String copyright_text;
}

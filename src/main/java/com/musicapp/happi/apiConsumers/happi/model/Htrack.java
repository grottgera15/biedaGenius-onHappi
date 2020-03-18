package com.musicapp.happi.apiConsumers.happi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Htrack implements DataTransferObjectTemplate {
    @JsonProperty("name")
    private String track;

    private String lyrics;

    private String copyright_label;

    private String copyright_notice;

    private String copyright_text;
}

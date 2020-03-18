package com.musicapp.happi.apiConsumers.happi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HalbumMeta extends DataTransferObjectTemplate {
    private String api_album;
}

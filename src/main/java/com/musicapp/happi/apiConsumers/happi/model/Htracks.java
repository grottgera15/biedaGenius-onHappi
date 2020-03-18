package com.musicapp.happi.apiConsumers.happi.model;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Htracks extends DataTransferObjectTemplate {

    private String label;

    private List<HtrackMeta> tracks;
}

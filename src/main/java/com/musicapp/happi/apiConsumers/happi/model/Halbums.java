package com.musicapp.happi.apiConsumers.happi.model;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//MapStruck

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Halbums implements DataTransferObjectTemplate {
    private String aritst;

    private Integer length;

    private List<HalbumMeta> albums;
}

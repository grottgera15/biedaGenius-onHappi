package com.musicapp.happi.apiConsumers.happi.model;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HtrackMeta implements DataTransferObjectTemplate {
     private  String api_lyrics;
}

package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HappiDTOHandler extends DataTransferObjectTemplate {
    private boolean success;
    private int length;
    private List<DataTransferObjectTemplate> result;
}

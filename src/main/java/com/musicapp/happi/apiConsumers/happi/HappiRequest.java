package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import com.musicapp.happi.apiConsumers.RequestTemplate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class HappiRequest implements RequestTemplate {
    private String address;
    private List<String> pathParams;
    private Map<String, String> apiParams


    @Override
    public String requestUrlAddress() {


        return  null;
    }

    @Override
    public DataTransferObjectTemplate getResponse() {
        return null;
    }
}

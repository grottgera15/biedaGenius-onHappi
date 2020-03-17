package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import com.musicapp.happi.apiConsumers.RequestTemplate;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HappiRequest implements RequestTemplate {
    private String address = new String("https://api.happi.dev/v1/music/");
    private List<String> pathParams;
    private Map<String, String> apiParams;
    private Pair<String, String> apikey = new Pair<>("apikey", "4728a2ukk9fAUKeoYWXbYPiQQ6YfAJNb60xRXSIwt3BITlwycdg2rVxH");

    public HappiRequest(List<String> pathParams, Map<String, String> apiParams) {
        this.pathParams = pathParams;
        this.apiParams = apiParams;
    }

    @Override
    public String requestUrlAddress(){
        RestTemplate restTemplate = new RestTemplate();

        return  null;
    }

    @Override
    public DataTransferObjectTemplate getResponse() {
        return null;
    }
}

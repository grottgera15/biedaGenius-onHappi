package com.musicapp.happi.apiConsumers.happi;

import com.musicapp.happi.apiConsumers.DataTransferObjectTemplate;
import com.musicapp.happi.apiConsumers.RequestTemplate;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
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

    public HappiRequest(String address, List<String> pathParams, Map<String, String> apiParams) {
        this.address = address;
        this.pathParams = pathParams;
        this.apiParams = apiParams;
        this.apiParams.put(apikey.getKey(), apikey.getValue());
    }

    @Override
    public String requestUrlAddress(){
        return address + addPathParamsToUrl(pathParams);
    }

    private static String addPathParamsToUrl(List<String> pathParams) {
        StringBuilder result = new StringBuilder();

        for(String param : pathParams){
            if(param == pathParams.get(pathParams.size()-1)){
                result.append(param);
            }else{
                result.append(param)
                      .append("/");
            }
        }

        return result.toString();
    }

    @Override
    public void  getResponse(HappiDataTransferObject data) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HappiDataTransferObject> response = restTemplate.getForEntity(requestUrlAddress(), HappiDataTransferObject.class, apiParams);
        data = response.getBody();
    }

    public void getResponse(HappiDataTransferObject data, String uri){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HappiDataTransferObject> response = restTemplate.getForEntity(uri, HappiDataTransferObject.class);
        data = response.getBody();
    }
}

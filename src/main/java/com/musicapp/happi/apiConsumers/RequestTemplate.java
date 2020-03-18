package com.musicapp.happi.apiConsumers;


import org.springframework.http.ResponseEntity;

public interface RequestTemplate {
    public String requestUrlAddress();

    public ResponseEntity<DataTransferObjectTemplate> getResponse();
}

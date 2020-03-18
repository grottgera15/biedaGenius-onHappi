package com.musicapp.happi.apiConsumers;


public interface RequestTemplate {
    public String requestUrlAddress();

    public void getResponse(DataTransferObjectTemplate o);
}

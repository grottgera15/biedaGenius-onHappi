package com.musicapp.happi.apiConsumers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public interface RequestTemplate {
    public String requestUrlAddress();

    public DataTransferObjectTemplate getResponse();
}

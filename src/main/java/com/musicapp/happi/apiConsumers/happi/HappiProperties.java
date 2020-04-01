package com.musicapp.happi.apiConsumers.happi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
public class HappiProperties {
    @Value("${happi.url}")
    private String url;

    @Value("${happi.authorizationKey}")
    private String authorizationKey;
}

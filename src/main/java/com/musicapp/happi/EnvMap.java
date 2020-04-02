package com.musicapp.happi;

import com.musicapp.happi.apiConsumers.happi.HappiProperties;
import com.sun.crypto.provider.ChaCha20Poly1305Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Map;

public class EnvMap {
    HappiProperties happi;
    public static void main (String[] args) {
        System.out.println("Started:");
        Map<String,String> envVar = System.getenv();

        for(Map.Entry<String, String> var: envVar.entrySet()){
            System.out.print(var.getKey());
            System.out.print("=");
            System.out.println(var.getValue());
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    private void printHappiKey() {
        System.out.println("APLICATIONREADYEVENT IS HERE: ");
    }
}
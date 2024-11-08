// src/main/java/com/example/demo/controller/SettingsController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SettingsController 
{

    @GetMapping("/api/settings")
    public Map<String, Object> getSettings() 
    {
        Map<String, Object> settings = new HashMap<>();

        // Ana dropdown verileri
        List<String> dropdownItems = Arrays.asList("Uygulama Ayarları", "Kullanıcı Ayarları", "Güvenlik Ayarları", "Gelişmiş Ayarlar","Ana Sayfaya Dön");

        // Envanter dropdown verileri
        List<String> subDropdownItems = Arrays.asList("Envanter Sayısı", "Envanter Ekle", "Envanter Çıkar");

        // Verileri map yapısına ekle
        settings.put("dropdownItems", dropdownItems);
        settings.put("subDropdownItems", subDropdownItems);

        return settings;
    }
}





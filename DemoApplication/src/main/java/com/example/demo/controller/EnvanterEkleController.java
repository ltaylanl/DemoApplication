package com.example.demo.controller;

import com.example.demo.model.Envanter;
import com.example.demo.response.EnvanterDTO;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvanterEkleController 
{

    @Autowired
    private LogService logService;

    @PostMapping("/envanterEkle")
    public ResponseEntity<?> addEnvanter(@RequestBody EnvanterDTO envanterdto) 
    {
        try {
            // Log kaydı ekleyin
            logService.log("INFO", "Envanter ekleme işlemi başlatıldı: " + envanterdto.toString());

            // Envanter ekleme işlemi
            Envanter envanter = new Envanter(envanterdto.getIsim(), envanterdto.getKod(), envanterdto.getBarkod(), envanterdto.getAdet());
            
            Map<String, Object> response = new HashMap<>();
            response.put("time", new Date());
            response.put("message", "Envanter eklendi");
            response.put("inventory", envanter);

            // Başarılı işlem logu
            logService.log("SUCCESS", "Envanter başarıyla eklendi: " + envanter.getKod());

            return ResponseEntity.ok().body(response);
        } 
        catch (Exception e) 
        {
            // Hata logu
            logService.log("ERROR", "Envanter ekleme işlemi başarısız: " + e.getMessage());
            return ResponseEntity.status(500).body("Envanter ekleme işleminde hata oluştu");
        }
    }
}

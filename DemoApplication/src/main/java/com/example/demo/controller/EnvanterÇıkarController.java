package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EnvanterRepository;

@RestController
public class EnvanterÇıkarController 
{
    private static final Logger logger = LoggerFactory.getLogger(EnvanterEkleController.class);

    @Autowired
    private EnvanterRepository envanterRepository;

    @DeleteMapping("/envanterCikart")
    public ResponseEntity<Map<String, Object>> deleteEnvanter(@RequestParam String kod) 
    {
        logger.info("Envanter çıkartılıyor, kod: {}", kod);
        try
        {
            if (!envanterRepository.existsById(kod)) {
                return ResponseEntity.badRequest().body(Map.of("message", "Belirtilen kod ile envanter bulunamadı"));
            }

            // Veritabanından envanter kaydını sil
            envanterRepository.deleteById(kod);

            Map<String, Object> response = new HashMap<>();
            response.put("time", new Date());
            response.put("message", "Envanter başarıyla çıkartıldı");
            response.put("kod", kod);

            return ResponseEntity.ok().body(response);
        }
        catch (Exception e)
        {
            logger.error("Envanter çıkartılırken hata oluştu", e);
            return ResponseEntity.status(500).body(Map.of("message", "Envanter çıkartılırken hata oluştu"));
        }
    }
}

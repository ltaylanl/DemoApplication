package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Envanter;
import com.example.demo.repository.EnvanterRepository;
import com.example.demo.response.EnvanterDTO;

@RestController
public class EnvanterEkleController 
{
    private static final Logger logger = LoggerFactory.getLogger(EnvanterEkleController.class);

    @Autowired
    private EnvanterRepository envanterRepository;

    @PostMapping("/envanterEkle")
    public ResponseEntity<Map<String, Object>> addEnvanter(@RequestBody EnvanterDTO envanterdto) 
    {
        logger.info("Input parameters: envanter {}", envanterdto);
        try
        {
            if(envanterdto.getIsim() == null || envanterdto.getKod() == null || envanterdto.getBarkod() == null || envanterdto.getAdet() == 0)
            {
                return ResponseEntity.badRequest().body(Map.of("message", "Envanter bilgileri eksik"));
            }

            Envanter envanter = new Envanter(envanterdto.getIsim(), envanterdto.getKod(), envanterdto.getBarkod(), envanterdto.getAdet());
            
            // Envanteri veritabanına kaydet
            envanterRepository.save(envanter);

            Map<String, Object> response = new HashMap<>();
            response.put("time", new Date());
            response.put("message", "Envanter eklendi");
            response.put("inventory", envanter);

            return ResponseEntity.ok().body(response);
        }
        catch (Exception e)
        {
            logger.error("An error occurred while adding envanter", e);
            return ResponseEntity.status(500).body(Map.of("message", "An error occurred while adding envanter"));
        }
    }
}

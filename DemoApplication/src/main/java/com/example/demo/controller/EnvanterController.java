package com.example.demo.controller;

import com.example.demo.model.Envanter;
import com.example.demo.repository.EnvanterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;



@RestController
public class EnvanterController 
{

     @Autowired
    private EnvanterRepository envanterRepository;

    @GetMapping("/envanterSayisi")//Kontrol amaçlı bulunan envanterin oluşumu
    public List<Envanter> getEnvanterList() 
    {
        return Arrays.asList(
           new Envanter("Kalem", "001", "A001", 50),
            new Envanter("Defter", "002", "A002", 20),
            new Envanter("Silgi", "003", "A003", 30),
            new Envanter("Kalem Kutusu", "004", "A004", 10),
            new Envanter("Suluk", "005", "B001", 25),
            new Envanter("Açacak", "006", "A006", 40),
            new Envanter("A4 Kağıdı", "007", "C001", 100),
            new Envanter("Boya Fırçası", "008", "A007", 15),
            new Envanter("Sulu Boya", "009", "A008", 5)
        );
    }

    @GetMapping("/envanterler")
    public List<Envanter> getAllEnvanterler() 
    {
        // Tüm Envanter verilerini veritabanından çekiyoruz
        return envanterRepository.findAll();
    }
    
}


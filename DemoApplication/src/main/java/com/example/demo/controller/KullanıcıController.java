package com.example.demo.controller;

import com.example.demo.model.Kullanıcı;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.KullanıcıRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
public class KullanıcıController 
{
    private List<Kullanıcı> kullanıcıListesi = new ArrayList<>();

    public KullanıcıController() 
    {
        kullanıcıListesi.add(new Kullanıcı("Ali", "Veli", 123456));
        kullanıcıListesi.add(new Kullanıcı("Ayşe", "Fatma", 654321));
        kullanıcıListesi.add(new Kullanıcı("Ahmet", "Mehmet", 112233));
    }

    @GetMapping("/kullanıcı")
    public List<Kullanıcı> getKullanıcı() 
    {
        return kullanıcıListesi;
    }

    @Autowired
    private KullanıcıRepository kullanıcıRepository;

    @GetMapping("/kullanicilar")
    public ResponseEntity<List<Kullanıcı>> getAllKullanicilar() 
    {
        List<Kullanıcı> kullanicilar = kullanıcıRepository.findAll();
        return ResponseEntity.ok(kullanicilar);
}
}

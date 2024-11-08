package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Kullanıcı 
{
    private String ad;
    private String soyad;
    @Id
    private int sicil;

    public Kullanıcı() //Hibernate için gerekli
    {
    }

    // Constructor
    public Kullanıcı(String ad, String soyad, int sicil) 
    {
        this.ad = ad;
        this.soyad = soyad;
        this.sicil = sicil;
    }

    // Getter ve Setter'lar
    public String getAd() 
    {
        return ad;
    }

    public void setAd(String ad) 
    {
        this.ad = ad;
    }

    public String getSoyad() 
    {
        return soyad;
    }

    public void setSoyad(String soyad) 
    {
        this.soyad = soyad;
    }

    public int getSicil() 
    {
        return sicil;
    }

    public void setSicil(int sicil) 
    {
        this.sicil = sicil;
    }
    @Override
    public String toString() 
    {
        return "Kullanıcı [ad=" + ad +  ", soyad=" + soyad + ", sicil=" + sicil + "]";
    }   
}

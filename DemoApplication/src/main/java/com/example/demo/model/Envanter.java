package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Envanter 
{
    private String isim;
    @Id
    private String kod;
    private String barkod;
    private int adet;

    public Envanter() 
    {
    }

    // Constructor
    public Envanter(String isim, String kod, String barkod, int adet) 
    {
        this.isim = isim;
        this.kod = kod;
        this.barkod = barkod;
        this.adet = adet;
    }

    // Getter ve Setter'lar
    public String getIsim() 
    {
        return isim;
    }

    public void setIsim(String isim) 
    {
        this.isim = isim;
    }

    public String getKod() 
    {
        return kod;
    }

    public void setKod(String kod) 
    {
        this.kod = kod;
    }

    public String getBarkod() 
    {
        return barkod;
    }

    public void setBarkod(String barkod) 
    {
        this.barkod = barkod;
    }

    public int getAdet() 
    {
        return adet;
    }

    public void setAdet(int adet) 
    {
        this.adet = adet;
    }

    @Override
    public String toString() 
    {
        return "Envanter [adet=" + adet + ", barkod=" + barkod + ", isim=" + isim + ", kod=" + kod + "]";
    }

}

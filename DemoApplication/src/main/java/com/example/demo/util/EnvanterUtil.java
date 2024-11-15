package com.example.demo.util;

import com.example.demo.model.Envanter;
import com.example.demo.response.EnvanterDTO;

public class EnvanterUtil 
{
    private EnvanterUtil() 
    {

    }

    public static EnvanterDTO maptoEnvanterDTO(Envanter envanter) 
    {
        return EnvanterDTO.builder()
                .kod(envanter.getKod())
                .isim(envanter.getIsim())
                .barkod(envanter.getBarkod())
                .adet(envanter.getAdet())
                .build();
    }
    
}

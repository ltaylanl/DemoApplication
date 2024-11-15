package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvanterDTO 
{
    private String kod;
    private String isim;
    private String barkod;
    private Integer adet;
}

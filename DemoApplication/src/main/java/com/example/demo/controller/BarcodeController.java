package com.example.demo.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class BarcodeController 
{

    @GetMapping("/generateBarcode")
    public void generateBarcode(@RequestParam("code") String code, HttpServletResponse response) 
    {
        try 
        {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(code, BarcodeFormat.CODE_128, 300, 100);
            response.setContentType("image/png");
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

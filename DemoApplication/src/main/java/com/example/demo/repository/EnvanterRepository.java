package com.example.demo.repository;

import com.example.demo.model.Envanter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvanterRepository extends JpaRepository<Envanter, String> 
{
    // İhtiyaç halinde özel sorgular buraya eklenebilir ayrıca 
    // spring otomatikmen veri tabanı ile ilişkisini fonksiyon tamamlandıktan sonra kesiyor.
}

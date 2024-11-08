package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Kullanıcı;

public interface KullanıcıRepository extends JpaRepository<Kullanıcı, Integer> 
{
}


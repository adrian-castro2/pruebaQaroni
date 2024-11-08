package com.apirest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.demo.model.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long> {
}
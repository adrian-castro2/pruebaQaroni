package com.apirest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
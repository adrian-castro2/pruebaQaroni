package com.apirest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.demo.model.Autor;
import com.apirest.demo.model.Libro;
import com.apirest.demo.repository.AutorRepository;
import com.apirest.demo.repository.LibroRepository;



@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

      @Autowired
    private AutorRepository autorRepository; // Asegúrate de inyectar el repositorio de Autor

    @Transactional
    public Libro registrarLibro(Libro libro) {
        // Cargar autores desde la base de datos
        List<Autor> autores = libro.getAutores().stream()
            .map((Autor autor) -> autorRepository.findById(autor.getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + autor.getId())))
            .collect(Collectors.toList());
    
        libro.setAutores(autores);
        return libroRepository.save(libro);
    }
    

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    @Transactional
    public Libro editarLibro(Long id, Libro libro) {
        Optional<Libro> libroExistente = libroRepository.findById(id);
        if (libroExistente.isPresent()) {
            Libro libroActualizado = libroExistente.get();
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setDescripcion(libro.getDescripcion());
            libroActualizado.setFechaPublicacion(libro.getFechaPublicacion());
            return libroRepository.save(libroActualizado);
        } else {
            return null; // O lanzar una excepción
        }
    }
}
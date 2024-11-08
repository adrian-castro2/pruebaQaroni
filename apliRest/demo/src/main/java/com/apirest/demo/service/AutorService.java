package com.apirest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.demo.dto.AutorWithBooksDTO;
import com.apirest.demo.dto.AutorWithBooksDTO.BooksWithoutAutorsDTO;
import com.apirest.demo.model.Autor;
import com.apirest.demo.repository.AutorRepository;


@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public Autor registrarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

    @Transactional
    public Autor actualizarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Optional<AutorWithBooksDTO> obtenerAutorConLibrosPorId(Long id) {
        return autorRepository.findById(id).map(this::convertirAAutorWithBooksDTO);
    }


    private AutorWithBooksDTO convertirAAutorWithBooksDTO(Autor autor) {
        AutorWithBooksDTO dto = new AutorWithBooksDTO();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setBiografia(autor.getBiografia());

        List<BooksWithoutAutorsDTO> librosDTO = autor.getLibros().stream().map(libro -> {
            BooksWithoutAutorsDTO libroDTO = new BooksWithoutAutorsDTO();
            libroDTO.setId(libro.getId());
            libroDTO.setTitulo(libro.getTitulo());
            libroDTO.setDescripcion(libro.getDescripcion());
            libroDTO.setFechaPublicacion(libro.getFechaPublicacion());
            return libroDTO;
        }).collect(Collectors.toList());

        dto.setLibros(librosDTO);
        return dto;
    }

    // Método para obtener un autor por ID
    public Optional<Autor> obtenerAutorPorId(long id) {
        return autorRepository.findById(id);
    }
}
package com.apirest.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.dto.LibroDTO;
import com.apirest.demo.model.Autor;
import com.apirest.demo.model.Libro;
import com.apirest.demo.model.Usuario;
import com.apirest.demo.repository.AutorRepository;
import com.apirest.demo.service.LibroService;

@RestController
@RequestMapping("/api/libros")
@PreAuthorize("denyAll()")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorRepository autorRepository; // Asegúrate de inyectar el repositorio de Autor


    @PreAuthorize("hasAnyAuthority('ADMIN', 'LIBRARIAN')")
    @PostMapping("/registrar")
    public ResponseEntity<Libro> registrarLibro(@RequestBody LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setDescripcion(libroDTO.getDescripcion());
        libro.setFechaPublicacion(libroDTO.getFechaPublicacion());

        // Convertir los IDs de autores a entidades Autor
        List<Autor> autores = libroDTO.getAutoresIds().stream()
            .map(id -> {
                Autor autor = new Autor();
                autor.setId(id);
                return autor;
            })
            .collect(Collectors.toList());

        libro.setAutores(autores);

        return ResponseEntity.ok(libroService.registrarLibro(libro));

    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'LIBRARIAN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Libro> editarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        Optional<Libro> libroExistente = libroService.obtenerLibroPorId(id);
        if (libroExistente.isPresent()) {
            Libro libroActualizado = libroExistente.get();
            libroActualizado.setTitulo(libroDTO.getTitulo());
            libroActualizado.setDescripcion(libroDTO.getDescripcion());
            libroActualizado.setFechaPublicacion(libroDTO.getFechaPublicacion());
    
            // Cargar autores desde la base de datos
            List<Autor> autores = libroDTO.getAutoresIds().stream()
                .map((Long autorId) -> autorRepository.findById(autorId)
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + autorId)))
                .collect(Collectors.toList());
    
            libroActualizado.setAutores(autores);
    
            return ResponseEntity.ok(libroService.registrarLibro(libroActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
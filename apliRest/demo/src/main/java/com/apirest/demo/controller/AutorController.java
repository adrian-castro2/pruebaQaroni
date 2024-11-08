package com.apirest.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.apirest.demo.dto.AutorDTO;
import com.apirest.demo.dto.AutorWithBooksDTO;
import com.apirest.demo.model.Autor;
import com.apirest.demo.service.AutorService;

@RestController
@RequestMapping("/api/autores")
@PreAuthorize("denyAll()")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'LIBRARIAN')")
    @PostMapping("/registrar")
    public ResponseEntity<Autor> registrarAutor(@RequestBody AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setBiografia(autorDTO.getBiografia());
        return ResponseEntity.ok(autorService.registrarAutor(autor));
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN', 'LIBRARIAN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Autor> editarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        Optional<Autor> autorExistente = autorService.obtenerAutorPorId(id);
        if (autorExistente.isPresent()) {
            Autor autorActualizado = autorExistente.get();
            autorActualizado.setNombre(autorDTO.getNombre());
            autorActualizado.setBiografia(autorDTO.getBiografia());
            return ResponseEntity.ok(autorService.actualizarAutor(autorActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Autor> obtenerTodosLosAutores() {
        return autorService.obtenerTodosLosAutores();
    }

  
    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<AutorWithBooksDTO> obtenerAutorPorId(@PathVariable Long id) {
        Optional<AutorWithBooksDTO> autor = autorService.obtenerAutorConLibrosPorId(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

  
    

}
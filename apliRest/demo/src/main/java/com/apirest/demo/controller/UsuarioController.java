package com.apirest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.model.Usuario;
import com.apirest.demo.dto.UsuarioDTO;
import com.apirest.demo.service.UsuarioService;

;

@RestController
@RequestMapping("/api/usuarios")
@PreAuthorize("permitAll()")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }

    @GetMapping("/obtener-usuarios")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        System.out.println("llega a intentar");
        return usuarioService.obtenerTodosLosUsuarios();
    }
}

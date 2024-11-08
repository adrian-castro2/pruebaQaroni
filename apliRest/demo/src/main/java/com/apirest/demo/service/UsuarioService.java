package com.apirest.demo.service;




import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.demo.model.Usuario;
import com.apirest.demo.repository.UsuarioRepository;
import com.apirest.demo.dto.UsuarioDTO;


@Service
public class UsuarioService implements  UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public UsuarioDTO registrarUsuario(Usuario usuario) {
        
  
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        
        // En caso de que se quiera enviar a algun otro correo comentar
        if(usuario.getCorreo().equals("nombreqaroniapellidosqaroni@gmail.com")){
            enviarCorreoBienvenida(nuevoUsuario);
        }
        return convertirADTO(nuevoUsuario);
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .correo(usuario.getCorreo())
                .nombreCompleto(usuario.getNombreCompleto())
                .roleEnum(usuario.getRoleEnum().name())
                .build();
    }

    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return usuarioOptional.get();
    }


    private void enviarCorreoBienvenida(Usuario usuario) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(usuario.getCorreo());
        message.setSubject("Bienvenido a nuestra aplicación");
        message.setText("Hola " + usuario.getNombreCompleto() + ",\n\n¡Bienvenido a nuestra aplicación!");

        mailSender.send(message);
    }
    
}
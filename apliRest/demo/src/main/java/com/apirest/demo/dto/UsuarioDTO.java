package com.apirest.demo.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String username;
    private String correo;
    private String nombreCompleto;
    private String roleEnum;
}

package com.apirest.demo.dto;

import java.time.LocalDate;
import java.util.List;

// DTO para Libro
public class LibroDTO {
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private List<Long> autoresIds;

    // Getters y Setters
    

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return LocalDate return the fechaPublicacion
     */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return List<Long> return the autoresIds
     */
    public List<Long> getAutoresIds() {
        return autoresIds;
    }

    /**
     * @param autoresIds the autoresIds to set
     */
    public void setAutoresIds(List<Long> autoresIds) {
        this.autoresIds = autoresIds;
    }

}
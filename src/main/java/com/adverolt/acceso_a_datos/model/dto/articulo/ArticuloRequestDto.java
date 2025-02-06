package com.adverolt.acceso_a_datos.model.dto.articulo;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ArticuloRequestDto {
    @NotNull
    private Integer id;

    @NotEmpty
    private String titulo;

    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres.")
    private String descripcion;

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;

    @NotNull
    private Integer idUsuario;

    // CONSTRUCTORES
    public ArticuloRequestDto() {
    }
    public ArticuloRequestDto(Integer id, String titulo, String descripcion, Integer idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();
        this.idUsuario = idUsuario;
    }

    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}

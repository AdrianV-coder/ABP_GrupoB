package com.adverolt.acceso_a_datos.model.dto.articulo;

import java.time.LocalDate;

public class ArticuloResponseDto {
    private String titulo;
    private String descripcion;

    // CONSTRUCTORES
    public ArticuloResponseDto() {
    }
    public ArticuloResponseDto(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS
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
}

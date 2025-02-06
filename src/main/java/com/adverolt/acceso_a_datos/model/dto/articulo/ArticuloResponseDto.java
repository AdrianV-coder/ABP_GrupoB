package com.adverolt.acceso_a_datos.model.dto.articulo;

public class ArticuloResponseDto {
    private Integer id;
    private String titulo;
    private String descripcion;

    // CONSTRUCTORES
    public ArticuloResponseDto() {
    }
    public ArticuloResponseDto(Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
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
}

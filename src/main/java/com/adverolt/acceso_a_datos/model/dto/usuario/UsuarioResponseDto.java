package com.adverolt.acceso_a_datos.model.dto.usuario;

public class UsuarioResponseDto {
    private String nombre;
    private String apellidos;
    private String correo;
    private double longitud;
    private double latitud;

    // CONSTRUCTORES
    public UsuarioResponseDto() {
    }
    public UsuarioResponseDto(String nombre, String apellidos, String correo, double longitud, double latitud) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}

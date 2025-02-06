package com.adverolt.acceso_a_datos.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private double latitud;

    // CONSTRUCTORES
    public Usuario() {
    }
    public Usuario(String nombre, String apellidos, String correo, String contrasena, double longitud, double latitud) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

/*@Embeddable // MARCA LA CLASE PARA QUE SE PUEDA USAR DENTRO DE OTRA ENTIDAD
class Ubicacion {
    private double longitud;
    private double latitud;

    // CONSTRUCTORES
    public Ubicacion() {
    }
    public Ubicacion(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    // GETTERS Y SETTERS
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
}*/

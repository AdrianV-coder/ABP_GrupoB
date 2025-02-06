package com.adverolt.acceso_a_datos.service;

import com.adverolt.acceso_a_datos.model.Articulo;
import com.adverolt.acceso_a_datos.model.Usuario;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloRequestDto;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioRequestDto;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioResponseDto;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDto> listar();
    UsuarioResponseDto listarPorId(Integer id);
    Usuario registrar(UsuarioRequestDto usuarioDto);
    Usuario modificar(Integer id, UsuarioRequestDto usuarioDto);
    void eliminar(Integer id) throws Exception;
    Boolean comprobarUsuario(String email, String contrasenya) throws Exception;
    //Métodos espefíficos de esta entidad
}

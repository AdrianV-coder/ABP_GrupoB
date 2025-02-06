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
    UsuarioRequestDto registrar(UsuarioResponseDto articulodto);
    UsuarioResponseDto modificar(Integer id, UsuarioRequestDto hotel);
    void eliminar(Integer id);

    //Métodos espefíficos de esta entidad
}

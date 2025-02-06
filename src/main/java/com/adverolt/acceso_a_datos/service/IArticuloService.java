package com.adverolt.acceso_a_datos.service;

import com.adverolt.acceso_a_datos.model.Articulo;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloRequestDto;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloResponseDto;

import java.util.List;

public interface IArticuloService {
    List<ArticuloResponseDto> listar();
    ArticuloResponseDto listarPorId(Integer id);
    ArticuloRequestDto registrar(ArticuloResponseDto articulo) throws Exception;
    Articulo modificar(ArticuloResponseDto articulo);
    void eliminar(Integer id);

    //Métodos espefíficos de esta entidad
}

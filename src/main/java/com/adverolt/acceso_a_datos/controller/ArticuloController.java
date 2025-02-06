package com.adverolt.acceso_a_datos.controller;

import com.adverolt.acceso_a_datos.model.Articulo;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloRequestDto;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloResponseDto;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioResponseDto;
import com.adverolt.acceso_a_datos.service.IArticuloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private IArticuloService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ArticuloResponseDto>> listar() {
        List<ArticuloResponseDto> articulos = service.listar()
                .stream()
                .map(habitacion -> modelMapper.map(habitacion, ArticuloResponseDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(articulos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloResponseDto> listarPorId(@PathVariable("id") Integer id){
        ArticuloResponseDto articulo = service.listarPorId(id);

        if (articulo == null) {
            // Código 404 No encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Código 200 OK para select
        return new ResponseEntity<>(articulo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticuloRequestDto> registrar(@RequestBody ArticuloResponseDto dto) throws Exception {
        return new ResponseEntity<>(service.registrar(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> modificar(@PathVariable("id") Integer id, @RequestBody ArticuloResponseDto articulo) {
        return new ResponseEntity<>(service.modificar(articulo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);

        // Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ////////////////////////////////////////
    /// Métods espefícos de esta entidad ///
    ////////////////////////////////////////
}

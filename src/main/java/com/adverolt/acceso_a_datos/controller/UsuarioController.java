package com.adverolt.acceso_a_datos.controller;

import com.adverolt.acceso_a_datos.model.Usuario;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioRequestDto;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioResponseDto;
import com.adverolt.acceso_a_datos.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        List<UsuarioResponseDto> hoteles = service.listar()
                .stream()
                .map(hotel -> modelMapper.map(hotel, UsuarioResponseDto.class))
                .collect(Collectors.toList());

        // Código 200 OK para select
        return new ResponseEntity<>(hoteles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> listarPorId(@PathVariable("id") Integer id){
        UsuarioResponseDto usuario = service.listarPorId(id);

        if (usuario == null) {
            // Código 404 No encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Código 200 OK para select
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioRequestDto> registrar(@RequestBody UsuarioResponseDto usuario) {
        // Código 200 OK para select
        return new ResponseEntity<>(service.registrar(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> modificar(@PathVariable Integer id, @RequestBody UsuarioRequestDto usuario) {
        // Código 200 OK para select
        return new ResponseEntity<>(service.modificar(id, usuario), HttpStatus.OK);
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

package com.adverolt.acceso_a_datos.service;

import com.adverolt.acceso_a_datos.model.Articulo;
import com.adverolt.acceso_a_datos.model.Usuario;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloRequestDto;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloResponseDto;
import com.adverolt.acceso_a_datos.repository.IArticuloRepository;
import com.adverolt.acceso_a_datos.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticuloServiceImpl implements IArticuloService {

    @Autowired
    private IArticuloRepository repository;

    @Autowired
    private IUsuarioRepository repoUsu;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ArticuloResponseDto> listar() {
        return repository.findAll().stream()
                .map(articulo -> modelMapper.map(articulo, ArticuloResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ArticuloResponseDto listarPorId(Integer id) {
        return repository.findById(id)
                .map(articulo -> modelMapper.map(articulo, ArticuloResponseDto.class))
                .orElse(null);
    }

    @Override
    @Transactional
    public Articulo registrar(ArticuloRequestDto articulodto) throws Exception {
        Usuario usuario = repoUsu.findById(articulodto.getIdUsuario())
                .orElseThrow(() -> new Exception("El usuario con ID " + articulodto.getIdUsuario() + " no existe."));

        Articulo articulo = modelMapper.map(articulodto, Articulo.class);
        articulo.setUsuario(usuario);

        return repository.save(articulo);
    }

    @Override
    @Transactional
    public Articulo modificar(Integer id, ArticuloRequestDto articuloDto) throws Exception {
        Articulo articuloExistente = repository.findById(id)
                .orElseThrow(() -> new Exception("El artículo con ID " + id + " no existe."));

        // Mantener el ID y el usuario original
        articuloExistente.setTitulo(articuloDto.getTitulo());
        articuloExistente.setDescripcion(articuloDto.getDescripcion());
        articuloExistente.setFechaCreacion(articuloDto.getFechaCreacion());

        return repository.save(articuloExistente);
    }


    @Override
    @Transactional
    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}

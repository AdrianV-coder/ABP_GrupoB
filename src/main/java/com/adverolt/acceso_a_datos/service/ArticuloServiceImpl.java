package com.adverolt.acceso_a_datos.service;

import com.adverolt.acceso_a_datos.model.Articulo;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloRequestDto;
import com.adverolt.acceso_a_datos.model.dto.articulo.ArticuloResponseDto;
import com.adverolt.acceso_a_datos.repository.IArticuloRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticuloServiceImpl implements IArticuloService{
    @Autowired
    private IArticuloRepository repository;

    @Autowired
    private IUsuarioService articuloService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ArticuloResponseDto> listar() {
        return repository.findAll().stream()
                .map(habitacion -> modelMapper.map(habitacion, ArticuloResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ArticuloResponseDto listarPorId(Integer id) {
        Optional<Articulo> articulo = repository.findById(id);

        return articulo.map(value -> modelMapper.map(value, ArticuloResponseDto.class))
                .orElse(null);
    }

    @Override
    public ArticuloRequestDto registrar(ArticuloRequestDto articulodto) throws Exception{
        if (articuloService.listarPorId(articulodto.getIdUsuario()) == null) {
            throw new Exception("El hotel con el ID " + articulodto.getIdUsuario() + " no existe.");
        }

        Articulo articulo = modelMapper.map(articulodto, Articulo.class);
        articulo.setUsuario(modelMapper.map(articuloService.listarPorId(articulodto.getIdUsuario()), Articulo.class).getUsuario());

        return modelMapper.map(repository.save(articulo), ArticuloRequestDto.class);
    }

    @Override
    public ArticuloResponseDto modificar(Integer id, ArticuloRequestDto articulodto) {
        Optional<Articulo> optionalHabitacion = repository.findById(id);
        if (optionalHabitacion.isPresent()) {
            Articulo articulo = optionalHabitacion.get();
            modelMapper.map(articulodto, articulo);
            articulo.setUsuario(modelMapper.map(articuloService.listarPorId(articulodto.getIdUsuario()), Articulo.class).getUsuario());
            return modelMapper.map(repository.save(articulo), ArticuloResponseDto.class);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

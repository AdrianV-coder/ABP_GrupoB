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
    public ArticuloRequestDto registrar(ArticuloResponseDto articulodto) throws Exception{
        if (articuloService.listarPorId(articulodto.getId()) == null) {
            throw new Exception("El hotel con el ID " + articulodto.getId() + " no existe.");
        }

        Articulo articulo = modelMapper.map(articulodto, Articulo.class);
        articulo.setUsuario(modelMapper.map(articuloService.listarPorId(articulodto.getId()), Articulo.class).getUsuario());

        return modelMapper.map(repository.save(articulo), ArticuloRequestDto.class);
    }

    @Override
    public Articulo modificar(ArticuloResponseDto articuloMod) {
        Optional<Articulo> optionalArticulo = repository.findById(articuloMod.getId());
        if (optionalArticulo.isPresent()) {
            Articulo articulo = optionalArticulo.get();
            return modelMapper.map(repository.save(articulo), Articulo.class);
        }
        return null;
    }



    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

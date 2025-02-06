package com.adverolt.acceso_a_datos.service;

import com.adverolt.acceso_a_datos.model.Usuario;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioRequestDto;
import com.adverolt.acceso_a_datos.model.dto.usuario.UsuarioResponseDto;
import com.adverolt.acceso_a_datos.repository.IUsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioResponseDto> listar() {
        return repository.findAll().stream()
                .map(habitacion -> modelMapper.map(habitacion, UsuarioResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDto listarPorId(Integer id) {
        Optional<Usuario> articulo = repository.findById(id);

        return articulo.map(value -> modelMapper.map(value, UsuarioResponseDto.class))
                .orElse(null);
    }

    @Override
    public UsuarioRequestDto registrar(UsuarioResponseDto usuariodto) {
        Usuario hotel = modelMapper.map(usuariodto, Usuario.class);
        hotel = repository.save(hotel);

        return modelMapper.map(hotel, UsuarioRequestDto.class);
    }

    @Override
    public UsuarioResponseDto modificar(Integer id, UsuarioRequestDto usuariodto) {
        Optional<Usuario> optionalHotel = repository.findById(id);

        if (optionalHotel.isPresent()) {
            Usuario usuario = optionalHotel.get();
            modelMapper.map(usuariodto, usuario);

            return modelMapper.map(repository.save(usuario), UsuarioResponseDto.class);
        }

        return null;
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

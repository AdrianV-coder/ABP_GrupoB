package com.adverolt.acceso_a_datos.repository;

import com.adverolt.acceso_a_datos.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Métodos específicos de esta entidad diferentes al CRUD
}

package com.adverolt.acceso_a_datos.repository;

import com.adverolt.acceso_a_datos.model.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo, Integer> {
    // Métodos específicos de esta entidad diferentes al CRUD
}

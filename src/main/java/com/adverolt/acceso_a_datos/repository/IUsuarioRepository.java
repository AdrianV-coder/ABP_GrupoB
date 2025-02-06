package com.adverolt.acceso_a_datos.repository;

import com.adverolt.acceso_a_datos.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Métodos específicos de esta entidad diferentes al CRUD

    //metodo que retorne bool si existe el correo del usuario em la base de datos
    @Query("FROM Usuario u WHERE u.correo LIKE :correo AND u.contrasena LIKE :contrasena")
    Usuario findByEmailAndPassword(@Param("correo") String correo, @Param("contrasena") String contrasena);

    @Query("FROM Usuario u WHERE u.correo LIKE :correo")
    Usuario findByEmail(@Param("correo") String correo);
}

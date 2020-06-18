package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entities.Usuario;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer> {
 Usuario findByUsuario(String usuario);
}

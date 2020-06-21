package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.franam.domain.Usuario;


public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}


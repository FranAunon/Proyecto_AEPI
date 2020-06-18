package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.franam.domain.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}

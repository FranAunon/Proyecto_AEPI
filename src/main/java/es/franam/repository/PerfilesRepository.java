package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.franam.domain.Perfil;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {

}

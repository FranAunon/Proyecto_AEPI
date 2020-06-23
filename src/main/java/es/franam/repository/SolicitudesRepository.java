package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.franam.domain.Solicitud;


public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}

package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.franam.domain.Editorial;


public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	
}

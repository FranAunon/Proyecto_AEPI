package es.franam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.franam.domain.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	
}

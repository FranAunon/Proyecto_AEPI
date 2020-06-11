package es.franam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findAllByName(String name);
}

package es.franam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.franam.domain.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findAllByName(String name);
}

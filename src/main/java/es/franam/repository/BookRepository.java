package es.franam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.franam.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findAllByTitle(String title);
	List<Book> findByDestacado(Integer destacado);
	
}

package es.franam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByName(String name);
}

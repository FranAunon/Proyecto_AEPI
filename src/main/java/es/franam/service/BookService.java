package es.franam.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.franam.domain.Book;
import es.franam.repository.BookRepository;

@Service
public class BookService {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAllBooks() {
		log.info("Buscando todos los libros");
		return this.bookRepository.findAll();
	}

	public void saveBook(Book book) {
		this.bookRepository.save(book);
		log.info("Libro guardado: " + book);
	}

	public void deleteBook(Long id) throws Exception {
		log.info("Buscando libro por id");
		Optional<Book> book = this.bookRepository.findById(id);
		if (book.isPresent()) {
			log.info("Libro encontrado por id");
			this.bookRepository.deleteById(id);
			log.info("Libro borrado por id");
		} else {
			throw new Exception();
		}
	}
	
	public void editBook(Long id) {
		
	}
}

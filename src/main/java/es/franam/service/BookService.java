package es.franam.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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

	private List<Book> lista = null;

	public BookService() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Book>();
		// Creamos libro 1.
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Spring");
		book1.setAuthor("Miguel");
		book1.setEditorial("Anaya");
		book1.setISBN("11111");
		book1.setPrice(20.45);
		book1.setPublishedDate(new Date());
		book1.setImagen("empresa1.png");
		book1.setDestacado(0);
		
					
		// Creamos libro 1.
					Book book2 = new Book();
					book2.setId(1);
					book2.setTitle("Spring");
					book2.setAuthor("Miguel");
					book2.setEditorial("Anaya");
					book2.setISBN("11111");
					book2.setPrice(20.45);
					book2.setPublishedDate(new Date());
					book2.setImagen("empresa2.png");
					book2.setDestacado(1);
		
					
					// Creamos libro 1.
					Book book3 = new Book();
					book3.setId(1);
					book3.setTitle("Spring");
					book3.setAuthor("Miguel");
					book3.setEditorial("Anaya");
					book3.setISBN("11111");
					book3.setPrice(20.45);
					book3.setPublishedDate(new Date());
					book3.setImagen("empresa3.png");
					book3.setDestacado(1);
					
					// Creamos libro 1.
					Book book4 = new Book();
					book4.setId(1);
					book4.setTitle("Spring");
					book4.setAuthor("Miguel");
					book4.setEditorial("Anaya");
					book4.setISBN("11111");
					book4.setPrice(20.45);
					book4.setPublishedDate(new Date());
					
					book4.setDestacado(1);
		/**
		 * Agregamos los 4 objetos de tipo Vacante a la lista ...
		 */
		lista.add(book1);			
		lista.add(book2);
		lista.add(book3);
		lista.add(book4);
		
	}

	public List<Book> buscarTodas() {
		return lista;
	}

	public Book buscarPorId(Integer idVacante) {

		for (Book b : lista) {
			if (b.getId() == idVacante) {
				return b;
			}
		}

		return null;
	}
}

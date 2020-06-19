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
import es.franam.domain.Editorial;
import es.franam.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {

	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> buscarTodos() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		 Optional<Book> optional= bookRepository.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 
		 return null;
	}

	@Override
	public void guardar(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	/*
	 * private List<Book> lista = null;
	 * 
	 * public BookServiceImpl() { SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd-MM-yyyy"); lista = new LinkedList<Book>(); // Creamos
	 * libro 1. Book book1 = new Book(); Editorial e1=new Editorial(); e1.setId(1);
	 * e1.setName("Anaya"); e1.setAddress("Almazara"); book1.setId(1);
	 * book1.setTitle("Spring"); book1.setAuthor("Miguel"); book1.setEditorial(e1);
	 * book1.setISBN("11111"); book1.setPrice(20.45); book1.setPublishedDate(new
	 * Date()); book1.setImagen("empresa1.png"); book1.setDestacado(0);
	 * 
	 * 
	 * // Creamos libro 1. Book book2 = new Book(); Editorial e2=new Editorial();
	 * e2.setId(2); e2.setName("Anaya2"); e2.setAddress("Almazara2");
	 * book2.setId(1); book2.setTitle("Spring"); book2.setAuthor("Miguel");
	 * book2.setEditorial(e2); book2.setISBN("11111"); book2.setPrice(20.45);
	 * book2.setPublishedDate(new Date()); book2.setImagen("empresa2.png");
	 * book2.setDestacado(1);
	 * 
	 * 
	 * // Creamos libro 1. Book book3 = new Book(); Editorial e3=new Editorial();
	 * e3.setId(3); e3.setName("Anaya3"); e3.setAddress("Almazara3");
	 * book3.setId(1); book3.setTitle("Spring"); book3.setAuthor("Miguel");
	 * book3.setEditorial(e3); book3.setISBN("11111"); book3.setPrice(20.45);
	 * book3.setPublishedDate(new Date()); book3.setImagen("empresa3.png");
	 * book3.setDestacado(1);
	 * 
	 * // Creamos libro 1. Book book4 = new Book(); Editorial e4=new Editorial();
	 * e2.setId(4); e2.setName("Anaya4"); e2.setAddress("Almazara4");
	 * book4.setId(4); book4.setTitle("Spring"); book4.setAuthor("Miguel");
	 * book4.setEditorial(e4); book4.setISBN("11111"); book4.setPrice(20.45);
	 * book4.setPublishedDate(new Date());
	 * 
	 * book4.setDestacado(1);
	 *//**
		 * Agregamos los 4 objetos de tipo Vacante a la lista ...
		 *//*
			 * lista.add(book1); lista.add(book2); lista.add(book3); lista.add(book4);
			 * 
			 * }
			 * 
			 * @Override public List<Book> buscarTodos() { return lista; }
			 * 
			 * @Override public Book buscarPorId(Integer idVacante) {
			 * 
			 * for (Book b : lista) { if (b.getId() == idVacante) { return b; } }
			 * 
			 * return null; }
			 * 
			 * 
			 * 
			 * 
			 * @Override public void guardar(Book book) { lista.add(book);
			 * 
			 * }
			 */
}

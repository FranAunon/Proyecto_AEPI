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

	@Override
	public List<Book> buscarStock() {
		// TODO Auto-generated method stub
		return bookRepository.findByDestacado(1);
	}

	@Override
	public void eliminar(Integer idBook) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(idBook);
	}

	
	
}

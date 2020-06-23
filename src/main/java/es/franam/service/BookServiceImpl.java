package es.franam.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.franam.domain.Book;
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

	@Override
	public List<Book> buscarByExample(Example<Book> example) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(example);
	}

	@Override
	public Page<Book> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(page);
	}


	
	
}

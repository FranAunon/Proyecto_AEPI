package es.franam.service;

import java.util.List;

import org.springframework.data.domain.Example;

import es.franam.domain.Book;

public interface IBookService {
	
	List<Book> buscarTodos();
	Book buscarPorId(Integer id);
	void guardar(Book book);
	List<Book> buscarStock();
	void eliminar(Integer idBook);
	List<Book> buscarByExample(Example<Book> example);
	
}

package es.franam.service;

import java.util.List;

import es.franam.domain.Book;

public interface IBookService {
	
	List<Book> buscarTodos();
	Book buscarPorId(Integer id);
	void guardar(Book book);
	List<Book> buscarStock();
}

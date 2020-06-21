package es.franam.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import es.franam.domain.Editorial;


public interface IEditorialService {
	void guardar(Editorial editorial);
	List<Editorial> buscarTodas();
	Editorial buscarPorId(Integer idCategoria);
	void eliminar(Integer idEditorial);	
	Page<Editorial> buscarTodos(Pageable page);
}
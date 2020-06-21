package es.franam.service;

import java.util.List;


import es.franam.domain.Editorial;


public interface IEditorialService {
	void guardar(Editorial editorial);
	List<Editorial> buscarTodas();
	Editorial buscarPorId(Integer idCategoria);
	void eliminar(Integer idEditorial);	
}
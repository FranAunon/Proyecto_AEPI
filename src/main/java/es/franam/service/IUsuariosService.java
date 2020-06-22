package es.franam.service;

import java.util.List;

import es.franam.domain.Usuario;


public interface IUsuariosService {


	void guardar(Usuario usuario);
	
	void eliminar(Integer idUsuario);
	
	
	List<Usuario> buscarTodos();
}



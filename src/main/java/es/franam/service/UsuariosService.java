package es.franam.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.franam.domain.Usuario;
import es.franam.repository.UsuariosRepository;

@Service
public class UsuariosService implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	public List<Usuario> buscarTodos() {
		return usuariosRepo.findAll();
	}

}

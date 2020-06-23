package es.franam.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Usuario buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return usuariosRepo.findByUsername(username);
	}

	@Override
	public List<Usuario> buscarRegistrados() {
		return usuariosRepo.findByFechaRegistroNotNull();

	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public int bloquear(int idUsuario) {
		int rows = usuariosRepo.lock(idUsuario);
		return rows;
	}

	@Override
	public int activar(int idUsuario) {
		int rows = usuariosRepo.unlock(idUsuario);
		return rows;
	}

}

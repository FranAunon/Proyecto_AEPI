package es.franam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.franam.domain.Editorial;
import es.franam.repository.EditorialRepository;


@Service
public class EditorialServiceImpl implements IEditorialService {
	
	@Autowired
	private EditorialRepository editorialRepository;
	
	@Override
	public void guardar(Editorial editorial) {
		editorialRepository.save(editorial);
		
	}

	@Override
	public List<Editorial> buscarTodas() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

	@Override
	public Editorial buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		 Optional<Editorial> optional= editorialRepository.findById(idCategoria);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 
		 return null;
	}
	
	
	@Override
	public void eliminar(Integer idEditorial) {
		editorialRepository.deleteById(idEditorial);
	}

	@Override
	public Page<Editorial> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return editorialRepository.findAll(page);
	}


}

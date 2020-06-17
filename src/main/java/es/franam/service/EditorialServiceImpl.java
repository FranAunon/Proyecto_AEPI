package es.franam.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import es.franam.domain.Book;
import es.franam.domain.Editorial;


@Service
public class EditorialServiceImpl implements IEditorialService{

	private List<Editorial> lista = null;
	
	public EditorialServiceImpl() {
		lista = new LinkedList<Editorial>();
		
		Editorial e1 = new Editorial();
		e1.setId(1);
		e1.setName("Anaya");
		e1.setAddress("Madrid");
		
		Editorial e2 = new Editorial();
		e2.setId(2);
		e2.setName("Eni");
		e2.setAddress("Madrid");
		
		
		Editorial e3 = new Editorial();
		e3.setId(3);
		e3.setName("Planeta");
		e3.setAddress("Barcelona");
		
	
		Editorial e4 = new Editorial();
		e4.setId(4);
		e4.setName("Ra-ma");
		e4.setAddress("Madrid");
		
		
		
		/**
		 * Agregamos los 5 objetos de tipo Categoria a la lista ...
		 */
		lista.add(e1);			
		lista.add(e2);
		lista.add(e3);
		lista.add(e4);
		
	}
	
	public void guardar(Editorial editorial) {		
		lista.add(editorial);
	}

	public List<Editorial> buscarTodas() {
		return lista;
	}

	public Editorial buscarPorId(Integer idEditorial) {			
		for (Editorial ed : lista) {
			if (ed.getId()==idEditorial) {
				return ed;
			}
		}		
		return null;	
	}

}

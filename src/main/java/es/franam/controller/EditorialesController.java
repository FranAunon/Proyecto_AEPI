package es.franam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.franam.domain.Book;
import es.franam.domain.Editorial;
import es.franam.service.IEditorialService;

@Controller
@RequestMapping(value="/editoriales")
public class EditorialesController {
	
	@Autowired
   	private IEditorialService editorialService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Editorial> editoriales = editorialService.buscarTodas();
    	model.addAttribute("editoriales", editoriales);
		return "editoriales/listEditoriales";		
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Editorial editorial) {
		return "editoriales/formEditorial";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Editorial editorial, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "editoriales/formEditorial";
		}	
		
		
		System.out.println(editorial);
		editorialService.guardar(editorial);
		attributes.addFlashAttribute("msg", "Los datos de la categoría fueron guardados!");		
		return "redirect:/editoriales/indexPaginate";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idEditorial, Model model) {		
		Editorial editorial = editorialService.buscarPorId(idEditorial);			
		model.addAttribute("editorial", editorial);
		return "editoriales/formEditorial";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idEditorial, RedirectAttributes attributes) {		
		
		editorialService.eliminar(idEditorial);			
		attributes.addFlashAttribute("msg", "La editorial fue eliminada!.");
		return "redirect:/editoriales/indexPaginate";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Editorial>lista = editorialService.buscarTodos(page);
		model.addAttribute("editoriales", lista);
		return "editoriales/listEditoriales";
	}
}

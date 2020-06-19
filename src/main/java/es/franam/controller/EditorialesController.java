package es.franam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		// Guadamos el objeto categoria en la bd
		System.out.println(editorial);
		editorialService.guardar(editorial);
		attributes.addFlashAttribute("msg", "Los datos de la categoría fueron guardados!");		
		return "redirect:/editoriales/index";
	}
	
}

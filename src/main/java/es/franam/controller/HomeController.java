package es.franam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.franam.domain.Book;
import es.franam.domain.Editorial;
import es.franam.service.IBookService;
import es.franam.service.IEditorialService;

@Controller
public class HomeController {

	

	@Autowired
	private IEditorialService editorialService;
	
	@Autowired
	private IBookService bookService;
	

	@GetMapping("/")
	public String showHome(Model model) {
//		List<Book> books = bookService.buscarTodos();
//		model.addAttribute("books", books);
		return "home";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("books", bookService.buscarStock());
	}
	
	@GetMapping("/tabla")
	public String showTable(Model model) {
		List<es.franam.domain.Book> books = bookService.buscarTodos();
		model.addAttribute("books", books);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Book book = new Book();
		
		return "detalle";
	}
	

}

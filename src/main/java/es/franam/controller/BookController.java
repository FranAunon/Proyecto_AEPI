package es.franam.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.franam.domain.Book;
import es.franam.service.BookService;
import es.franam.service.IBookService;

@Controller
@RequestMapping(path = "/")
public class BookController {

	@Autowired
	private IBookService bookService;

	@GetMapping("/tabla")
	public String showTable(Model model) {
		List<es.franam.domain.Book> books = bookService.buscarTodos();
		model.addAttribute("books", books);
		return "tabla";
	}

	@GetMapping("/")
	public String showHome(Model model) {
		List<Book> books = bookService.buscarTodos();
		model.addAttribute("books", books);
		return "home";
	}
	
	@GetMapping("books/index")
	public String mostrarIndex(Model model) {
		List<Book> books = bookService.buscarTodos();
    	model.addAttribute("books", books);
		return "listBooks";
	}

	@GetMapping("/books/view/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		Book book = bookService.buscarPorId(id);
		System.out.println("Book: " + book);
		model.addAttribute("book", book);

		return "detalle";
	}

	@GetMapping("/books/create")
	public String crear(Book book,Model model) {
		model.addAttribute("books", bookService.buscarTodos() );
		return "formBook";
	}

	@PostMapping("/books/save")
	public String guardar(Book book, BindingResult result) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			}
			return"formBook";
		}
		
		bookService.guardar(book);
		System.out.println("Book: "+book);
		
		return "listBooks";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}


}

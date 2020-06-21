package es.franam.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.franam.domain.Book;
import es.franam.service.IBookService;
import es.franam.service.IEditorialService;
import es.franam.util.Utilidades;

@Controller
@RequestMapping(path = "/books")
public class BookController {
	
	@Value("${proyecto_AEPI.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IEditorialService editorialesService;

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Book> books
		= bookService.buscarTodos();
    	model.addAttribute("books", books);
		return "books/listBooks";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		Book book = bookService.buscarPorId(id);
		System.out.println("Book: " + book);
		model.addAttribute("book", book);

		return "detalle";
	}

	@GetMapping("/create")
	public String crear(Book book,Model model) {
		
		
		return "books/formBook";
	}

	@PostMapping("/save")
	public String guardar(Book book, BindingResult result, RedirectAttributes attributes,@RequestParam("archivoImagen") MultipartFile multiPart ) {
		
		System.out.println(book);
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			}
			return"books/formBook";
		}
		
		if (!multiPart.isEmpty()) {
			
			//String ruta = "c:/libros/img-libros/"; 
			String nombreImagen = Utilidades.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
				// Procesamos la variable nombreImagen
				book.setImagen(nombreImagen);
			}
		}
		
		bookService.guardar(book);
		attributes.addFlashAttribute("msg", "Registro guardado");
		
		System.out.println(book);
		
		return "redirect:/books/indexPaginate";
	}
	
	
	
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idBook, RedirectAttributes attributes) {
		bookService.eliminar(idBook);
		attributes.addFlashAttribute("msg", "El libro fue eliminado");
		return "redirect:/books/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idBook, Model model) {
		Book book=bookService.buscarPorId(idBook);
		
		model.addAttribute("book", book);
		
		return "books/formBook";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("editoriales", editorialesService.buscarTodas() );
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Book>lista = bookService.buscarTodos(page);
		model.addAttribute("books", lista);
		return "books/listBooks";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}


}

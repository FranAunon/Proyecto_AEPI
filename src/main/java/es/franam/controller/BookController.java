package es.franam.controller;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.franam.domain.Book;
import es.franam.service.BookService;

@Controller
@RequestMapping(path = "/")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/tabla")
	public String showTable(Model model) {
		List<es.franam.domain.Book> books = bookService.buscarTodas();
		model.addAttribute("books", books);
		return "tabla";
	}

	@GetMapping("/")
	public String showHome(Model model) {
		List<Book> books = bookService.buscarTodas();
		model.addAttribute("books", books);
		return "home";
	}

	@GetMapping("/books/view/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		Book book = bookService.buscarPorId(id);
		System.out.println("Book: " + book);
		model.addAttribute("book", book);

		return "detalle";
	}

	@GetMapping({ "/book", "/book/list" })
	public String allBooks(Model model) {

		List<Book> books = bookService.findAllBooks();
		model.addAttribute("books", books);
		return "allBooks";
	}

	@GetMapping("/books/create")
	public String crear(Book book, Model model) {
		//model.addAttribute("books", bookService.buscarTodas() );
		System.out.println(book.getPrice());
		return "formBook";
	}

	@PostMapping("/save")
	public String guardar(@RequestParam("title") String title, @RequestParam("ISBN") String ISBN,
			@RequestParam("author") String author, @RequestParam("price") double price,
			@RequestParam("editorial") String editorial, @RequestParam("destacado") int destacado,
			@RequestParam("publishedDate") Date publishedDate) {
		System.out.println(price);
		return "books/listBooks";
	}

	@PutMapping("/edit/{id}")
	public String editBook(Long id, BindingResult result) {

		bookService.editBook(id);
		return "allbooks";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(Long id) {

		try {
			bookService.deleteBook(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "allBooks";
	}

}

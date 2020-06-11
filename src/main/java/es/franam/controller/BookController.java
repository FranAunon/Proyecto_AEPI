package es.franam.controller;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.franam.domain.Book;

@Controller
@RequestMapping(path = "/")
public class BookController {
	
	@GetMapping({"/book", "/book/list"})
	public String allBooks() {
		return "allBooks";
	}
	
	@PostMapping("/book/create")
	public String createBook(Book book) {
		return "allBooks";
	}
	
	@PutMapping("/edit/{id}")
	public String editBook(Long id, BindingResult result) {
		return "allbooks";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook() {
		return "allBooks";
	}
	
}

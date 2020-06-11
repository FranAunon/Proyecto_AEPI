package es.franam.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Author implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Length(min = 2, max = 30)
	@NotBlank
	private String name;

	@Length(min = 2, max = 30)
	@NotBlank
	private String surname;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	public Author() {

	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}



	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", book=" + book + "]";
	}

	

}

package es.franam.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;



@Entity
public class Author implements Serializable {
	
	@Length(max = 30)
	@NotBlank
	private String name;
	
	@Length(max = 30)
	@NotBlank
	private String surname;

	public Author() {
		
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
		return "Author [name=" + name + ", surname=" + surname + "]";
	}
	
	
	
}

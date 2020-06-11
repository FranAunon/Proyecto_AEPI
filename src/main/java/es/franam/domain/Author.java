package es.franam.domain;

import java.io.Serializable;

public class Author implements Serializable {
	
	private String name;
	
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

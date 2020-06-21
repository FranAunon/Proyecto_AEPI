package es.franam.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Version
	private Long version;

	@Length(min = 2, max = 30)
	@NotBlank
	private String title;

	@Length(min = 2, max = 30)
	@NotBlank
	//@ISBN
	private String ISBN;

	@Min(1)
	private double price;

	@Length(min = 2, max = 30)
	@NotBlank
	private String author;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date publishedDate;
	
	
	@ManyToOne
	@JoinColumn(name="idEditorial")
	private Editorial editorial;
	
	
	private String imagen="no-image.png";
	
	@NotNull
	private int destacado;
	
	@NotBlank
	private String descripcion;

	public Book() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getDestacado() {
		return destacado;
	}

	public void setDestacado(int destacado) {
		this.destacado = destacado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", version=" + version + ", title=" + title + ", ISBN=" + ISBN + ", price=" + price
				+ ", author=" + author + ", publishedDate=" + publishedDate + ", editorial=" + editorial.getName() + ", imagen="
				+ imagen + ", destacado=" + destacado + ", descripcion=" + descripcion + "]";
	}
	


	
}

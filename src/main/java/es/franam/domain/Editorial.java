package es.franam.domain;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "editoriales")
public class Editorial implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Version
	private Long version;

	@Length(min = 2, max = 30)
	private String name;

	@Length(min = 2, max = 50)
	private String address;

//	@OneToMany(mappedBy = "editorial")
//	@OrderBy("date asc, id desc")
//	Set<Book> books = new HashSet<>();

	/*
	 * @OneToOne
	 * 
	 * @MapsId private Book book;
	 */
	/*
	 * @NotNull
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "book_id", nullable = false) private Book book;
	 */

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Editorial [id=" + id + ", version=" + version + ", name=" + name + ", address=" + address + "]";
	}

	

}

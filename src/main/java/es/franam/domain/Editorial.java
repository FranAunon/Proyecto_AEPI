package es.franam.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Editorial")
public class Editorial implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Version
	private Long version;

	@Length(min = 2, max = 30)
	@NotBlank
	private String name;

	@Length(min = 2, max = 50)
	@NotBlank
	private String address;

	/*
	 * @NotNull
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "book_id", nullable = false) private Book book;
	 */
	public Editorial() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

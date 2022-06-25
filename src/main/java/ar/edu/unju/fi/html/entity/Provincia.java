package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ciudadanos")
public class Provincia {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="provincia")
	private String provincia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Provincia(Long id, String provincia) {
		super();
		this.id = id;
		this.provincia = provincia;
	}

	public Provincia() {
		super();
	}

	public Provincia(String provincia) {
		super();
		this.provincia = provincia;
	}

	


}

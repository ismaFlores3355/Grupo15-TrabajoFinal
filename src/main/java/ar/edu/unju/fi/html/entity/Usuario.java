package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Entity
@Table(name="usuariose")
@Component
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	
	@Column(name = "username")
	@NotBlank(message = "Ingrese un valor para nombre de usuario")
	private String username;
	
	@Column(name = "password")
	@NotBlank(message = "Ingrese un valor para nombre de password")	
	private String password;
	
	@Column(name = "perfil")
	@NotBlank(message = "Ingrese un valor para perfil")
	private String perfil;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}	
	
}
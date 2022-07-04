package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Entity
@Table(name="curriculums")
public class Curriculum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curri_id")
	private Long id;
	
	@Column(name="curri_apellido")
    @NotBlank(message = "El apellido no puede ser blanco")
    private String apellido;
    
	@Column(name="curri_nombre")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    
	@Column(name="curri_dni")
    @Min(value = 100000, message = "El dni debe ser mayor o igual a 100000")
    private int dni;
    
	@Column(name="curri_domicilio")
    @NotBlank(message = "El domicilio no puede ser blanco")
    private String domicilio;
   
	@Column(name="curri_contacto")
	 @Min(value = 100000, message = "El telefono debe ser mayor o igual a 100000")
    private int contacto;

	@Column(name="curri_experiencial")
	 @NotEmpty(message = "La experiencia laboral no puede estar vacia")
    private String experienciaLaboral;

	@Column(name="curri_educacion")
	 @NotEmpty(message = "La educacion no puede estar vacia")
    private String educacion;

	@Column(name="curri_idioma")
	@NotEmpty(message = "El idioma no puede estar vacio")
    private String idioma;

	@Column(name="curri_conocInf")
    private String conocimientoInformatico;
	@Column(name="curri_InfoCompl")
    private String informacionComplementaria;
	@Column(name="curri_datoAdic")
    private String datoAdicional;

    public Curriculum(){

    }

    public Curriculum(String apellido, String nombre, int dni, String domicilio, int contacto, String experienciaLaboral, String educacion, String idioma, String conocimientoInformatico, String informacionComplementaria, String datoAdicional) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.contacto = contacto;
        this.experienciaLaboral = experienciaLaboral;
        this.educacion = educacion;
        this.idioma = idioma;
        this.conocimientoInformatico = conocimientoInformatico;
        this.informacionComplementaria = informacionComplementaria;
        this.datoAdicional = datoAdicional;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getConocimientoInformatico() {
        return conocimientoInformatico;
    }

    public void setConocimientoInformatico(String conocimientoInformatico) {
        this.conocimientoInformatico = conocimientoInformatico;
    }

    public String getInformacionComplementaria() {
        return informacionComplementaria;
    }

    public void setInformacionComplementaria(String informacionComplementaria) {
        this.informacionComplementaria = informacionComplementaria;
    }

    public String getDatoAdicional() {
        return datoAdicional;
    }

    public void setDatoAdicional(String datoAdicional) {
        this.datoAdicional = datoAdicional;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", domicilio='" + domicilio + '\'' +
                ", contacto=" + contacto +
                ", experienciaLaboral='" + experienciaLaboral + '\'' +
                ", educacion='" + educacion + '\'' +
                ", idioma='" + idioma + '\'' +
                ", conocimientoInformatico='" + conocimientoInformatico + '\'' +
                ", informacionComplementaria='" + informacionComplementaria + '\'' +
                ", datoAdicional='" + datoAdicional + '\'' +
                '}';
    }
}

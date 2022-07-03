package ar.edu.unju.fi.html.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;




public interface ICiudadanoService {
	/**
	 * Agregamos un ciudadano a la fuente de datos.
	 */
	public void addCiudadano(Ciudadano ciudadano);
	
	
	
	public Ciudadano getCiudadano();
	
	public List<Ciudadano> getAllCiudadanos();
	
	public Optional<Ciudadano> getUnCiudadano(Long id);
	
	public void borrarCiudadano(Long id);
	
	
	public List<Ciudadano> getCiudadanosFiltro(String provincia);
	

}

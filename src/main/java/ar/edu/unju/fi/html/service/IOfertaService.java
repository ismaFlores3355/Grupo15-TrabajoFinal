package ar.edu.unju.fi.html.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.html.entity.OfertasLaborales;

public interface IOfertaService {
	/**
	 * Agregamos una oferta laboral a la fuente de datos.
	 */
	public void addOferta(OfertasLaborales empleado);
	

	public OfertasLaborales getOferta();
	
	public List<OfertasLaborales> getAllOfertas();
	
	public Optional<OfertasLaborales> getUnaOferta(Long id);
	
	public void borrarOferta(Long id);
	
}

package ar.edu.unju.fi.html.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.OfertasLaborales;

public interface ICursoService {
	/**
	 * Agregamos una oferta laboral a la fuente de datos.
	 */
	public void addOferta(Curso curso);
	

	public Curso getCurso();
	
	public List<Curso> getAllOcursos();
	
	public Optional<Curso> getUnCurso(Long id);
	
	public void borrarCurso(Long id);

	public List<Curso> getCursoFiltro(String categoria);
}

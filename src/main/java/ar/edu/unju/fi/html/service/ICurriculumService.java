package ar.edu.unju.fi.html.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curriculum;

public interface ICurriculumService {
	/**
	 * Agregamos un curriculum a la fuente de datos.
	 */
	
public void addCurriculum(Curriculum curriculum);
	
	
	
	public Curriculum getCurriculum();
	
	public List<Curriculum> getAllCurriculum();
	
	public Optional<Curriculum> getUnCurriculum(Long id);
	
	
	
}

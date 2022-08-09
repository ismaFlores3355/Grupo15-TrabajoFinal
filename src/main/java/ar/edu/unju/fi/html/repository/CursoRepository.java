package ar.edu.unju.fi.html.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	
	public List<Curso> findAll(); 
	public Optional<Curso> findById(Long id);
	
	public List<Curso> findByCategoriaLike(String categoria);

}

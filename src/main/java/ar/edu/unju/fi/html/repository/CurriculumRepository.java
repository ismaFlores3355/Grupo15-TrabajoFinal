package ar.edu.unju.fi.html.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.html.entity.Curriculum;

public interface CurriculumRepository extends CrudRepository<Curriculum,Long> {
	
	public List<Curriculum> findAll(); 
	public Optional<Curriculum> findById(Long id);

}

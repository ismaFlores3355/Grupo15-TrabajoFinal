package ar.edu.unju.fi.html.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.html.entity.OfertasLaborales;




public interface OfertasLRepository extends CrudRepository<OfertasLaborales, Long> {
	
	public List<OfertasLaborales> findAll(); 
	public Optional<OfertasLaborales> findById(Long id);
	
	

}

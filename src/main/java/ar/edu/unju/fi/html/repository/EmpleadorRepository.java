package ar.edu.unju.fi.html.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.html.entity.Empleador;

public interface EmpleadorRepository extends CrudRepository<Empleador, Long> {
	
	public List<Empleador> findAll(); 
	public Optional<Empleador> findById(Long id);
	public List<Empleador> findByProvinciaLike(String nombre);
	public List<Empleador> findByEmpleadorResumendelpLike(String apellido);
	
	

}

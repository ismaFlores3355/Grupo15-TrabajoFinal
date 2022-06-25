package ar.edu.unju.fi.html.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.html.entity.Ciudadano;

public interface CiudadanoRepository extends CrudRepository<Ciudadano,Long> {
	
	public List<Ciudadano> findAll(); 
	public Optional<Ciudadano> findById(Long id);
	//public List<Ciudadano> findByApellidoLike(String apellido);
	//public List<Ciudadano> findBySueldoGreaterThanEqual(double sueldo);
	public Ciudadano findByDni(int username);
	public Optional<Ciudadano> findByUsuarioUsername(String username);

}

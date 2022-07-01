package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.service.ICiudadanoService;


@Service("ciudadanoService")
public class CiudadanoServiceImp implements ICiudadanoService {

	
	@Autowired
	Ciudadano ciudadano;
	
	List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
	
	
	
	
	
	@Override
	public void addCiudadano(Ciudadano ciudadano) {
		 this.ciudadanos.add(ciudadano);
		
	}

	@Override
	public Ciudadano getCiudadano() {
		//this.ciudadano.setDni("aa");
		return this.ciudadano;
	}

	@Override
	public List<Ciudadano> getAllCiudadanos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ciudadano> getUnCiudadano(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarCiudadano(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

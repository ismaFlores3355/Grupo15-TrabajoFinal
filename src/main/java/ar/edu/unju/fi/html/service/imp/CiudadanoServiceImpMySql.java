package ar.edu.unju.fi.html.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.repository.CiudadanoRepository;
import ar.edu.unju.fi.html.service.ICiudadanoService;

@Service("ciudadanoServiceMysql")
public class CiudadanoServiceImpMySql implements ICiudadanoService {
   
	
	@Autowired
	CiudadanoRepository ciudadanoRepository;
	
	@Autowired
	Ciudadano ciudadano;
	
	
	
	
	
	@Override
	public void addCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		String pw = ciudadano.getUsuario().getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		ciudadano.getUsuario().setPassword(bCryptPasswordEncoder.encode(pw));
		ciudadanoRepository.save(ciudadano);
	}

	@Override
	public Ciudadano getCiudadano() {
		// TODO Auto-generated method stub
		return this.ciudadano;
	}

	@Override
	public List<Ciudadano> getAllCiudadanos() {
		// TODO Auto-generated method stub
		List<Ciudadano> ciudadanos = ciudadanoRepository.findAll();
		return ciudadanos;
	}

	@Override
	public Optional<Ciudadano> getUnCiudadano(Long id) {
		// TODO Auto-generated method stub
		return ciudadanoRepository.findById(id);
	}

	@Override
	public void borrarCiudadano(Long id) {
		ciudadanoRepository.deleteById(id);
		
	}

}

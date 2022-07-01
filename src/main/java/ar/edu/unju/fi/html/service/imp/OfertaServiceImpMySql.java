package ar.edu.unju.fi.html.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.repository.OfertasLRepository;
import ar.edu.unju.fi.html.service.IOfertaService;

@Service("ofertaServiceMysql")
public class OfertaServiceImpMySql implements IOfertaService {
  
	@Autowired
	OfertasLRepository ofertasrepo;
	@Autowired
	OfertasLaborales ofertal;
	
	
	
	@Override
	public void addOferta(OfertasLaborales ofertazz) {
		ofertasrepo.save(ofertazz);
		
	}

	@Override
	public OfertasLaborales getOferta() {
		// TODO Auto-generated method stub
		return this.ofertal;
	}

	@Override
	public List<OfertasLaborales> getAllOfertas() {
		// TODO Auto-generated method stub
		List<OfertasLaborales> ofertazz = ofertasrepo.findAll();
		return ofertazz;
	}

	@Override
	public Optional<OfertasLaborales> getUnaOferta(Long id) {
		// TODO Auto-generated method stub
		return ofertasrepo.findById(id);
	}

	@Override
	public void borrarOferta(Long id) {
		ofertasrepo.deleteById(id);
		
	}
	
	
	

}

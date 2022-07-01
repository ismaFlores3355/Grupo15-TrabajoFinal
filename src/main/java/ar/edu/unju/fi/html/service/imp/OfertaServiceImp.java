package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.service.IOfertaService;


@Service("ofertaServiceRam")
public class OfertaServiceImp implements IOfertaService {
    
	@Autowired
	OfertasLaborales oferta;
	
	List<OfertasLaborales> ofertas = new ArrayList<OfertasLaborales>();
	
	
	@Override
	public void addOferta(OfertasLaborales ofertazz) {
		this.ofertas.add(ofertazz);
		
	}

	@Override
	public OfertasLaborales getOferta() {
		// TODO Auto-generated method stub
		return this.oferta;
	}

	@Override
	public List<OfertasLaborales> getAllOfertas() {
		// TODO Auto-generated method stub
		return this.ofertas;
	}

	@Override
	public Optional<OfertasLaborales> getUnaOferta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarOferta(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}

package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.EmpleadorRepository;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("empleadorServiceMysql")
public class EmpleadorServiceImpMySql implements IEmpleadorService  {

	@Autowired
	EmpleadorRepository empleadorRepository;
	
	
	
	@Override
	public void addSucursal(Empleador empleador) {
		empleadorRepository.save(empleador);
		
	}

	@Override
	public List<Empleador> getEmpleadores() {
		// TODO Auto-generated method stub
		return empleadorRepository.findAll();
	}

	@Override
	public List<Empleador> getEmpleadoresFiltro(String sucursalNombre) {
		List<Empleador> empleadores = new ArrayList<Empleador>();
		//aplico el filtro si los dos parametros tiene valores o almenos algunos tiene
		sucursalNombre = "%"+sucursalNombre+"%";
		if (!sucursalNombre.isEmpty()) {
			//agrego caracteres necesarios para que funcione el like
			empleadores = this.empleadorRepository.findByProvinciaLike(sucursalNombre);
		}  
			
		return empleadores;
	}
	
	
     
	
}

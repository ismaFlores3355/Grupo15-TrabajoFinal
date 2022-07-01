package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("empleadorServiceRam")
public class EmpleadorServiceImp implements IEmpleadorService {
 
	
	List<Empleador> empleadores = new ArrayList<Empleador>();
	
	
	@Override
	public void addSucursal(Empleador empleador) {
		this.getEmpleadores().add(empleador);
		
	}

	@Override
	public List<Empleador> getEmpleadores() {
		// TODO Auto-generated method stub
		return this.empleadores;
	}

	@Override
	public List<Empleador> getEmpleadoresFiltro(String sucursalNombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

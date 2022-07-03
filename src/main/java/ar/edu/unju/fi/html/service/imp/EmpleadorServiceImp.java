package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.IEmpleadorService;

@Service("empleadorServiceRam")
public class EmpleadorServiceImp implements IEmpleadorService {
 
	
	List<Empleador> empleadores = new ArrayList<Empleador>();
	 
	@Autowired
	Empleador empleador;
	
	//estos 2 para el registro del empleador para el login
	@Override
	public Empleador getEmpleador() {
		//this.ciudadano.setDni("aa");
		return this.empleador;
	}
	
	@Override
	public void addEmpleador(Empleador empleador) {
		 this.empleadores.add(empleador);
		
	}
	
	
	
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

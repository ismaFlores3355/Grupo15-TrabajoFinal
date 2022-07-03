package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;

public interface IEmpleadorService {

	//para el registro login estos 2
	public void addEmpleador(Empleador empleador);
	public Empleador getEmpleador();
	
	public void addSucursal(Empleador empleador);
	
	public List<Empleador> getEmpleadores();
	
	public List<Empleador> getEmpleadoresFiltro(String sucursalNombre);
}

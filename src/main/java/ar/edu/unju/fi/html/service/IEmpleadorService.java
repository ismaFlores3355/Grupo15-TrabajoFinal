package ar.edu.unju.fi.html.service;

import java.util.List;

import ar.edu.unju.fi.html.entity.Empleador;

public interface IEmpleadorService {

	public void addSucursal(Empleador empleador);
	
	public List<Empleador> getEmpleadores();
	
	public List<Empleador> getEmpleadoresFiltro(String sucursalNombre);
}

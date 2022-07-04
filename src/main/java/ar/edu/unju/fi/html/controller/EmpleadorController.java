package ar.edu.unju.fi.html.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.IEmpleadorService;
import ar.edu.unju.fi.html.service.IOfertaService;




@Controller
public class EmpleadorController {
	@Autowired
	@Qualifier("ofertaServiceMysql")
	IOfertaService ofertaService;
	
	@Autowired
	@Qualifier("empleadorServiceMysql")
	IEmpleadorService empleadorService;
	@Autowired
	Empleador empleador;
	
	@GetMapping("/empleador/listar")
	public String getSucursalesPage(Model model) {
		model.addAttribute("filtrosempleadorprovincia", "");
		model.addAttribute("empleadores",  empleadorService.getEmpleadores());
		return "lista-empleador";
	}
	
	@GetMapping("/empleador/nuevo")
	public String getSucursalFormPage(Model model) {
		
		model.addAttribute("empleador", this.empleador);
		
		model.addAttribute("ofertas",  ofertaService.getAllOfertas());
		return "nuevo-empleador";
	
	}	
	
	@GetMapping("/empleador/filtrar")
	public String getSucursalFiltro(Model model,
			@RequestParam(name="filtroempleadorprovincia") String filtrosucursalnombre) {
		

		//llamar al un metodo del service pasando el parametro para que filtre las 
		//empleadores conincidentes, en el método del service puede varios if para validar cada tres situaciones
		//posibles 1) que ingrese solo filtrosucursalnombre 2) que ingrese filtroencargadoapellido 3) que ingrese
		//ambos valores
		//En todos los casos se debe retornar un List<Sucursales> lista de sucursales que coindidieron con los params
		
		List<Empleador> empleadores = this.empleadorService.getEmpleadoresFiltro(filtrosucursalnombre);
		
		
		model.addAttribute("ffiltroempleadorprovincia", filtrosucursalnombre);
		
		model.addAttribute("empleadores", empleadores);
		return "lista-empleador";
	}
	
	@GetMapping("/empleador/guardar")
	public String getEmpleadoResultPage(Model model, 
			@RequestParam(name="id") String id,
			@RequestParam(name="cuit") String cuit,
			@RequestParam(name="provincia") String provincia,
			@RequestParam(name="empleador.id") String empleadorid)
	        
	{
		
		Empleador em = new Empleador();
		
		
		em.setProvincia(provincia);
		em.setCuit(Integer.valueOf(cuit));
		em.setEmpleador(this.ofertaService.getUnaOferta(Long.valueOf(empleadorid)).orElseThrow());
		
		empleadorService.addSucursal(em);
		
		model.addAttribute("empleadores", empleadorService.getEmpleadores());
		return "lista-empleador";
	}	
}

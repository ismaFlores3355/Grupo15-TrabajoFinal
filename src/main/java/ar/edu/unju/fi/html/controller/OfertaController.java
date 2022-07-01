package ar.edu.unju.fi.html.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.service.IOfertaService;





@Controller
public class OfertaController {
	@Autowired
	@Qualifier("ofertaServiceMysql")
	IOfertaService ofertaService;
	
	@GetMapping("/oferta/nuevo")
	public String getEmpleadoFormPage(Model model) {
		model.addAttribute("oferta", ofertaService.getOferta());
		return "nueva-oferta";
	}
	
	@GetMapping("/oferta/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<OfertasLaborales> oferta = ofertaService.getUnaOferta(id);
		model.addAttribute("oferta", oferta);
		return "nueva-oferta";
	}
	
	@GetMapping("/oferta/borrar/{id}")
	public String borrar(@PathVariable Long id, Model model) {
		//implementar la llamada al service de borrar.
		
		ofertaService.borrarOferta(id);
		//vemos otra forma de redirigir a la lista de empleados
		//redirigimos hacia la ruta donde se carga la lista de empleados.
		//observe que no retornando un template sino una ruta donde se redirigira el flujo
		return "redirect:/oferta/listar";
	}	
	
	@PostMapping("/oferta/guardar")
	public String getEmpleadoResultPage(@Valid @ModelAttribute("oferta") OfertasLaborales unaOferta, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("oferta", unaOferta);
			return "nueva-oferta";
		}else {
			ofertaService.addOferta(unaOferta);
			ofertaService.addOferta(unaOferta);
			return "OfertaLaboral";			
		}
		

	}
	
	@GetMapping("/oferta/listar")
	public String getEmpleadosPage(Model model) {
		
		model.addAttribute("ofertas", ofertaService.getAllOfertas());
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
		
		return "OfertaLaboral";
	}
	
}

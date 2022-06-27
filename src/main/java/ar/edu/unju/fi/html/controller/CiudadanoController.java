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

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.service.ICiudadanoService;

@Controller
public class CiudadanoController {

	@Autowired
	@Qualifier("ciudadanoServiceMysql")
	ICiudadanoService ciudadanoService;
	
	@GetMapping("/ciudadano/nuevo")
	public String getCiudadanoFormPage(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		return "RegistroCiudadano";
	}
	
	@PostMapping("/ciudadano/guardar")
	public String getCiudadanoResultPage(@Valid @ModelAttribute("ciudadano") Ciudadano unCiudadano, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ciudadano", unCiudadano);
			return "Registro-Ciudadano";
		}else {
			ciudadanoService.addCiudadano(unCiudadano);
			return "resultado-empleado";			
		}
	}
	
	@GetMapping("/ciudadano/listar")
	public String getCiudadanosPage(Model model) {
		
		model.addAttribute("ciudadanos", ciudadanoService.getAllCiudadanos());
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
		
		return "lista-empleado";
	}

}

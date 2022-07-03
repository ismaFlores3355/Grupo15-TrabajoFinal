package ar.edu.unju.fi.html.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.service.ICiudadanoService;
import ar.edu.unju.fi.html.service.IEmpleadorService;
import ar.edu.unju.fi.html.service.IOfertaService;

@Controller
public class InicioController {
	
	@GetMapping("/home")
	public String getPageHome() {
		return "VerCV";
	}
	
	//pagina por defecto
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "index";
	}
	
	
	//login registro ciudadano
	@GetMapping("/loginciu")
	public String getPageCiudadano() {
		return "loginRegistroCiudadano";
	}
	
	//login registro empleador
			@GetMapping("/loginemp")
			public String getPageEmpleador() {
				return "loginRegistroEmpleador";
			}
	
	//login para logearse con username y password en ciudadano
	@GetMapping("/loginn")
	public String getPageeHome() {
		return "LoginCiudadano";
	}
	
	//login para logearse con username y password en empleador
		@GetMapping("/logine")
		public String getPageem() {
			return "LoginEmpleador";
		}
	
	
		
		
		
		
	//EMPLEADOR PARA PERMITIR EL ACCESOS AL REGISTRO
				
				@Autowired
				@Qualifier("empleadorServiceMysql")
				IEmpleadorService empleadorService;
				
				@GetMapping("/empleador/nuevoo")
				public String getCeFormPage(Model model) {
					model.addAttribute("empleador", empleadorService.getEmpleador());
					return "RegistroEmpleador";
				}
				
				
				@PostMapping("/empleador/guardarr")
				public String getEResultPage(@Valid @ModelAttribute("empleador") Empleador unEmpleador, BindingResult result, Model model) {
					
					if(result.hasErrors()) {
						model.addAttribute("empleador", unEmpleador);
						return "RegistroEmpleador";
					}else {
						empleadorService.addEmpleador(unEmpleador);
						return "loginRegistroEmpleador";			
					}
					

				}
				
				@GetMapping("/empleador/listarr")
				public String getEmpleadoresPage(Model model) {
					
					model.addAttribute("ciudadanos", ciudadanoService.getAllCiudadanos());
					//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
					//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
					
					return "lista-ciudadano";
				}		
		
		
		
				
		
	
	
	
	//CIUDADANO PARA PERMITIR EL ACCESO AL REGISTRO
	@Autowired
	@Qualifier("ciudadanoServiceMysql")
	ICiudadanoService ciudadanoService;
	
	@GetMapping("/ciudadano/nuevoo")
	public String getCiudadanoFormPage(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		return "RegistroCiudadano";
	}
	
	
	@PostMapping("/ciudadano/guardarr")
	public String getCiudadanoResultPage(@Valid @ModelAttribute("ciudadano") Ciudadano unCiudadano, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ciudadano", unCiudadano);
			return "RegistroCiudadano";
		}else {
			ciudadanoService.addCiudadano(unCiudadano);
			return "loginRegistroCiudadano";			
		}
		

	}
	
	@GetMapping("/ciudadano/listarr")
	public String getCiudadanosPage(Model model) {
		
		model.addAttribute("ciudadanos", ciudadanoService.getAllCiudadanos());
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
		
		return "lista-ciudadano";
	}
	
	
	
	//portal para ciudadano
			@GetMapping("/portal")
			public String getPagePortal() {
				return "InscripcionCurso";
			}
			
			//portal para empleador
					@GetMapping("/portal2")
					public String getPagePortal2() {
						return "InscripcionCurso2";
					}
		
	
	
	

}

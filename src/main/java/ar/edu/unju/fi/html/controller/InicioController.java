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
	
	
	//login registro empleador
		@GetMapping("/loginemp")
		public String getPageEmpleador() {
			return "loginRegistroEmpleador";
		}
		
		
		//nuevo empleador
				@GetMapping("/nuevoemp")
				public String getPageEmpleadorr() {
					return "nuevo-empleador";
				}
		
	//EMPLEADOR PARA PERMITIR EL ACCESOS AL REGISTRO
				
				@Autowired
				@Qualifier("ofertaServiceMysql")
				IOfertaService ofertaService;
				
				@Autowired
				@Qualifier("empleadorServiceMysql")
				IEmpleadorService empleadorService;
				@Autowired
				Empleador empleador;
				
				
				
				@GetMapping("/empleador/nuevoR")
				public String getSucursalFormPage(Model model) {
					
					model.addAttribute("empleador", this.empleador);
					
					model.addAttribute("ofertas",  ofertaService.getAllOfertas());
					return "nuevo-empleador";
				
				}	
				@GetMapping("/empleador/guardarR")
				public String getEmpleadoResultPage(Model model, 
						@RequestParam(name="id") String id,
						@RequestParam(name="cuit") String cuit,
						@RequestParam(name="provincia") String provincia,
						@RequestParam(name="empleador.id") String empleadorid) {
					
					Empleador em = new Empleador();
					
					
					em.setProvincia(provincia);
					em.setCuit(Integer.valueOf(cuit));
					em.setEmpleador(this.ofertaService.getUnaOferta(Long.valueOf(empleadorid)).orElseThrow());
					
					empleadorService.addSucursal(em);
					
					model.addAttribute("empleadores", empleadorService.getEmpleadores());
					return "LoginRegistroEmpleador";
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
	
	
	
	
	
	
	

}

package ar.edu.unju.fi.html.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ar.edu.unju.fi.html.entity.Curriculum;
import ar.edu.unju.fi.html.service.ICurriculumService;


@Controller
public class CurriculumController {
	@Autowired
	@Qualifier("curriculumServiceMysql")
	ICurriculumService curriculumService;
	
	@GetMapping("/curriculum/nuevo")
	public String getCiudadanoFormPage(Model model) {
		model.addAttribute("curriculum", curriculumService.getCurriculum());
		return "CrearCV";
	}
	
	@PostMapping("/curriculum/guardar")
	public String getCurriculumResultPage(@Valid @ModelAttribute("curriculum") Curriculum unCurriculum, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("curriculum", unCurriculum);
			return "CrearCV";
		}else {
			curriculumService.addCurriculum(unCurriculum);
			return "VerCV";			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/ciudadano/listar")
	public String getCiudadanosPage(Model model) {
		
		model.addAttribute("ciudadanos", ciudadanoService.getAllCiudadanos());
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
		
		return "lista-empleado";
	}
	*/
	
}

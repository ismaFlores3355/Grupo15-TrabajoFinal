package ar.edu.unju.fi.html.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.service.ICursoService;
import ar.edu.unju.fi.html.service.IOfertaService;







@Controller
public class CursoController {
	@Autowired
	@Qualifier("cursoServiceMysql")
	ICursoService  cursoService;
	
	@GetMapping("/curso/nuevo")
	public String getCursoFormPage(Model model) {
		model.addAttribute("curso", cursoService.getCurso());
		return "nuevo-curso";
	}
	
	@GetMapping("/curso/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Curso> curso = cursoService.getUnCurso(id);
		model.addAttribute("curso", curso);
		return "curso-descripcion";
	}
	
	@PostMapping("/curso/guardar")
	public String getEmpleadoResultPage( @ModelAttribute("curso") Curso uncurso, Model model) {
		
			cursoService.addOferta(uncurso);
			model.addAttribute("cursos",  cursoService.getAllOcursos());
			return "lista-cursosencontrados";			
		
	}
	
	@GetMapping("/curso/listar")
	public String getEmpleadosPage(Model model) {
		
		model.addAttribute("cursos",  cursoService.getAllOcursos());
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorApellido("%"+"Torres"+"%"));
		//model.addAttribute("empleados", empleadoService.getEmpleadosPorSueldo(25000));
		
		return "lista-curso";
	}
	
	
	@GetMapping("/curso/filtrar")
	public String getCursoFiltro(Model model,
			@RequestParam(name="filtrocursocategoria") String filtrocursocategoria) {
		

		//llamar al un metodo del service pasando el parametro para que filtre las 
		//empleadores conincidentes, en el método del service puede varios if para validar cada tres situaciones
		//posibles 1) que ingrese solo filtrosucursalnombre 2) que ingrese filtroencargadoapellido 3) que ingrese
		//ambos valores
		//En todos los casos se debe retornar un List<Sucursales> lista de sucursales que coindidieron con los params
		
		List<Curso> cursos = this.cursoService.getCursoFiltro(filtrocursocategoria);
		
		
		model.addAttribute("filtrocursocategoria", filtrocursocategoria);
		
		model.addAttribute("cursos", cursos);
		return "lista-cursosencontrados";
	}
	
	
	@GetMapping("/curso/des")
	public String getdescPage(Model model) {
		
		
		return "descripcion";
	}
	
	@GetMapping("/curso/lise")
	public String getdesccPage(Model model) {
		
		
		return "lista-cursosencontrados";
	}
}

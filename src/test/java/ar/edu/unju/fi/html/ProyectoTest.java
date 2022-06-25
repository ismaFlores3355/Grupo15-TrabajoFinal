package ar.edu.unju.fi.html;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Usuario;
import ar.edu.unju.fi.html.service.ICiudadanoService;




@SpringBootTest
class ProyectoTest {

	@Autowired
	@Qualifier("ciudadanoServiceMysql")
	ICiudadanoService ciudadanoService;
	
	/**
	
	@Test
	void test() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		Empleado e1 = empleadoService.getUnEmpleado(1L).orElseThrow();
		Empleado e2 = empleadoService.getUnEmpleado(2L).orElseThrow();
		empleados.add(e1);
		empleados.add(e2);
		Proyecto proyecto = new Proyecto();
		proyecto.setDescripcion("Proyecto de Escuela 102");
		proyecto.setEmpleados(empleados);
		proyectoService.saveProyecto(proyecto);
		assertTrue(true);
		
	}
**/
	@Test
	void testEmpleado() {
		
		Ciudadano e1 = new Ciudadano();
		e1.setContrasenia("aae");
		e1.setDni("eea");
		e1.setEmail("aa@aae");
		e1.setEstadoCivil("ADMIN");
		e1.setNroTramite(12);
		e1.setPerfil("CONSULTOR");
		e1.setProvincia("eeee");
		e1.setTelefono(123456789);
		Usuario usu = new Usuario();
		usu.setPassword("1234");
		usu.setPerfil("ADMIN");
		usu.setUsername("papan");
		e1.setUsuario(usu);
		
		
		ciudadanoService.addCiudadano(e1);
		assertTrue(true);
		
	}
	
}

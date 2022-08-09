package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.service.ICursoService;


@Service("cursoServiceRam")
public class CursoServiceImp implements ICursoService {
   
	@Autowired
	Curso curso;
	
	List<Curso> cursos = new ArrayList<Curso>();
	
	
	
	@Override
	public void addOferta(Curso curso) {
		this.cursos.add(curso);
		
	}

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return this.curso;
	}

	@Override
	public List<Curso> getAllOcursos() {
		// TODO Auto-generated method stub
		return this.cursos;
	}

	@Override
	public Optional<Curso> getUnCurso(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarCurso(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> getCursoFiltro(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

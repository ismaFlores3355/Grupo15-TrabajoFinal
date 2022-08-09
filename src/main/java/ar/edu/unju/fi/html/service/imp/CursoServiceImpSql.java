package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Curso;
import ar.edu.unju.fi.html.entity.OfertasLaborales;
import ar.edu.unju.fi.html.repository.CursoRepository;
import ar.edu.unju.fi.html.repository.OfertasLRepository;
import ar.edu.unju.fi.html.service.ICursoService;

@Service("cursoServiceMysql")
public class CursoServiceImpSql implements ICursoService{
   
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	Curso cursoz;
	
	
	
	@Override
	public void addOferta(Curso curso) {
		cursoRepository.save(curso);
		
	}

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return this.cursoz;
	}

	@Override
	public List<Curso> getAllOcursos() {
		// TODO Auto-generated method stub
		List<Curso> cursos = cursoRepository.findAll();
		return cursos;
	}

	@Override
	public Optional<Curso> getUnCurso(Long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id);
	}

	@Override
	public void borrarCurso(Long id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	public List<Curso> getCursoFiltro(String categoria) {
		List<Curso> cursos = new ArrayList<Curso>();
		//aplico el filtro si el parametro tiene valores o almenos algunos tiene
		categoria = "%"+categoria+"%";
		if (!categoria.isEmpty()) {
			//agrego caracteres necesarios para que funcione el like
			cursos = this.cursoRepository.findByCategoriaLike(categoria);
		}  
			
		return cursos;
	

}
}
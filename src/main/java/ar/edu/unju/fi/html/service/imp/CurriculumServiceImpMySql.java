package ar.edu.unju.fi.html.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.html.entity.Curriculum;
import ar.edu.unju.fi.html.repository.CurriculumRepository;
import ar.edu.unju.fi.html.service.ICurriculumService;

@Service("curriculumServiceMysql")
public class CurriculumServiceImpMySql implements ICurriculumService {

	@Autowired
	CurriculumRepository curriculumRepository;
	
	@Autowired
	Curriculum curriculum;
	
	
	
	@Override
	public void addCurriculum(Curriculum curriculum) {
		curriculumRepository.save(curriculum);
		
	}

	@Override
	public Curriculum getCurriculum() {
		// TODO Auto-generated method stub
		return this.curriculum;
	}

	@Override
	public List<Curriculum> getAllCurriculum() {
		List<Curriculum> curriculums = curriculumRepository.findAll();
		return curriculums;
	}

	@Override
	public Optional<Curriculum> getUnCurriculum(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

}

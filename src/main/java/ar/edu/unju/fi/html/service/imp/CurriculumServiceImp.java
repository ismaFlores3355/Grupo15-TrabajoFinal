package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.html.entity.Curriculum;
import ar.edu.unju.fi.html.service.ICurriculumService;

@Service("curriculumService")
public class CurriculumServiceImp implements ICurriculumService {

	@Autowired
	Curriculum curriculum;
	
	List<Curriculum> curriculums = new ArrayList<Curriculum>();
	
	
	
	@Override
	public void addCurriculum(Curriculum curriculum) {
		this.curriculums.add(curriculum);
		
	}

	@Override
	public Curriculum getCurriculum() {
		// TODO Auto-generated method stub
		return this.curriculum;
	}

	@Override
	public List<Curriculum> getAllCurriculum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Curriculum> getUnCurriculum(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}

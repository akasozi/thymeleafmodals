package io.motionlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import io.motionlab.model.Nationality;
import io.motionlab.repository.NationalityRepository;

@Service
public class NationalityService {
	
	@Autowired
	private NationalityRepository nationalityRepository;
	
	public List<Nationality> getAllNationalities() {
		
		List<Nationality> nationalities = new ArrayList<>();
		nationalityRepository.findAll()
		       .forEach(nationalities::add);
		return nationalities;
	}
	
	public Nationality getNationality(int id) {
		
		return nationalityRepository.findById(id)
				.orElse(null);
	} 
	
	public void addNationality(Nationality nationality) {
		nationalityRepository.save(nationality);
	}
	
	public void updateNationality(Nationality nationality) {
		nationalityRepository.save(nationality);
	}
	
	public void deleteNationality(int id) {
		nationalityRepository.deleteById(id);
	}
}

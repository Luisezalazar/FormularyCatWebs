package com.formularioFull.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.repository.ITechnicalRepository;

@Service
public class TechnicalService implements ITechnicalService{

	@Autowired
	ITechnicalRepository techRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public List<TechnicalAccount> getListTechinian() {
		List<TechnicalAccount> listTechnical = techRepo.findAll();
		return listTechnical;
	}
	
	@Override
	public void saveTechnician(TechnicalAccount tech) {
		String passCodificado = encoder.encode(tech.getPassword());
		tech.setPassword(passCodificado);
		techRepo.save(tech);
	}

	@Override
	public TechnicalAccount findTechnician(Integer id) {
		TechnicalAccount tech = techRepo.findById(id).orElse(null);
		return tech;
	}

	@Override
	public void deleteTechnician(Integer id) {
		techRepo.deleteById(id);
	}

	@Override
	public void editTechnician(TechnicalAccount tech) {
		
		 techRepo.save(tech);
		
	}


	@Override
	public TechnicalAccount findByName(String name) {
		
		return techRepo.findByUser(name).orElse(null);
	
	}

}

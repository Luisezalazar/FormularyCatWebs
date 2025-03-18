package com.formularioFull.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.repository.ITechnicalRepository;
import com.formularioFull.service.ITechnicalService;

@Configuration
public class InitialDataConfiguration {

	@Autowired
	ITechnicalService techServ;
	@Autowired
	ITechnicalRepository techRepo;
	
	@Bean
	CommandLineRunner run () {
		return args->{System.out.println("Existo padre");
		if(techRepo.count()==0) {
			TechnicalAccount tech = new TechnicalAccount();
			tech.setName("CatWebs");
			tech.setLastName("Pyme");
			tech.setDni("11111111");
			tech.setAdmissionDate(LocalDate.now());
			tech.setCategory("Admin");
			tech.setUser("admin");
			tech.setPassword("123123");
			tech.setRol("admin");
			techServ.saveTechnician(tech);
			System.out.println("He sido creado, padre");
			
		}
	};
}
}


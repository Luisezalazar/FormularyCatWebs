package com.formularioFull.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.repository.ITechnicalRepository;
import com.formularioFull.security.UserSecurity;


@Service
@Transactional(readOnly=true)
public class UserService implements UserDetailsService{

	
	@Autowired
	ITechnicalRepository techRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<TechnicalAccount> technician = techRepo.findByUser(username);
		if(technician.isPresent()) {
			return new UserSecurity(technician.get());
		}
		throw new UsernameNotFoundException("Not found");
	}

	
}

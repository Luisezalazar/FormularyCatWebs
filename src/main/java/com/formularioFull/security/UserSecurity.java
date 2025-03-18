package com.formularioFull.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.formularioFull.model.TechnicalAccount;



public class UserSecurity implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private TechnicalAccount tech;
	
	public UserSecurity(TechnicalAccount tech) {
		this.tech = tech;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> authority = new ArrayList<>();
		authority.add(new SimpleGrantedAuthority("tecnico"));
		if(tech.getRol().equals("admin")) {
			authority.add(new SimpleGrantedAuthority("admin"));
		}
		return authority;
	}

	
	
	@Override
	public String getPassword() {
		if(tech!= null) {
			return tech.getPassword();
		}
		return null;
	}

	@Override
	public String getUsername() {
		if(tech!=null) {
			
			return tech.getUser();
			
		}
		return null;
	}

	public TechnicalAccount getTechnical() {
		return tech;
	}
	@Override
	public boolean isEnabled () {
		return true;
	}
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

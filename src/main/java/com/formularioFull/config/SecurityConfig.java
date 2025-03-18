package com.formularioFull.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filtro(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize -> authorize
        		
        		
        		.requestMatchers("/css/**").permitAll()
        		.requestMatchers("/img/**").permitAll()
        		.requestMatchers("/js/**").permitAll()
        		.requestMatchers("/scss/**").permitAll()
        		.requestMatchers("/vendor/**").permitAll()
        		.anyRequest().authenticated())
        .formLogin(form -> form
        		.loginPage("/login")
        		.defaultSuccessUrl("/",true).permitAll())
        .logout(logout -> logout
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
        		);// .csrf(AbstractHttpConfigurer::disable) habilitar postman
        return http.build();
        
        
        		
	}
	
	
	
}

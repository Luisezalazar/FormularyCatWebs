package com.formularioFull.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formularioFull.model.Formulary;
import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.service.IFormService;
import com.formularioFull.service.ITechnicalService;


@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	ITechnicalService techServ;
	
	@Autowired
	IFormService formServ;
	
	@GetMapping("")
	public String index() {
		return "redirect:/SeeForm";
		
	}
	
	@GetMapping("/Logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null || auth instanceof AnonymousAuthenticationToken) {
			return "login";
		}else {
			return "redirect:/index";
		}
		
	}
	
	@GetMapping("/AltaForm")
	public String AltaForm(Formulary formulary) {
		return "AltaForm";
	}
	
	@GetMapping("/AltaTechnician")
	public String AltaTechnician(TechnicalAccount tech) {
		return "AltaTechnician";
	}
	
	@GetMapping("/editTechnician/{original_id}")
	public String EditTechnician(@PathVariable Integer original_id, Model model) {
		TechnicalAccount tech = techServ.findTechnician(original_id);
		System.out.println(tech.getName());
		model.addAttribute("technicalAccount", tech);
		return "EditTechnician";
	}
	
	@GetMapping("/editForm/{original_id}")
	public String EditForm(@PathVariable Integer original_id, Model model) {
		Formulary form = formServ.findForm(original_id);
		model.addAttribute("formulary", form);
		return "EditForm";
	}
	
	
	@GetMapping("/SeeForm")
	public String SeeForm(Formulary form, Model model) {
	
		model.addAttribute("formulary",formServ.getForm());
		
		return "SeeForm";
	}
	
	@GetMapping("/SeeTechnician")
	public String SeeTechnician(TechnicalAccount tech, Model model) {
		
		model.addAttribute("technicalAccount", techServ.getListTechinian());
		return "SeeTechnician";
	}
	
}

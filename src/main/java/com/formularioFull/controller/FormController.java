package com.formularioFull.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.formularioFull.model.Formulary;
import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.service.IFormService;
import com.formularioFull.service.ITechnicalService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class FormController {

	@Autowired
	private IFormService formServ;
	
	@Autowired
	private ITechnicalService techServ;
	
	
	@GetMapping("/form/get")
	public List<Formulary> getForm(){
		List<Formulary> listForm = formServ.getForm();
		return listForm;
	}
	
	@GetMapping("/form/get/{id}")
	public Formulary getFindForm(@PathVariable Integer id) {
		return formServ.findForm(id);
	}
	
	@PostMapping(value="/create", consumes = {"*/*"})
	public String createForm(@RequestParam String type,
									@RequestParam(required=false) LocalDate date,
									@RequestParam(required=false) LocalTime time,
									@RequestParam String description,
									@RequestParam String home,
									@RequestParam String floor,
									@RequestParam String department,
									@RequestParam String customerName,
									@RequestParam String signature,
									Principal prin,
									TechnicalAccount tech,
									RedirectAttributes redi,
												@Valid Formulary form, BindingResult bin) {
		if(bin.hasErrors()) {
			redi.addFlashAttribute("error", bin);
			return "redirect:/AltaForm";
		}
		
		
		System.out.println(techServ.findByName(prin.getName()));
		form.setTechnical_account(techServ.findByName(prin.getName()));
		formServ.saveForm(form);
		redi.addFlashAttribute("successfully", bin);
		return "redirect:/AltaForm";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteForm(@PathVariable Integer id) {
		formServ.deleteForm(id);
		return "redirect:/SeeForm";
	}
	
	@PostMapping("/edit")
	public String editForm(@RequestParam Integer id_form, @RequestParam String type,
			@RequestParam(required = false) LocalDate date, @RequestParam(required = false) LocalTime time,
			@RequestParam String description, @RequestParam String home, @RequestParam String floor,
			@RequestParam String department, @RequestParam String customerName, @RequestParam String signature,
			RedirectAttributes redi,
			@Valid Formulary form, BindingResult bin) {
		
		if (bin.hasErrors()) {
			redi.addFlashAttribute("error", bin);
			return "redirect:/SeeForm";
		}

		formServ.saveForm(form);
		redi.addFlashAttribute("successfully", bin);
		return "redirect:/SeeForm";
		
	}

	@PutMapping("/form/edit/edit")
	public Formulary editForm(@RequestBody Formulary form) {
		formServ.editForm(form);
		return formServ.findForm(form.getId_form());
	}
	
}

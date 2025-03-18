package com.formularioFull.controller;

import java.time.LocalDate;

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

import com.formularioFull.model.TechnicalAccount;
import com.formularioFull.service.ITechnicalService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/technicalAccount")
public class TechnicalController {

	@Autowired
	private ITechnicalService techServ;

	

	@GetMapping("/get")
	public List<TechnicalAccount> getTech() {
		List<TechnicalAccount> listTech = techServ.getListTechinian();
		return listTech;
	}

	@GetMapping("/get/{id}")
	public TechnicalAccount getTech(@PathVariable Integer id) {
		return techServ.findTechnician(id);
	}

	@PostMapping(value = "/create", consumes = { "*/*" })
	public String createTech(@RequestParam String name, @RequestParam String lastName, @RequestParam String dni,
			@RequestParam(required=false) LocalDate admissionDate, @RequestParam String category, @RequestParam String user,
			@RequestParam String password,@RequestParam(required=false) String rol, RedirectAttributes redi,

			@Valid TechnicalAccount tech, BindingResult bin) {
		
		if (bin.hasErrors() || admissionDate == null) {
			redi.addFlashAttribute("error", bin);
			return "redirect:/AltaTechnician";
		}else {
		tech.setRol("tecnico");
		techServ.saveTechnician(tech);
		redi.addFlashAttribute("successfully", bin);
		
		return "redirect:/AltaTechnician";}
	}
	

	@PostMapping("/delete/{id}")
	public String deleteTech(@PathVariable Integer id) {
		techServ.deleteTechnician(id);
		return "redirect:/SeeTechnician";
	}

	@PostMapping("/edit")
	public String editTech(@RequestParam Integer id_technician,@RequestParam String name, @RequestParam String lastName, @RequestParam String dni,
			@RequestParam LocalDate admissionDate, @RequestParam String category, @RequestParam String user,
			 RedirectAttributes redi,
			@Valid TechnicalAccount tech, BindingResult bin) {
		
		TechnicalAccount passte = techServ.findTechnician(id_technician);
		 tech.setPassword(passte.getPassword());
		
		if (bin.hasErrors() || admissionDate == null) {
			redi.addFlashAttribute("error", bin);
			return "redirect:/SeeTechnician";
		}

		techServ.editTechnician(tech);
		redi.addFlashAttribute("successfully", bin);
		return "redirect:/SeeTechnician";
	}

	@PutMapping("/edit/edit")
	public TechnicalAccount editTech(@RequestBody TechnicalAccount tech) {
		techServ.editTechnician(tech);
		return techServ.findTechnician(tech.getId_technician());
	}
}
package com.formularioFull.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formularioFull.model.Formulary;
import com.formularioFull.repository.IFormRepository;

@Service
public class FormService implements IFormService{

	@Autowired
		private IFormRepository formRepo;
	
	@Override
	public List<Formulary> getForm() {
		List<Formulary> listForm = formRepo.findAll();
		return listForm;
	}

	@Override
	public void saveForm(Formulary form) {
		LocalDate nowDate= LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		form.setTime(nowTime);
		form.setDate(nowDate);
		formRepo.save(form);
	}

	@Override
	public Formulary findForm(Integer id) {
		Formulary form = formRepo.findById(id).orElse(null);
		return form;
	}

	@Override
	public void deleteForm(Integer id) {
		formRepo.deleteById(id);
	}

	@Override
	public void editForm(Integer original_id,String newtype, LocalDate newDate, LocalTime newTime, String newDescription, String newHome,
			String newFloor, String newDepartament, String newCustomerName, String newSignature) {
		Formulary form = this.findForm(original_id);
		form.setType(newtype);
		form.setDate(newDate);
		form.setTime(newTime);
		form.setDescription(newDescription);
		form.setHome(newHome);
		form.setFloor(newFloor);
		form.setDepartment(newDepartament);
		form.setCustomerName(newCustomerName);
		form.setSignature(newSignature);
		
		this.saveForm(form);
	}

	@Override
	public void editForm(Formulary form) {
		this.saveForm(form);
	}

}

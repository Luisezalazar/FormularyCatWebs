package com.formularioFull.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.formularioFull.model.Formulary;

public interface IFormService {

	public List<Formulary> getForm();
	
	public void saveForm(Formulary form);
	
	public Formulary findForm(Integer id);
	
	public void deleteForm(Integer id);
	
	public void editForm(Integer original_id,String newtype, LocalDate newDate, LocalTime newTime, String newDescription, String newHome,
							String newFloor, String newDepartament, String newCustomerName, String newSignature);
	
	public void editForm(Formulary form);
	
}

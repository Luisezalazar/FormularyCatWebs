package com.formularioFull.service;


import java.util.List;


import com.formularioFull.model.TechnicalAccount;


public interface ITechnicalService {
	
	public List<TechnicalAccount> getListTechinian();
	
	public void saveTechnician(TechnicalAccount tech);
	
	public TechnicalAccount findTechnician(Integer id);
	
	public void deleteTechnician(Integer id);
	
	public void editTechnician(TechnicalAccount tech);
	
	public TechnicalAccount findByName(String name);
	

}

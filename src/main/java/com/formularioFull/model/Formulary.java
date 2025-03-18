package com.formularioFull.model;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Formulary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_form;
	
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String type;
	
	
	private LocalDate date;
	private LocalTime time;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String description;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String home;
	@Size(min=1)
	@NotNull(message="Obligatorio")
	private String floor;
	@Size(min=1)
	@NotNull(message="Obligatorio")
	private String department;
	
	
	private String customerName;
	private String signature;
	
	@ManyToOne
	@JoinColumn(name="id_technician", nullable=false)
	private TechnicalAccount technical_account;
	
}

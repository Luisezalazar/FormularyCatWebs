package com.formularioFull.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="technical_account")
public class TechnicalAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_technician;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String name;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String lastName;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String dni;
	
	@NotNull(message="Obligatorio")
	private LocalDate admissionDate;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String category;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String user;
	@Size(min=2)
	@NotNull(message="Obligatorio")
	private String password;
	
	private String rol;
	
	@OneToMany(mappedBy = "technical_account",cascade=CascadeType.ALL)
	private List<Formulary> listForm;
	
	
}

package com.miradorlacala.apt.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Languages")
public class Language {
	@Id
	private String idLanguage;

	private String descLanguage;
	
	@OneToMany
	@JoinColumn(name = "language")
	private List<Request> requests;

	@OneToMany
	@JoinColumn(name = "language")
	private List<Rental> rentals;

	
	public Language() {
		super();
	}

	@Override
	public int hashCode() {
		return idLanguage.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		String idLanguage = ((Language) o).getIdLanguage();
		return idLanguage.equals(this.idLanguage);
	}

	// GETTERS & SETTERS
	
	public String getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(String idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getDescLanguage() {
		return descLanguage;
	}

	public void setDescLanguage(String descLanguage) {
		this.descLanguage = descLanguage;
	}

//	public List<Request> getRequests() {
//		return requests;
//	}
//
//	public void setRequests(List<Request> requests) {
//		this.requests = requests;
//	}
	
//	public List<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}

	
	
}
package com.miradorlacala.apt.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "States")
public class State {
	@Id
	private Integer idState;

	private String descState;
	
	@OneToMany
	@JoinColumn(name = "state")
	private List<Rental> rentals;

	public State() {
		super();
	}

	@Override
	public int hashCode() {
		return idState.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Integer idState = ((State) o).getIdState();
		return idState.equals(this.idState);
	}

	// GETTERS & SETTERS
	
	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public String getDescState() {
		return descState;
	}

	public void setDescState(String descState) {
		this.descState = descState;
	}

//	public List<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}		
	
}
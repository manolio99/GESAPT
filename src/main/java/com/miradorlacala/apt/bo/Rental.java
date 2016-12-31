package com.miradorlacala.apt.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rentals")
public class Rental {
	@Id
	private Integer idRental;
	private String firstName;
	private String lastName;
	private Date entryDate;
	private Date departureDate;
	private String phone;
	private Integer numPeople;
	private Double price;
	private Double booking;
	private Double deposit;
	@ManyToOne
	@JoinColumn(name = "idState")
	private State state;
	private Date creationDate;
	private Date modificationDate;

	public Rental() {
		super();
	}

	@Override
	public int hashCode() {
		return idRental.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Integer idRental = ((Rental) o).getIdRental();
		return idRental.equals(this.idRental);
	}
	
	// GETTERS & SETTERS
	
	public Integer getIdRental() {
		return idRental;
	}

	public void setIdRental(Integer idRental) {
		this.idRental = idRental;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(Integer numPeople) {
		this.numPeople = numPeople;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBooking() {
		return booking;
	}

	public void setBooking(Double booking) {
		this.booking = booking;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}
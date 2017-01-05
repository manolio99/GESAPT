package com.miradorlacala.apt.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Requests")
public class Request {
	@Id
	private Integer idRequest;
	
	private String name;
	private Date entryDate;
	private Date departureDate;
	
	@ManyToOne
	@JoinColumn(name = "idLanguage")
	private Language language;
	
	private String phone;
	private Date creationDate;

	public Request() {
		super();
		language = new Language();
		language.setIdLanguage("es");
	}

	@Override
	public int hashCode() {
		return idRequest.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Integer idRequest = ((Request) o).getIdRequest();
		return idRequest.equals(this.idRequest);
	}

	// GETTERS & SETTERS

	public Integer getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
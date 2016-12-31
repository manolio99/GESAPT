package com.miradorlacala.apt.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prices")
public class Price {
	@Id
	private Integer idPrice;
	private Date startDate;
	private Date endDate;
	private Double priceNight;
	private Double priceNightWeekend;
	private Double priceWeek;
	private Double priceForty;
	private Double priceMonth;
	private Double priceExtraNight;
	private Integer minimumRental;
	private Boolean offer;
	private Date modificationDate;

	public Price() {
		super();
	}

	@Override
	public int hashCode() {
		return idPrice.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Integer idPrice = ((Price) o).getIdPrice();
		return idPrice.equals(this.idPrice);
	}
	
	// GETTERS & SETTERS
	
	public Integer getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(Integer idPrice) {
		this.idPrice = idPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPriceNight() {
		return priceNight;
	}

	public void setPriceNight(Double priceNight) {
		this.priceNight = priceNight;
	}

	public Double getPriceNightWeekend() {
		return priceNightWeekend;
	}

	public void setPriceNightWeekend(Double priceNightWeekend) {
		this.priceNightWeekend = priceNightWeekend;
	}

	public Double getPriceWeek() {
		return priceWeek;
	}

	public void setPriceWeek(Double priceWeek) {
		this.priceWeek = priceWeek;
	}

	public Double getPriceForty() {
		return priceForty;
	}

	public void setPriceForty(Double priceForty) {
		this.priceForty = priceForty;
	}

	public Double getPriceMonth() {
		return priceMonth;
	}

	public void setPriceMonth(Double priceMonth) {
		this.priceMonth = priceMonth;
	}

	public Double getPriceExtraNight() {
		return priceExtraNight;
	}

	public void setPriceExtraNight(Double priceExtraNight) {
		this.priceExtraNight = priceExtraNight;
	}

	public Integer getMinimumRental() {
		return minimumRental;
	}

	public void setMinimumRental(Integer minimumRental) {
		this.minimumRental = minimumRental;
	}

	public Boolean getOffer() {
		return offer;
	}

	public void setOffer(Boolean offer) {
		this.offer = offer;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

}
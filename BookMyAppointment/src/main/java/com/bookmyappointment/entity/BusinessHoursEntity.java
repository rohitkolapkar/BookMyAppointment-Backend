package com.bookmyappointment.entity;

import java.io.Serializable;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "txn_business_hours")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessHoursEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer businessHourId;
	private LocalTime openTime;
	private LocalTime closeTime;
	private boolean open;
	private int day;
	
	
	  @ManyToOne(cascade=CascadeType.MERGE)
	  
	  @JoinColumn(name = "sp_id", referencedColumnName = "spId")
	  //referencedColumnName should be same as @Id field of reffered entity. here
	  private ServiceProviderEntity serviceProvider;
	 
	
	public Integer getBusinessHourId() {
		return businessHourId;
	}
	public void setBusinessHourId(Integer businessHourId) {
		this.businessHourId = businessHourId;
	}
	public LocalTime getOpenTime() {
		return openTime;
	}
	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}
	public LocalTime getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	

	



}

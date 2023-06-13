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
@Table(name = "txn_services")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;
	private String serviceName;
	private LocalTime serviceDuration;
	private double servicePrice;
	
	 @ManyToOne(cascade=CascadeType.MERGE)
	 @JoinColumn(name = "sp_id", referencedColumnName = "spId")
	 //referencedColumnName should be same as @Id field of reffered entity. here ServiceProviderEntity
	 private ServiceProviderEntity serviceProvider;


	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public LocalTime getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(LocalTime serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	/*public ServiceProviderEntity getServiceProvider() {
		return serviceProvider;
	}*/

	public void setServiceProvider(ServiceProviderEntity serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	 
	 
	
	
}

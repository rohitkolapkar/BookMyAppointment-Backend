package com.bookmyappointment.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "txn_service_providers")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProviderEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer spId;

	private String spName;
	private String spEmail;
	private String spPassword;
	private String spPhone;
	private String businessName;
	private String businessAddress;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	// referencedColumnName should be same as @Id field of reffered entity. here
	// ServiceCategoryEntity
	private ServiceCategoryEntity serviceCategory;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "city_id", referencedColumnName = "cityId")
	private CityEntity city;

	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL /* ,fetch = FetchType.EAGER */ )
	private List<ServiceEntity> services;

	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL /* ,fetch = FetchType.EAGER */ )
	private List<BusinessHoursEntity> businessHours;

	public ServiceProviderEntity() {
		super();
	}

	public ServiceProviderEntity(Integer spId, String spName, String spEmail, String spPassword, String spPhone,
			String businessName, String businessAddress, ServiceCategoryEntity serviceCategory, CityEntity city,
			List<ServiceEntity> services, List<BusinessHoursEntity> businessHours) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.spEmail = spEmail;
		this.spPassword = spPassword;
		this.spPhone = spPhone;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.serviceCategory = serviceCategory;
		this.city = city;
		this.services = services;
		this.businessHours = businessHours;
	}

	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpEmail() {
		return spEmail;
	}

	public void setSpEmail(String spEmail) {
		this.spEmail = spEmail;
	}

	public String getSpPassword() {
		return spPassword;
	}

	public void setSpPassword(String spPassword) {
		this.spPassword = spPassword;
	}

	public String getSpPhone() {
		return spPhone;
	}

	public void setSpPhone(String spPhone) {
		this.spPhone = spPhone;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public ServiceCategoryEntity getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ServiceCategoryEntity serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public List<ServiceEntity> getServices() {
		return services;
	}

	public void setServices(List<ServiceEntity> services) {
		this.services = services;
	}

	public List<BusinessHoursEntity> getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(List<BusinessHoursEntity> businessHours) {
		this.businessHours = businessHours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

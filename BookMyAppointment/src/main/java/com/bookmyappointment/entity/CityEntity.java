package com.bookmyappointment.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "txn_cities")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;

	private String cityName;

	/*
	 * @OneToMany(mappedBy = "city", cascade = CascadeType.PERSIST ,fetch =
	 * FetchType.EAGER ) private List<ServiceProviderEntity> serviceProviders;
	 */

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityEntity [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	/*
	 * public List<ServiceProviderEntity> getServiceProviders() { return
	 * serviceProviders; }
	 * 
	 * public void setServiceProviders(List<ServiceProviderEntity> serviceProviders)
	 * { this.serviceProviders = serviceProviders; }
	 */

}

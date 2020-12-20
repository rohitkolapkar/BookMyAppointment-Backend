package com.bookmyappointment.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "txn_service_categories")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceCategoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    
	@OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.PERSIST /*,fetch = FetchType.EAGER*/ ) 
	private List<ServiceProviderEntity> serviceProviders;

	public ServiceCategoryEntity() {
		super();
	}

	public ServiceCategoryEntity(Integer categoryId, String categoryName
			) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



}

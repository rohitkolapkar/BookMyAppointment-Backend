package com.bookmyappointment.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "txn_business")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bu_id")
    private Integer buId;

	@Column(name = "business_email")
    private String businessEmail;

	@Column(name = "business_name")
	private String businessName;

	@Column(name = "mobile")
	private String mobile;


	public Integer getId() {
		return id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuId() {
		return buId;
	}

	public void setBuId(Integer buId) {
		this.buId = buId;
	}

	public String getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}


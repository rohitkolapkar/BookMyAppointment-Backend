package com.bookmyappointment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "txn_consumer")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumerEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String consumerName;
    private String consumerEmail;
    private String consumerPassword;
    private String consumerPhone;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerEmail() {
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail) {
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerPassword() {
		return consumerPassword;
	}
	public void setConsumerPassword(String consumerPassword) {
		this.consumerPassword = consumerPassword;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}
}

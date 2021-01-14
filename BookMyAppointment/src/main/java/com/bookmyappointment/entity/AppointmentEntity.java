package com.bookmyappointment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "txn_appointment")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @Column(name = "start_date_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss", timezone = "Asia/Kolkata")
    private Date startDateTime;

    @Column(name = "end_date_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss", timezone = "Asia/Kolkata")
    private Date endDateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "consumer_id", referencedColumnName = "id")
    private ConsumerEntity consumer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "serviceProvider_id", referencedColumnName = "spId")
    private ServiceProviderEntity serviceProvider;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private ServiceEntity service;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public ConsumerEntity getConsumer() {
		return consumer;
	}

	public void setConsumer(ConsumerEntity consumer) {
		this.consumer = consumer;
	}

	public ServiceProviderEntity getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderEntity serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public ServiceEntity getService() {
		return service;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}
    
    
    
    
}
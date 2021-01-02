package com.bookmyappointment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "txn_appoitment")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appoitmentId;

    @Column(name = "start_date_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss", timezone = "Asia/Kolkata")
    private Date startDateTime;

    @Column(name = "end_date_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss", timezone = "Asia/Kolkata")
    private Date endDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consumer_id", referencedColumnName = "id")
    private ConsumerEntity consumer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceProvider_id", referencedColumnName = "spId")
    private ServiceProviderEntity serviceProvider;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private ServiceCategoryEntity serviceCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private ServiceEntity service;

    /*public AppoitmentEntity(){

    }
    public AppoitmentEntity(Integer appoitmentId, Date startDateTime, Date endDateTime, ConsumerEntity consumer, ServiceProviderEntity serviceProvider, ServiceCategoryEntity serviceCategory, ServiceEntity service) {
        this.appoitmentId = appoitmentId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.consumer = consumer;
        this.serviceProvider = serviceProvider;
        this.serviceCategory = serviceCategory;
        this.service = service;
    }*/

    public Integer getAppoitmentId() {
        return appoitmentId;
    }

    public void setAppoitmentId(Integer appoitmentId) {
        this.appoitmentId = appoitmentId;
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

    public ServiceCategoryEntity getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategoryEntity serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "AppoitmentEntity{" +
                "appoitmentId=" + appoitmentId +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", consumer=" + consumer +
                ", serviceProvider=" + serviceProvider +
                ", serviceCategory=" + serviceCategory +
                ", service=" + service +
                '}';
    }
}

package com.bookmyappointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyappointment.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
    List<ServiceEntity> findByServiceProvider_SpId(int spId);
}

package com.bookmyappointment.repository;

import com.bookmyappointment.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
    List<ServiceEntity> findByServiceProvider_SpId(int spId);
}

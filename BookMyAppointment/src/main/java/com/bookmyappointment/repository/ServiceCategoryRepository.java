package com.bookmyappointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.ServiceCategoryEntity;

@Repository
public interface ServiceCategoryRepository extends CrudRepository<ServiceCategoryEntity, Integer> {

}

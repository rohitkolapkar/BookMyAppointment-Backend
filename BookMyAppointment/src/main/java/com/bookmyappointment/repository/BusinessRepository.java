package com.bookmyappointment.repository;

import com.bookmyappointment.entity.BusinessEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusinessRepository extends CrudRepository<BusinessEntity, Integer> {
}

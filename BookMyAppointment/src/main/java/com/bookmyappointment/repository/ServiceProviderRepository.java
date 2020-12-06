package com.bookmyappointment.repository;

import com.bookmyappointment.entity.ServiceProviderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProviderEntity, Integer> {
}

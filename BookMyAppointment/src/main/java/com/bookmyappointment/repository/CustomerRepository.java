package com.bookmyappointment.repository;

import com.bookmyappointment.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository  extends CrudRepository<CustomerEntity, Integer>{

}

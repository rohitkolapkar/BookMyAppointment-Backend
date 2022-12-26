package com.bookmyappointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.ConsumerEntity;


@Repository
public interface ConsumerRepository  extends CrudRepository<ConsumerEntity, Integer>{

}

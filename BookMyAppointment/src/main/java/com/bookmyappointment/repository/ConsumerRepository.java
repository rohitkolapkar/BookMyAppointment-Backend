package com.bookmyappointment.repository;

import com.bookmyappointment.entity.ConsumerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumerRepository  extends CrudRepository<ConsumerEntity, Integer>{

}

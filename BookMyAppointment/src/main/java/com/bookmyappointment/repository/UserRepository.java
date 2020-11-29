package com.bookmyappointment.repository;

import com.bookmyappointment.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Integer>{

}

package com.bookmyappointment.repository;

import com.bookmyappointment.entity.AuthenticationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthenticationRepository extends CrudRepository<AuthenticationEntity, Integer> {
    AuthenticationEntity findByEmail(String email);
}

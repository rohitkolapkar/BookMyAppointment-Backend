package com.bookmyappointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.AuthenticationEntity;


@Repository
public interface AuthenticationRepository extends CrudRepository<AuthenticationEntity, Integer> {
    AuthenticationEntity findByEmail(String email);
}

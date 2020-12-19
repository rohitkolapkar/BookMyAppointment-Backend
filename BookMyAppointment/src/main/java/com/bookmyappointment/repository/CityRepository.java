package com.bookmyappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {



}

package com.bookmyappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.ServiceCategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<ServiceCategoryEntity, Integer> {
}

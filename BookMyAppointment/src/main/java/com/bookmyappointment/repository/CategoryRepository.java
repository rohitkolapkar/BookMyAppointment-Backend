package com.bookmyappointment.repository;

import com.bookmyappointment.entity.ServiceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ServiceCategoryEntity, Integer> {
}

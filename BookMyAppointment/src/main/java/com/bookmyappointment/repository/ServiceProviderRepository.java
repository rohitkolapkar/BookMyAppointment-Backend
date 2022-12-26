package com.bookmyappointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.ServiceProviderEntity;


@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProviderEntity, Integer> {

    List<ServiceProviderEntity> findByCity_CityName(String cityName);

	List<ServiceProviderEntity> findByCity_CityIdAndServiceCategory_CategoryId(int cityId, int categoryId);

	
}

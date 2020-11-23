package com.bookmyappointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyappointment.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer>{

}

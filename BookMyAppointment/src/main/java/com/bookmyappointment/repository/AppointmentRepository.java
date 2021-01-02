package com.bookmyappointment.repository;


import com.bookmyappointment.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Integer> {

    AppointmentEntity findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThan(Integer spId, Date startDateTime, Date endDateTime);

}

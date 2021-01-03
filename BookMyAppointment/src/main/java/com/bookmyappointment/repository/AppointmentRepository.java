package com.bookmyappointment.repository;


import com.bookmyappointment.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Integer> {

    AppointmentEntity findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThan(Integer spId, Date startDateTime, Date endDateTime);

    List<AppointmentEntity> findByServiceProvider_SpId(Integer id);

    List<AppointmentEntity> findByconsumer_Id(Integer id);
}

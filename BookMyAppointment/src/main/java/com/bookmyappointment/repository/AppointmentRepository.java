package com.bookmyappointment.repository;


import com.bookmyappointment.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Integer> {
    List<AppointmentEntity> findByServiceProvider_SpId(Integer id);

    List<AppointmentEntity> findByconsumer_Id(Integer id);

	List<AppointmentEntity> findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualOrEndDateTimeLessThanEqual(
			Integer spId, Date startDateTime, Date endDateTime);

    @Query("SELECT u FROM AppointmentEntity u left join u.serviceProvider q WHERE(:startDateTime BETWEEN u.startDateTime AND u.endDateTime OR :endDateTime BETWEEN u.startDateTime AND u.endDateTime OR u.startDateTime BETWEEN :startDateTime AND :endDateTime)AND q.spId = :spId")
    List<AppointmentEntity> customQuery(@Param("spId") Integer spId, @Param("startDateTime") Date startDateTime, @Param("endDateTime") Date endDateTime);
	
    List<AppointmentEntity> findByConsumer_IdOrderByStartDateTimeDesc(int consumerId);

	List<AppointmentEntity> findByServiceProvider_SpIdOrderByStartDateTimeDesc(int spId);

	List<AppointmentEntity> findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThanEqual(
			int spId, Date startDateTime, Date endDateTime);
}

package com.pet.main.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pet.main.enm.AttendanceStatus;
import com.pet.main.entities.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	List<Attendance> findByEmployeeId(Long employeeId);

	List<Attendance> findByStatus(AttendanceStatus status);
	  List<Attendance> findByEmployeeIdAndCheckInTimeBetween(Long employeeId, LocalDateTime start, LocalDateTime end);
}

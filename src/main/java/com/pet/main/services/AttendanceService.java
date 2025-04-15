package com.pet.main.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pet.main.entities.Attendance;
import com.pet.main.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	public List<Attendance> getAllAttendanceRecords() {
		return attendanceRepository.findAll();
	}

//	public Attendance getAttendanceById(Long id) {
//		return attendanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Attendance record not found"));
//	}

	public void saveAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}

	public void deleteAttendance(Long id) {
		attendanceRepository.deleteById(id);
	}
	
	public List<Attendance> getAllAttendance() {
		return attendanceRepository.findAll(); // Create this if not already present
	}
	public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }
	
	public List<Attendance> getEmployeeAttendanceByMonth(Long employeeId, int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        
        return attendanceRepository.findByEmployeeIdAndCheckInTimeBetween(
            employeeId,
            startDate.atStartOfDay(),
            endDate.atTime(23, 59, 59)
        );
    }
	
}

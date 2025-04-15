package com.pet.main.entities;

import java.time.LocalDateTime;
import com.pet.main.enm.AttendanceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;

	@Enumerated(EnumType.STRING)
	private AttendanceStatus status; // PRESENT, ABSENT, LATE, HALF_DAY

	  @Transient // This field won't be persisted in the database
	    private Double workingHours;

	    // ... existing constructors and methods ...

	    public Double getWorkingHours() {
	        return workingHours;
	    }

	    public void setWorkingHours(Double workingHours) {
	        this.workingHours = workingHours;
	    }
	
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

}

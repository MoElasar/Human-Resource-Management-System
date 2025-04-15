package com.pet.main.entities;

import java.time.LocalDate;
import java.util.List;

import com.pet.main.enm.EmploymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType; // FULL_TIME, PART_TIME, CONTRACT, INTERN

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	private LocalDate dateOfJoining;
	private Double salary;

	@OneToMany(mappedBy = "employee")
	private List<LeaveRequest> leaveRequests;

	@OneToMany(mappedBy = "employee")
	private List<Payroll> payrollRecords;

	@OneToMany(mappedBy = "employee")
	private List<Attendance> attendanceRecords;

	@OneToOne
	@JoinColumn(name = "user_account_id", unique = true)
	private UserAccount userAccount; // Link to UserAccount

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the employmentType
	 */
	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the dateOfJoining
	 */
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the leaveRequests
	 */
	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	/**
	 * @param leaveRequests the leaveRequests to set
	 */
	public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	/**
	 * @return the payrollRecords
	 */
	public List<Payroll> getPayrollRecords() {
		return payrollRecords;
	}

	/**
	 * @param payrollRecords the payrollRecords to set
	 */
	public void setPayrollRecords(List<Payroll> payrollRecords) {
		this.payrollRecords = payrollRecords;
	}

	/**
	 * @return the attendanceRecords
	 */
	public List<Attendance> getAttendanceRecords() {
		return attendanceRecords;
	}

	/**
	 * @param attendanceRecords the attendanceRecords to set
	 */
	public void setAttendanceRecords(List<Attendance> attendanceRecords) {
		this.attendanceRecords = attendanceRecords;
	}

	/**
	 * @return the userAccount
	 */
	public UserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}

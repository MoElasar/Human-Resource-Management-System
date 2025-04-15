package com.pet.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.main.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    Optional<Employee> findByEmail(String email);

    // Add this method to find an employee by their username
    Optional<Employee> findByUserAccountUsername(String username);
}

package com.pet.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.main.entities.Department;
import com.pet.main.entities.Employee;
import com.pet.main.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService; // Inject the DepartmentService

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // New method to get all departments
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}

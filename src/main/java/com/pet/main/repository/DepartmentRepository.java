package com.pet.main.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pet.main.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByName(String name);
}

package com.codecomet.tutorial.dataMapping.DataMappingTutorial.repositories;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}

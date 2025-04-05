package com.codecomet.tutorial.dataMapping.DataMappingTutorial.repositories;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}

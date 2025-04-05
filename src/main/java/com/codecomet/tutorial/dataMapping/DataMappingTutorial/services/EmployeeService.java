package com.codecomet.tutorial.dataMapping.DataMappingTutorial.services;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.EmployeeEntity;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

      @Autowired
      EmployeeRepository employeeRepository;

      public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
          System.out.println(employeeEntity.getName());
          return employeeRepository.save(employeeEntity);
      }

      public EmployeeEntity getEmployeeById(Long id){
          return employeeRepository.findById(id).orElse(null);
      }

    public EmployeeEntity updateEmployee(Long employeeId, EmployeeEntity employeeEntity) {

          employeeEntity.setId(employeeId);

          return employeeRepository.save(employeeEntity);

    }
}

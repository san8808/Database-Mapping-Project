package com.codecomet.tutorial.dataMapping.DataMappingTutorial.controllers;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.EmployeeEntity;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }

    @PutMapping("/{employeeId}")
    public EmployeeEntity updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeEntity employeeEntity){
        return employeeService.updateEmployee(employeeId,employeeEntity);
    }


}

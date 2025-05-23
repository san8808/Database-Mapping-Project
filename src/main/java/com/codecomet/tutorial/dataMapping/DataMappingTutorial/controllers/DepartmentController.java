package com.codecomet.tutorial.dataMapping.DataMappingTutorial.controllers;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.DepartmentEntity;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return  departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping(path="/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(departmentId,employeeId);
    }


    @GetMapping(path = "/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignedDepartmentOfManager(@PathVariable Long employeeId){
        return departmentService.getAssignedDepartmentOfManager(employeeId);
    }

    @PutMapping(path="/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignWorkerToDepartment(departmentId,employeeId);
    }

    @PutMapping(path="/{departmentId}/freelancers/{employeeId}")
    public DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignFreelancerToDepartment(departmentId,employeeId);
    }


}

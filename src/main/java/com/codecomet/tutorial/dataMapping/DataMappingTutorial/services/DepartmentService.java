package com.codecomet.tutorial.dataMapping.DataMappingTutorial.services;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.DepartmentEntity;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities.EmployeeEntity;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.repositories.DepartmentRepository;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        DepartmentEntity departmentEntity= departmentRepository.findById(departmentId).orElse(null);

        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).orElse(null);

        if(employeeEntity!=null && departmentEntity!=null) {
            departmentEntity.setManager(employeeEntity);
            return departmentRepository.save(departmentEntity);
        }

        return null;


    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {

        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).orElse(null);

        if(employeeEntity!=null)
            return employeeEntity.getManagedDepartment();

        return null;
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {

        Optional<DepartmentEntity> departmentEntity =departmentRepository.findById(departmentId);

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department -> employeeEntity.map(employee -> {
                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);

                    department.getWorkers().add(employee);
                    return department;
                }
        )).orElse(null);

    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {

        Optional<DepartmentEntity> departmentEntity =departmentRepository.findById(departmentId);

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department -> employeeEntity.map(employee -> {
                   employee.getFreelanceDepartment().add(department);
                   employeeRepository.save(employee);

                   department.getFreelancers().add(employee);
                   return department;

                }
        )).orElse(null);

    }
}

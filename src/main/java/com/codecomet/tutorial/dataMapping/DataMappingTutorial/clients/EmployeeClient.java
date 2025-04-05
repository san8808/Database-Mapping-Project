package com.codecomet.tutorial.dataMapping.DataMappingTutorial.clients;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.advice.ApiResponse;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    ApiResponse<List<EmployeeDTO>> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);


}

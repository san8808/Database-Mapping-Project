package com.codecomet.tutorial.dataMapping.DataMappingTutorial.clients.impl;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.advice.ApiResponse;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.clients.EmployeeClient;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.dto.EmployeeDTO;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    @Autowired
    private RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);


    @Override
    public ApiResponse<List<EmployeeDTO>> getAllEmployees() {

      log.trace("Trying to retrieve all the employees");


        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList =  restClient.get()
                    .uri("employee")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        log.error(new String(response.getBody().readAllBytes()));
                    }))
                    .body(new ParameterizedTypeReference<>() {
                    });

            log.info("Successfully retrived the employees");
            log.trace("Retrieved employees list in getAllEmplyees : {}", employeeDTOList.getDate());
            return employeeDTOList;

        }
        catch (Exception e){

            log.error("Exception occured in getAllEmployees()",e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{
            ApiResponse<EmployeeDTO> employeeResponse= restClient.get()
                    .uri("employee/{employeeId}",employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeResponse.getDate();

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employee")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        System.out.println("Error occured" + response.getBody().readAllBytes());
                        throw new ResourceNotFoundException("could not find the resource");
                    }))
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeDTOApiResponse.getDate();

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package com.codecomet.tutorial.dataMapping.DataMappingTutorial;

import com.codecomet.tutorial.dataMapping.DataMappingTutorial.advice.ApiResponse;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.clients.EmployeeClient;
import com.codecomet.tutorial.dataMapping.DataMappingTutorial.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class DataMappingTutorialApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees(){
		ApiResponse<List<EmployeeDTO>> employeeDTOList = employeeClient.getAllEmployees();

		System.out.println(employeeDTOList.getTimeStamp());
		System.out.println(employeeDTOList.getDate());

		List<EmployeeDTO> employeeDTOS = employeeDTOList.getDate();
		for(EmployeeDTO employee: employeeDTOS){
			System.out.println(employee.getName());
			System.out.println(employee.getAge());
			System.out.println(employee.getDateOfBirth());
		}

		System.out.println(employeeDTOList.getError());
	}

	@Test
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO =employeeClient.getEmployeeById(152L);
		System.out.println(employeeDTO);
		System.out.println(employeeDTO.getName());
	}

	@Test
	void createEmployee(){

		EmployeeDTO employee=new EmployeeDTO(null,"Raghav","rahul@gmail.com","9654677545",2,9277332323297L, LocalDate.of(1997,3,23),"Engineer",LocalDate.now(),true,"ADMIN",LocalDate.now());

		EmployeeDTO employeeDTO = employeeClient.createEmployee(employee);

		System.out.println(employeeDTO);
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
	}

}

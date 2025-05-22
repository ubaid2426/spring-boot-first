package com.crudoperation.springboot_project;

import com.crudoperation.springboot_project.models.Employee;
import com.crudoperation.springboot_project.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}
     @Autowired
     private EmployeeRespository employeeRespository;



	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Ubaid");
//		employee.setLastName("Nadeem");
//		employee.setEmailId("ubaidnadeem@gmail.com");
//		employeeRespository.save(employee);
//
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Awais");
//		employee1.setLastName("Nadeem");
//		employee1.setEmailId("awaisnadeem@gmail.com");
//		employeeRespository.save(employee1);
	}
}

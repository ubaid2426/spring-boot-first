package com.crudoperation.springboot_project.repository;

import com.crudoperation.springboot_project.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {
    //all crud database operation

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastNameAndEmailId(String lastName, String emailId);
}

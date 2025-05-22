package com.crudoperation.springboot_project.controller;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import com.crudoperation.springboot_project.exception.ResponseNotFound;
import com.crudoperation.springboot_project.models.Employee;
import com.crudoperation.springboot_project.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

    @Autowired
    private final EmployeeRespository employeeRespository;
    public EmployeeController(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

   @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRespository.findAll();
    }

//    @GetMapping
//    public List<Employee> getAllEmployees(){
//        return employeeRespository.findByFirstName("Ali");
//    }

    // build create employee Rest Api
    @PostMapping("create-from-json/")
    public ResponseEntity<?> createEmployeeWithJson(@Valid @RequestBody Employee request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmailId(request.getEmailId());

        return new ResponseEntity<>(employeeRespository.save(employee), HttpStatus.CREATED);
    }



    @PostMapping("create-from-params")
    public ResponseEntity<?> createEmployeeFromParams(@Valid @ModelAttribute Employee request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmailId(request.getEmailId());

        return new ResponseEntity<>(employeeRespository.save(employee), HttpStatus.CREATED);
    }




    // build get Api by using Id
    @GetMapping("{Id}/")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long Id){
        Employee employee = employeeRespository.findById(Id)
                .orElseThrow(()-> new ResponseNotFound("Employee not found for this id :: "+Id));
        return ResponseEntity.ok(employee);
    }





    //build update Api
    @PutMapping("{Id}/")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long Id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRespository.findById(Id)
                .orElseThrow(()-> new ResponseNotFound("Employee not found for this id :: "+Id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

         employeeRespository.save(updateEmployee);
         return ResponseEntity.ok(updateEmployee);
    }


    //build Delete Data
    @DeleteMapping("{Id}/")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long Id){
        Employee employee = employeeRespository.findById(Id)
                .orElseThrow(()-> new ResponseNotFound("Employee not found for this id :: "+Id));
        employeeRespository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    // Delete all employees
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        employeeRespository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

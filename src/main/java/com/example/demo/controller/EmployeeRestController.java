package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /employees - returns all employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){

        return employeeService.findAll();

    }

    // GET /employees/{employeeId} - return employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId) {

        Optional<Employee> result = employeeService.findById(employeeId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }

        return theEmployee;

    }

    // POST /employees - add new employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        employee.setId(0);

        return employeeService.save(employee);

    }

    // PUT /employees - update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    // DELETE /employees/{employeeId} - delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){

        employeeService.deleteById(employeeId);

    }




}

package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();

    public Optional<Employee> findById(Integer employeeId);

    public Employee save(Employee employee);

    public void deleteById(Integer employeeId);

}

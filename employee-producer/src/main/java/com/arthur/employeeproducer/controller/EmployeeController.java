package com.arthur.employeeproducer.controller;

import com.arthur.employeeproducer.model.Employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  
  @RequestMapping(value = "/employee", method = RequestMethod.GET)
  public Employee firstPage() {
    Employee employee = new Employee();
    employee.setName("emp1");    
    employee.setDesignation("manager");
    employee.setEmpId("1");
    employee.setSalary(3000);

    return employee;
  }
}

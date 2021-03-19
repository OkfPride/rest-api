/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.spring.mvc.server.controller;

import com.konstantin.spring.mvc.server.entity.Employee;
import com.konstantin.spring.mvc.server.exceptions.IncorrectData;
import com.konstantin.spring.mvc.server.exceptions.MyException;
import com.konstantin.spring.mvc.server.myservise.IServise;
import com.konstantin.spring.mvc.server.myservise.MyServise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JavaDev
 */
@RestController
@RequestMapping(path = "/api")
public class MyRestController {
    
    @Autowired
    private IServise meservise;
    
    @GetMapping(path = "employees")
    public List<Employee> showAll() {
        return meservise.showAllEmployees();
    }
    
    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = meservise.getEmployee(id);
        if (employee == null) {
            throw new MyException("there is no Such Employee with id = " + id);
        }
        return employee;
    }
    
    @DeleteMapping(path = "employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        meservise.delete(meservise.getEmployee(id));
    }
    
    @PutMapping(path = "employee")
    public void updateEmployee() {
        
    }
    
    @PostMapping(path = "employee")
    public void addEmployee(@RequestBody Employee employee) {
        meservise.save(employee);
    }
}

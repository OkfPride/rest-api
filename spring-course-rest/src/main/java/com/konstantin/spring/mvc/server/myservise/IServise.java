/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.spring.mvc.server.myservise;

import com.konstantin.spring.mvc.server.entity.Employee;
import java.util.List;

/**
 *
 * @author JavaDev
 */
public interface IServise {

    List<Employee> showAllEmployees();

    Employee add();

    void save(Employee employee);

    Employee getEmployee(int id);
 
    void delete(Employee employee);
}

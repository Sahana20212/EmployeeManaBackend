package com.ecomm.employee.service;

import java.util.List;

import com.ecomm.employee.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getEmployees();

	boolean deleteEmployee(long id);

}

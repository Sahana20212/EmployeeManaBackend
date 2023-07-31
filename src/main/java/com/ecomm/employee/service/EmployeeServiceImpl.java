package com.ecomm.employee.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.employee.entity.EmployeeEntity;
import com.ecomm.employee.model.Employee;
import com.ecomm.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public Employee createEmployee(Employee employee) {
		
		EmployeeEntity employeeentity= new EmployeeEntity();
		
		BeanUtils.copyProperties(employee,employeeentity);
		// TODO Auto-generated method stub
		
		employeeRepository.save(employeeentity);
		return employee;
	}


	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List <EmployeeEntity> empList= employeeRepository.findAll();
		List<Employee> empList1=empList
				.stream().
				map(emp -> 
		           new Employee(emp.getId(),emp.getFirstName(),
				emp.getLastName(),emp.getEmailId())).collect(Collectors.toList());
         return empList1;
	}


	@Override
	public boolean deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return true;
	}

}

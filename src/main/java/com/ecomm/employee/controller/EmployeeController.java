package com.ecomm.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.employee.model.Employee;
import com.ecomm.employee.service.EmployeeService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	public final EmployeeService employeeService;
	
	//@Autowired
	//private EmployeeService employeeservice;
	
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
		
	}
	
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee ) {
		return employeeService.createEmployee(employee);
		
		
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployees();
		
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteEmployee(@PathVariable long id){
		boolean deleted =false;
		deleted=employeeService.deleteEmployee(id);
		Map<String,Boolean>response=new HashMap<>();
		response.put("deleted", deleted);
		return ResponseEntity.ok(response);
	}

}

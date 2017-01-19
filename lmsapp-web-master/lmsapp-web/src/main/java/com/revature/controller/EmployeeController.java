package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService = new EmployeeService();

	@PostMapping("/save")
	public void save(@RequestBody Employee emp) {
		
		employeeService.save(emp);
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long empId) {
		return employeeService.findById(empId);
	}

	@GetMapping("/searchByEmail")
	public Employee findByEmailId(@RequestParam("email") String emailId) {
		return employeeService.findByEmailId(emailId);
	}

	@PutMapping("/{id}/activate")
	public void activate(@PathVariable("id") Long empId) {
		employeeService.activate(empId);
	}

	@PutMapping("/{id}/deactivate")
	public void deActivate(@PathVariable("id") Long empId) {
		employeeService.deActivate(empId);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long empId, @RequestBody Employee employee) {
		
		employeeService.update(empId,employee);
	}
	// @DeleteMapping("/employee/{id}")
	// public ResponseEntity remove(@PathVariable("id") Long empId) {
	// if (null == employeeService.delete(empId)) {
	// return new ResponseEntity("No employee found for id " + empId,
	// HttpStatus.NOT_FOUND);
	// }
	// return new ResponseEntity(empId, HttpStatus.OK);
	// }

	@GetMapping("/")
	public List<Employee> list() {
		return employeeService.list();
	}

}

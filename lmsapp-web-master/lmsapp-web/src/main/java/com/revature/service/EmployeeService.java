package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public void save(Employee emp) {

		employeeDAO.save(emp);
	}

	public void update(Long empId, Employee emp) {
		employeeDAO.update(empId, emp);
	}

	public Employee findById(Long empId) {

		return employeeDAO.findById(empId);
	}

	public Employee findByEmailId(String emailId) {
		System.out.println(emailId);
		return employeeDAO.findByEmailId(emailId);
	}

	public void activate(Long empId) {

		Employee findById = employeeDAO.findById(empId);
		findById.setActive(true);
		employeeDAO.update(empId, findById);
	}

	public void deActivate(Long empId) {

		Employee findById = employeeDAO.findById(empId);
		findById.setActive(false);
		employeeDAO.update(empId, findById);
	}

	// public Long delete(Long empId) {
	// Employee findById = employeeDAO.findById(empId);
	// if(findById!=null){
	// employeeDAO.delete(empId);
	// return empId;
	// }
	// return null;
	// }

	public List<Employee> list() {

		return employeeDAO.list();
	}

}

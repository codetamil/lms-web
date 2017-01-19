package com.revature.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Employee;
import com.revature.model.Role;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee emp) {

		String sql = "insert into EMPLOYEES ( CODE, NAME, ROLE_ID, EMAIL_ID, MOBILE_NO) values ( ?, ?, ? , ?,?)";
		int rows = jdbcTemplate.update(sql, new Object[] { emp.getCode(), emp.getName(), emp.getRole().getId(),
				emp.getEmailId(), emp.getMobileNo() });
		System.out.println("No of rows inserted:" + rows);

	}

	public void update(Long empId, Employee emp) {

		String sql = "UPDATE EMPLOYEES SET CODE=?, NAME=?, ROLE_ID=?, EMAIL_ID=?, MOBILE_NO= ?, ACTIVE=?, MODIFIED_DATE=NOW() WHERE ID=?";
		int rows = jdbcTemplate.update(sql, emp.getCode(), emp.getName(), emp.getRole().getId(), emp.getEmailId(),
				emp.getMobileNo(), emp.isActive(), empId);
		System.out.println("No of rows updated:" + rows);

	}

	// public void delete(Long empId) {
	//
	// String sql ="DELETE FROM EMPLOYEES WHERE ID= ? ";
	// int rows = jdbcTemplate.update(sql, empId);
	// System.out.println("No of rows deleted:" + rows);
	//
	// }

	public Employee findById(Long id) {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID AND e.ID = ?";

		Employee employee = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {

			Employee emp = new Employee();
			emp.setId(rs.getLong("ID"));
			emp.setCode(rs.getString("CODE"));
			emp.setName(rs.getString("NAME"));
			emp.setEmailId(rs.getString("EMAIL_ID"));
			emp.setMobileNo(rs.getLong("MOBILE_NO"));
			emp.setActive(rs.getBoolean("ACTIVE"));
			emp.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
			emp.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());

			Role r = new Role();
			r.setId(rs.getLong("ROLE_ID"));
			r.setCode(rs.getString("ROLE_CODE"));
			r.setName("ROLE_NAME");

			emp.setRole(r);

			return emp;

		});
		return employee;

	}

	public Employee findByEmailId(String emailId) {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID AND e.EMAIL_ID = ?";

		Employee employee = null;

		try {
			employee = jdbcTemplate.queryForObject(sql, new Object[] { emailId }, (rs, rowNum) -> {

				Employee emp = new Employee();
				emp.setId(rs.getLong("ID"));
				emp.setCode(rs.getString("CODE"));
				emp.setName(rs.getString("NAME"));
				emp.setEmailId(rs.getString("EMAIL_ID"));
				emp.setMobileNo(rs.getLong("MOBILE_NO"));
				emp.setActive(rs.getBoolean("ACTIVE"));
				emp.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
				emp.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());

				Role r = new Role();
				r.setId(rs.getLong("ROLE_ID"));
				r.setCode(rs.getString("ROLE_CODE"));
				r.setName("ROLE_NAME");

				emp.setRole(r);

				System.out.println(emp);
				return emp;

			});
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		System.out.println(employee);
		return employee;

	}

	public List<Employee> list() {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO,e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID";

		List<Employee> employee = jdbcTemplate.query(sql, (rs, rowNum) -> {

			Employee emp = new Employee();
			emp.setId(rs.getLong("ID"));
			emp.setCode(rs.getString("CODE"));
			emp.setName(rs.getString("NAME"));
			emp.setEmailId(rs.getString("EMAIL_ID"));
			emp.setMobileNo(rs.getLong("MOBILE_NO"));
			emp.setActive(rs.getBoolean("ACTIVE"));
			emp.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
			emp.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());

			Role r = new Role();
			r.setId(rs.getLong("ROLE_ID"));
			r.setCode(rs.getString("ROLE_CODE"));
			r.setName("ROLE_NAME");

			emp.setRole(r);

			return emp;

		});
		return employee;

	}
}

package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.dto.EmployeeResponseDto;
import com.hcl.demo.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long employeeId);
	
	public List<Employee> getEmployeeByDesignation(String designation);

	public String deleteEmployee(Long employeeId);

	public Employee updateEmployee(Long employeeId, Employee employee);

	public List<Employee> getEmployeeByFirstName(String firstName);

	public List<Employee> getEmployeeByName(String firstName, String lastName);

	public List<Employee> getEmployeeByNames(String firstName, String lastName);

	public List<Employee> getEmployeeByFirstNameEquals(String firstName);

	public List<Employee> getEmployeeBySalary(double minSalary, double maxSalary);

	public List<Employee> getEmployeeByAgeLessThan(int age);

	public List<Employee> getEmployeeByAgeGreaterThan(int age);

	public List<Employee> getEmployeeByAge(int age);

	public List<Employee> getEmployeeBySalaryAfter(double salary);

	public List<Employee> getEmployeeBySalaryBefore(double salary);

	public List<Employee> getEmployeeByFirstNameStartWith(String firstName);

	public List<Employee> getEmployeeByLastNameEndWith(String lastName);

	public List<Employee> getEmployeeByFirstNameLike(String firstName);

	public List<Employee> getEmployeeByFirstNameNotLike(String firstName);

	public List<Employee> getEmployeeByLastNameNot(String lastName);

	public List<Employee> getEmployeeByOrder(String firstName, String lastName);
	
	public List<Employee> getEmployeeByAgeOrder(int age, String lastName);

	public List<Employee> getEmployeeByAgeNotNull();

	public List<Employee> getEmployeeByLastNameNull();

	public List<EmployeeResponseDto> getCustomEmployee(String firstName);

	public List<EmployeeResponseDto> getCount(String firstName);

	public List<Employee> getEmployeeByNameAndAge(String firstName, int age);

	public List<Employee> getEmployeeByNameHql(String firstName, String lastName);

	public List<Employee> getEmployeeByNameSql(String firstName, String lastName);

	public List<Employee> getAll(int pageNumber,int pageSize);

	public List<Employee> getEmployeesBySorting(int pageNumber, int pageSize);

}

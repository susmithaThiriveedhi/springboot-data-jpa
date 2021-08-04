package com.hcl.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hcl.demo.dto.EmployeeResponseDto;
import com.hcl.demo.entity.Employee;
import com.hcl.demo.repository.EmployeeRepository;
import com.hcl.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long employeeId) {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	public String deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Success";
	}

	public Employee updateEmployee(Long employeeId, Employee employee) {
		Optional<Employee> newEmployee=employeeRepository.findById(employeeId);
		Employee emp=newEmployee.get();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		emp.setAge(employee.getAge());
		emp.setDesignation(employee.getDesignation());
		emp.setSalary(employee.getSalary());
		return employeeRepository.save(emp);
	}
	
	public List<Employee> getEmployeeByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContains(firstName);
	}

	public List<Employee> getEmployeeByName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
	}

	public List<Employee> getEmployeeByNames(String firstName, String lastName) {
		return employeeRepository.findByFirstNameOrLastName(firstName,lastName);
	}

	public List<Employee> getEmployeeByFirstNameEquals(String firstName) {
		return employeeRepository.findByFirstNameEquals(firstName);
	}

	public List<Employee> getEmployeeBySalary(double minSalary, double maxSalary) {
		return employeeRepository.findBySalaryBetween(minSalary,maxSalary);
	}

	public List<Employee> getEmployeeByAgeLessThan(int age) {
		return employeeRepository.findByAgeLessThan(age);
	}

	public List<Employee> getEmployeeByAgeGreaterThan(int age) {
		return employeeRepository.findByAgeGreaterThan(age);
	}

	public List<Employee> getEmployeeByAge(int age) {
		return employeeRepository.findByAgeGreaterThanEqual(age);
	}

	public List<Employee> getEmployeeBySalaryAfter(double salary) {
		return employeeRepository.findBySalaryAfter(salary);
	}

	public List<Employee> getEmployeeBySalaryBefore(double salary) {
		return employeeRepository.findBySalaryBefore(salary);
	}

	public List<Employee> getEmployeeByFirstNameStartWith(String firstName) {
		return employeeRepository.findByFirstNameStartingWith(firstName);
	}

	public List<Employee> getEmployeeByLastNameEndWith(String lastName) {
		return employeeRepository.findByLastNameEndingWith(lastName);
	}

	public List<Employee> getEmployeeByFirstNameLike(String firstName) {
		return employeeRepository.findByFirstNameLike(firstName);
	}

	public List<Employee> getEmployeeByFirstNameNotLike(String firstName) {
		return employeeRepository.findByFirstNameNotLike(firstName);
	}

	public List<Employee> getEmployeeByLastNameNot(String lastName) {
		return employeeRepository.findByLastNameNot(lastName);
	}

	public List<Employee> getEmployeeByOrder(String firstName, String lastName) {
		return employeeRepository.findByFirstNameOrLastNameOrderByLastNameAsc(firstName,lastName);
	}

	public List<Employee> getEmployeeByAgeOrder(int age, String lastName) {
		return employeeRepository.findByAgeOrLastNameOrderByLastNameDesc(age,lastName);
	}

	public List<Employee> getEmployeeByAgeNotNull() {
		return employeeRepository.findByAgeNotNull();
	}

	public List<Employee> getEmployeeByLastNameNull() {
		return employeeRepository.findByLastNameNull();
	}
	
	public List<EmployeeResponseDto> getCount(String firstName) {
		return employeeRepository.countByFirstName(firstName);
	}

	public List<EmployeeResponseDto> getCustomEmployee(String firstName) {
		return employeeRepository.getCustomEmployee(firstName);
	}

	public List<Employee> getEmployeeByNameAndAge(String firstName, int age) {
		return employeeRepository.getEmployeeByNameAndAge(firstName,age);
	}

	public List<Employee> getEmployeeByNameSql(String firstName, String lastName) {
		return employeeRepository.getEmployeeByNameSql(firstName,lastName);
	}

	public List<Employee> getEmployeeByNameHql(String firstName, String lastName) {
		return employeeRepository.getEmployeeByNameHql(firstName,lastName);
	}
	
	public List<Employee> getAll(int pageNumber,int pageSize){
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findAll(pageable).getContent();
	}

	public List<Employee> getEmployeesBySorting(int pageNumber, int pageSize) {
		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC,"firstName"));
		return employeeRepository.findAll(pageable).getContent();
	}

}

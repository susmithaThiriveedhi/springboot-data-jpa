package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.EmployeeResponseDto;
import com.hcl.demo.entity.Employee;
import com.hcl.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
  @Autowired
  EmployeeService employeeService;
  
  @GetMapping("/test")
  public String test() {
	  return "Welcome to HCL!!";
  }
  
  @PostMapping
  public Employee saveEmployee(@RequestBody Employee employee) {
	  return employeeService.saveEmployee(employee); 
  }
  
  @GetMapping
  public List<Employee> getAllEmployees(){
	  return employeeService.getAllEmployees();
  }
  
  @GetMapping("/{employeeId}")
  public Employee getEmployeeById(@PathVariable Long employeeId) {
	  return employeeService.getEmployeeById(employeeId);
  }
  
  @DeleteMapping("/{employeeId}")
  public String deleteEmployee(@PathVariable Long employeeId) {
	  return employeeService.deleteEmployee(employeeId);
  }
   
  @PutMapping("/{employeeId}")
  public Employee updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee) {
	 return employeeService.updateEmployee(employeeId,employee);
  }
  
  @GetMapping("/byDesignation")
  public List<Employee> getEmployeeByDesignation(@RequestParam String designation) {
	  List<Employee> employee= employeeService.getEmployeeByDesignation(designation);
	  if(employee.size()!=0) {
		  return employee;
	  }
	  return null;
  }

  @GetMapping("/byFirstName")
  public List<Employee> getEmployeeByFirstName(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstName(firstName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byName")
  public List<Employee> getEmployeeByName(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByName(firstName,lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byNames")
  public List<Employee> getEmployeeByNames(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByNames(firstName,lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byFirstNameEquals")
  public List<Employee> getEmployeeByFirstNameEquals(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameEquals(firstName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("bySalary")
  public List<Employee> getEmployeeBySalary(@RequestParam double minSalary,@RequestParam double maxSalary){
	  List<Employee> employees=employeeService.getEmployeeBySalary(minSalary,maxSalary);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byAgeLessThan")
  public List<Employee> getEmployeeByAgeLessThan(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAgeLessThan(age);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byAgeGreaterThan")
  public List<Employee> getEmployeeByAgeGreaterThan(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAgeGreaterThan(age);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byAge")
  public List<Employee> getEmployeeByAge(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAge(age);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("bySalaryAfter")
  public List<Employee> getEmployeeBySalaryAfter(@RequestParam double salary){
	  List<Employee> employees=employeeService.getEmployeeBySalaryAfter(salary);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("bySalaryBefore")
  public List<Employee> getEmployeeBySalaryBefore(@RequestParam double salary){
	  List<Employee> employees=employeeService.getEmployeeBySalaryBefore(salary);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byFirstNameStartWith")
  public List<Employee> getEmployeeByFirstNameStartWith(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameStartWith(firstName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byLastNameEndWith")
  public List<Employee> getEmployeeByLastNameEndWith(@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByLastNameEndWith(lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byFirstNameLike")
  public List<Employee> getEmployeeByFirstNameLike(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameLike(firstName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byFirstNameNotLike")
  public List<Employee> getEmployeeByFirstNameNotLike(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameNotLike(firstName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byLastNameNot")
  public List<Employee> getEmployeeByLastNameNot(@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByLastNameNot(lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byOrder")
  public List<Employee> getEmployeeByOrder(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByOrder(firstName,lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byAgeOrder")
  public List<Employee> getEmployeeByAgeOrder(@RequestParam int age,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByAgeOrder(age,lastName);
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byAgeNotNull")
  public List<Employee> getEmployeesByAgeNotNull(){
	  List<Employee> employees=employeeService.getEmployeeByAgeNotNull();
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/byLastNameNull")
  public List<Employee> getEmployeesByLastNameNull(){
	  List<Employee> employees=employeeService.getEmployeeByLastNameNull();
	  if(employees.size()!=0) {
		  return employees;
	  }
	  return null;
  }
  
  @GetMapping("/count")
 	public List<EmployeeResponseDto> getCount(@RequestParam String firstName){
 		return employeeService.getCount(firstName);
 }
  
  @GetMapping("/customEmployee")
	public List<EmployeeResponseDto> getCustomEmployee(@RequestParam String firstName){
		return employeeService.getCustomEmployee(firstName);
	}
  
  @GetMapping("/byNameAndAge")
	public List<Employee> getEmployeeByNameAndAge(@RequestParam String firstName, @RequestParam int age){
		return employeeService.getEmployeeByNameAndAge(firstName, age);
	}
  
  @GetMapping("/searchByNames")
	public List<Employee> getEmployeeByNameHql(@RequestParam String firstName, @RequestParam String lastName){
		return employeeService.getEmployeeByNameHql(firstName, lastName);
	}
  
  @GetMapping("/searchByName")
	public List<Employee> getEmployeeByNameSql(@RequestParam String firstName, @RequestParam String lastName){
		return employeeService.getEmployeeByNameSql(firstName, lastName);
	}
  
  @GetMapping("/byPageNumber")
   public List<Employee> getAll(@RequestParam int pageNumber,@RequestParam int pageSize){
	  return employeeService.getAll(pageNumber, pageSize);
  }
  
  @GetMapping("/byPageSort")
  public List<Employee> getEmployeesBySorting(@RequestParam int pageNumber,@RequestParam int pageSize){
	  return employeeService.getEmployeesBySorting(pageNumber, pageSize);
  }
  
} 

package com.hcl.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.EmployeeRequestDto;
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
  public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
	  return new ResponseEntity<Employee>(employeeService.saveEmployee(employeeRequestDto),HttpStatus.CREATED); 
  }
  
  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees(){
	  return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
  }
  
  @GetMapping("/{employeeId}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
	  return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
  }
  
  @DeleteMapping("/{employeeId}")
  public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
	  return new ResponseEntity<String>(employeeService.deleteEmployee(employeeId),HttpStatus.OK);
  }
   
  @PutMapping("/{employeeId}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee) {
	 return new ResponseEntity<Employee>(employeeService.updateEmployee(employeeId,employee),HttpStatus.OK);
  }
  
  @GetMapping("/byDesignation")
  public ResponseEntity<?> getEmployeeByDesignation(@RequestParam String designation) {
	  List<Employee> employees= employeeService.getEmployeeByDesignation(designation);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }

  @GetMapping("/byFirstName")
  public ResponseEntity<?> getEmployeeByFirstName(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstName(firstName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byName")
  public ResponseEntity<?> getEmployeeByName(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByName(firstName,lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byNames")
  public ResponseEntity<?> getEmployeeByNames(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByNames(firstName,lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byFirstNameEquals")
  public ResponseEntity<?> getEmployeeByFirstNameEquals(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameEquals(firstName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("bySalary")
  public ResponseEntity<?> getEmployeeBySalary(@RequestParam double minSalary,@RequestParam double maxSalary){
	  List<Employee> employees=employeeService.getEmployeeBySalary(minSalary,maxSalary);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byAgeLessThan")
  public ResponseEntity<?> getEmployeeByAgeLessThan(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAgeLessThan(age);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byAgeGreaterThan")
  public ResponseEntity<?> getEmployeeByAgeGreaterThan(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAgeGreaterThan(age);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byAge")
  public ResponseEntity<?> getEmployeeByAge(@RequestParam int age){
	  List<Employee> employees=employeeService.getEmployeeByAge(age);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("bySalaryAfter")
  public ResponseEntity<?> getEmployeeBySalaryAfter(@RequestParam double salary){
	  List<Employee> employees=employeeService.getEmployeeBySalaryAfter(salary);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("bySalaryBefore")
  public ResponseEntity<?> getEmployeeBySalaryBefore(@RequestParam double salary){
	  List<Employee> employees=employeeService.getEmployeeBySalaryBefore(salary);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byFirstNameStartWith")
  public ResponseEntity<?> getEmployeeByFirstNameStartWith(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameStartWith(firstName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byLastNameEndWith")
  public ResponseEntity<?> getEmployeeByLastNameEndWith(@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByLastNameEndWith(lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byFirstNameLike")
  public ResponseEntity<?> getEmployeeByFirstNameLike(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameLike(firstName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byFirstNameNotLike")
  public ResponseEntity<?> getEmployeeByFirstNameNotLike(@RequestParam String firstName){
	  List<Employee> employees=employeeService.getEmployeeByFirstNameNotLike(firstName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byLastNameNot")
  public ResponseEntity<?> getEmployeeByLastNameNot(@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByLastNameNot(lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byOrder")
  public ResponseEntity<?> getEmployeeByOrder(@RequestParam String firstName,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByOrder(firstName,lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byAgeOrder")
  public ResponseEntity<?> getEmployeeByAgeOrder(@RequestParam int age,@RequestParam String lastName){
	  List<Employee> employees=employeeService.getEmployeeByAgeOrder(age,lastName);
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byAgeNotNull")
  public ResponseEntity<?> getEmployeesByAgeNotNull(){
	  List<Employee> employees=employeeService.getEmployeeByAgeNotNull();
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/byLastNameNull")
  public ResponseEntity<?> getEmployeesByLastNameNull(){
	  List<Employee> employees=employeeService.getEmployeeByLastNameNull();
	  if(employees.size()!=0) {
		  return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	  }
	  return new ResponseEntity<String>("Does Not Exist",HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/count")
 	public ResponseEntity<List<EmployeeResponseDto>> getCount(@RequestParam String firstName){
 		return new ResponseEntity<List<EmployeeResponseDto>>(employeeService.getCount(firstName),HttpStatus.OK);
 }
  
  @GetMapping("/customEmployee")
	public  ResponseEntity<List<EmployeeResponseDto>> getCustomEmployee(@RequestParam String firstName){
		return new ResponseEntity<List<EmployeeResponseDto>>(employeeService.getCustomEmployee(firstName),HttpStatus.OK);
	}
  
  @GetMapping("/byNameAndAge")
	public ResponseEntity<List<Employee>> getEmployeeByNameAndAge(@RequestParam String firstName, @RequestParam int age){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameAndAge(firstName, age),HttpStatus.OK);
	}
  
  @GetMapping("/searchByNames")
	public ResponseEntity<List<Employee>> getEmployeeByNameHql(@RequestParam String firstName, @RequestParam String lastName){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameHql(firstName, lastName),HttpStatus.OK);
	}
  
  @GetMapping("/searchByName")
	public ResponseEntity<List<Employee>> getEmployeeByNameSql(@RequestParam(required=false) String firstName, @RequestParam @Size(min = 4, max = 12) String lastName){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameSql(firstName, lastName),HttpStatus.OK);
	}
  
  @GetMapping("/byPageNumber")
   public ResponseEntity<List<Employee>> getAll(@RequestParam int pageNumber,@RequestParam int pageSize){
	  return new ResponseEntity<List<Employee>>(employeeService.getAll(pageNumber, pageSize),HttpStatus.OK);
  }
  
  @GetMapping("/byPageSort")
  public ResponseEntity<List<EmployeeRequestDto>> getEmployeesBySorting(@RequestParam int pageNumber,@RequestParam int pageSize){
	  return new ResponseEntity<List<EmployeeRequestDto>>(employeeService.getEmployeesBySorting(pageNumber, pageSize),HttpStatus.OK);
  }
  
} 

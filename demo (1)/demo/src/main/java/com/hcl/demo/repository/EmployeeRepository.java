package com.hcl.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.demo.dto.EmployeeResponseDto;
import com.hcl.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee> findByDesignation(String designation);

	List<Employee> findByFirstNameContains(String firstName);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

	List<Employee> findByFirstNameEquals(String firstName);

	List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

	List<Employee> findByAgeLessThan(int age);

	List<Employee> findByAgeGreaterThan(int age);

	List<Employee> findByAgeGreaterThanEqual(int age);

	List<Employee> findBySalaryAfter(double salary);

	List<Employee> findBySalaryBefore(double salary);

	List<Employee> findByFirstNameStartingWith(String firstName);

	List<Employee> findByLastNameEndingWith(String lastName);

	List<Employee> findByFirstNameNotLike(String firstName);

	List<Employee> findByFirstNameLike(String firstName);

	List<Employee> findByLastNameNot(String lastName);

	List<Employee> findByFirstNameOrLastNameOrderByLastNameAsc(String firstName, String lastName);

	List<Employee> findByAgeOrLastNameOrderByLastNameDesc(int age, String lastName);

	List<Employee> findByAgeNotNull();

	List<Employee> findByLastNameNull();
	
	List<EmployeeResponseDto> countByFirstName(String firstName);
	
	@Query("select new com.hcl.demo.dto.EmployeeResponseDto(firstName, count(*)) from Employee where firstName=:firstName")
	List<EmployeeResponseDto> getCustomEmployee(@Param("firstName") String firstName);

	@Query("from Employee where firstName=:firstName or age=:age")
	List<Employee> getEmployeeByNameAndAge(@Param("firstName") String firstName,@Param("age") int age);
	
	@Query("from Employee where firstName=:firstName and lastName=:lastName")
	List<Employee> getEmployeeByNameHql(@Param("firstName") String firstName,@Param("lastName") String lastName);

	@Query(value="select * from employee e where e.first_name=:firstName or e.last_name=:lastName",nativeQuery=true)
	List<Employee> getEmployeeByNameSql(@Param("firstName") String firstName,@Param("lastName") String lastName);

}

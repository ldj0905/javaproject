package com.itwill.springboot3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	// JPA query method 작성 방법:
	// JAP 에서 약속된 키워드들을 메서드 이름을 (camel 표기법으로) 작성할 때 사용.
	
	// select * from employees where department_id = ?
	List<Employee> findByDepartmentId(Integer id); // 메서드를 선언만 해준다. 
	
	// 이름(firstName)으로 검색:
	// select * from employees where first_name = ?
	List<Employee> findByFirstName(String firstName);
}

package com.itwill.springboot3.query;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.repository.EmployeeRepository;



@SpringBootTest
public class EmployeeQueryTest {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void test() {
		List<Employee> list;
		list = empRepo.findByFirstName("Steven");
		
		list.forEach(System.out::println);
	}
	
	
}

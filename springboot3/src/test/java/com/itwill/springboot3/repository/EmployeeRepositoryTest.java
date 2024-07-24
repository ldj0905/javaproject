package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired // 의존성 주입
	private EmployeeRepository empRepo;
	
//	@Test
	public void testDependencyInjection() {
		// employeeRepository 객체를 의존성 주입을 받을 수 있는 지 테스트.
		assertThat(empRepo).isNotNull();
		log.info("empRepo={}",empRepo);
		/*
		 * Repository<T, ID>
		 * |__ CrudRepository<T, ID>, PagingAndSortingRepository<T,ID>
		 *     |__JpaReapository<T, ID>
		 *     	  |__EmployeeRepository<T,ID>
		 * 	   	  	 |__ ListCrudRepository<T, ID> 
		 */
	}
	
//	@Test
	public void testFindAll() {
		// employees 테이블 전체 검색 테스트:
		long count = empRepo.count();
		assertThat(count).isEqualTo(107L);
		List<Employee> list = empRepo.findAll();
		log.info("employees[0]={}",list.get(0));
	}
	@Transactional //fetch파일 lazy일때 가지고와야함. junit실패할 수있음
	@Test
	public void testFindById() {
		//1. EmployeeRepository.findById() 메서드 테스트
		//2. Employees 테이블과 Jobs 테이블의 관계 테스트
		//3. Employees 테이블과 Employees 테이블 간의 관계 테스트
		//(MANAGER_ID - EMPLOYEE_ID)
		
		//테이블에 id(사번)가 존재하는 경우: 
		Employee emp =  empRepo.findById(101).orElseThrow();
		log.info("emp={}", emp);
		log.info("emp.job={}",emp.getJob());
		log.info("emp.manager={}",emp.getManager());
	}
	
}

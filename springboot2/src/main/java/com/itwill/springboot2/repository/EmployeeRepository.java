package com.itwill.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot2.domain.Employee;

/*
 * Repository<T, ID>
 * |__ CrudRepository<T, ID>, PagingAndSortingRepository<T, ID>
 * 	   |__JpaRepository<T, ID>
 * 상속관계에 대해 설명
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

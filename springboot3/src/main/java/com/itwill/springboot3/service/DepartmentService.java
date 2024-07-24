package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class DepartmentService {
	private final  DepartmentRepository depRepo;
	
	public List<Department> read(){
		log.info("read()");
		return depRepo.findAll();
	}

	public Department read(Integer id){
			
		log.info("read(id={})", id);
		
		return  depRepo.findById(id).orElseThrow();
	}
}

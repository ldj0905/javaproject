package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Country;
import com.itwill.springboot3.repository.CountryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CountryService {
	private final  CountryRepository cntRepo;
	
	public List<Country> read(){
		log.info("read()");
		return cntRepo.findAll();
	}

	public Country read(String id){
			
		log.info("read(id={})", id);
		
		return  cntRepo.findById(id).orElseThrow();
	}
}

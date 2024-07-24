package com.itwill.springboot3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.itwill.springboot3.domain.Location;
import com.itwill.springboot3.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor //-> final 필드를 초기화하는 생성자. 생성자에 의한 의존성 주입.
@Controller
@RequestMapping("/location")
public class LocationController {
    
    // 생성자에 의한 의존성 주입: (1) RequiredArgsConstructor + (2) final field
    private final LocationService locSvc;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list()");
        
        // 서비스(비즈니스) 계층의 메서드를 호출해서 (데이터베이스의) 직원 목록을 불러옴.
        List<Location> list = locSvc.read();
        
        // 직원 목록을 뷰 템플릿에게 전달.
        model.addAttribute("locations", list);
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model) {
    	log.info("details(id={})",id);
    	Location loc = locSvc.read(id);
    	model.addAttribute("location",loc);
    	
    	return "/location/details";
    }
    
   
    
}
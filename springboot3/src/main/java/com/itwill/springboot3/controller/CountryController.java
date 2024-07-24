package com.itwill.springboot3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Country;
import com.itwill.springboot3.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor //-> final 필드를 초기화하는 생성자. 생성자에 의한 의존성 주입.
@Controller
@RequestMapping("/country")
public class CountryController {
    
    // 생성자에 의한 의존성 주입: (1) RequiredArgsConstructor + (2) final field
    private final CountryService cntSvc;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list()");
        
        // 서비스(비즈니스) 계층의 메서드를 호출해서 (데이터베이스의) 직원 목록을 불러옴.
        List<Country> list = cntSvc.read();
        
        // 직원 목록을 뷰 템플릿에게 전달.
        model.addAttribute("countries", list);
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model) {
    	log.info("details(id={})",id);
    	Country cnt = cntSvc.read(id);
    	model.addAttribute("country",cnt);
    	
    	return "/country/details";
    }
    
   
    
}
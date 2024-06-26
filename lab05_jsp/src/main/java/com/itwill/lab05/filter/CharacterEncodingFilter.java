package com.itwill.lab05.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;
	
	private String encoding;
	private static final Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// web.xml에서 <filter>의 <param-name> 값을 아규먼트로 전달하면,
		// <filter>의 <param-value> 값을 리턴해줌.
		encoding = filterConfig.getInitParameter("encoding");
		
		log.debug("init: encoding={}", encoding);
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청(request) 객체의 문자열 인코딩 타입을 (UTF-8)로 설정:
		request.setCharacterEncoding(encoding);
		
		// 다음 필터 체인을 진행(-> 서블릿 메서드(doGet, doPost) 호출)
		chain.doFilter(request, response);
		
		
	}

}

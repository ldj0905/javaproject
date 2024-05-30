package com.itwill.lab05.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet(name = "frontController", urlPatterns = {""})
//context root(http://localhost:8080/labo5)로 들어오는 요청을 처리하는 서블릿!
public class FrontController extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FrontController.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FrontController#doGet");
		log.debug("doGet");
		// DB posts 테이블에서 전체 검색을 하고, 그 결과를 뷰에 전달.
		//List<Post> list = PostService.read();
		
		request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
	}

	
	
}

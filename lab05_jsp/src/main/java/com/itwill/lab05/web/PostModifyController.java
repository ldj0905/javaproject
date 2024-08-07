package com.itwill.lab05.web;

import java.io.IOException;

import org.apache.catalina.servlets.WebdavServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postModifyController", urlPatterns = {"/post/modify"})
public class PostModifyController extends WebdavServlet{

	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostModifyController.class);
	
	private  final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			
		log.debug("doGet()");
		
		//상세보기-> 수정하기로 들어온것
		
		//query String에 포함된 요청 파라미터 id 값을 읽음.
		int id = Integer.parseInt(request.getParameter("id"));
		log.debug("id={}", id);
		
		//서비스 계층의 메서드를 호출해서 수정하기 전에 post 객체를 읽음.
		Post post = postService.read(id); 
		// 수정 전의 Post 객체를 뷰에 전달.
		request.setAttribute("post", post);
		//뷰로 이동(forword)
		request.getRequestDispatcher("/WEB-INF/views/post/modify.jsp").forward(request, response);
			
	}

}

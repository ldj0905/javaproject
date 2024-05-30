package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name ="PostDetailsController", urlPatterns = "/post/details") //쿼리스트링 바로 앞에있는거까지만 urlpatterns를 넣는다
public class PostDetailsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDetailsController.class); //클래스이름이 있어야 클래스 이름이 찍힘
	
	private final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()"); //get방식인지 post방식인지 알려주기위해서.
		
		// 질의 문자열(query string)에 포함된 요청 파라미터 id 값을 읽음.
		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id= {}", id);
		// 서비스 계층의 메서드를 호출해서 해당 id의 post 정보를 db에서 읽음.
		Post post = postService.read(id); 
		// post 객체를 뷰(jsp)에게 전달. 뷰가 html을 그릴수 있도록 해준다.
		// 검색된 post 객체를 뷰(JSP)에게 전달.
		req.setAttribute("post", post);

		
		//뷰로 이동(foward) 
		req.getRequestDispatcher("/WEB-INF/views/post/details.jsp").forward(req, resp); //저런 파일에다가 넣을예정임
	}
	
}

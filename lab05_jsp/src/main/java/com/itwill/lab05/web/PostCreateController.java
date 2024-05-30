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

//HttpServlet 상속받기
@WebServlet(name = "PostCreateController", urlPatterns = { "/post/create" }) // <<< 얘 왜하는건지 생각좀 해보기
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PostCreateController.class); // 얘는 왜 쓰는거고 클래스이름은 왜넣는지
	private final PostService postService = PostService.INSTANCE;

	// 링크를 클릭해서 들어오는거는 GET방식임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		// TODO 새 글을 작성할 수있는 폼(양식)을 작성하는 뷰(JSP)로 이동 시켜주는 역할.
		// JSP로 이동시키는이유 -> 귀찮아서
		req.getRequestDispatcher("/WEB-INF/views/post/create.jsp").forward(req, resp); // 주소 왜 WEB-INF 부터 ?
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");
		;
		// TODO 폼에서 사용자가 입력을 다함 저장 버튼을 누름. 그럼 이제 포스트를받아서 서비스 전달해서
		// 서비스랑 DAO하고 DB에 저장 여기서 포스트를 받음 사용자가 입력한 제목 내용 작성자를 받는다. (req)에 있음
		// 요청(request)에 포함된 정보들(제목, 내용, 작성자)을 읽음.
		// request.getParameter(arg) 메서드의 아규먼트는 요청 파라미터 이름. name 속성의 값
		String title = req.getParameter("title");// getParameter 리턴타입 무조껀 String
		String content = req.getParameter("content");
		String author = req.getParameter("author");
		// post를 만들어주는 객체에게 post를 만들어주기
		Post post = Post.builder().title(title).content(content).author(author).build();
		log.debug("post ={}", post);
		// 서비스 객체의 메서드를 호출해서 DB에 저장.
		postService.create(post);
		// 페이지를 이동시킨다.
		// 포스트 목록페이지로 이동시킬예정 주의해야할건 루트부터 써줘야한다.
		String url = req.getContextPath() + "/post/list";
		log.debug("redirect: " + url);
		resp.sendRedirect(url);
		// PRG(Post-Rediredct-Get)

	}
	
	
}

package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/application-context.xml"} 
		//얘가 있어야 스프링 컨테이너가 가지고있는 bean을 생성할수 있음
		)

public class CommentDaoTest {
	@Autowired // 스프링 컨테이너가 생성/관리하는 빈을 주입받음. 
	private CommentDao commentDao; 
	
	
	
	
	
//	@Test
	public void testSelect() {
		List<Comment> list = commentDao.selectByPostId(12);
		for (Comment c : list) {
			log.debug(c.toString());
		}
	}
	
//	@Test
	public void testInsert() {
		Comment comment = Comment.builder()
				.postId(12).username("admin아?님").ctext("메끼얏호우")
				.build();
		int result = commentDao.insert(comment);
		Assertions.assertEquals(1,  result);
	}
	
//	@Test
	public void testupdate() {
		Comment comment = Comment.builder().postId(12).ctext("끼얏1호우와우우").build();
		int result = commentDao.update(comment); 
		Assertions.assertEquals(1, result);//update의 result가 1과 같다고 주장 아니면 실패
		
	}
	
//	@Test
	public void testdeleteById() {
		int result = commentDao.deleteById(2);
		Assertions.assertEquals(1, result);
	}
	
//	@Test
	public void testdeleteByPostId() {
		int result = commentDao.deleteByPostId(12);
		Assertions.assertEquals(1, result);
	}

//	@Test
	public void testCommentCount() {
		int result = commentDao.selectCommentCount(12);
		Assertions.assertEquals(3, result);
		//select를 한 행의 갯수 = 지금은 3
	}
	
//	@Test
	public void testselectById() {
		//테이블에 아이디가(PK)가 있는 경우
		Comment comment1 = commentDao.selectById(7);
		Comment comment2 = commentDao.selectById(1);
		Assertions.assertNotNull(comment1);
		log.debug(comment1.toString());
		Assertions.assertNotNull(comment2);
		log.debug(comment2.toString());
	}
	
	
}

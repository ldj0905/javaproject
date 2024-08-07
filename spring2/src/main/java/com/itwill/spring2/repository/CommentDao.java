package com.itwill.spring2.repository;

import java.util.List;

// mapper xml 파일과 연결.
public interface CommentDao {
	
	// 포스트에 달려 있는 모든 댓글 검색
	List<Comment> selectByPostId(Integer postid);

	//포스트에 새로운 댓글 추가
	int insert(Comment comment);
	
	//댓글 내용, 수정 시간을 업데이트
	int update(Comment comment);
	
	//댓글 아이디로 삭제
	int deleteById(Integer id);
	
	//포스트에 달려 있는 모든 댓글을 삭제
	int deleteByPostId(Integer postId);
	
	//포스트에 달려 있는 댓글 갯수를 검색
	Integer selectCommentCount(Integer postId);
	
	//댓글 아이디(PK)로 검색하기
	Comment selectById(Integer id);
	
}

package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Comment;

import lombok.Data;

// 댓글 업데이트 요청의 요청 파라미터들을 저장하기 위한 DTO
@Data
public class CommentUpdateDto {
	private Integer id;
	private String ctext;
	
	public Comment toEntity() {

		return Comment.builder().id(id).ctext(ctext).build();
	}
}

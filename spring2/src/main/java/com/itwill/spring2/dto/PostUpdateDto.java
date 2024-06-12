package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

@Data
public class PostUpdateDto {
	//업데이트 요청(POST)의 요청 파라미터들을 저장하기 위한 DTO
	// 어떤 필드들을 생성해야할지 생각할 것 createDto 새글작성 요청 에서 요청 파라미터들을 저장하기위한 dto를 참고
	
	private Integer id;
	private String title;
	private String content;
	
	
	public Post toEntity() {
		return Post.builder().id(id).title(title).content(content).build();
	}
}

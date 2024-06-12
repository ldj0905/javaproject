package com.itwill.spring2.dto;

import java.time.LocalDateTime;

import com.itwill.spring2.repository.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class PostSearchDto {
	
	private Integer id;
	private String title;
	private String author;
	private LocalDateTime modifiedTime;
	private String keyword;
	private String category;
	
    public static PostSearchDto fromEntity(Post post) {
    	return PostSearchDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .modifiedTime(post.getModifiedTime())
                .build();
    }
}

package com.itwill.spring1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data//-> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 기본생성자는 아님
@NoArgsConstructor
@Builder @AllArgsConstructor // 두개 이상도 붙일수있고 꼭 클래스 위에만 붙일필요는없다. Builder넣으면 아규먼트를 갖는 생성자가 생김.
public class UserDto {
	private String username;
	private int age;
	


}

package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//ORM(Object Relation Mapping) -> JPA(Java Persistence API) -> Hibernate 표준처럼 되어버림
@Getter @ToString @EqualsAndHashCode
@Entity  //데이터베이스 테이블과 매핑하는 자바 객체/jakarta 로 시작하는걸로
@Table(name = "EMP") // 클래스이름과 실제 테이블 이름이 다를 때.
@NoArgsConstructor
public class Employee { //테이블이름이 다름. 애너테이션 하나를 더 붙여야함.
	@Id // 객체를 유일하게 구분할 수 있는 것(primary key)
	@Column(name = "EMPNO") //필드 이름과 실제 컬럼 이름이 다를 때. 
	private Integer id;
	
	private String ename;
	
	private String job;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MGR")
	private Employee manager;
	
	private LocalDate hiredate;
	
	@Column(name = "SAL")
	private Double salary;
	
	@Column(name = "COMM")
	private Double commission;
	
	
	@ToString.Exclude //toString 메서드에서 출력 문자열에서 제외/ toString에서 department는 안나옴
	@ManyToOne(fetch = FetchType.LAZY) //쓸때 exclude 랑 꼭 같이 쓰기.
	@JoinColumn(name = "DEPTNO") //EMP 테이블에서 DEPT 테이블과 join하는 컬럼 이름.
	private Department department;
}

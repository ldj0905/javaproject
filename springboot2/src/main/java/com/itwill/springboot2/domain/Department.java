package com.itwill.springboot2.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "DEPT")
public class Department {
	@Id
	@Column(name = "DEPTNO")
	private Integer id;

	private String dname;

	@Column(name = "LOC")
	private String location;
	
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department") //eager ->바로가져오기, lazy -> 필요한것만 가져오기
	//mappedBy: Employee 엔티티에서 @ManyToOne 에너테이션이 설정된 필드 이름.
	private List<Employee> employees;
}
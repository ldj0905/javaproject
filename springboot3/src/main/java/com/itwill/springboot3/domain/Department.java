package com.itwill.springboot3.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Getter @ToString
@EqualsAndHashCode @Entity
@Table(name = "DEPARTMENTS")
public class Department {
	@Id @Column(name="DEPARTMENT_ID")
	private Integer id;
	
	private String departmentName;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MANAGER_ID")
	private Employee manager;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department") //eager ->바로가져오기, lazy -> 필요한것만 가져오기
	//mappedBy: Employee 엔티티에서 @ManyToOne 에너테이션이 설정된 필드 이름.
	private List<Employee> employees;
}

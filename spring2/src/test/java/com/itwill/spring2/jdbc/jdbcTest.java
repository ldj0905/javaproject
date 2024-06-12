package com.itwill.spring2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;import oracle.jdbc.OracleDriver;

@Slf4j // log4j2-slf4j2 라이브러리를 이용한 로그 출력
@ExtendWith(SpringExtension.class) //spring JUnit 테스트를 실행하는 메인 클래스.
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/application-context.xml"} //이파일을 사용할것
		)// 스프링 컨텍스트(환경 변수) 파일(들)의 경로(이름).

public class jdbcTest {

	@Test //테스트 메서드 - 단위 테스트에서 실행할 메서드
	public void testOracleJdbc() throws SQLException { // test 시 public void 파라미터를 갖지않는다
		//JDBC 1. OJDBC 라이브러리를 드라이버 매니저에 등록
		DriverManager.registerDriver(new OracleDriver());
		log.debug("오라클 JDBC 라이브러리 등록 성공");
		
		//JDBC 2. connection 객체 생성
		final String url = "jdbc:oracle:thin:@localhost:1521:xe"; //접속할 url
		final String user ="jspstudy"; //sql 계정
		final String password = "jspstudy"; //sql 패스워드
		Connection conn = DriverManager.getConnection(url, user, password);
		Assertions.assertNotNull(conn); //conn이 null이 아니면 단위 테스트 성공.
		log.debug("conn = {}", conn);
		//JDBC 2. 사용했던 리소스 해제
		conn.close(); 
		log.debug("오라클 연결 해제 성공");
	}
}

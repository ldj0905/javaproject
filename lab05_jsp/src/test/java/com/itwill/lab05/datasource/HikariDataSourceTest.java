package com.itwill.lab05.datasource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HikariDataSourceTest {
	private static final Logger log = LoggerFactory.getLogger(HikariDataSourceTest.class);
	private final DataSourceUtil util = DataSourceUtil.getInstance();
	
	@Test
	public void test() {
		log.debug("test ><");
		
	}
}

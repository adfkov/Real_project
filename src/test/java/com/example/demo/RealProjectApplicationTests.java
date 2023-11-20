package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
 
@SpringBootTest  // 스프링 부트를 기반 테스트를 기동시킨다.
class RealProjectApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	
	@Test
	void contextLoads() {
	}

	@Test 
	void 더하기테스트() {
		logger.debug("####### 더하기 테스트 수행");
		int a = 10;
		int b = 20;
		assertEquals(31, a + b);
		
	}
	
}

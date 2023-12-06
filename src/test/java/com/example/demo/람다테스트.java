package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class 람다테스트 {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void 람다테스트1() {
		List<String> list = List.of("apple", "banana", "grape");
		
		// stream
		list
		.stream()  // stream 객체로 계속 줄줄이 이어지다 
		.filter(e -> e.startsWith("b")) // e는 stream
		.forEach(e -> logger.info("#### {}", e));
	}
	
	@Test
	void 람다테스트2() {
		List<String> list = List.of("apple", "banana", "grape");
		list = list
		.stream()
		.map(e -> e.toUpperCase()) // 대문자 stream
		.collect(Collectors.toList()); // stream to list
		
		logger.info("###### {}", list);
	}
	
	@Test
	void 메소드레퍼런스() {
		List<String> list = List.of("apple", "banana", "grape");
		list = list
		.stream()
		.map(String::toUpperCase) // e -> e.toUpperCase(_
		.collect(Collectors.toList());
	}
}

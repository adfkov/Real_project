package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 자동 스케쥴링 허용
@SpringBootApplication
public class RealProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealProjectApplication.class, args);
	}

}

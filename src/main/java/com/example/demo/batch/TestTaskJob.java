package com.example.demo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // 로그 찍을 거다
public class TestTaskJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Scheduled( cron = "1 * * * * *") // 1분 마다
	public void test() {
		// Job 내용
		logger.info("######## test job 수행");
	}
}

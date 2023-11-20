package com.example.demo.cook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driver {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	
	public static void main(String[] args) {
		try {
			System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH);
		} catch(Exception e) {
			e.printStackTrace();

		}
		//크롬 설정을 담은 객체 생성
		ChromeOptions options = new ChromeOptions();
		//브라우저가 눈에 보이지 않고 내부적으로 돈다.
		//설정하지 않을 시 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "https://www.10000recipe.com";
		
		driver.get(url);
		//브라우저 이동시 생기는 로드시간을 기다린다.
				//HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
		try {Thread.sleep(1000);} catch (InterruptedException e) {}

		List<WebElement> list = driver.findElements(By.className("cate_list"));
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
				System.out.println(list.get(i));
			}
		}
	}

}

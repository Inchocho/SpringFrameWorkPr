package kr.co.ezen;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx
			= new ClassPathXmlApplicationContext("/spring-context.xml");

		//key value로 생각하자 bean id에 키값, 해당 클래스가 밸류값
		HelloDao helloDao = ctx.getBean("helloDao", HelloDao.class);
		
		int result = helloDao.addNum(3, 5);
		
		System.out.println(result);
		
		ScoreDto scoreDto = ctx.getBean("scoreDto", ScoreDto.class);
		
		System.out.println("이름: " + scoreDto.getName());
		System.out.println("국어: " + scoreDto.getKor());
		System.out.println("영어: " + scoreDto.getEng());
	}
}

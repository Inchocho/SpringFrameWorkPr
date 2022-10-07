package kr.co.di;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx
			= new ClassPathXmlApplicationContext("/spring-context.xml");
		
		Score sc = ctx.getBean("score", Score.class);
		Score sc2 = ctx.getBean("score2", Score.class);
				
		Student std = new Student(sc);
		std.name = "이영빈";
		
		std.showStudent();
		
		Student std2 = new Student(sc2);
		std2.name = "삼영빈";
		std2.showStudent();
		
		Student std3 = new Student();
		std3.score = new Score();
		std3.showStudent();
	}

}

package kr.co.ezen;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx
		= new ClassPathXmlApplicationContext("/spring-context.xml");
		
		Car carDao = ctx.getBean("car", Car.class);
		
		carDao.carInfo();
	}
}

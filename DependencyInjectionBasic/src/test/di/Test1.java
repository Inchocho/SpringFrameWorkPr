package test.di;

public class Test1 {

	public static void main(String[] args) {

		//new연산자를 통한 객체생성을 안해도 스프링에서 해줌
		Score sc = new Score(100,90);
		Student std = new Student(sc);
		
		std.name = "밥";
		std.showStudent();
		
		System.out.println();
		
		Student std2 = new Student();
		std2.name = "김밥";
		std2.setScore(sc);
		std2.showStudent();
	}

}

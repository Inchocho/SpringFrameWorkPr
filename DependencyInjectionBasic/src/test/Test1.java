package test;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {

		ArrayList<Student> stdArray = new ArrayList<>();

		Student std = new Student();
		Score sc = new Score(50, 100);

		sc.setEng(65);
		sc.setKor(35);

		std.name = "김똘똘";
		std.score = sc;

		std.showStudent();

		stdArray.add(std);

		Student std2 = new Student();

		std2.name = "박똘똘";
		std2.showStudent();

		stdArray.add(std2);

		stdArray.get(0).showStudent();
		stdArray.get(1).showStudent();

	}

}

package kr.co.di;

public class Student{
	
	String name;
	Score score;
	
	public Student(Score score) {
		this.score = score;
	}
	
	public Student() {
		
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	
	public void showStudent() {
		System.out.println("이름은 " + name);
		score.showScore();
	}
}
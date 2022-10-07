package test.di;

public class Student{
	
	String name;
	Score score;
	
	//DI 의존성 주입형태로 변경한 상태 (Score 객체 생성을 외부에 맡김)
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
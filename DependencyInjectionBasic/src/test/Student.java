package test;

public class Student{
	
	String name;
	Score score;
	
	public Student() {
		// 의존성을 만들고 있는 문장
		// Student클래스는 Score클래스에 의존함 (생성시 score객체를 생성함)
		// 현재 D(dependecy - 의존, = 두 클래스 간의 관계) 상태
		score = new Score(100, 90);
	}
	
	public void showStudent() {
		System.out.println("이름은 " + name);
		score.showScore();
	}
}
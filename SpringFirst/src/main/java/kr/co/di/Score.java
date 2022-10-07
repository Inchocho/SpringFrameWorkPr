package kr.co.di;

public class Score {

	private int kor;
	private int eng;
	
	public Score() {
		
	}
	
	public Score(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}	
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void showScore() {
		System.out.println(kor);
		System.out.println(eng);
	}
}

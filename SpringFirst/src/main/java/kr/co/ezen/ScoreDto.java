package kr.co.ezen;

public class ScoreDto {

	String name;
	int kor;
	int eng;
	
	public ScoreDto() {
		super();
	}

	public ScoreDto(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "ScoreDto [name=" + name + ", kor=" + kor + ", eng=" + eng + "]";
	}
	
}

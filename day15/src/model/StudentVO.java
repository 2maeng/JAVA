package model;

// 학생 데이터 그 자체를 의미함
// 멤버변수 + getter, setter
// toString() 오버라이딩
// 생성자(오버로딩)
public class StudentVO {
	private int num;
	private String name;
	private int score;
	
	StudentVO(int num, String name, int score){
		this.num = num;
		this.name = name;
		this.score = score;
		System.out.println(this.name + " 학생 생성 완료!");
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return this.num + "번 학생" + this.name + " [" + this.score + "점]";
	}
	
}

package class01;

public class StudentVO {
	private int num;
	private String name;
	private int score;
	
	public StudentVO(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;
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
		return this.num + "번 " + this.name + " 학생" + this.score + "점";
	}
	
	
	
}

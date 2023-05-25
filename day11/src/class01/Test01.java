package class01;

class Student{
	private String name;
	private int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
		System.out.println(this.name + "학생 생성완료!");
	}
	
	@Override
	public String toString() {
		return this.name + "학생은 " + this.score + "점 입니다.";
	}
	
	// private된 멤버변수에 접근 가능하도록하는 "메서드"를 추가로 생성
	// setter : 멤버변수에 값을 설정
	void setName(String name) {
		this.name = name;
	}
	
	void setScore(int score) {
		this.score = score;
	}
	
	// getter : 멤버변수로부터 값을 받아올 수 있도록 해줌
	String getName() {
		return this.name;
	}
	
	int getScore() {
		return this.score;
	}
	
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Student s1 = new Student("똥멍충이", 100);
		s1.setScore(95); // '로그'에 기록됨
		System.out.println(s1);
		
		// [ 로그 ] ★★★★★
		// 기록
		// 하나의 코드로 여러 개발자들이 동시에 작업
		// : 프로젝트 완성시 기여도 측정
		// : 오류가 발생시 어떤 액션 + 어떤 기능에서 발생했는지 기록
		// => 메서드 위주로 기록됨
		// => 단순 연산자X
		
		
		
		
		
		
	}
	
}

package class02;

import java.util.Scanner;

// JAVA의 기본단위 == class

// '학생' 코딩해줘.
class Student{ // 클래스는 대문자로 시작
	String name;
	int score;
	// 상태 : 멤버변수, 필드, 속성
	
	// 오버로딩
	Student(String name){
		this.name = name;
		this.score = 0; // 아직 전학생이라 시험을 안 봤기 때문에
		System.out.println(name + "학생 출석부에 입력완료!");
	}
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
		System.out.println(name + "학생 출석부에 입력완료!");
	}
	
	// static == "객체와 무관하게"
	void hello() {
		System.out.println("안녕, 난" + name + "야." + score + "점");
	}
	// 동작(기능) : 멤버함수, 메서드
	// 메서드는 함수에게 주어(주체)가 생긴 것!
}

public class Test1 {

	public static void main(String[] args) {
		
		// new를 사용해서 heap메모리 생성
		// class02.Student@6f2b958e
		// class02.Student@5e91993f
		// class02.Student@1c4af82c
		
		Student student1 = new Student("아무무", 97);
		// 클래스	객체	= new 생성자();
		// 클래스는 자료형의 역할
		// 객체는 변수, 붕어빵의 역할
		// 클래스로부터 객체를 생성할때에는
		// new 생성자()가 반드시 필요하며
		// 객체화(인스턴스화)
		// 교재, 유튜브, 인강, 블로그 -> "인스턴스" new해서 나온 객체
		Student student2 = new Student("티모");
		Student student3 = new Student("아리");
		
		student1.hello();
		student2.hello();
		student3.hello();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

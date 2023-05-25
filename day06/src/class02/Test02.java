package class02;

// 클래스
class Book{
	// 멤버 변수
	String title;
	int price;
	
	// 메서드
	void printInfo() {
		System.out.println(title + "은(는)" + price + "원 입니다.");
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		// 객체들
		Book b1 = new Book(); // 선언하지 않아도 기본적으로 제공되는 생성자
		Book b2 = new Book(); // 기본(디폴트) 생성자 : 인자없음
		// 생성자(함수)
		// 1. 클래스와 이름이 같고
		// 2. 객체를 생성할 수 있으며
		// 3. new 연산자와 함께 사용
		
		b1.title = "어린왕자";
		b1.price = 7800;
		b1.printInfo();
		
		// 15 ~ 23라인까지 함수는 총 4개
		// 함수 1개
		// 메서드 1개
		// 생성자 2개
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

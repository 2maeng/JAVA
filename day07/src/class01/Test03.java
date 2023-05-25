package class01;

class A{
	int a; // 멤버변수, 필드, 속성
	// 인스턴스 변수
	// : 각각의 객체들이 고유한 값을 저장, 객체들끼리 값을 공유 X
	
	static int b; 
	// 객체와 무관하게
	// 클래스 변수, 공유 자원
	// : 주인이 클래스라서 객체들끼리 값을 공유 O
	
	void printInfo() {
		System.out.println("a = " + this.a);
		System.out.println("b = " + this.b);
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		A a1 = new A(); // a1 객체 생성
		a1.a = 10; // a1의 멤버변수 a를 10으로 설정
		a1.b = 10; // a1의 멤버변수 b를 10으로 설정 -> 11
		A a2 = new A(); // a2 객체 생성
 		a2.a = 10; // a2의 멤버변수 a를 10으로 설정 -> 11
		a2.b = 10; // a2의 멤버변수 b를 10으로 설정 -> 11
		a2.a++;
		a2.b++; // 값을 다같이 공유
		
		a1.printInfo();
		a2.printInfo();
	}
	
}

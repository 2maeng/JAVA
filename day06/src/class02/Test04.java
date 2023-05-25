package class02;

// Point 1. 지역변수 vs 멤버변수
// Point 2. 멤버변수에 대입연산자 사용 xxx
// 			-> 생성자를 정의하여 해결!
class Circle1{
	String name;
	int radius;
	double PI;
	double area;
	
	// 생성자
	// 1. input
	// 2. output xxxxx -> 당연히 객체이기 때문
	// 3. 생성자 함수명 == 클래스명
	// ★★★ 생성자의 존재이유 ★★★
	// : 멤버변수의 값들을 초기화하기 위해서 사용
	Circle1(String name, int radius) { // 언제나 객체이기 때문에 output 쓰지않음
		this.name = name;
		this.radius = radius;
		this.PI = 3.14;
		this.area = this.radius * this.radius * this.PI;
		System.out.println(this.name + "이(가) 생성완료!");
	}
	
	void printInfo() {
		// 갈색 : 지역변수
		// 파랑 : 멤버변수
		System.out.println(this.name + "는(은) 넓이가" + this.area + "입니다.");
	}
}

public class Test04 {

	public static void main(String[] args) {
		
		// 생성자를 1개라도 제작하게되면,
		// 더이상 기본생성자는 제공되지 않습니다.
		Circle1 c1 = new Circle1("피자", 10);
		Circle1 c2 = new Circle1("도넛", 1);
		
		c1.printInfo();
		c2.printInfo();
	}
	
}

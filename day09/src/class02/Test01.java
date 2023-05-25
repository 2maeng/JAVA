package class02;


class A{ // 기존에 있었던 클래스
	// 부모 클래스, 상위 클래스
	int a;
	
//	A(){
//		System.out.println("A() 기본생성자 호출완료!");
//	}
	
	A(int a){
		this.a = a;
		System.out.println("A() 기본 생성자 호출완료!");
	}
	
	void funcA() {
		System.out.println("a = " + this.a);
	}
}

// 부모 클래스에서는 자식 클래스의 내용에 접근 X
// 자식 클래스에서는 부모 클래스의 멤버변수, 메서드에 접근 O
class B extends A{ // 기존에 존재했던 클래스를 보고 추가로 구현한 클래스
	// 자식 클래스, 하위 클래스
	int b;
	
	B(){
		super(1234); // super() -> 생성자 -> 클래스 : 에러
		// super() => this()와 유사
		// this() : 자기자신 클래스의 생성자
		// super() : 자신의 부모 클래스의 생성자
		this.b = b;
	}
	
	void funcB() {
		System.out.println("b = " + this.b);
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		A aaa = new A(123); // 객체화(인스턴스화) -> 붕어빵 틀을 만든다고 생각하면 이해가 쉬움
//		aaa.a = 10; // aaa -> a, funcA()
		
		B bbb = new B(); // bbb -> a, b, funcA(), funcB()
//		bbb.a = 22;
		bbb.b = 20;
		
		aaa.funcA();
		
		System.out.println();
		
		bbb.funcB();
		bbb.funcB();
		
	}
	
}

package class01;

class A{
	int num;
	
	A(int num){
		this.num = num;
	}
	
	void printInfo() {
		System.out.println("A : " + this.num);
	}

	@Override
	public boolean equals(Object obj) {
		
		A a = (A)obj;
		
		if(this.num == a.num) {
			return true;
		}
		return false;
	}
	
	
}

class B extends A{
	B(int num){
		super(num);
	}
}

class C extends A{
	C(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		B b1 = new B(1);
		B b2 = new B(1); // B클래스의 객체들은 1
		C c1 = new C(2); // C클래스의 객체들은 2
		
		// 1. 현재 equals()는 Object 클래스의 것
		// 	  -> 주소값을 비교중
		// 2. 오버라이딩
		if(b1.equals(b2)) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

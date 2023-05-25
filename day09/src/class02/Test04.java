package class02;

// 선생님 풀이
class Shape1{
	String name;
	double area;
	
	Shape1(String name){ // 나랑 다른 것.
		this(name, 0.0);
	}
	
	Shape1(String name, double area){
		this.name = name;
		this.area = area;
	}
	
	void printArea() {
		System.out.println(this.name + "의 넓이는" + this.area + "입니다.");
	}
}

// 부모 클래스의 코딩이 완전히 끝나야, 자식 클래스를 코딩한다!

class Circle1 extends Shape{ // 자기가 가진 멤버변수를 모두 초기화 하는지 꼭 확인 필요!
	int r;
	final static double PI = 3.14;
	
	Circle1(int r){
		this("원", r);
	}
	
	Circle1(String name, int r){
		super(name);
		this.r = r;
		this.area = this.r * this.r * Circle.PI;
	}
}

class Rect1 extends Shape{
	int x;
	int y;
	
	Rect1(String name, int x, int y){
		super(name);
		this.x = x;
		this.y = y;
		this.area = this.x * this.y;
	}
}

public class Test04 {

	public static void main(String[] args) {
		
		Circle1 c1 = new Circle1(1);
		Circle1 c2 = new Circle1("도넛", 10);
		c1.printArea();
		c2.printArea();
		
		Rect1 r = new Rect1("네모네모", 3, 4);
		r.printArea();
	}
	
}

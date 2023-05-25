package class01;

// "포켓몬" 객체는 없는것 아닌가요?
// "피카츄, 파이리" 객체만 있으면 되는거 아닌가요?

// [ 추상 클래스 ]
// "객체화 하는것이 목표가 아니라,
// 설계를 하는것이 목표였던 클래스들"
// "클래스들의 기준이 되는것이 목표"

abstract class Shape{
	String name;
	double area;
	
	abstract void draw(); // 추상 메서드
}

class Rect extends Shape {

	@Override
	void draw() {
		System.out.println("네모 그리기");
	}
	
}

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("원 그리기");
	}
	
}

class Tri extends Shape {
	@Override
	void draw() {
		System.out.println("세모 그리기");
	}
}

public class Tset02 {

	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		c1.draw();
		Rect r = new Rect();
		r.draw();
		
	}
	
}

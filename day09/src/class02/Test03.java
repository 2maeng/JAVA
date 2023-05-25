package class02;

// 내 풀이
class Shape{
	String name;
	double area;
	
	Shape(String name){
	this.name = name;
	this.area = area;
	}
	
	void printArea() {
		System.out.println(this.name + "의 넓이는 " + this.area + "입니다.");
	}
}

class Circle extends Shape{
	int r;
	final static double PI = 3.14;
	
	Circle(String name, int r){
		super(name);
		this.r = r;
		this.area = r * r * PI;
	}
}

class Rect extends Shape{
	int x;
	int y;
	
	Rect(String name, int x, int y){
		super(name);
		this.x = x;
		this.y = y;
		this.area = x * y;
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Circle pizza = new Circle("피자", 4);
		Rect box = new Rect("박스", 5, 6);
		
		pizza.printArea();
		box.printArea();
	
		System.out.println("피자의 반지름 = " + pizza.r);
		System.out.println("박스 가로 = " + box.x + ", " + "박스 세로 = " + box.y);
		
	}
	
}

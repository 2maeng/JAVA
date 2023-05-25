package class02;

class Circle{
	// 이름
	// 반지름
	String name;
	int r;
	
	void printInfo() {
		System.out.println(name + "의 넓이는" + (r * r * 3.14) + "입니다.");
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Circle earth = new Circle();
		Circle mars = new Circle();
		
		earth.name = "지구";
		earth.r = 3;
		earth.printInfo();
		
		mars.name = "화성";
		mars.r = 4;
		mars.printInfo();
	}
	
}

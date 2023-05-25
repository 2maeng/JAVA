package class01;

// ※ this()
class Point {
	// 클래스 만들때 생각할 것
	// 1.멤버변수 2.메서드 3.생성자
	int x;
	int y;

	Point(){ // 생성자 역할 : 멤버변수 초기화
		this(0, 0);
	}

	Point(int x){
		this(x, x);
	}

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	void move() {
		this.x++;
		this.y++;
	}

	void move(int x) {
		this.x+=x;
		this.y+=x;
	}

	void move(int x, int y) {
		this.x+=x;
		this.y+=y;
	}

	void printInfo() {
		System.out.println("현재 위치는 (" + this.x + "," + this.y + ")");
	}

}
public class Test01 {

	public static void main(String[] args) {

		Point p1 = new Point();
		Point p2 = new Point(10);
		Point p3 = new Point(1, 2);

		p1.printInfo();
		p1.move();
		
		p2.printInfo();
		p2.move();
		
		p3.printInfo();
		p3.move();

	}

}
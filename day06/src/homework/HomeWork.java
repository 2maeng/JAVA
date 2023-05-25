package homework;

class Point {
	int x;
	int y;
	
	Point(){
		this(0, 0);
	}
	
	Point(int x){ // 고친 부분 1
		this(x, x);
//		this.x = x;
//		this.y = x;s
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void printInfo() {
		System.out.println("현재 위치는 : " + "(" + this.x + "," + this.y + ")");
	}
	
	void move() {
		this.x++;
		this.y++;
		System.out.print("이동한 값은 : ");
		System.out.println("(" + this.x + "," + this.y + ")");
	}
	
	void move(int x) { // 고친 부분 2
			this.x+=x;
			this.y+=x;
			System.out.print("이동한 값은 : ");
			System.out.println("(" + this.x + "," + this.y + ")");
	}
	
	void move(int x, int y) { // 고친 부분 3
		this.x+=x;
		this.y+=y;
		System.out.print("이동한 값은 : ");
		System.out.println("(" + this.x + "," + this.y + ")");
	}
	
}

public class HomeWork {
	
	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point(3);
		Point p3 = new Point(11, 12);
		
		p1.printInfo();
		p1.move();
		p2.printInfo();
		p2.move(3);
		p3.printInfo();
		p3.move(4, 5);
	}
}

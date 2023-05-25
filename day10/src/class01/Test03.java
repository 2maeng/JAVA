package class01;

class Point{
	// 멤버변수
	int x;
	int y;
	
	// 생성자 초기화
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// 출력 메서드
	void printInfo() {
		System.out.println("x = " + this.x + ", y = " + this.y);
	}

	// 최상위 Object 클래스 오버라이딩
	@Override
	public boolean equals(Object obj) {
		
		// 명시적 형변환
		// 다운 캐스팅
		Point p = (Point)obj;
		
		// 점 좌표를 비교
		if((this.x == p.x) && (this.y == p.y)) {
			return true;
		}
		return false;
	}
	
}

// ColorPoint 부모 Point를 상속
class ColorPoint extends Point{
	// 멤버변수 color
	String color;
	
	// ColorPoint 생성자 초기화
	ColorPoint(String color, int x, int y){
		super(x, y);
		this.color = color;
	}

	// 최상위 Object 클래스 오버라이딩
	@Override
	public boolean equals(Object obj) {
		
		// 색깔 비교하기위한 명시적 형변환
		// 스트링 비교는 .equals() -> 오류가 안 뜰 수 있어서 조심
		ColorPoint p = (ColorPoint)obj;
		// 부모 클래스에 형변환 그대로
		
		// 색깔과 좌표를 비교하기
		if((this.color.equals(p.color)) && (this.x == p.x) && (this.y == p.y)) {
			return true;
		}
		return false;
	}
	
	void printInfo() {
		System.out.println("Color = " + this.color + ", x = " + this.x + ", y = " + this.y);
	}
	
}

public class Test03 {

	public static void main(String[] args) {
		
		// 좌표 배열 3개 저장
		Point[] data=new Point[3];
		data[0] = new Point(10, 20);
		data[1] = new Point(123, 20);
		data[2] = new Point(10, 20);
		data[0].printInfo();
		data[1].printInfo();
		data[2].printInfo();
		System.out.println();
	 
		if(data[0].equals(data[1])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		if(data[0].equals(data[2])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		System.out.println();
		
		// 컬러 좌표 배열 3개 저장
		ColorPoint[] data2 = new ColorPoint[3];
		data2[0] = new ColorPoint("파랑", 10, 20);
		data2[1] = new ColorPoint("파랑", 10, 20);
		data2[2] = new ColorPoint("빨강", 10, 20);
		data2[0].printInfo();
		data2[1].printInfo();
		data2[2].printInfo();
		
		System.out.println();
		
		if(data2[0].equals(data2[1])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		if(data2[0].equals(data2[2])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

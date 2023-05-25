package class03;

import java.util.Scanner;

class Point {
	int x;
	int y;

	Point(){
		this(0, 0);
	}

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	void printPoint() {
		System.out.println("(" + this.x + ", " + this.y +")");
	}

	void move() {
		this.x++;
		this.y++;
	}

	void move(int x) {
		this.x += x;
		this.y += x;
	}

	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

}

class ColorPoint extends Point{
	String color;

	ColorPoint(){
		this("검정", 0, 0);
	}

	ColorPoint(int x, int y){
		this("검정", x, y);
	}

	ColorPoint(String color, int x, int y){
		super(x , y);
		this.color = color;
	}

	void printPoint() {
		System.out.println(this.color + "(" + this.x + ", " + this.y +")");
	}

	void changeColor(String color) {
		this.color = color;
	}

	void move() {
		this.x++;
		this.y++;
	}

	void move(int x) {
		this.x += x;
		this.y += x;
	}

	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public boolean equals(Object obj) {
		ColorPoint colorPoint = (ColorPoint)obj;
		if((this.x == colorPoint.x) && (this.y == colorPoint.y) && (this.color.equals(colorPoint.color))) {
			return true;
		}
		return false;
	}


}

public class Test01 {

	public static void main(String[] args) {

		Point[] data = new Point[3];

		Scanner sc = new Scanner(System.in);

		int select;
		int index = 0;

		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 점 생성");
			System.out.println("2. 점 목록 출력");
			System.out.println("3. 점 1개 출력");
			System.out.println("4. 점 이동");
			System.out.println("5. 색 변경");
			System.out.println("6. 프로그램 종료");

			System.out.println("입력 : ");
			select = sc.nextInt(); // 목차 선택값
			sc.nextLine();

			if(select == 1) { // 점 생성
				String color = ""; // 점 색깔
				int x = 0; // x값
				int y = 0; // y값

				while(true) {
					if(index == data.length) {
						System.out.println("점은 3개까지만 만들 수 있습니다.");
						break;
					}

					System.out.println("1.색깔있는 점 2.색깔없는 점");
					select = sc.nextInt();
					sc.nextLine();

					if(select == 1) {
						System.out.println("1.색깔,좌표입력X 2.좌표만받기 3.색깔좌표 모두받기");
						System.out.println("입력 : ");
						select = sc.nextInt();
						if(select == 1) {
							data[index++] = new ColorPoint();
						}
						else if(select == 2) {
							System.out.println("x 값 입력 : ");
							x = sc.nextInt();
							System.out.println("y 값 입력 : ");
							y = sc.nextInt();
							data[index++] = new ColorPoint(x, y);
						}
						else if(select == 3) {
							System.out.println("색깔 입력 : ");
							color = sc.next();
							System.out.println("x 값 입력 : ");
							x = sc.nextInt();
							System.out.println("y 값 입력 : ");
							y = sc.nextInt();
							data[index++] = new ColorPoint(color, x, y);
						}

					}
					else if(select == 2) {
						System.out.println("1.좌표입력X 2.좌표입력O");
						System.out.println("입력 : ");
						select = sc.nextInt();
						if(select == 1) {
							data[index++] = new Point();
						}
						else if(select == 2) {
							System.out.println("x 값 입력 : ");
							x = sc.nextInt();
							System.out.println("y 값 입력 : ");
							y = sc.nextInt();
							data[index++] = new Point(x, y);
						}
					}

				}

			}
			else if(select == 2) {
				System.out.println("==== 점 목록 ====");
				for(int i = 0; i < index; i++) {
					data[i].printPoint();
				}
				System.out.println("=================");
			}
			else if(select == 3) {
				int num = 0;
				System.out.println("출력할 점 번호를 입력 해주세요.");
				num = sc.nextInt();
				data[num - 1].printPoint();

			}
			else if(select == 4) {
				for(int i = 0; i < index; i++) {
					data[i].printPoint();
				}
				System.out.println("이동할 원하는 점 번호 입력 : ");
				int num = sc.nextInt();

				System.out.println("이동할 이동 좌표 1.() 2.(x) 3.(x,y)");
				select = sc.nextInt();
				if(select == 1) {
					data[num - 1].move();
					data[num - 1].printPoint();
				}
				else if(select == 2) {
					System.out.println("이동할 x 값을 입력 : ");
					int x = sc.nextInt();

					data[num - 1].move(x);
					data[num - 1].printPoint();
				}
				else if(select == 3) {
					System.out.println("이동할 x 값을 입력 : ");
					int x = sc.nextInt();
					System.out.println("이동할 y 값을 입력 : ");
					int y = sc.nextInt();

					data[num - 1].move(x, y);
					data[num - 1].printPoint();
				}
			}
			else if(select == 5) {
				for(int i = 0; i < index; i++) {
					data[i].printPoint();
				}

				System.out.println("색깔 변경할 점을 고르세요.");
				int num = sc.nextInt();

				if(data[num - 1] instanceof ColorPoint) {
					ColorPoint cp = (ColorPoint)data[num - 1];
					System.out.println("색 입력 : ");
					String color = sc.next();
					cp.changeColor(color);
				} else {
					System.out.println("색 변경 불가능!");
				}
				data[num - 1].printPoint();
			}
			else if(select == 6) {
				break;
			}

		}
















































	}

}

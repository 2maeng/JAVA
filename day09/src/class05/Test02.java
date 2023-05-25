package class05;

import java.util.Random;

class Damagochi{ // 다마고치 클래스 생성
	// 멤버변수 생성
	String name;
	int age;
	int hungry;
	int meal;
	static Random rand = new Random();
	
	Damagochi(){ // 오버로딩
		this("다마고치");
	}
	
	Damagochi(String name){ // 다마고치 생성자
		this.name = name;
		this.age = 1;
		this.hungry = 0;
		this.meal = rand.nextInt(21) + 10;
	}
	
	void game() { // 게임 메서드
		int coin = rand.nextInt(5);
		if(coin == 0) { 
			gameT();
		} else {
			gameF();
		}
		ageUp();
	}
	
	void gameT() { // 게임 성공시
		this.hungry += this.meal;
		System.out.println(this.name + ", 성공!");
	}
	
	void gameF() { // 게임 실패시
		this.hungry += 5;
		System.out.println(this.name + ", 실패...");
	}
	
	void ageUp() { // 나이 먹을시
		while(this.hungry >= 100) {
			System.out.println("★경 " + this.name + "가 나이 한 살 먹어서 " + this.age + "살이 됐습니다." + " 축★");
			System.out.println();
			this.age++;
			this.hungry-=100;
		}
		if(this.age == 15 && this.hungry > 100) {
			System.out.println(this.name + "가 ★경 중2병 입니다! 고★");
		} else if(this.age == 20 && this.hungry > 100) {
			System.out.println(this.name + "가 ★경 성인입니다. 분가시켜주세요 축★");
		}
	}
	
	void print() {
		System.out.println(this.name + "는 " + this.age + "살이고 배고픔 상태 : " + this.hungry + "입니다."); 
	}
}

class A extends Damagochi{
	
	A(){
		this(5);
	}
	
	A(int age){
		super("꼬맹이");
		this.age = age;
	}
	
	void game() { // 오버 라이딩
		int coin = rand.nextInt(3);
		if(coin == 0) {
			gameT();
		}else {
			gameF();
		}
		ageUp();
	}
}

class B extends Damagochi{
	B(){
		this(3);
	}
	
	B(int age){
		super("돌맹이");
		this.age = age;
	}
	 
	void game() { // 오버라이딩
		int coin = rand.nextInt(3);
		if(coin == 0) {
			gameT();
		}else {
			gameF();
		}
		ageUp();
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		
		while(true) {
			a.game();
			b.game();
			if(a.age == 20) {
				break;
			}
		}
		a.print();
		b.print();
		
	}
	
}

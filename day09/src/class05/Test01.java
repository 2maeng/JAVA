package class05;

import java.util.Random;

// 선생님 풀이
class Pokemon{
	String name;
	int exp;
	int lv;
	String sound;
	static Random rand = new Random(); // 메모리를 절약하는 방법 공유자원으로
	
	Pokemon(){ // 지정하지 않는 경우에는 디폴트로 "포켓몬"이 설정됨
		this("포켓몬");
	}
	
	Pokemon(String name){ // 이름을 사용자가 지정할 수도 있고,
		this.name = name;
		this.exp = 0;
		this.lv = 5;
		this.sound = "...";
	}
	
	void game() {
		int action = rand.nextInt(2);
		if(action == 0) {
			gameT();
		}else {
			gameF();
		}
		lvUp();
	}
	
	void gameT() {
		this.exp += (rand.nextInt(41) + 10);
		System.out.println(this.name + ", 성공!");
	}
	
	void gameF() {
		this.exp+=10;
		System.out.println(this.name + ", 실패...");
	}
	
	void lvUp() {
		while(this.exp >= 100) {
			this.exp-=100;
			this.lv++;
			System.out.println(this.name + " 레벨업!");
		}
	}
	
	void hello() {
		System.out.println(this.name + " : " + this.sound);
	}
	
	void printInfo() {
		System.out.println(this.name + "는 Lv." + this.lv + " [" + this.exp + "/100]");
	}
}

class Pika extends Pokemon{
	Pika(){
		this(5);
	}
	
	Pika(int lv){ // 무조건 인자가 많은 것부터
		super("피카츄");
		this.lv = lv;
		this.sound = "피카피카";
	}
	
	void game() {
		int action = rand.nextInt(1);
		if(action == 0) {
			gameT();
		}else {
			gameF();
		}
		lvUp();
	}
	
}

class Charmander extends Pokemon{
	Charmander(){
		this(5);
	}
	
	Charmander(int lv){
		super("파이리");
		this.lv = lv;
		this.sound = "파아~~~";
	}
	
	void game() {
		int action = rand.nextInt(5);
		if(action == 0) {
			gameT();
		}else {
			gameF();
		}
		lvUp();
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Pika p1 = new Pika(); // 피카츄 , 5, 0
		Pika p2 = new Pika(10); // 피카츄, 10, 0
		
		Charmander c1 = new Charmander();
		Charmander c2 = new Charmander(11);
		
		for(int i = 0; i < 10; i++) {
			p1.game();
			p2.game();
			c1.game();
			c2.game();
		}
		
		p1.printInfo();
		p2.printInfo();
		c1.printInfo();
		c2.printInfo();
		
		p1.hello();
		c1.hello();
	}
	
}

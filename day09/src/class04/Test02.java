package class04;

import java.util.Random;


// 내 풀이
class Pokemon{
	String name;
	int exp;
	int lv;
	
	Pokemon(String name){
		this(name, 0, 5);
	}
	
	Pokemon(String name, int exp, int lv){
		this.name = name;
		this.exp = exp;
		this.lv = lv;
	}
	
	void printInfo() {
		System.out.println(this.name + "는" + " Lv." + this.lv + "[" + this.exp + "/100]");
	}
	
	void hello() {
		System.out.println("");
	}
	
	void game() {
		Random rand = new Random();
		int coin = rand.nextInt(2);
		if(coin == 1) {
			System.out.println(this.name + " 게임 승리");
			this.exp += rand.nextInt(40) + 10;
		} else {
			System.out.println(this.name + " 게임 패배");
			this.exp += 10;
		}
		
		
	}
	
	void levelUp() {
		while(this.exp >= 100) {
			System.out.println(this.name + " 레벨업!");
			this.lv++;
			this.exp -= 100;
		}
	}
}

class Pikachu extends Pokemon{
	
	Pikachu(){
		this("피카츄", 0, 5);
	}
	
	Pikachu(String name, int exp, int lv){
		super(name,exp,lv);
	}
	
	void hello() {
		System.out.println(this.name + " : 피카피카");
	}
	
	void game() {
		Random rand = new Random();
		this.exp += rand.nextInt(40) + 10;
		
		levelUp();
	}
}

class Fire extends Pokemon{
	Fire(){
		super("파이리", 50, 25);
	}
	
	void hello() {
		System.out.println(this.name + " : 파이파이");
	}
	
	void game() {
		Random rand = new Random();
		int coin = rand.nextInt(5) + 1;
		if(coin == 1) {
			System.out.println(this.name + " 게임 승리");
			this.exp += rand.nextInt(40) + 10;
		} else {
			System.out.println(this.name + " 게임 실패");
			this.exp += 10;
		}
		
		levelUp();
	}
}

public class Test02 {
	public static void main(String[] args) {
		
		Pikachu p1 = new Pikachu();
		Pikachu p2 = new Pikachu("피카츄2", 23, 11);
		Fire f1 = new Fire();
		
		for(int i = 0; i < 10; i++) {
			p1.game();
			p1.hello();
			p2.game();
			p2.hello();
			f1.game();
			f1.hello();
		}
		p1.printInfo();
		p2.printInfo();
		f1.printInfo();
		
	}
}

package class02;

import java.util.Random;

// 선생님 풀이
// 소문자로 시작하고 .이 있어서 객체
class Home {
	String name;
	static int money = 10000;
	
	Home(String name){
		this.name = name;
	}
	
	boolean use(int money) {
		System.out.println(this.name + "님이 " + money + "원 결제중입니다.");
		if(Home.money <= money) {
			System.out.println(this.name + "님이 과소비중입니다.");
			return false;
		}
		Home.money-=money;
		return true;
	}
}

public class Test01 {
	
	public static void main(String[] args) {
		
		Home[] data = new Home[3];
		data[0] = new Home("홍길동");
		data[1] = new Home("임꺽정");
		data[2] = new Home("이몽룡");
		
		Random rand = new Random();
		int i = 0;
		while(true) {
			int randMoney = (rand.nextInt(50) + 1) * 100;  
			if(!data[i++].use(randMoney)) {
				break;
			}
			if(i == data.length) {
				i = 0;
			}
		}
		
		// person은 객체구나~
	}
}

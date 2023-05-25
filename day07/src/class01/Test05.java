package class01;

import java.util.Random;

class Home{
	String name;
	static int money = 10000;
	
	Home(String name){
		this.name = name;
		System.out.println(this.name + " 구성원 추가");
	}
	
	boolean use() {
		Random rand = new Random();
		int res = rand.nextInt(1000) + 1;
		
		money-=res;
		if(money <= 0) {
			
			System.out.println("남은 돈 : " + money + " " + this.name + " 돈을 다 쓰면 어쩌니");
			return false;
		}
		System.out.println(this.name + "가 사용한 돈" + res + "원 쓰고 남은 돈 : " + money + "원");
		return true;
	}
}

public class Test05 {

	public static void main(String[] args) {
		
//		Home h1 = new Home("엄마");
//		Home h2 = new Home("아빠");
//		Home h3 = new Home("나");
//		Home h4 = new Home("동생");
		
		Home[] person = new Home[4];
		person[0] = new Home("엄마");
		person[1] = new Home("아빠");
		person[2] = new Home("나");
		person[3] = new Home("동생");
		
		int i = 0;
		while(true) {
			if(!person[i++].use()) {
				break;
			}
			
			if(i == person.length) {
				i = 0;
			}
		}
	}
	
}

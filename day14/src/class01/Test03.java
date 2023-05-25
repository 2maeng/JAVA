package class01;

class Family extends Thread {
	Account a = new Account();
	
	
	
	@Override
	public void run() {
		a.pay();
	}
	
}

class Account { // 사람들이 공유자원인 티겟을 구매하는 로직
	static int money = 10000; // 공유자원, 클래스변수
	
	synchronized void pay() {
		if(money > 0) {
			System.out.println(Thread.currentThread().getName() + "돈썻으~");
			money -= 5000;
		} else {
			System.out.println(Thread.currentThread().getName() + "쓸 돈이 읎다~");
		}
		System.out.println("남은 돈 : " + money);
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Family f = new Family();
		Thread t1 = new Thread(f, "나");
		Thread t2 = new Thread(f, "엄마");
		Thread t3 = new Thread(f, "아빠");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
}

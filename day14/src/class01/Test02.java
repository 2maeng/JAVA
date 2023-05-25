package class01;

// 동기화 
//  : 공유자원을 어떤 스레드가 점유하고 있을때,
//    다른 스레드의 접근을 막는 것
// ex) 티켓, 계좌, ...

class Person extends Thread {
	Ticketting t = new Ticketting(); // 원래 같으면 new를 하는 경우는 없음
	
	
	
	// thread.start() -> run() 메서드가 실행
	@Override
	public void run() {
		t.pay();
	}
	
}

class Ticketting { // 사람들이 공유자원인 티겟을 구매하는 로직
	static int ticket = 2; // 공유자원, 클래스변수
	
	synchronized void pay() {
		if(ticket > 0) {
			System.out.println(Thread.currentThread().getName() + "구매성공!");
			ticket--;
		} else {
			System.out.println(Thread.currentThread().getName() + "구매실패ㅜㅜ...");
		}
		System.out.println("남은티켓 : " + ticket);
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		Person p = new Person();
		Thread t1 = new Thread(p, "김임형");
		Thread t2 = new Thread(p, "내똥");
		Thread t3 = new Thread(p, "니똥");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
}

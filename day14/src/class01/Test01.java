package class01;

// 이미 JAVA에서 구현한 Thread 클래스를 가져다가 사용
// 코드를 재사용할 예정
// => 상속
class Th01 extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Thread 01 " + i);
		}
	}
	
}

class Th02 extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Thread 02 " + i);
		}
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Th01 t1 = new Th01();  // 생성
		// 생성이되면, 즉시 대기상태가 됌
		Th02 t2 = new Th02();
		
		// 수행
		t1.start(); // 스레드 객체야, 너 일해!
		t2.start(); // -> run() 메서들 실행시킴
		
		// start()로 인해 run()을 수행하게되고,
		// 주어진 run()을 다 수행하게되면
		// 데드상태가 됌
		
		// 스레드 객체들은 현재 독립적으로 일을 수행하고 있구나!
		
		// 스레드 생명주기(라이프 사이클)
		// 생성 -> 대기 -> 수행 -> 데드
		// 블록 : 자원(메모리)을 할당받지 못하도록 막아둔 상태
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1000 == 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		
		
	}
	
}

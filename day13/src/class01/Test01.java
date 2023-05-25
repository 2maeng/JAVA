package class01;

// [ 예외와 예외 처리 ]
// 예외
// 1. 스크린샷 -> 포스팅
// 2. 예외 발생한 라인 넘버
// 3. 원인 --->> 해결방안

public class Test01 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0; // 정수 / 정수 자체는 문제가 없음!
		try {
			System.out.println("확인1");
			System.out.println(a / b); // 실행을 하려고 보니까, 0 이었던것
			// 코딩 자체에는 문제가 없으나,
			// "실행시" 발생하는 문제 == 예외
			System.out.println("확인2");
		}
		catch(ArithmeticException e) {
			System.out.println("확인3");
			System.out.println(a / 1);
			System.out.println("확인4");
		}
		
	}
	
}

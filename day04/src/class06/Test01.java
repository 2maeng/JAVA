package class06;

public class Test01 {

	// public : 공개범위
	// static : "객체와 무관하게"
	// void : '아무것도 없음' 無
	
	// 함수끼리는 메모리 공간 공유 x
	// 호출이 끝나면 메모리 해제
	public static void hello() { // 함수명은 "기능"을 유추 할 수 있게 만들어야만 한다.
		// 함수 A유형 input x, output x
		System.out.println("안녕하세요! :D");
	}
	// "함수를 정의(선언)했다."

	public static void printStar(int num) {
		// 함수 B유형 input o, output x
		for(int i = 0; i < num; i++) {
			System.out.println("★");
		}
	}

	public static void main(String[] args) {

		System.out.println("메인함수");

		hello(); // "함수를 호출(사용)했다."

//		printStar(); // 함수를 호출 할 때에는 input, output을 정확히 맞춰서 사용
		printStar(5);
		hello();
		printStar(3);
	}	

}
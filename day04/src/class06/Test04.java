package class06;

public class Test04 {
	
	public static String funcC() {
		// 함수 유형 C, input x, output o
		
		System.out.println("funcC() 동작!");
		
		return "apple"; // 함수 즉시 종료됨!!!!!
		
//		System.out.println("funcC()의 마지막 코드"); 유효하지않은 코드
	}
	
	public static void main(String[] args) {
		
		funcC(); // return 값은 해당 함수를 호출한 자리로 이동
		System.out.println("main() 공간 : " + funcC());
		// 1. println() 해주세요
		// 2. funcC() 호출해주세요.
		// 3. 2 >> 1
		String msg = funcC();
		// 1. = 대입 연산자
		// 2. funcC() 호출해주세요.
		// 2 >> 1
		System.out.println("msg: " + msg);
		
		// 이 예제를 통해 알 수 있는 것
		// 1. 일반적으로 OUTPUT이 존재하는 함수들은
		//	a) 출력하거나,
		//	b) 변수에 저장하거나,
		//	해서 활용함
		
		// 2. return 값은 함수를 호출한 자리로 이동
		
	}
}

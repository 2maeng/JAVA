package class01;

import java.util.Scanner;

public class Test01 {
	
	// 1. 메서드 시그니처를 먼저 만들고, 그 다음에 기능을 구현
	// 2. 기능을 먼저 만들고, 메서드 시그니처를 문제에 맞추는 방법
	
	// [1]
	// Q1) 어떤수가 입력되었을때, 짝수인지 아닌지 판별하는 함수
	// INPUT : int 1개
	// OUTPUT : boolean
	public static boolean isEven(int num) {
		if(num % 2 == 0) {
			return true; // return은 함수 즉시 종료
		}
		return false;
	}
	
	// [2]
	// Q2) main에 구현되었던 기능을 뜯어서 func()에 우선 넣고 시작
	public static int checkMinus(int num, int b) {
		if(num < 0) {
			b++;
		}
		return b; // main한테 b를 전달
	}
	
	// 완성된 기능들의 묶음을 하나하나 분리 해내는 작업
	// == 모듈화, 컴포넌트화
	// : 코드 재사용성이 증가 --->> 유지보수 용이(이익증가)
	
	// [1]
	// Q) 어떤 정수가 0이니? 그럼 프로그램을 종료할 예정이야.
	//	  프로그램 종료 안내멘트 출력해줘.
	// INPUT : int 1개
	// OUTPUT : boolean
	public static boolean check(int num) {
		if(num == 0) {
			System.out.println("0이 입력되어 프로그램 종료.");
			System.out.println();
			return true;
		}
		return false; // 종료 안함
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// CTRL C, V를 하고있네? --->> 반복문!
		// while VS for
		int cnt = 0;
		int a = 0; // 짝수의 개수
		int b = 0; // 음수의 개수
		while(cnt < 10) { // 10번 입력될때까지
			System.out.println((cnt + 1) + "번 정수를 입력하세요."); // 사용자 편의성을 고려
			System.out.println("입력) ");
			int num = sc.nextInt();
			if(check(num)) { // 0이 입력되었을때 종료
				break;
			}
			cnt++;
			
			if(isEven(num)) {
				a++;
			}
			b = checkMinus(num, b);
		}
		
		System.out.println(cnt + "번 입력 완료했습니다.");
		System.out.println("짝수: " + a + "개");
		System.out.println("음수: " + b + "개");
	}
}

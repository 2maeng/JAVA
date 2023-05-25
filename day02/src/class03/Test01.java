package class03;

// 한 소스코드내에서는
// 유사한 코드가 없도록 작성해보자
public class Test01 {
	public static void main(String[] args) {

		// 내풀이
		//		int a = 5;
		//		int b = 9;
		//		for(int i = 5; i <=9; i++) {
		//			System.out.println(i);
		//		}
		//		
		//		int c = -5; 
		//		int d = -3;
		//		for(int i = -5; i <= -3; i++) {
		//			System.out.println(i);
		//		}
		//		
		//		int f = 3;
		//		int g = 1;
		//		for(int i = 1; i <= 3; i++) {
		//			System.out.println(i);
		//		}

		// 5 6 7 8 9 라고 출력
		// 선생님 풀이
//		int a = 5;
//		int b = 9;
//
//		int i = a;
//		while(i <= b) {
//			System.out.println(i + "");
//			i++;
//		}
		
		// 좋지않은 코드
//		int a = 10;
//		int b = 9;
//		
//		if(a <= b) {
//			int i = a;
//			while(i < b) {
//				System.out.println(i + " ");
//				i++;
//			}
//		} else {
//			int i = b;
//			while(i <= a) {
//				System.out.println(i + " ");
//				i++;
//			}
		
//		int a = 10;
//		int b = 9;
//		
//		int min = a > b ? b : a;
//		int max = a > b ? a : b;
//		
//		int i = min;
//		while(i <= max) {
//			System.out.println(i + " ");
//			i++;
//		}
		
		int a = 10;
		int b = 9;
		
		// 항상 a가 b보다 작을수 있또록
		// "교환 알고리즘"을 활용!
		if(a > b) { // a와 b의 값을 교환해줘!
			int tmp = a; // "임시저장 변수"
			a = b;
			b = tmp;
		}
		
		int i = a;
		while(i <= b) {
			System.out.println(i + " ");
			i++;
		}
	}
}

package class04;

public class Test03 {
	public static void main(String[] args) {

		// 1. a = 5, b = 3
		// 작은수부터 큰수까지 출력
		// 3 4 5
		
		// 선생님 풀이
//		int a = 5;
//		int b = 3;
//		if(a > b) {
//			int tmp = a;
//			a = b;
//			b = tmp;
//		}
//		for(int i = a; i <= b; i++) {
//			System.out.println(i);
//		}
		// 1. 출력 문구가 반복되네? 반복문쓰자
		// 2. while vs for
		// for : a부터 b까지 "범위"
		// 3. 반복문을 썼으니까, "조건식"
		// 4. a가 무조건 작아!
		//	  OR min, max 설정하기

		// 내 풀이
		//		for(int i = 3; i < 6; i++) {
		//			System.out.print(i + " ");
		//		}


		// 2. a = 1, b = 10
		// 작은수부터 큰수까지 출력
		// 1 3 5 7 9
		
		// 선생님 풀이
		// 어? 선택사항이 생겼네? -> if 조건문!
		int a = 1;
		int b = 10;
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		// 1. 홀수일때 출력해!
		for(int i = a; i <= b; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
			}
		}
		// 2. 짝수일때 출력하지마 
		for(int i = a; i <= b; i++) {
			if(i % 2 == 0) {
				continue; // 반복수행자체는 유지하되, 이 아래로는 수행하지마
				// == "즉시" 반복문의 처음으로 이동
			}
			System.out.println(i);
		}

		// 내 풀이
		//		for(int i = 1; i < 10; i++) {
		//			if(i % 2 == 1) {				
		//				System.out.print(i + " ");
		//			}
		//		}


		// 3. 1부터 100까지 총합을 출력
		
		// 내 풀이
//		int sum = 0;
//		for(int i = 1; i <= 100; i++) {
//			sum += i;
//		}
//		System.out.print(sum);
		
		// 선생님 풀이
		// 1. 주어진 것 == 데이터
		// 2. output을 생성(정의)
		int s = 1;
		int e = 100;
		int sum = 0;
		
		// 3. 내가 해야하는 문장을 작성 --->> 반복되는 문장을 찾음!!!
		// 	  for : 범위가 주어져있기 때문에
		for(int i = s; i <= e; i++) {
			sum += i;
		}
		System.out.println(sum);



	}
}

package class04;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		
		// 1. 문제
		// 2. 풀이
		// 3. 2 -> 코드
		
		// 1. N개의 랜덤수를 생성
		// 2. 랜덤수는 1~10까지 중에서 생성된다고 합니다
		// ex) 6 : 10 1 2 3 4
		// 3. 이 랜덤수들의 평균을 출력
		// 4. 평균보다 높은 값들을 '저장', 이후에 출력
		
		// ★ 풀이를 한국어로 작성해보자! ★
		// 1. Random을 생성
		// 2. N을 결정
		// 3. N개 만큼의 랜덤수를 생성
		// 4. 총합 --->> 평균
		// 5. 평균보다 높은 값들을 저장할 공간 생성
		// 6. 5의 공간에 값 저장
		// 7. 6을 출력
		
		// [1]
		Random rand = new Random();
		int N = rand.nextInt(10) + 1;
		// rand.nextInt(101) --->> 0 ~ 100
		// rnad.nextInt(10) + 1 --->> 1 ~ 10
		System.out.println("N: " + N);
		
		System.out.println("==================");
		
		// [3]
		// 배열 쓰고싶다!
		// : 배열 3요소를 모두 만족하므로, 사용가능!
		int[] data = new int[N];
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(10) + 1;
		}
		
		
		
		// [4]
		int sum = 0;
		// 향상된 for문 == forEach
		for(int v : data) { // 콜론기준 오른쪽을 순서대로 보여줄게
			System.out.println("랜덤수 " + v);
			sum+= v;
		}
		
		System.out.println("==================");
		
		System.out.println("총합: " + sum);
		
		System.out.println("==================");
		
		double avg = sum * 1.0 / data.length;
		System.out.println("평균: " + avg);
		
		System.out.println("==================");
		
		// [5] 평균보다 높은 값들을 저장할 공간 생성
		// 배열 3요소 확인 중...
		// : 현재 배열의 개수를 알 수가 없음
		// a) 예상
		// b) 확인후 배열생성 --->> 
		int num = 0;
		for(int v : data) {
			if(v > avg) { // 평균보다 높음?
				num++;
			}
		}
		System.out.println("평균보다 높은값들은 " + num + "개"); // b완료
		
		System.out.println("==================");
		
		int[] data2 = new int[num]; // 평균보다 높은 값들을 저장할 공간 생성 완료
		
		// [6]
		int j = 0; // data2 배열에대한 인덱스
		for(int i = 0; i < data.length; i++) {
			if(data[i] > avg) { // 평균보다 높을때만
				data2[j++] = data[i];
				// => data[i]를 data[j]에 대입하고,
				//	  j가 한칸이동
			}
		}
		

		
		// [7]
		System.out.print("평균보다 큰값은...");
		for(int v : data2) {
			System.out.print(v + " ");
		}
		System.out.println("입니다.");
		
		
		
		
		
		
		
		
		
		
	}
}

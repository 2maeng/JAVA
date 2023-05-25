package class04;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
//		1) 이 배열의 이름은 data 이고
//		2) 3 ~ 5개까지 중에서 랜덤으로 크기를 결정
//		ex) 3 --->> [ _ _ _ ]
//				3) data에 저장되는 정수는 100 ~ 105 사이의 랜덤수가 저장됨
//		ex) [ 102 100 100 ]
//				4) A - 홀수들의 총합
//		5) B - 짝수들의 평균
//
//		console)
//		[ 102 100 100 ]
//		홀수총합 : 
//		짝수평균 : 100.66667
		
		Random rand = new Random();
		int randNum = rand.nextInt(3) + 3;
		int[] data = new int[randNum];
		System.out.print("[");
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(6) + 100;
			System.out.print(data[i] + " ");
		}
		System.out.println("]");
		
		int oSum = 0;
		int eSum = 0;
		int eCnt = 0;
		
		for(int v : data) {
			if(v % 2 == 0) {
				eSum+=v;
				eCnt++;
			} else {
				oSum+=v;
			}
		}
		
		double eAvg = eSum * 1.0 / eCnt;
		
		System.out.println("홀수총합 : " + oSum);
		System.out.println("짝수평균 : " + eAvg);
	}
}	

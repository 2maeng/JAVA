package class05;

import java.util.Random;

import javax.xml.crypto.Data;

public class Test01 {
	public static void main(String[] args) {

		//	1) 이 배열의 이름은 data 이고
		//	2) 3 ~ 5개까지 중에서 랜덤으로 크기를 결정
		//		ex) 3 --->> [ _ _ _ ]
		//	3) data에 저장되는 정수는 100 ~ 105 사이의 랜덤수가 저장됨
		//		ex) [ 102 100 100 ]
		//	4) A - 홀수들의 총합
		//	5) B - 짝수들의 평균

		Random rand = new Random();
		int N = rand.nextInt(5) + 1;
		int N2 = rand.nextInt(105) + 1;
		System.out.println("N: " + N);
		System.out.print(N2);

		System.out.println("==================");

		int[] data = new int[N];
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(5) + 1;
		}
		int[] data2 = new int[N];
		for(int j = 0; j < data2.length; j++) {
			data[j] = rand.nextInt(105) + 1;
		}
		
	}
}

package Work01;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		
//		문제
//		랜덤으로 5개 숫자 오름차순으로 출력
//		숫자 범위(1~5)
//
//		Console
//		정렬 전:
//		정렬 후:
		
		Random rand = new Random();
		int[] data = new int[5];
		
		System.out.print("정렬 전 : ");
		for(int i = 0; i < 5; i++) {
			data[i] = rand.nextInt(5) + 1;
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) {
				if(data[i] > data[j]) {
					int tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}
		}
		
		System.out.print("정렬 후 : ");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}

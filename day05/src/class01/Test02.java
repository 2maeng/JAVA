package class01;

import java.util.Random;
import java.util.Scanner;

//+++) 10개의 랜덤 정수가 저장된 배열(범위:1~100)
//	사용자가 정수를 입력 ex) 50
//50은 [2]에 저장되어 있습니다.
//	50은 배열에 없습니다!

public class Test02 {
	
	// 배열에 특정 정수가 있는지 없는지 -1
	// 있다면, 몇번 인덱스인지 -2
	// INPUT : int[] 1개, int 1개
	// OUTPUT : (boolean,) int 
	// 		=> 두개 이상의 반환은 불가능!
	//		   int의 값에 의미를 부여하는 방식으로 해결!
	public static int checkNum(int[] data, int num) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == num) {
				return i;
			}
		}
		return -1; // false를 의미함
	}
	
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int[] data = new int[10];
		
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100) + 1;
		}
		
		System.out.print("[");
		for(int v : data) {
			System.out.print(v + " ");
		}
		System.out.print("]");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수입력) ");
		int num = sc.nextInt();
		int index = checkNum(data, num); // 함수를 index에 저장
		if(index < 0) {
			System.out.println(num + "은 배열에 없습니다.");
		} else {
			System.out.println(num + "은 [" + index + "]에 저장되어있습니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

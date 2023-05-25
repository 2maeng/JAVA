package class01;

import java.util.Random;
import java.util.Scanner;

// flag 알고리즘
// : 특정 상황이 T인지 F인지 판단할때 활용
// : 이때 '특정상황'이 반복문, 함수 등 처럼
// 	 시간이 좀 흘러야,
//	 범위를 모두 확인해야 알 수 있을때!

public class Test01 {
	public static void main(String[] args) {
		
		int[] data = new int[5]; // 배열 다섯 칸
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100) + 1; // 랜덤 수 생성 1 ~ 100
		}
		// data.length; == 배열의 크기
		//				!= 저장되어있는 데이터의 개수
		System.out.print("[");
		for(int v : data) {
			System.out.print(v + " ");
		}
		System.out.println("]");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수입력)");
		int num = sc.nextInt(); // 정수 입력
		
		boolean flag = false; // OFF 배열에 num이 없는 상황을 의미
		int index = -1;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i] == num) {
				flag = true; // ON 배열에 num이 있는 상황을 의미
				index = i;
			}
		}
		
		if(flag) { // num이 배열에 존재한다면
			System.out.println(num + "은 [" + index + "]에 존재합니다.");
		} else {
			System.out.println(num + "은 존재하지 않습니다.");
		}
		
		
		
	}
}

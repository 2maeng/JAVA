package class01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// 정상적인 입력을 3번 할때까지 계속


		Scanner sc = new Scanner(System.in);

		//		while(true) {
		//
		//			for(int i = 0; i < 3; i++) {
		//				try {
		//					System.out.println("정수 입력) ");
		//					int num = sc.nextInt();
		//					System.out.println("num = " + num);
		//				}
		//				catch(InputMismatchException e) {
		//					sc.nextLine(); // 버퍼에 남아있는 쓰레기값을 제거하는 코드
		//					System.out.println("정수로만 입력하셔야 합니다");
		//				}
		//			}
		//		}

		int index = 0;
		while(index < 3) {
			try {
				System.out.println("정수 입력) ");
				int num = sc.nextInt();
				System.out.println("num = " + num);
				index++;
			}
			catch(InputMismatchException e) {
				sc.nextLine(); // 버퍼에 남아있는 쓰레기값을 제거하는 코드
				System.out.println("정수로만 입력하셔야 합니다");
			}

		}
























	}

}

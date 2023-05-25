package class02;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		


		int a = N % 10; // 1의 자리
		int b = N % 100 / 10; // 10의자리
		int c = N % 1000 / 100; // 100의 자리
		int cnt = 0;

		System.out.println("[" + N + "]");

		if (a == 3 || a == 6 || a == 9) { // 1의 자리가 3,6,9일 때 카운트.
			cnt++;
		} 
		if (b == 3 || b == 6 || b == 9) {
			cnt++;
		} 
		if (c == 3 || c == 6 || c == 9) {
			cnt++;
		}

		String clap = sc.nextLine();
		String ans = null;

		while(true) {
			
			int N = rand.nextInt(1000) + 1;
			
			// cnt가 1일때 내가 짝을 한 번 썼다면 정답 
			// cnt가 2일때 내가 두번 짝쳐야 정답
			if(cnt == 1) {
				ans = "짝";
			} else if(cnt == 2) {
				ans = "짝짝";
			} else if(cnt == 3) {
				ans = "짝짝짝";
			} else if(cnt == 0){
				ans = String.valueOf(N);
			} 
			if(ans.equals(clap)) {
				System.out.println("정답입니다.");
			} else {
				System.out.println("오답입니다.");
			}

			
			
			System.out.println("이름입력) ");
			clap = sc.nextLine();
			System.out.println(clap + "님 축하합니다! 상품 드리겠습니다." );
		}


	}
}

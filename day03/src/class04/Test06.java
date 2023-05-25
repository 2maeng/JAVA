package class04;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		// 자판기
		String[] mName = new String[3]; // 자료형이 달라서 다 따로 작성
		mName[0] = "아메리카노";
		mName[1] = "카푸치노";
		mName[2] = "아이스티";
		
		int[] mPrice = new int[3];
		mPrice[0] = 2500;
		mPrice[1] = 4500;
		mPrice[2] = 3000;
		
		int[] mCnt = new int[3];
		mCnt[0] = 100;
		mCnt[1] = 10;
		mCnt[2] = 2;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { // 종료조건을 일부러 안 만듦!
			
			System.out.println("=== 메뉴판 ===");
			for(String v : mName) {
				System.out.println(v);
			}
			System.out.println("============");
			
			 // 사용자의 편의성을 고려하여 코딩한다! ★
	         System.out.print("먹고싶은메뉴를 입력하세요) ");
	         int uNum=sc.nextInt(); // 아메리카노
	         int uCnt=10; // 몇개 구매할지
	         
	         if(uCnt>mCnt[uNum - 1]) {
	            System.out.println("재고가 부족합니다!");
	            break;
	         }

			
			System.out.println(mName[uNum - 1] + "메뉴를");
			System.out.println(uCnt + "개 구매했습니다.");
			System.out.println("총 금액: " + uCnt * mPrice[uNum - 1]);
			mCnt[uNum - 1]-=uCnt;
			
			
			
			
			
			
			
			
			
			
		}
	}
}

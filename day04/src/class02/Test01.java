package class02;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int N = 4; // 상품 4개
		String[] mName = new String[N]; // 메뉴이름 배열
		for(int i = 0; i < mName.length; i++) {
			System.out.println((i + 1) + "번 상품이름 입력: ");
			mName[i] = sc.nextLine(); // 문자열 입력
			System.out.println(mName[i] + " 상품 저장완료");
			System.out.println();
		}

		int[] mPrice = new int[4];
		for(int i = 0; i < mPrice.length; i++) {
			System.out.println(mName[i] + " 의 가격입력: ");
			mPrice[i] = sc.nextInt();
		}

		System.out.println();
		int[] mCnt = new int[4];
		for(int i = 0; i < mCnt.length; i++) {
			System.out.println(mCnt[i] + " 의 개수입력: ");
			mCnt[i] = sc.nextInt();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
//		String[] mName = new String[N]; // 메뉴이름 배열
//		mName[0] = "아이폰";
//		mName[1] = "에어팟";
//		mName[2] = "아이패드";
//		mName[3] = "맥북";
//
//		int[] mPrice = new int[4];
//		for(int i = 0; i < mPrice.length; i++) {
//			mPrice[i] = (rand.nextInt(6) + 10) * 100; // 1000 ~ 1500
//			// 10 ~ 15 X 100 : 연산자 우선순위 이슈 체크!
//		}
//
//		int[] mCnt = new int[4];
//		for(int i = 0; i < mCnt.length; i++) {
//			mCnt[i] = rand.nextInt(4); // 0 ~ 3
//		}

		while(true) {
			System.out.println("1.구매 2.종료");
			System.out.println("입력) ");
			int action = sc.nextInt();
			if(action == 2) {
				System.out.println("프로그램 종료...");
				System.out.println();
				break;
			} else if(action < 1 || 2 < action) {
				System.out.println("유효하지않은 값입니다!");
				System.out.println("다시 입력해주세요.");
				continue;
			}


			while(true) {
				System.out.println("=== 메뉴목록 ===");
				for(int i = 0; i < mName.length; i++) {
					System.out.print((i + 1) + ". " + mName[i] + "[");
					if(mCnt[i] == 0) {
						System.out.print("재고없음");
					} else {
						System.out.print(mCnt[i]);
					}
					System.out.println("]");
				}
				System.out.println("===============");
				System.out.println("번호입력) ");
				int num = sc.nextInt();

				if((1 <= num && num <= N) && (mCnt[num - 1] > 0)) { // 정상 입력이라면 1~4사이이고, 재고도 있어야함
					break;
				}

				if(num < 1 || N < num) {
					System.out.println("없는 상품입니다!");
				} else if(mCnt[num - 1] == 0) {
					System.out.println("재고가 없어서 구매가 불가능합니다!");
				}
			}
			

		}

	}
}

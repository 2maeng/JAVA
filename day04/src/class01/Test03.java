package class01;

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//		[자판기 프로그램 작성하기]
		//		1. 상품은 4개
		//		2. 이름은 정하되 
		//		3. 가격, 재고 랜덤으로 설정
		//		4. 1-구매, 2-종료
		//		5. 상품목록을 재고와 함께 출력해주세요!
		//			단, '재고가 없는 상품은 출력하지 않습니다!'
		//				 ex) 1-콜라[3] 2-사이다[재고없음] 3-환타[4]
		//			1 입력시 -> 몇개구매?
		//			2 입력시 -> 재고가없어서 구매가 불가능합니다!
		//			3 입력시 -> 없는 상품입니다!
		//		6. 그 외에는 모두 연습문제와 동일하게 진행해주세요!

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int N = 4; // 메뉴의 개수 , N으로 설정한 이유는 유지보수 편하기 위함
		String[] iName = new String[N]; // 메뉴이름 배열
		iName[0] = "아이폰";
		iName[1] = "에어팟";
		iName[2] = "아이패드";
		iName[3] = "맥북";

		int[] iPrice = new int[N];
		iPrice[0] = 100;
		iPrice[1] = 30;
		iPrice[2] = 80;
		iPrice[3] = 200;

		int[] iCnt = new int[N];
		for(int i = 0; i < iCnt.length; i++) {
			iCnt[i] = rand.nextInt(4) + 1;
		}

		while(true) {
			// 출력
			System.out.println("1.구매 2.종료");
			System.out.println("입력) ");
			int action = sc.nextInt();

			// 종료
			if(action == 2) { // 종료조건 : 종료하기 버튼 눌름
				System.out.println("이용해주셔서 감사합니다!");
				System.out.println();
				break; // 무한루프 종료
				
			} else if (action < 1 || 2 < action) { // 유효성 검사 : 1, 2도 아니라면
				System.out.println("확인후 다시 이용해주세요.");
				continue;
			}

			int num;
			// 구매
			System.out.println("=== Apple ===");
			while(true) {
				for(int i = 0; i < iName.length; i++) {
					System.out.println((i + 1) + ". " + iName[i] + "[" + iCnt[i] + "]");
					if(iCnt[i] <= 0) {
						System.out.println((i + 1) + " 재고가 없는 상품 입니다.");
					}
				}
				System.out.println("======================");

				System.out.println("구매할 상품 번호를 입력) ");
				num = sc.nextInt();

				if(1 <= num && num <= N) { // 제대로 입력했으면
					System.out.println("몇개를 구매하시겠습니까?");
					break;
				} else if(N < num) {
					System.out.println("존재하지 않는 상품 입니다.");
					System.out.println("다시 입력하세요!");
					System.out.println();
				} 
				

			}

			int cnt; // 지역변수의 특성
			while(true) { // 유효성 검사 : 구매할 개수가 음수이거나, 재고보다 많으면 안됌
				System.out.println("선택한 상품은 " +iName[num-1] + "입니다.");
				System.out.println("가격: " + iPrice[num - 1]+ "만원 재고: " + iCnt[num - 1] + "개");
				System.out.println("구매할 개수 입력) ");
				cnt = sc.nextInt();
				
				if(iCnt[num - 1] < cnt) {
					System.out.println("재고가 없어서 구매 불가능합니다.");
				}else if(0 <= cnt && cnt <= iCnt[num - 1]) {
					break;
				}
				
				System.out.println("다시 입력해주세요!");
				System.out.println();

			}
			
			int res = iPrice[num - 1] * cnt;
			int money;
			System.out.println("금액: " + res + " 만원");
			while(true) {
				System.out.println("내실 돈 입력) ");
				money = sc.nextInt();
				if(res <= money) {
					break;
				}
				System.out.println("잘못된 입력입니다.");
				System.out.println("새로 입력해주세요!");
				System.out.println();
			}
			
			res = money - res;
			if(res != 0) {
				System.out.println("거스름돈 " + res + "만원 반환 완료");
			}
			System.out.println("구매 성공!");
			System.out.println();
			
			iCnt[num - 1]-=cnt; // "장바구니 이슈"를 생각해볼 것!
			
		}


	}
}
	

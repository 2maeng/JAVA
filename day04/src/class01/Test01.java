package class01;

import java.util.Random;
import java.util.Scanner;

// [ 자판기 프로그램 ]
// 어디에, 어떤 방식으로 "유효성 검사"가 들어가야할까?
// 총 몇개 추가되어야할까??? --->> 4번
// : 유효성 검사는 "입력할때마다" 진행! ★ 중요!!! ★
// 1) 사용자에게 안내 -> 올바른 입력을 알려주면 더 좋음!
// 2) 프로그램의 강제종료를 예방
public class Test01 {
	public static void main(String[] args) {
		
		// 1. 먹고가기 / 포장
		// 2-1. 종료하기 : 프로그램
		// 2-2. 구매하기 : 아메리카노 / 카페라테 / 아이스티 등의 메뉴를 출력
		// 3. 몇개 구매?
		// 4. 가격안내
		// 5. 현금입력 -> 거스름돈 반환
		// ※ 재고 데이터 o
		
		Scanner sc = new Scanner(System.in); // 생성 코드는 상단 배치
		Random rand = new Random();
		
		int N = 3; // 메뉴의 개수
		// ★ 유지보수 유리하게 하기 위함. ★
		String[] mName = new String[N]; // 메뉴이름 배열
		mName[0] = "아메리카노";
		mName[1] = "카페라테";
		mName[2] = "아이스티";
		int[] mPrice = new int[N];
		mPrice[0] = 2000;
		mPrice[1] = 3500;
		mPrice[2] = 3000;
		int[] mCnt = new int[N];
		for(int i = 0; i < mCnt.length; i++) {
			mCnt[i] = rand.nextInt(3) + 1;
		}
		
		while(true) { // 몇 번 반복할지 모르기때
			
			// 1. 출력
			System.out.println("1.구매 2.종료");
			System.out.println("입력) ");
			int action = sc.nextInt();
			
			// 2-1. 종료
			if(action == 2) { // 종료조건 : 종료하기 버튼을 눌렀다면
				System.out.println("이용해주셔서 감사합니다!");
				System.out.println();
				break; // 무한루프네? 종료조건이 필수다!
				
			} else if(action < 1 || 2 < action) { // 유효성 검사 : 1, 2도 아니라면
				System.out.println("잘못된 입력값입니다.");
				System.out.println("확인후 다시 이용해주세요!~~");
				continue;
			}
			
			int num;
			// 2-2. 구매
			System.out.println("=== 메뉴판 ===");
			while(true) {
				for(int i = 0; i < mName.length; i++) {
					System.out.println((i + 1) + ". " + mName[i]);
				}
				System.out.println("=========================");
				
				System.out.println("구매할 상품의 번호를 입력) ");
				num = sc.nextInt();
				// num (지역)변수는 61번의 while블록에서 선언되었기 때문에
				// 84번의 블록을 벗어나면 소멸된다!
				
				if(1 <= num && num <= N) { // 제대로 입력했다면
					break;
				}
				
//				if(num < 1 || N < num) {
//					System.out.println("없는 상품번호 입니다.");
//					System.out.println("다시 입력하세요!");
//					System.out.println();
//					continue;
//				}
				System.out.println("없는 상품번호 입니다.");
				System.out.println("다시 입력하세요!");
				System.out.println();
			}
			
			int cnt; // 지역변수의 특성
			while(true) { // 유효성 검사 : 구매할 개수가 음수이거나, 재고보다 많으면 안됌
				System.out.println("선택한 상품은 " + mName[num-1] + "입니다.");
				System.out.println("가격: " + mPrice[num - 1]+ "원 재고: " + mCnt[num - 1] + "개");
				System.out.println("구매할 개수 입력) ");
				cnt = sc.nextInt();
				
				if(0 <= cnt && cnt <= mCnt[num - 1]) {
					break;
				}
				
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요!");
				System.out.println();

			}
			
			int res = mPrice[num - 1] * cnt;
			int money;
			System.out.println("금액: " + res + " 원");
			while(true) {
				System.out.println("돈 입력) ");
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
				System.out.println("거스름돈 " + res + "원 반환 완료");
			}
			System.out.println("구매 성공!");
			System.out.println();
			
			mCnt[num - 1]-=cnt; // "장바구니 이슈"를 생각해볼 것!
			
		}
		
	}
}

package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
// 목록출력,목록검색_이름,목록검색_가격
public class ClientView {
	private static Scanner sc = new Scanner(System.in);

	//==================================================================================
	//예외 처리   
	public int menuTryCatch(int num) {// 사용자 선택의 최대값을 입력받음
		while (true) {// 사용자 입력 무한 루프
			try {
				System.out.print("입력) ");
				int select = sc.nextInt();// 사용자가 입력한 번호
				if (select == 777) {
					return select;
				} else if (select < 1 || select > num) {// 메뉴는 1~num 까지 입력 가능
					// 메뉴가 1보다 작거나 num 보다 크다면 잘못된 입력값으로 확인
					System.out.println("정확한 메뉴를 입력해주세요");// 안내 멘트후
					continue;// 범위 벗어날시 다시 입력
				} // end if(범위 확인)

				return select;// 예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();// 버퍼 처리
				System.out.println("정수를 입력");
			} // end try-catch

		} // end while

	}// end tryCatch(예외처리)

	// 예아니오 유효성 검사
	public int checkYesNo() {
		while (true) {// 사용자 입력 무한 루프
			try {
				System.out.print("입력) ");
				int select = sc.nextInt();// 사용자가 입력한 번호
				if (select < 1 || select > 2) {// 메뉴는 1~2 까지 입력 가능
					// 메뉴가 1보다 작거나 2 보다 크다면 잘못된 입력값으로 확인
					System.out.println("정확한 값을 입력해주세요");// 안내 멘트후
					continue;// 범위 벗어날시 다시 입력
				} // end if(범위 확인)

				return select;// 예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();// 버퍼 처리
				System.out.println("정수를 입력");
			} // end try-catch

		} // end while
	}

	public int cntTrycatch() {// 재고 예외
		while (true) {// 사용자 입력 무한 루프
			try {
				System.out.print("구매할 개수 입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				if (num <= 0) {
					System.out.println("구매할 개수는 0이나 음수가 될 수 없습니다.");
					continue;
				}
				return num;// 예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();// 버퍼 처리
				System.out.println("정수를 입력");
			} // end try-catch

		} // end while
	}

	public int priceTrycatch() {// 가격 예외
		while (true) {// 사용자 입력 무한 루프
			try {
				System.out.print("가격 입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				if (num <= 0) {
					System.out.println("가격은 0이나 음수가 될 수 없습니다.");
					continue;
				}
				return num;// 예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();// 버퍼 처리
				System.out.println("정수를 입력");
			} // end try-catch

		} // end while
	}

	public int numTrycatch() {// 상품번호 예외
		while (true) {// 사용자 입력 무한 루프
			try {
				System.out.print("구매할 상품 번호 입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				return num;// 예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();// 버퍼 처리
				System.out.println("정수를 입력");
			} // end try-catch

		} // end while
	}

	//==================================================================================================
	// 사용자 모드
	public int printClientMenu02(int num) {// 인자: crtl에서 선택범위 최대값을 받음 / 아웃풋: 사용자가 입력한 메뉴 값
		System.out.println();
		System.out.println("=== 사 용 자 모 드 ===");
		System.out.println("1. 상품목록출력");
		System.out.println("2. 상품 구매");
		System.out.println("3. 상품목록검색_이름으로 검색");
		System.out.println("4. 상품목록검색_가격으로 검색");
		System.out.println("5. 종료");
//		System.out.print("입력) ");
		return menuTryCatch(num);
	}

	//==================================================================================================
	// 1.상품 목록 출력

	public void printProduct(ProductVO pdata) {// 상품 하나 출력
		System.out.println();
		if (pdata == null) {
			System.out.println("출력할 상품 없음");
			return;
		}
		System.out.println(pdata);
	}

	public void printProductList(ArrayList<ProductVO> pdatas) {// 상품 목록 출력
		System.out.println();
		if (pdatas.isEmpty()) {// 사용자 편의성을 고려(UI/UX)
			System.out.println("===출력할 상품 없음===");
			return;
		}
		System.out.println("===목록 출력===");
		for (ProductVO pVO : pdatas) {// .toString() 자동 호출
			System.out.println(pVO);
		}
	}

	//==================================================================================================
	// 2. 상품 구매

	public int getBuyPKNum() {// 상품 번호 입력

		return numTrycatch();// 유효성 검사(예외처리)
	}

	public int getButCntNum() {// 구매할 상품 갯수 입력
		return cntTrycatch();// 유효성 검사(예외처리, 0이하 x)
	}

	public int getBuyPriceNum() {// 구매할 상품 가격 입력
		return priceTrycatch();// 유효성 검사(예외처리, 0이하 x)
	}
	// 추가
	public boolean getCheckBuy() {// 물건 구매 예 아니오 물어보기
		System.out.println("정말 이 상품을 구매하시겠습니까?\n");
		System.out.println("1. Yes     2.NO");
		int num = checkYesNo();// 유효성 검사
		if (num == 1) {
			return true;
		}
		return false;
	}

	public void printBuyTrue() {
		System.out.println("물건 구매 성공");
	}

	public void printBuyFalseCntZero() {
		System.out.println("재고가 없습니다.");
	}

	public void printBuyFalseCntOver() {
		System.out.println("남은 재고보다 많이 구매할 수 없습니다.");
	}

	//==================================================================================================
	// 3.상품 목록 검색_이름으로 검색

	public String getSearchContent() {
		System.out.println();
		System.out.println("===이 름 으 로 검 색 ===");
		System.out.print("검색어 입력: ");
		String name = sc.next();// 검색어 입력

		return name;// 검색어 반환
	}
	// Ex) 화 라고 검색하면 화가 포함되어있는 물건들을 출력
	// printProductList(ArrayList<ProductVO> pdatas) 리스트 출력 사용

	//==================================================================================================
	//4.상품목록검색_가격으로 검색
	public String printClientSearchPriceMenu(int num) {
		System.out.println();
		System.out.println("===가 격 으 로 검 색 ===");
		System.out.println("1. 가장 싼 상품 출력");
		System.out.println("2. 가장 비싼 상품 출력");
		System.out.println("3. 입력값보다 비싼 상품들 출력");
		System.out.println("4. 입력값보다 싼 상품들 출력");
		System.out.println("5. 필터 검색(가격 2번 입력)");

		return menuTryCatch(num) + "";// 입력받은 메뉴값 리턴
	}

	public int getSearchPrice() {// 가격 하나 입력
		return priceTrycatch();
	}

	public ProductVO getSearchFilter() {// 반환 2개가 안되기 때문에 VO를 반환으로 설정
		System.out.println("가격이 범위를 입력");
		System.out.println("(최소값)");

		int minPrice = priceTrycatch();
		System.out.println("(최대값)");

		int maxPrice = priceTrycatch();
		ProductVO pVO = new ProductVO(0, "5", minPrice, maxPrice);// search condition, 사용하지 않는 인자 사용

		return pVO;
	}

	//==================================================================================================
	// 5.사용자 모드 종료
	public void printClientEnd02() {
		System.out.println();
		System.out.println("=== 사 용 자 모 드 종 료 ===");
	}
	
	public void printClientStart() {
		System.out.println();
		System.out.println("=== 사용자가 입장합니다. ===");
		
	}
}
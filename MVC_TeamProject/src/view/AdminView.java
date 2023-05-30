package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

// 회원목록출력
public class AdminView {
	private static Scanner sc = new Scanner(System.in);

	public int menuTryCatch(int num) { //사용자 선택의 최대값을 입력받음
		while (true) { //사용자 입력 무한 루프
			try {
				System.out.print("입력) ");
				int select = sc.nextInt(); // 사용자가 입력한 번호
				if(select<1 || select >num) { //메뉴는 1~num 까지 입력 가능
					//메뉴가 1보다 작거나 num 보다 크다면 잘못된 입력값으로 확인
					System.out.println("정확한 메뉴를 입력해주세요");//안내 멘트후
					continue; //범위 벗어날시 다시 입력
				} //end if(범위 확인)

				return select; //예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();//버퍼 처리
				System.out.println("정수를 입력!");
			} //end try-catch

		} // end while

	} // end tryCatch(예외처리)

	public int checkYesNo() {
		while (true) {//사용자 입력 무한 루프
			try {
				System.out.print("입력) ");
				int select = sc.nextInt();// 사용자가 입력한 번호
				if(select<1 || select >2) {//메뉴는 1~2 까지 입력 가능
					//메뉴가 1보다 작거나 2 보다 크다면 잘못된 입력값으로 확인
					System.out.println("정확한 값을 입력해주세요");//안내 멘트후
					continue;//범위 벗어날시 다시 입력
				}//end if(범위 확인)

				return select;//예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();//버퍼 처리
				System.out.println("정수를 입력");
			}//end try-catch

		} // end while
	}

	public int cntTryCatch() {   // 재고 trycatch문
		while (true) {//사용자 입력 무한 루프
			try {

				System.out.print("입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				if(num < 0) {
					System.out.println("재고는 음수가 될 수 없습니다.");
					continue;
				}

				return num;//예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();//버퍼 처리
				System.out.println("정수를 입력");
			}//end try-catch

		} // end while
	}
	public int priceTryCatch() {   // 가격 trycatch문
		while (true) {//사용자 입력 무한 루프
			try {

				System.out.print("입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				if(num <= 0) {
					System.out.println("가격은 0이나 음수가 될 수 없습니다.");
					continue;
				}

				return num;//예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();//버퍼 처리
				System.out.println("정수를 입력");
			}//end try-catch

		} // end while
	}

	public int numTryCatch() {   // 번호 trycatch문
		while (true) {//사용자 입력 무한 루프
			try {

				System.out.print("입력) ");
				int num = sc.nextInt();// 사용자가 입력한 번호
				return num;//예외가 발생하지 않는다면 값 리턴
			} catch (Exception e) {
				sc.nextLine();//버퍼 처리
				System.out.println("정수를 입력");
			}//end try-catch

		} // end while
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

	public void printProduct(ProductVO pdata) {// 상품 하나 출력
		System.out.println();
		if (pdata == null) {
			System.out.println("출력할 상품 없음");
			return;
		}
		System.out.println(pdata);
	}
	//===================================================================================  

	public int printAdminMenu(int num) {
		System.out.println();
		System.out.println("=== 관 리 자 모 드 ===");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 삭제");
		System.out.println("3. 상품 재고 변경");
		System.out.println("4. 관리자모드 종료");
		return menuTryCatch(num);
	}
	//=======================================================================
	// 상품 추가
	public int getProductPrice() {   // 상품 가격입력 받기
		System.out.println("추가하실 상품의 가격을 입력");
		return priceTryCatch();
	}
	public int getProductCnt() {   // 상품 가격입력 받기
		System.out.println("추가하실 상품의 재고를 입력");
		return cntTryCatch();
	}

	public String getProductName() {   // 상품 이름입력 받기
		System.out.println("추가하실 상품의 이름을 입력");
		System.out.print("입력) ");
		String name= sc.next();
		return name;
	}

	public boolean printCheckAddProduct() {
		System.out.println("상품 추가하시겠습니까?");
		System.out.println("1. Yes      2. No");
		int num= checkYesNo();
		if(num==1) {
			return true;
		}
		return false;
	}

	public void printAddProductTrue() {
		System.out.println("상품이 추가되었습니다.");
	}

	public void printAddProductFalse() {
		System.out.println("상품의 추가를 실패하셨습니다.");
	}

	//=======================================================================   
	// 상품 재고변경
	public int getChangePKNum() {
		System.out.println("재고변경하실 상품 번호를 입력해주세요.");
		return numTryCatch();
	}
	public boolean getChangeType() {
		System.out.println("재고변경 방식을 선택해주세요.");
		System.out.println("1. 재고증가      2. 재고감소");
		int num = checkYesNo();
		if(num == 1) {
			return true;
		}
		return false;
	}
	public int getChangeCnt() {
		System.out.println("변경하실 재고량을 입력해주세요.");
		return cntTryCatch();

	}
	
	public void printChangeCntOverFalse() {
		System.out.println("재고 0 미만이 될 수 없습니다.\n");
	}
	public void printChangeTrue() {
		System.out.println("재고 변경을 완료했습니다.\n");
	}
	public void printChangeFalse() {
		System.out.println("재고 변경을 실패하셨습니다.\n");
	}
	public boolean printCheckChange() {
		System.out.println("해당 상품 재고변경을 하시겠습니까?\n");
		System.out.println("1. Yes      2. No");
		int num= checkYesNo();
		if(num==1) {
			return true;
		}
		return false;
	}
	//=======================================================================   
	// 상품 삭제
	public int getDeletePKNum() {
		System.out.println("삭제하실 상품 번호를 입력해주세요.");
		int num = numTryCatch();
		return num;
	}
	public void printDeleteTrue() {
		System.out.println("삭제했습니다.\n");
	}
	public void printDeleteFalse() {
		System.out.println("삭제를 실패하셨습니다.\n");
	}

	public boolean printCheckDelete() {
		System.out.println("상품을 삭제하시겠습니까?\n");
		System.out.println("1. Yes      2. No");
		int num= checkYesNo();
		if(num==1) {
			return true;
		}
		return false;
	}
	
	public void printFalseNum() {
		System.out.println("해당 번호는 존재하지않습니다.");
	}
	
	//=======================================================================   

	public void printAdminEnd() {
		System.out.println("=== 관 리 자 모 드 종 료 ===\n");
	}
}
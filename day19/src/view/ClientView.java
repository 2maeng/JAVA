package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
// 목록출력,목록검색_이름,목록검색_가격
public class ClientView {
	private static Scanner sc=new Scanner(System.in);

	public int printClientMenu01() {
		System.out.println();
		System.out.println("=== 프 로 그 램 모 드 ===");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 프로그램 종료");
		System.out.print("입력) ");
		return sc.nextInt();
	}
	
	public String getSearchContent() {
		System.out.println();
		System.out.println("=== 이 름 으 로 검 색 ===");
		System.out.println("검색어 입력) ");
		String name = sc.next();
		return name;
	}
	
	public void printProduct(ProductVO pVO) {
		System.out.println();
		if(pVO == null) {
			System.out.println("=== 출 력 할 상 품 없 음 ===");
			return;
		}
		System.out.println("=== 상 품 출 력 ===");
		System.out.println(pVO);
	}
	
	public void printProductList(ArrayList<ProductVO> pdatas){
		System.out.println();
		if(pdatas.isEmpty()) { // 사용자 편의성 고려(UI/UX)
			System.out.println("=== 출 력 할 상 품 없 음 ===");
		}
		
		System.out.println("=== 상 품 목 록 출 력 ===");
		for(ProductVO data : pdatas) {
			System.out.println(data); // .toString()은 자동 호출됩니다.
		}
	}
	
	public MemberVO signUp() {
		System.out.println();
		System.out.println("=== 회 원 가 입 ===");
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		System.out.print("이름입력) ");
		String name=sc.next();
		return new MemberVO(mid,mpw,name);
	}
	
	public void signUpTrue() {
		System.out.println();
		System.out.println("회원가입 성공!");
	}
	
	public void signUpFalse() {
		System.out.println();
		System.out.println("회원가입 실패...");
	}
	
	public String getMpw() {
		System.out.println();
		System.out.println("=== 비 밀 번 호 확 인 ===");
		System.out.print("비밀번호입력) ");
		String mpw = sc.next();
		return mpw;
	}
	
	public String getChangeMpw() {
		System.out.println();
		System.out.println("=== 새 비 밀 번 호 확 인 ===");
		System.out.println("새 비밀번호 입력) ");
		String mpw = sc.next();
		return mpw;
	}
	
	public void printFalse() {
		System.out.println();
		System.out.println("비밀번호 불일치...");
	}
	
	public void printChangeMpwFalse() {
		System.out.println();
		System.out.println("비밀번호 변경 실패...");
	}
	
	public void printChangeMpwTrue() {
		System.out.println();
		System.out.println("비밀번호 변경 성공!");
	}
	
	public void printMemberDeleteTrue() {
		System.out.println();
		System.out.println("회원탈퇴 성공!");
	}
	
	public void printMemberDeleteFalse() {
		System.out.println();
		System.out.println("회원탈퇴 실패...");
	}
	
	public MemberVO signIn() {
		System.out.println();
		System.out.println("=== 로 그 인 ===");
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		return new MemberVO(mid, mpw, null);
	}
	
	public void signInTrue() {
		System.out.println();
		System.out.println("로그인 성공!");
	}
	
	public void signInFalse() {
		System.out.println();
		System.out.println("로그인 실패...");
	}
	
	public void printClientEnd01() {
		System.out.println();
		System.out.println("=== 프 로 그 램 종 료 ===");
	}
	
	public int printClientMenu02(MemberVO mVO) {
		System.out.println();
		System.out.println("=== 사 용 자 모 드 ===");
		System.out.println(" 현재 로그인한 사용자 이름 [" + mVO.getName() + "]");
		System.out.println("1. 로그아웃(사용자모드 종료)");
		System.out.println("2. 마이페이지"); //////////
		System.out.println("3. 회원탈퇴(사용자모드 종료)"); //////////
		System.out.println("4. 상품목록출력"); //////////
		System.out.println("5. 상품목록검색_이름으로 검색"); //////////
		System.out.println("6. 상품목록검색_가격으로 검색"); //////////
		System.out.println("7. 상품 검색_최고가 검색");
		System.out.println("8. 상품 검색_최저가 검색");
		System.out.print("입력) ");
		return sc.nextInt();
	}
	
	
	
	public ProductVO getSearchFilter() { // 반환값이 2개라 ProductVO
		System.out.println();
		System.out.println("=== 가 격 검 색 ===");
		System.out.println("1. 가장 비싼 상품 출력");
		System.out.println("2. 가장 싼 상품 출력");
		System.out.println("3. 가격 입력시 해당 금액보다 비싼 상품들 출력");
		System.out.println("4. 가격 입력시 해당 금액보다 싼 상품들 출력");
		System.out.println("5. 가격을 2번 입력시 price ~ price2까지의 상품들 출력");
		System.out.println("6. 종료");
		System.out.println("최저 가격 입력) ");
		int minPrice = sc.nextInt();
		System.out.println("최고 가격 입력) ");
		int maxPrice = sc.nextInt();
		ProductVO pVO = new ProductVO(0, "필터검색", minPrice, maxPrice);
										 // searchCondition
		return pVO;
	}
	
	public void printClientPriceMenuEnd() {
		System.out.println();
		System.out.println("=== 가 격 검 색 종 료 ===");
	}
	
	public void logout() {
		System.out.println();
		System.out.println("=== 로 그 아 웃 ===");
	}
	
	public void printClientEnd02() {
		System.out.println();
		System.out.println("=== 사 용 자 모 드 종 료 ===");
	}
	
}

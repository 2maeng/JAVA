package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

public class View {
	private static Scanner sc = new Scanner(System.in);
//	private ArrayList<String> searchCondition;
//	
//	public View() {
//		searchCondition = new ArrayList<String>();
//		searchCondition.add("이름");
//		searchCondition.add("가격");
//	}

	// 어떤 기능이 가능한지 보여주기
	public int printMenu() {
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 상품목록출력");
		System.out.println("2. 상품검색");
		System.out.println("3. 상품구매");
		System.out.println("4. 회원가입");
		System.out.println("5. 로그인");
		System.out.println("6. 로그아웃");
		System.out.println("7. 회원비번변경");
		System.out.println("8. 회원탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.println("입력) ");
		int action = sc.nextInt();
		return action;
	}

	// 상품목록출력
	public void printList(ArrayList<ProductVO> pdatas) {
		System.out.println("=== 목록출력 ===");
		if(pdatas.isEmpty()) {
			System.out.println("출력할 리스트 없음!");
			return;
		}
		for(ProductVO pdata : pdatas) {
			System.out.println(pdata);
		}
	}

	public int PrintSearchMenu() {
		System.out.println("=== 검색 메뉴 ===");
		System.out.println("1. 상품 이름 검색");
		System.out.println("2. 상품 가격 검색");
		System.out.println("입력) ");
		int action = sc.nextInt();
		return action;
	}

	// 상품검색
	public String getName() {
		System.out.println("상품 이름 검색) ");
		String name = sc.next();
		sc.nextLine();
		return name;
	}

	public ProductVO getPrice() {
		System.out.println("최저 가격 입력) ");
		int minPrice = sc.nextInt();
		System.out.println("최고 가격 입력) ");
		int maxPrice = sc.nextInt();

		if(maxPrice < minPrice) {
			int tmp = maxPrice;
			maxPrice = minPrice;
			minPrice = tmp;
		}

		ProductVO pVO = new ProductVO(minPrice, null, maxPrice, 0);
		return pVO;
	}
	
	// 상품검색 [ 선생님 풀이 ]
	public ProductVO funcC() {
		
		ProductVO pVO = new ProductVO();
		
		String searchCondition = "";
		System.out.println("Q. 이름으로 검색할래요?");
		System.out.println("1.YES 2.NO");
		int num = sc.nextInt();
		if(num == 1) { // 0번 인덱스 추가
			searchCondition += "이름";
			System.out.println("검색할 이름 입력) ");
			String name = sc.next();
			pVO.setName(name);
		}
		
		System.out.println("Q. 가격으로 검색할래요?");
		System.out.println("1.YES 2.NO");
		num = sc.nextInt();
		if(num == 1) { // 1번 인덱스 추가
			searchCondition += "가격";
			System.out.println("검색할 최저가 가격 입력) ");
			int min = sc.nextInt();
			System.out.println("검색할 최고가 가격 입력) ");
			int max = sc.nextInt();
			pVO.setPrice(min);
			pVO.setTmp(max);
		}
		
		if(searchCondition.equals("")) {
			searchCondition += "이름";
		}
		pVO.setSearchCondition(searchCondition);
		return pVO;
	}

	// 상품선택
	public int getNum() {
		System.out.println("상품번호입력) ");
		int num = sc.nextInt();
		return num;
	}

	// 상품구매
	public void printData(ProductVO pdata) {
		if(pdata == null) {
			System.out.println("출력할 데이터 없음!");
			return;
		}
		System.out.println(pdata);
	}

	public void printTrue() {
		System.out.println("성공!");
	}

	public void printFalse() {
		System.out.println("실패...");
	}

	// 회원가입
	// 로그인
	public MemberVO signIn() {
		System.out.println("아이디입력) ");
		String mid = sc.next();
		System.out.println("비밀번호입력) ");
		String mpw = sc.next();

		MemberVO mVO = new MemberVO(mid, mpw);
		return mVO;
	}

	// 회원비번변경
	public String getMpw(MemberVO mVO) { // 객체를 받아오는게 유지보수에 더욱 용이
		// A. 현재 로그인한 __님
		//	  비번 입력해보세요!
		System.out.println(mVO.getMid() + "비밀번호 입력) ");
		String mpw = sc.next();
		sc.nextLine();

		return mpw;
	}

	public String getChangeMpw(String mpw) {
		// B. 비번 불일치시, 실패
		//	  비번 일치시, 비번 변경가능!
		while(true) {
			System.out.println("새로운 비밀번호 입력) ");
			String npw = sc.next();
			sc.nextLine();
			
			if(!npw.equals(mpw)) { // 새로 입력한 비번이 이전 비번과 다를때
				return npw;
			}
			
		}

	}

	// 회원탈퇴

}

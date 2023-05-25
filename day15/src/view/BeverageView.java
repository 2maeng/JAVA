package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.BeverageVO;

public class BeverageView {

	// 높은 응집도를 가진 코드를 구현하기 위함
	// 최대 메뉴 갯수 공유자원으로 설정 -> 유지보수 용이 위함
	private static final int maxMenuNum = 5;
	// 여러번 쓰이기에 공유자원으로 클래스 안에 스캐너 생성
	private static Scanner sc = new Scanner(System.in);
	
	// 메뉴를 안내 해주는 기능
	// 1. 음료 목록 출력
	// 2. 음료 추가
	// 3. 음료 구매
	// 4. 음료 삭제
	// 5. 프로그램 종료
	public void printMenu() {
		System.out.println("=== 메뉴 프로그램 ===");
		System.out.println("1. 음료 목록 출력");
		System.out.println("2. 음료 추가");
		System.out.println("3. 음료 구매");
		System.out.println("4. 음료 삭제");
		System.out.println("5. 프로그램 종료");
	}
	
	// 사용자의 입력을 저장하는 기능
	public int getMenuNum() {
		while(true) {
			try {
				System.out.println("입력) ");
				int menuNum = sc.nextInt();
				
				if(1 <= menuNum && menuNum <= maxMenuNum) {
					return menuNum;
				}
				System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.\n");
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.\n");
				System.out.println("정수로 입력 해주세요!\n");
				return -1;
			}
		}
	}
	
	// 음료 목록을 출력하는 기능
	public void printBeverageList(ArrayList<BeverageVO> datas) {
		if(datas.size() == 0) {
			System.out.println("출력할 음료 상품이 없습니다.\n");
		}
		
		System.out.println("======= 음료 목록 출력 =======");
		
		for(BeverageVO v : datas) {
			System.out.println(v);
		}
		System.out.println("==========================\n");
	}
	
	// 사용자가 입력한 번호를 저장하는 기능
	public int getBeverageNum() {
		System.out.println("음료 번호 입력) ");
		int num = sc.nextInt();
		return num;
	}
	
	// 사용자가 입력한 가격을 저장하는 기능
	public int getBeveragePrice() {
		System.out.println("음료 가격 입력) ");
		int price = sc.nextInt();
		return price;
	}
	
	// 사용자가 입력한 개수 저장하는 기능
	public int getCnt() {
		System.out.println("구매할 개수 입력) ");
		int cnt = sc.nextInt();
		return cnt;
	}
	
	// 구매 완료를 안내 해주는 기능
	public void buySuccess() {
		System.out.println("음료 구매 완료!\n");
	}
	
	// 재고가 부족해서 구매 실패 했을때
	public void buyFail() {
		System.out.println("재고 부족으로 음료 구매 실패...\n");
	}
	
	// 재고 입력값 유효하지 않은 값
	public void buyFail2() {
		System.out.println("유효하지 않은 값입니다.\n");
	}
	
	// 음료 추가시 안내멘트
	public void addInfo() {
		System.out.println("음료 추가를 시작합니다.\n");
	}
	
	// 이름 입력받기
	public String getBeverageName() {
		System.out.println("이름 입력) ");
		String name = sc.next();
		return name;
	}
	
	// 음료 추가 완료를 안내 해주는 기능
	public void addSuccess() {
		System.out.println("음료 추가 완료!\n");
	}
	
	// 음료 삭제시 안내 멘트
	public void deleteInfo() {
		System.out.println("음료 삭제를 시작합니다.\n");
	}
	
	// 음료 삭제 완료를 안내 해주는 기능
	public void deleteSuccess() {
		System.out.println("음료 삭제 완료!\n");
	}
	
	// 프로그램 종료 안내 해주는 기능
	public void printEnd() {
		System.out.println("프로그램 종료...");
	}
	
	public void printFalse() {
		System.out.println("서비스 수행 실패...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

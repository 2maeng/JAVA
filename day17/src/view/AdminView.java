package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;

// 회원목록출력
public class AdminView {
	private static Scanner sc=new Scanner(System.in);
	
	public int printAdminMenu() {
		System.out.println();
		System.out.println("=== 관 리 자 모 드 ===");
		System.out.println("1. 회원목록출력");
		System.out.println("2. 관리자모드 종료");
		System.out.print("입력) ");
		return sc.nextInt();
	}
	
	public void printMemberList(ArrayList<MemberVO> mdatas) {
		System.out.println();
		if(mdatas.isEmpty()) {
			System.out.println("=== 가입한 회원이 없습니다. ===");
			return;
		}
		
		System.out.println("=== 회 원 목 록 ===");
		for(MemberVO mdata:mdatas) {
			System.out.println(mdata);
		}
	}
	
	public void printAdminEnd() {
		System.out.println();
		System.out.println("=== 관 리 자 모 드 종 료 ===");
	}
}

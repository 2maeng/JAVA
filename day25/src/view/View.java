package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.MovieVO;

public class View {
	
	private static Scanner sc = new Scanner(System.in);

	public void printMenu() {
		System.out.println("영화 프로그램입니다.");
		System.out.println("샘플 데이터를 크롤링 합니다...");
	}
	
	public void printTrue() {
		System.out.println("작업 성공!");
	} 
	
	public void printFalse() {
		System.out.println("작업 실패...");
	}
	
	public void printMovieList(ArrayList<MovieVO> mdatas) {
		System.out.println("영화 목록 출력입니다.\n");
		if(mdatas.isEmpty()) { // 사용자편의성고려(UI/UX)
			System.out.println("========= 영 화 없 음 =========");
			return;
		}
		
		for(MovieVO mdata : mdatas) {
			System.out.println(mdata); // .toString()은 자동호출됩니다!
		}
	}
	
	public int getMovieNum() {
		int num;
		while(true) {
			try {
				System.out.println("영화 번호 입력) ");
				num = sc.nextInt();
				sc.nextLine();
				if(num <= 0 ) {
					System.out.println("0보다 큰 정수를 입력하세요!\n");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로 입력하세요.\n");
			}
		}
		return num;
	}
	
	public String getMovieName() {
		System.out.println("변경할 영화 이름 입력) ");
		String name = sc.nextLine();
		return name;
	}
	
	public String getSearchMovieName() {
		System.out.println("검색할 영화 이름 입력) ");
		String name = sc.nextLine();
		return name;
	}
	
	public void printMovie(MovieVO mdata) {
		System.out.println("선택한 영화는 " + mdata);
	}
	
	public void printDeleteTrue(MovieVO mdata) {
		System.out.println(mdata + "가 삭제 되었습니다.\n");
	}
	
	public void printDelteFalse() {
		System.out.println("영화 삭제 실패...\n");
	}
	
	public void printChangeNameTrue(MovieVO mdata) {
		System.out.println(mdata.getName() + "(으)로 성공했습니다.");
	}
	
	public void printChangeNameFalse() {
		System.out.println("영화 이름 변경 실패...\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

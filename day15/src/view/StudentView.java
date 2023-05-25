package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentVO;

// MVC중에서 V를 담당하는 클래스로,
// main()을 동작시키는 것이 목표가 아님
// syso() 무조건 VIEW에서
public class StudentView {
	
	private static final int maxMenuNum = 6;
	// 높은 응집도를 가진 코드를 구현하기 위함
	private static Scanner sc = new Scanner(System.in);

	// 메뉴를 안내해주는 기능
	// 1. 학생 목록 출력
	// 2. 학생 검색
	// 3. 학생 정보 변경
	public void printMenu() {
		System.out.println("=== 학생부 프로그램 ===");
		System.out.println("1. 목록 출력");
		System.out.println("2. 학생 검색");
		System.out.println("3. 정보 변경");
		System.out.println("4. 학생 추가");
		System.out.println("5. 학생 삭제");
		System.out.println("6. 프로그램 종료");
	}

	// 사용자의 입력을 저장하는 기능
	public int getMenuNum() {
		while(true) {
			try {
				System.out.println("입력) ");
				int menuNum = sc.nextInt();
				
				if(1 <= menuNum && menuNum <= maxMenuNum){
					return menuNum;
				}
			} catch(Exception e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요!");
			}
		}
	}

	// 학생 목록을 출력하는 기능
	public void printStudentList(ArrayList<StudentVO> datas) { // 리스트를 받아옴
		System.out.println("=== 학생 목록 출력 ===");
		for(StudentVO v : datas) {
			System.out.println(v);
		}
	}

	// 검색한 학생의 정보를 출력하는 기능
	public void printStudent(StudentVO data) {
		System.out.println("=== 학생 출력 ===");
		System.out.println(data);
	}
	
	// 사용자가 입력한 번호를 저장하는 기능
	public int getStudentNum() {
		System.out.println("학생 번호 입력) ");
		int num = sc.nextInt();
		return num;
	}

	// 사용자가 입력한 점수를 저장하는 기능
	public int getStudentScore() {
		System.out.println("학생 점수 입력) ");
		int score = sc.nextInt();
		return score;
	}

	// 변경완료를 안내해주는 기능
	public void printInfo() {
		System.out.println("학생 정보 변경완료!");
	}
	
	// 학생 추가시 안내멘트
	public void printInfo_C_Start() {
		System.out.println("학생 추가를 시작합니다.");
	}
	
	// 이름 입력받기
	public String getStudentName() {
		System.out.println("이름 입력) ");
		String name = sc.next();
		return name;
	}
	
	// 학생 추가 완료를 안내 해주는 기능
	public void printInfo_C_End() {
		System.out.println("학생 추가 완료");
	}
	
	// 학생 삭제시 안내 멘트
	public void printInfo_D_Start() {
		System.out.println("학생 삭제를 시작합니다.");
	}
	
	// 학생 삭제 완료를 안내 해주는 기능
	public void printInfo_D_End() {
		System.out.println("학생 삭제 완료!");
	}

	// 프로그램 종료 안내해주는 기능
	public void printEnd() {
		System.out.println("프로그램 종료 ....");
	}
	
	public void printFalse() {
		System.out.println("서비스 수행 실패 ....");
	}
	
}

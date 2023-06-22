package view;

import java.util.ArrayList;
import java.util.InputMismatchException;

// [CommonView 설명]
// : 해당 클래스는 View 패키지의 공통기능들을 코딩하였습니다.

// [임포트]
//=====================================================================================================================
import java.util.Scanner;

import model.ChampVO;
import model.LineVO;
import model.MemberVO;
import model.ReplyVO;

public class CommonView {

	// [폰트]
	// =====================================================================================================================

	// [스캐너]
	// =====================================================================================================================
	private static Scanner scan = new Scanner(System.in);

	// [메뉴 모듈화]
	// =====================================================================================================================
//	private static final int CommonMaxMenuNum = 5; // : 프로그램 실행문구 메뉴 수

	// [유효성 검사]
	// 1. 정수 유효성 검사
	// 2. 문자 유효성 검사
	// =====================================================================================================================

	// 1. 정수 유효성 검사
	private static int intTcV(int min, int max) {

		while (true) { // 예외 처리가 완료될때까지 반복
			int num;
			try { // 예외 처리
				num = scan.nextInt(); // 입력값 저장
				scan.nextLine(); // 버퍼처리

			} catch (InputMismatchException e) { // 자료형 검사
				scan.nextLine(); // 버퍼처리
				System.out.println("정수로 입력해주세요");
				System.out.print("다시 입력해주세요 : ");
				continue;

			}

			if (num > max || num < min) {// 유효성 검사
				System.out.println("유효하지 않은 값입니다");
				System.out.print("다시 입력해주세요 : ");
				continue;
			}
			return num; // 입력값 리턴

		}
	} // 예외 처리 및 유효성 검사 모듈 종료

	public String getSearchName(String category) {
		while (true) {
			System.out.print("검색할 " + category + "이름을 입력해주세요 : ");
			String name = scan.next();

			return name;

		}
	}

	public String getName(String category) {
		while (true) {
			System.out.print(category + "이름을 입력해주세요 : ");
			String name = scan.next();
			System.out.println("정말로 " + name + "(으)로 입력하시겠습니까?");
			System.out.println("1) 예\t2) 아니오   3) 취소");
			int check = intTcV(1, 3);
			if (check == 2) {
				System.out.println("다시 입력해주세요");
				continue;

			} else if (check == 3) {
				System.out.println("입력을 취소합니다");
				return null;

			}
			return name;

		}
	}

	// [프로그램 시작 안내문]
	// =====================================================================================================================
	public void startCommnets() { // : 프로그램 첫 실행 안내문 출력 기능
		System.out.println("로딩중...");
		try {
			Thread.sleep(1500); // : 1.5초 후에 프로그램 메뉴 실행
			System.out.println("[＃Program.님 티어가 예상됨]_start♥");
			System.out.println("===============================");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// [프로그램 메뉴]
	// =====================================================================================================================
	public int getCommonMenu() { // : 공통 메뉴목록 출력 기능
		System.out.println("===========================");
		System.out.println("====== 프 로 그 램 메 뉴 ======");
		System.out.println("===========================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 챔피언 목록출력");
		System.out.println("4. 챔피언 검색");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(0, 4);

		return tryCatchmenuNum;

	}

	// [메서드]
	// 1. 회원가입
	// 2. 로그인
	// 3. 챔피언 목록출력
	// 4. 챔피언 검색
	// =====================================================================================================================

	// 1. 회원가입
	public MemberVO signUp() {
		String mId;
		String mPw;
		String mName;

		System.out.println("아이디를 입력해주세요");
		while (true) {
			mId = scan.next();

			if (mId.getBytes().length < 25) { // 길이 25바이트까지 varchar(25)
				break;

			}
			System.out.println("길이가 너무 깁니다!");

		}

		System.out.println("비밀번호를 입력해주세요");
		while (true) {
			mPw = scan.next();

			if (mPw.getBytes().length < 30) { // 길이 30바이트까지 varchar(30)
				break;

			}
			System.out.println("길이가 너무 깁니다!");

		}

		System.out.println("이름을 입력해주세요");
		while (true) {
			mName = scan.next();

			if (mName.getBytes().length < 25) { // 길이 30바이트까지 varchar(30)
				break;

			}
			System.out.println("길이가 너무 깁니다!");

		}
		MemberVO mVO = new MemberVO(mId, mName, mPw);
		return mVO;

	}

	// 2. 로그인
	public MemberVO login() {

		System.out.print("아이디 입력) ");
		String mId = scan.next();
		System.out.print("비밀번호 입력) ");
		String mPw = scan.next();

		MemberVO mVO = new MemberVO(mId, null, mPw);
		return mVO;

	}

	// 3. 챔피언 목록출력
	public int getChampListType() {
		System.out.println("검색메뉴를 선택해주세요");
		System.out.println("1) 전체	2) 라인	3) 티어");
		int select = intTcV(1, 3);
		return select;

	}

	public int getLineList(ArrayList<LineVO> ldatas) {
		for (int i = 0; i < ldatas.size(); i++) {
			System.out.print((i+1)+"번");
			System.out.println(ldatas.get(i));
		}
		System.out.println("라인을 선택해주세요) ");
		int line = intTcV(1, ldatas.size());
		return line;

	}

	public int getTier() {
		System.out.println("티어(1~5)를 입력해주세요.");
		int tier = intTcV(1, 5);
		return tier;
	}

	public int champSearchMenu() {
		System.out.println("검색메뉴를 선택해주세요");
		System.out.println("1) 이름   2) 라인,티어      0) 돌아가기");
		int select = intTcV(0, 2);
		return select;

	}
	public void printReplyList(ArrayList<ReplyVO> rdatas, ArrayList<ChampVO> cdatas) {

		if (rdatas.isEmpty()) { // : 목록데이터가 비어있는 상태
			System.out.println();
			System.out.println("출력할 댓글 목록이 없습니다");
			return;
		}

		for (int i = 0; i < rdatas.size(); i++) {
			String cName = cdatas.get(rdatas.get(i).getcNum()).getName();
			String mID = rdatas.get(i).getmId();
			System.out.println((i+1) + ". [작성자 : " + mID + "] [챔피언 : " + cName + "] " + rdatas.get(i).getComment());
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(" 로그: cView: printChampList: Thread.sleep 예외");
			e.printStackTrace();
		}
	}


	public void printChampList(ArrayList<ChampVO> cdatas, ArrayList<LineVO> ldatas) {

		if (cdatas.isEmpty()) { // : 챔피언 목록데이터가 비어있는 상태
			System.out.println();
			System.out.println("출력할 챔피언 목록이 없습니다");
			return;
		}
		// 챔피언 목록출력(번호, 이름, 라인, 티어)
		for (int i = 0; i < cdatas.size(); i++) {
			String name = cdatas.get(i).getName();
			String line = ldatas.get(cdatas.get(i).getLine()-1).getLine();
			int tier = cdatas.get(i).getTier();
			System.out.println("(" + (i + 1) + "번 " + name + " 라인 [" + line + " 티어: " + tier + " ]");
		}
		this.printChampListTrue();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(" 로그: cView: printChampList: Thread.sleep 예외");
			e.printStackTrace();
		}
	}

	// 4-4. 챔피언, 회원 검색
	public String ChampNameSearch() {
		System.out.println("검색할 챔피언 이름입력) ");
		String cName = scan.nextLine();
		return cName;
	}

	public ChampVO ChampSearch(ArrayList<LineVO> ldatas) {
		ChampVO cVO = new ChampVO(0);
		String select = "";
		int chooseAction = 0;

		System.out.println("Q. 라인 검색할래요?");
		System.out.println("1. YES    2. NO ");
		chooseAction = intTcV(1, 2);
		if (chooseAction == 1) {
			select += "라인";
			for (int i = 0; i < ldatas.size(); i++) {
				System.out.println((i + 1) + "번 라인: " + ldatas.get(i).getLine());
			}
			System.out.print("검색할 라인입력) ");
			int line = intTcV(1, 5);
			cVO.setLine(line);
		}

		System.out.println("Q. 티어 검색할래요?");
		System.out.println("1. YES 2. NO");
		chooseAction = intTcV(1, 2);
		if (chooseAction == 1) {
			select += "티어";
			System.out.print("검색할 티어입력) ");
			int tier = intTcV(1, 5);
			cVO.setTier(tier);
		}

		if (select.equals("")) {
			System.out.println("검색 종류 미지정으로 검색을 종료하겠습니다.");
			return null;
		}
		select += " 검색";

		cVO.setSelect(select);
		return cVO;

	}

	public void printBackMenu() {
		System.out.println("메뉴로 돌아갑니다");
	}

	public void printMemberInfo(MemberVO inmVO) {
		if (inmVO.isAdmin()) {
			System.out.println("관리자정보");
			System.out.println("아이디 : " + inmVO.getmId());
			System.out.println("이름 : " + inmVO.getmName());
			return;
		}
		System.out.println("회원정보");
		System.out.println(inmVO);

	}

	public boolean checkPW(MemberVO inmVO) {
		System.out.println("비밀번호를 입력해주세요");
		String pw = scan.next();
		if (inmVO.getmPw().equals(pw)) {
			System.out.println("확인되었습니다");
			return true;
		}
		System.out.println("비밀번호가 틀렸습니다");
		return false;
	}

	// 2. 비밀번호 변경
	public String changePassword(MemberVO inmVO) {
		System.out.print("현재 비밀번호 입력) ");
		String mPw = scan.next();
		if (!inmVO.getmPw().equals(mPw)) {
			System.out.println("비밀번호가 잘못되었습니다.");
			return null;
		}
		System.out.print("변경할 비밀번호 입력) ");
		String newmPw = scan.next();
		return newmPw;
	}

	public int getNum(int minnum, int maxnum) {
		System.out.print("번호를 입력해주세요 : ");
		int result = intTcV(minnum, maxnum);
		return result;
	}

	// [성공, 실패 메서드]
	// =====================================================================================================================
	public void signUpTrue() { // : 회원가입 관련 출력 기능
		System.out.println("회원가입 성공!"); // : 회원가입 성공

	}

	public void signUpFalse() { // : 회원가입 관련 출력 기능
		System.out.println("회원가입 실패.."); // : 회원가입 실패

	}

	public void loginTrue() { // : 로그인 관련 출력 기능
		System.out.println("로그인 성공!"); // : 로그인 성공

	}

	public void loginFalse() { // : 로그인 관련 출력 기능
		System.out.println("로그인 실패.."); // : 로그인 실패

	}

	public void printChampListTrue() { // : 챔피언 목록 출력 기능
		System.out.println("챔피언 목록출력 성공!"); // : 챔피언 목록 출력 성공

	}

	public void printChampListFalse() { // : 챔피언 목록 출력 기능
		System.out.println("챔피언 목록출력 실패.."); // : 챔피언 목록 출력 실패

	}

	public void champSearchTrue() { // : 챔피언 검색 관련 출력 기능
		System.out.println("챔피언 검색 성공!"); // : 챔피언 검색 성공

	}

	public void champSearchFalse() { // : 챔피언 검색 관련 출력 기능
		System.out.println("챔피언 검색 실패.."); // : 챔피언 검색 실패

	}

	public void changePasswordTrue() { // : 비밀번호 변경 관련 출력 기능
		System.out.println("비밀번호 변경 성공!"); // : 비밀번호 변경 성공

	}

	public void changePasswordFalse() { // : 비밀번호 변경 관련 출력 기능
		System.out.println("비밀번호 변경 실패.."); // : 비밀번호 변경 실패

	}

	public void programExit() { // : 프로그램 종료 출력 기능
		System.out.println("============================");
		System.out.println("프로그램명) 님 티어가 예상됨\n");
		System.out.println("기획 및 설계) No Pain No Coder");
		System.out.println("----------------------------");
		System.out.println("M) 우리승차니, 이맹, 두완쎈세, 멍백교");
		System.out.println("V) 성순");
		System.out.println("C) 준태찡");
		System.out.println("============================");
		System.out.println("프로그램 종료. 이용해 주셔서 감사합니다."); // : 프로그램 종료

	}

}
package view;

import java.util.ArrayList;
import java.util.InputMismatchException;

//[UserView 설명]
//: 해당 클래스는 View 패키지의 사용자 목록,기능들을 코딩하였습니다.

//[0. Import]
//=====================================================================================================================
import java.util.Scanner;

import model.BookMarkVO;
import model.ChampVO;
import model.ForbiddenWordVO;
import model.LineVO;
import model.MemberVO;
import model.ReplyVO;

public class UserView {

	// [폰트]
	// =====================================================================================================================

	// [스캐너]
	// =====================================================================================================================
	private static Scanner scan = new Scanner(System.in);

	// [메뉴 모듈화]
	// =====================================================================================================================
	//	private static final int UserMaxMenuNum = 5; // : 사용자 프로그램 실행문구 메뉴 수
	//	private static final int UserMypageMaxMenuNum = 5; // : 사용자 프로그램 마이페이지 실행문구 메뉴 수
	//	private static final int UserBookmarkMaxMenuNum = 2; // : 사용자 프로그램 즐겨찾기 실행문구 메뉴 수
	//	private static final int UsouteplyMaxMenuNum = 3; // 사용자 프로그램 댓글
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

	// [사용자 모드 시작 안내문]
	// =====================================================================================================================
	public void StartUserCommnets() { // : 사용자 프로그램 첫 실행 안내문 출력 기능
		System.out.println("잠시만 기다려주세요...");
		try {
			Thread.sleep(1500); // : 1.5초 후에 프로그램 메뉴 실행
			System.out.println("[＃Program.님 티어가 예상됨]_사용자 모드 start♥"); 
			System.out.println("========================================");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// [사용자 메뉴]
	// =====================================================================================================================
	public int userMenu() { // : 사용자 메뉴목록 출력 기능
		System.out.println("=========================");
		System.out.println("====== 사 용 자 메 뉴 ======");
		System.out.println("=========================");
		System.out.println("1. 챔피언 목록출력");
		System.out.println("2. 챔피언 검색");
		System.out.println("3. 게임하기");
		System.out.println("4. 마이페이지");
		System.out.println("0. 로그아웃");
		System.out.print("메뉴 번호입력) ");
		int tryCatchmenuNum = intTcV(0, 4);

		return tryCatchmenuNum;

	}

	public int userMypageMenu() { // : 마이페이지 메뉴목록 출력 기능
		System.out.println("=========================");
		System.out.println("====== 마 이 페 이 지 ======");
		System.out.println("=========================");
		System.out.println("1. 즐겨찾기 관리");
		System.out.println("2. 댓글 관리");
		System.out.println("3. 비밀번호 변경");
		System.out.println("4. 회원 탈퇴");
		System.out.println("0. 돌아가기");
		System.out.print("메뉴 번호입력) ");
		int tryCatchmenuNum = intTcV(0, 4);

		return tryCatchmenuNum;



	}

	public int userBookmark() { // : 즐겨찾기 메뉴목록 출력 기능
		System.out.println("======================");
		System.out.println("====== 즐 겨 찾 기 ======");
		System.out.println("======================");
		System.out.println("1. 삭제");
		System.out.println("2. 목록출력");
		System.out.print("메뉴 번호입력) ");
		int tryCatchmenuNum = intTcV(1, 2);

		return tryCatchmenuNum;



	}

	public int userReplyMenu() { // : 사용자 댓글 메뉴목록 출력 기능
		System.out.println("=========================");
		System.out.println("======= 댓 글 메 뉴 =======");
		System.out.println("=========================");
		System.out.println("1. 댓글목록출력  ");
		System.out.println("2. 댓글 수정");
		System.out.println("3. 댓글 삭제");
		System.out.print("메뉴 번호입력) ");
		int tryCatchmenuNum =intTcV(1,3);
		return tryCatchmenuNum;
	}
	// [메서드]
	// 1. 챔피언 선택 - 마이페이지
	// 2. 비밀번호 변경 - 마이페이지
	// 3. 회원탈퇴 - 마이페이지
	// 4. 즐겨찾기 - 삭제
	// =====================================================================================================================

	// 1. 챔피언 선택
	public int champSearchMenu() {
		System.out.println("검색메뉴를 선택해주세요");
		System.out.println("1) 이름   2) 라인   3) 티어   4) 라인,티어");
		int select = intTcV(1, 4);
		return select;

	}

	// 3. 회원탈퇴
	public int deleteUser(MemberVO inmVO) {
		System.out.println("회원탈퇴를 하시겠습니까?");
		System.out.println("1. YES\t2. NO");
		int select = intTcV(1, 2);
		return select;

	}

	// 4. 즐겨찾기 삭제
	public int getSelectBookMark() {
		System.out.println("사용기능을 선택해주세요");
		System.out.println("1. 목록출력\t2. 삭제");
		int select = intTcV(1, 2);
		return select;

	}

	// 댓글작성 yes or no
	public int bookMarkDeleteCheck() {
		System.out.println("즐겨찾기 삭제 하시겠습니까?");
		System.out.println("1. YES\t2. NO");
		int select = intTcV(1, 2);
		return select;
	}

	public int getChampMenu() {
		System.out.println("1.댓글작성		2.즐겨찾기추가		0.돌아가기");
		System.out.print("번호를 입력해주세요) ");
		int num=intTcV(0, 2);
		return num;
	}

	// 댓글 작성
	public String getReply() {
		System.out.print("댓글의 내용을 입력해주세요) ");
		String reply=scan.nextLine();
		return reply;
	}
	// 댓글 수정
	public String getChangeReply() {
		System.out.print("수정할 댓글의 내용을 입력해주세요) ");
		String reply=scan.nextLine();
		return reply;
	}

	// 챔피언 번호받는 기능
	public int getChampNum(int num) {
		System.out.print("챔피언 번호 입력)");
		int cNum=intTcV(1, num);
		return cNum; // 트라이 케치 해야함
	}

	// 즐겨찾기 목록 출력
	public void printBookMark(ArrayList<BookMarkVO> bdatas,ArrayList<ChampVO> cdatas, ArrayList<LineVO> ldatas) {
		if(bdatas.isEmpty()) {
			System.out.println("출력할 댓글이 없습니다.");
		}else {
			for(int i=0;i < bdatas.size();i++) {
				System.out.print((i+1)+"번");
				for(int j=0;j < cdatas.size();j++) {
					if(bdatas.get(i).getcNum() == cdatas.get(j).getNum()){
						String cName=cdatas.get(j).getName();
						System.out.print(" 챔피언"+cName);
						for(int k=0;k < ldatas.size();k++) {
							if(cdatas.get(j).getLine()==ldatas.get(k).getNum()) {
								String line=ldatas.get(k).getLine();
								System.out.println(" 의 라인 "+line);
								break;
							}
						}
						break;
					}
				}
			}
		}
	}
	// 댓글 목록출력
	public void printReply(ArrayList<ReplyVO> rdatas,ArrayList<ChampVO> cdatas) {
		if(rdatas.isEmpty()) {
			System.out.println("출력할 댓글이 없습니다.");
		}else {

			for(int i=0;i < rdatas.size();i++) {
				System.out.print((i+1)+"번");
				for(int j=0;j < cdatas.size();j++) {
					if(rdatas.get(i).getcNum() == cdatas.get(j).getNum()){
						String cName=cdatas.get(j).getName();
						System.out.print(" 챔피언 ["+cName+"]:");
						System.out.println(rdatas.get(i).getComment()+"\n댓글 날짜: "+rdatas.get(i).getCreateDT()+"\n");
						break;
					}
				}
			}
		}
	}

	public void printChamp(ChampVO cVO,ArrayList<LineVO> ldatas,ArrayList<ReplyVO> rdatas) {
		for(int i=0; i<ldatas.size(); i++) {
			if(cVO.getLine()==ldatas.get(i).getNum()){
				System.out.println("["+ldatas.get(i).getLine()+"] "+cVO.getName()+" [승률:"+(cVO.getWinCnt() * 100.0 / cVO.getPickCnt())+"]");
				break;
			}
		}
		if(rdatas.isEmpty()) {
			System.out.println("출력할 댓글이 없습니다.");
		}else {

			for(int i=0; i<rdatas.size(); i++) {
				System.out.println((i+1)+"번 댓글--"+rdatas.get(i).getComment());
			}
		}
	}

	public void printGameResult(ChampVO incVO) {
		double persent = incVO.getWinCnt() * 100.0 / incVO.getPickCnt();
		int p =(int)Math.floor(persent);
		System.out.println("이번 게임의 확률은 " + p + "% 입니다");
		try {
			System.out.println("결과를 발표합니다");
			System.out.println("3");
			Thread.sleep(1000);
			System.out.println("2");
			Thread.sleep(1000);
			System.out.println("1");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (incVO.getNum() == 1) {
			System.out.println("게임을 승리하였습니다");
			return;
		}
		System.out.println("게임을 패배하였습니다");
	}
	// [성공, 실패 메서드]
	// =====================================================================================================================


	public void champChooseTrue() { // : 챔피언 선택 관련 출력 기능
		System.out.println("챔피언 선택 접속 성공!"); // : 챔피언 선택 접속 성공

	}

	public void champChooseFalse() { // : 챔피언 선택 관련 출력 기능
		System.out.println("챔피언 선택 접속 실패.."); // : 챔피언 선택 접속 실패

	}

	public void signUpMyPageTrue() { // : 마이페이지 관련 출력 기능
		System.out.println("마이페이지 접속 성공!"); // : 마이페이지 접속 성공

	}

	public void signUpMyPageFalse() { // : 마이페이지 관련 출력 기능
		System.out.println("마이페이지 접속 실패.."); // : 마이페이지 접속 실패

	}

	public void deleteAccountTrue() { // : 회원탈퇴 관련 출력 기능
		System.out.println("회원탈퇴 성공!"); // : 회원탈퇴 성공

	}

	public void deleteAccountFalse() { // : 회원탈퇴 관련 출력 기능
		System.out.println("회원탈퇴 실패.."); // : 회원탈퇴 실패

	}

	public void bookMarkTrue() { // : 즐겨찾기 관련 출력 기능
		System.out.println("즐겨찾기 추가 성공!"); // : 즐겨찾기 추가 성공

	}

	public void bookMarkFalse() { // : 즐겨찾기 관련 출력 기능
		System.out.println("즐겨찾기 추가 실패.."); // : 즐겨찾기 추가 실패

	}

	public void bookMarkDeleteTrue() { // : 즐격찾기 삭제 출력 기능
		System.out.println("즐겨찾기 삭제 성공!"); // : 즐겨찾기 삭제 성공

	}

	public void bookMarkDeleteFalse() { // : 즐격찾기 삭제 출력 기능
		System.out.println("즐겨찾기 삭제 실패.."); // : 즐겨찾기 삭제 실패

	}
	public void replyDeleteTrue() { // : 즐격찾기 삭제 출력 기능
		System.out.println("댓글 삭제 성공!"); // : 즐겨찾기 삭제 성공

	}

	public void replyDeleteFalse() { // : 즐격찾기 삭제 출력 기능
		System.out.println("댓글 삭제 실패.."); // : 즐겨찾기 삭제 실패

	}

	public void bookMarkPrintTrue() { // : 즐겨찾기 목록 출력 기능
		System.out.println("즐겨찾기 목록출력 성공!"); // : 즐겨찾기 목록출력 성공

	}

	public void bookMarkPrintFalse() { // : 즐겨찾기 목록 출력 기능
		System.out.println("즐겨찾기 목록출력 실패.."); // : 즐겨찾기 목록출력 실패

	}

	public void gameStartTrue() { // : 게임하기 목록 출력 기능
		System.out.println("게임접속 성공!"); // : 게임접속 성공

	}

	public void gameStartFalse() { // : 게임하기 목록 출력 기능
		System.out.println("게임접속 실패.."); // : 게임접속 실패

	}

	public void commentsTrue() { // : 댓글기능 출력 기능
		System.out.println("댓글기능 접속 성공!"); // : 댓글기능 접속 성공

	}

	public void commentsFalse() { // : 댓글기능 출력 기능
		System.out.println("댓글기능 접속 실패.."); // : 댓글기능 접속 실패

	}
	// 댓글 작성 성공,실패
	public void printReplyTrue() { // : 댓글작성 성공
		System.out.println("댓글작성 성공!");

	}
	public void printReplyFalse() { // : 댓글작성 실패
		System.out.println("댓글작성 실패..");

	}
	public void printReplyWord(ArrayList<ForbiddenWordVO> fdatas) {
		System.out.println("금지어 사용으로인해 댓글을 작성할 수 없습니다.");
		System.out.println("사용된 금지어 목록");
		for(int i=0; i<fdatas.size(); i++) {
			System.out.println((i+1)+"번 ["+fdatas.get(i).getBlock()+"]");
		}
	}
	// 즐겨찾기 추가
	public void printbookMarktrue() {
		System.out.println("즐겨찾기 추가 성공!");
	}

	public void printbookMarkFalse() {
		System.out.println("즐겨찾기 추가 실패..");
	}
	public void printBookMarkDuplicate() {
		System.out.println("이미 즐겨찾기가 되어있습니다.");
	}

	public void printReturn() {
		System.out.println("0번) 돌아가기");
	}

	public void printExitUser() {		// 추가
		System.out.println("사용자모드를 종료합니다");
	}


	public void returnUser() {	// 추가
		System.out.println("사용자모드로 돌아갑니다.");
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
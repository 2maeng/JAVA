package view;

import java.util.ArrayList;
import java.util.InputMismatchException;

//[AdminView 설명]
//: 해당 클래스는 View 패키지의 관리자 목록,기능들을 코딩하였습니다.

//[0. Import]
//=====================================================================================================================
import java.util.Scanner;

import model.ForbiddenWordVO;
import model.MemberVO;

public class AdminView {

	// [폰트]
	// =====================================================================================================================
	// [스캐너]
	// =====================================================================================================================
	private static Scanner scan = new Scanner(System.in);

	// [메뉴 모듈화]
	// =====================================================================================================================
	//	private static final int AdminMaxMenuNum = 6; // : 관리자 프로그램 실행문구 메뉴 수
	//	private static final int AdminChampChangeMaxMenuNum = 4; // : 관리자 프로그램 챔피언 정보변경 실행문구 메뉴 수
	//	private static final int AdminMemberManagementMaxMenuNum = 4; // : 관리자 프로그램 회원목록 실행문구 메뉴 수
	//	private static final int AdminCommentsMaxMenuNum = 2; // : 관리자 프로그램 댓글기능 실행문구 메뉴 수
	//	private static final int AdminProhibitedWordsMaxMenuNum = 3; // : 관리자 프로그램 금지어관리 실행문구 메뉴 수

	// [유효성 검사]
	// 1. 정수 유효성 검사
	// 2. 문자 유효성 검사
	// =====================================================================================================================

	// 1. 정수 유효성 검사
	private static int intTcV(int min, int max) {

		while (true) { // 예외 처리가 완료될때까지 반복
			int num;
			try { // 예외 처리
				System.out.print("입력) ");
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

	// [관리자 모드 시작 안내문]
	// =====================================================================================================================
	public void StartUserCommnets() { // : 사용자 프로그램 첫 실행 안내문 출력 기능
		System.out.println("잠시만 기다려주세요...");
		try {
			Thread.sleep(1500); // : 1.5초 후에 프로그램 메뉴 실행
			System.out.println("[＃Program.님 티어가 예상됨]_관리자 모드 start♥");
			System.out.println("========================================");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// [관리자 메뉴]
	// =====================================================================================================================
	public int AdminMenu() { // : 관리자 메뉴목록 출력 기능
		System.out.println("=========================");
		System.out.println("====== 관 리 자 메 뉴 ======");
		System.out.println("=========================");
		System.out.println("1. 마이페이지");
		System.out.println("2. 챔피언 관리");
		System.out.println("3. 회원관리");
		System.out.println("4. 댓글관리");
		System.out.println("5. 금지어 관리");
		System.out.println("0. 로그아웃");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(0, 5);

		return tryCatchmenuNum;

	}

	public int AdminMyPageMenu() { // : 관리자 마이페이지 출력 기능
		System.out.println("=========================");
		System.out.println("====== 마 이 페 이 지 ======");
		System.out.println("=========================");
		System.out.println("1. 관리자 정보 확인");
		System.out.println("2. 비밀번호 변경");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(1, 2);

		return tryCatchmenuNum;
	}

	public int AdminChampChangeMenu() { // : 챔피언 정보변경 출력 기능
		System.out.println("=============================");
		System.out.println("====== 챔 피 언 정 보 변 경 ======");
		System.out.println("=============================");
		System.out.println("1. 챔피언 이름 변경");
		System.out.println("2. 챔피언 추가");
		System.out.println("3. 티어 변경");
		System.out.println("4. 챔피언 삭제");
		System.out.println("0. 돌아가기");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(0, 4);

		return tryCatchmenuNum;
	}

	public int AdminMemberManagementMenu() { // : 회원관리 목록 출력 기능
		System.out.println("=============================");
		System.out.println("======= 회 원 정 보 변 경 =======");
		System.out.println("=============================");
		System.out.println("1. 회원삭제");
		System.out.println("2. 관리자 권한부여");
		System.out.println("3. 경고 카운트 관리");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(1, 3);

		return tryCatchmenuNum;
	}

	public int AdminCommentsMenu() { // : 댓글관리 목록 출력 기능
		System.out.println("=======================");
		System.out.println("====== 댓 글 삭 제 ======");
		System.out.println("=======================");
		System.out.println("1. 회원 댓글목록");
		System.out.println("2. 미확인 댓글목록");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(1, 2);

		return tryCatchmenuNum;
	}

	public int AdminProhibitedWordsMenu() { // : 금지어 목록 출력 기능
		System.out.println("=========================");
		System.out.println("====== 금 지 어 관 리 ======");
		System.out.println("=========================");
		System.out.println("1. 금지어 목록출력");
		System.out.println("2. 금지어 추가");
		System.out.println("3. 금지어 삭제");
		System.out.println("메뉴 번호를 입력해주세요. ");
		int tryCatchmenuNum = intTcV(1, 3);

		return tryCatchmenuNum;

	}
	public void printForbiddenList(ArrayList<ForbiddenWordVO> fdatas) {
		if(fdatas.isEmpty()) {
			System.out.println("출력할 목록이 없습니다.");
		}else {

			for(int i = 0; i < fdatas.size(); i++) {
				System.out.println((i+1)+". "+fdatas.get(i).getBlock());
			}
		}

	}
	public String getWord() {
		while (true) {
			System.out.print("추가할 금지어를 입력해주세요 : ");
			String word = scan.next();
			System.out.println("정말로 " + word + "(을)를 금지어로 추가하시겠습니까?");
			System.out.println("1) 예\t2) 아니오   3) 추가 취소");
			int check = intTcV(1, 3);
			if (check == 2) {
				System.out.println("다시 입력해주세요");
				continue;

			} else if (check == 3) {
				System.out.println("금지어 추가를 취소합니다");
				return null;

			}
			return word;

		}
	}


	public int getSearchType() {
		System.out.println("1) 누적 경고수 3회이상\t2) 이름검색");
		int select = intTcV(1,2);
		return select;
	}

	public String getMId() {
		System.out.println("아이디를 입력해주세요");
		String mId=scan.next();
		return mId;
	}

	// [메서드]
	// 1. 비밀번호 변경
	// 2. 챔피언 이름 변경
	// 3. 티어 변경
	// 4. 챔피언 추가
	// 5. 회원삭제
	// 6. 관리자 권한부여
	// 7. 회원목록출력
	// 8. 경고 카운트 관리
	// 9. 댓글삭제
	// 10. 미확인 댓글목록
	// 11. 금지어 목록출력
	// 12. 금지어 추가
	// 13. 금지어 삭제
	// =====================================================================================================================

	// 챔피언 라인
	public int getCline() {
		System.out.println("1. 탑");
		System.out.println("2. 원딜");
		System.out.println("3. 미드");
		System.out.println("4. 원딜");
		System.out.println("5. 서폿");
		System.out.println("챔피언 라인을 입력해주세요. ");
		int cLine =intTcV(1, 5);
		
		return cLine;
	}

	// 1. 비밀번호 변경
	public int changePassword() {
		System.out.println("Q. 비밀번호 변경 하시겠습니까?");
		System.out.println("1.YES  2.NO");
		int num = intTcV(1, 2);
		return num;
	}

	public String getNewPassword() {
		System.out.print("변경할 비번입력) ");
		String newPwd = scan.next();
		return newPwd;
	}

	// 2. 챔피언 이름 변경

	// 챔피언 이름 변경
	public int changeCName() {
		System.out.println("Q. 챔피언 이름변경 하시겠습니까?");
		System.out.println("1.YES  2.NO");
		int num = intTcV(1, 2);
		return num;
	}

	// 챔피언 이름
	public String getCName() {
		System.out.print("챔피언 이름을 입력해주세요) ");
		String cName = scan.nextLine();
		return cName;
	}

	// 3. 티어 변경
	public int changeTier() {
		System.out.println("Q. 티어변경 하시겠습니까?");
		System.out.println("1.YES  2.NO");
		int num = intTcV(1, 2);
		return num;
	}

	// 챔피언 티어
	public int getCTier() {
		System.out.println("챔피언 티어를 입력해주세요) ");
		int cTier = intTcV(1, 5);
		return cTier;
	}

	// 4. 챔피언 추가
	public int addChamp() {
		System.out.println("Q. 챔피언을 추가하시겠습니까?");
		System.out.println("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 5. 회원삭제
	public int deleteUser() {
		System.out.println("Q. 회원을 삭제하시겠습니까?");
		System.out.println("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 6. 관리자 권한부여
	public int adminEmpowermentr() {

		System.out.println("Q. 관리자 권한을 부여하시겠습니까?");
		System.out.println("1.권한 부여	  2.권한 회수		0.돌아가기");
		int num = intTcV(0, 2);
		return num;
	}
	public int warnCountMenu() {

		System.out.println("Q. 경고 카운트를 변경하시겠습니까?");
		System.out.println("1.경고카운트증가		2.경고카운트감소		0.돌아가기");
		int num = intTcV(0, 2);
		return num;
	}

	// 7. 회원목록출력
	public void printUserList(ArrayList<MemberVO> mdatas) {
		if(mdatas.isEmpty()) {
			System.out.println("출력할 목록이 없습니다.");
		}else {

			for (int i = 0; i < mdatas.size(); i++) {
				System.out.println((i+1) + ". " + mdatas.get(i));
			}
		}
	}

	// 9. 댓글삭제
	public int deleteComments() {

		System.out.println("Q. 댓글을 삭제하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 10. 미확인 댓글목록
	public int unconfirmedComments() {

		System.out.println("Q. 미확인 댓글을 확인하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 11. 금지어 목록출력
	public int forbbidenCommentsPrintList() {

		System.out.println("Q. 금지어 목록출력하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 12. 금지어 추가
	public int forbbidenCommentsAdd() {

		System.out.println("Q. 금지어를 추가하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}

	// 13. 금지어 삭제
	public int forbbidenCommentsDelete() {

		System.out.println("Q. 금지어를 삭제하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = intTcV(1, 2);
		return num;
	}
	public void printReturn() {
		System.out.println("0번) 돌아가기");
	}

	// [성공, 실패 메서드]
	// =====================================================================================================================
	public void champAddTrue() { // : 챔피언 추가 관련 출력 기능
		System.out.println("챔피언 추가 성공!"); // : 챔피언 추가 성공

	}

	public void champAddFalse() { // : 챔피언 추가 관련 출력 기능
		System.out.println("챔피언 추가 실패.."); // : 챔피언 추가 실패

	}
	public void champDeleteTrue() { // : 챔피언 추가 관련 출력 기능
		System.out.println("챔피언 삭제 성공!"); // : 챔피언 추가 성공

	}

	public void champDeleteFalse() { // : 챔피언 추가 관련 출력 기능
		System.out.println("챔피언 삭제 실패.."); // : 챔피언 추가 실패

	}

	public void champChangeInfoTrue() { // : 챔피언 정보변경 관련 출력 기능
		System.out.println("챔피언 정보변경 성공!"); // : 챔피언 정보변경 성공

	}

	public void champChangeInfoFalse() { // : 챔피언 정보변경 관련 출력 기능
		System.out.println("챔피언 정보변경 실패.."); // : 챔피언 정보변경 실패

	}

	public void champChangeNameTrue() { // : 챔피언 이름변경 관련 출력 기능
		System.out.println("챔피언 이름변경 성공!"); // : 챔피언 이름변경 성공

	}

	public void champChangeNameFalse() { // : 챔피언 이름변경 관련 출력 기능
		System.out.println("챔피언 이름변경 실패.."); // : 챔피언 이름변경 실패

	}


	public void tierChangeTrue() { // : 티어변경 관련 출력 기능
		System.out.println("티어변경 성공!"); // : 티어변경 성공

	}

	public void tierChangeFalse() { // : 티어변경 관련 출력 기능
		System.out.println("티어변경 실패.."); // : 티어변경 실패

	}

	public void commentsDeleteTrue() { // : 댓글삭제 관련 출력 기능
		System.out.println("댓글삭제 성공!"); // : 댓글삭제 변경 성공

	}

	public void commentsDeleteFalse() { // : 댓글삭제 관련 출력 기능
		System.out.println("댓글삭제 실패.."); // : 댓글삭제 변경 실패

	}

	public void unconfirmedCommentsPrintTrue() { // : 미확인 댓글목록 출력 관련 출력 기능
		System.out.println("미확인 댓글목록 출력 성공!"); // : 미확인 댓글목록 출력 성공

	}

	public void unconfirmedCommentsPrintFalse() { // : 미확인 댓글목록 출력 관련 출력 기능
		System.out.println("미확인 댓글목록 출력 실패.."); // : 미확인 댓글목록 출력 실패

	}

	public void forbiddenWordPrintTrue() { // : 금지어 목록출력 출력 관련 출력 기능
		System.out.println("금지어 목록출력 성공!"); // : 금지어 목록출력 출력 성공

	}

	public void forbiddenWordPrintFalse() { // : 금지어 목록출력 출력 관련 출력 기능
		System.out.println("금지어 목록출력 출력 실패.."); // : 금지어 목록출력 출력 실패

	}

	public void forbiddenWordAddTrue() { // : 금지어 추가 관련 출력 기능
		System.out.println("금지어 추가 성공!"); // : 금지어 추가 성공

	}

	public void forbiddenWordAddFalse() { // : 금지어 추가 관련 출력 기능
		System.out.println("금지어 추가 실패.."); // : 금지어 추가 실패

	}

	public void forbiddenWordDeleteTrue() { // : 금지어 삭제 관련 출력 기능
		System.out.println("금지어 삭제 성공!"); // : 금지어 삭제 성공

	}

	public void forbiddenWordDeleteFalse() { // : 금지어 삭제 관련 출력 기능
		System.out.println("금지어 삭제 실패.."); // : 금지어 삭제 실패

	}

	public void userDeleteTrue() { // : 회원 삭제 관련 출력 기능
		System.out.println("회원 삭제 성공!"); // : 회원 삭제 성공

	}

	public void userDeleteFalse() { // : 회원 삭제 관련 출력 기능
		System.out.println("회원 삭제 실패.."); // : 회원 삭제 실패

	}

	public void adminPowerTrue() { // : 관리자 권한부여 관련 출력 기능
		System.out.println("관리자 권한부여 성공!"); // : 관리자 권한부여 성공

	}

	public void adminPowerFalse() { // : 관리자 권한부여 관련 출력 기능
		System.out.println("관리자 권한부여 실패.."); // : 관리자 권한부여 실패

	}
	public void adminLostPowerTrue() { // : 관리자 권한박탈 관련 출력 기능
		System.out.println("관리자 권한박탈 성공!"); // : 관리자 권한박탈 성공

	}

	public void adminLostPowerFalse() { // : 관리자 권한박탈 관련 출력 기능
		System.out.println("관리자 권한박탈 실패.."); // : 관리자 권한박탈 실패

	}

	public void userPrintTrue() { // : 회원목록출력 관련 출력 기능
		System.out.println("회원목록출력 성공!"); // : 회원목록출력 성공

	}

	public void userPrintFalse() { // : 회원목록출력 관련 출력 기능
		System.out.println("회원목록출력 실패.."); // : 회원목록출력 실패

	}

	public void managementForbbidenTrue() { // : 경고카운트관리 관련 출력 기능
		System.out.println("경고카운트관리 성공!"); // : 경고카운트관리 성공

	}

	public void managementForbbidenFalse() { // : 경고카운트관리 관련 출력 기능
		System.out.println("경고카운트관리 실패.."); // : 경고카운트관리 실패

	}
	public void returnManage() {
		System.out.println("관리자메뉴로 돌아갑니다.");
	}

}
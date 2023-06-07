package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.NewsDAO;
import model.NewsVO;
import view.View;

public class Ctrl {
	private NewsDAO nDAO;
	private MemberDAO mDAO;
	private View view;
	private MemberVO member;
	
	public Ctrl() {
		this.nDAO = new NewsDAO();
		this.mDAO = new MemberDAO();
		this.view = new View();
		this.member = null;
	}
	
	public void startApp() {
		while(true) {
			int action = view.printProgramMenu(3); // V에서 받은 프로그램 메뉴를 출력 후 입력받은 번호를 C action에 담음
			
// ========================================== 프로그램 메뉴 - 로그인 ==========================================
			
			if (action == 1) {
				MemberVO mdata = view.signIn(); // V에서 사용자가 입력한 아이디와 비밀번호를 mdata에 저장
				member = mDAO.selectOne(mdata); // mdata에 해당하는 회원을 추출해서 member 객체에 대입
				
				if (member == null) { // 해당하는 회원이 없을경우
					view.signInFalse(); // 로그인 실패
					continue;
				}
				view.signInTrue(); // 로그인 성공
				
				while(true) {
					action = view.printUserMenu(6); // V에서 받은 사용자 메뉴를 출력 후 입력받은 번호를 C action에 담음
					
// ========================================== 사용자 메뉴 - 뉴스목록출력 ==========================================
					
					if (action == 1) {
						ArrayList<NewsVO> ndatas = nDAO.selectAll(null); // 기사 전체 목록을 담은 배열리스트 선언후 초기화
						view.printNewsList(ndatas); // 담겨져있는 배열리스트를 출력
					}
					
// ========================================== 사용자 메뉴 - 뉴스검색 ==========================================
					
					else if (action == 2) {
						action = view.getSearchNews(3); // V에서 받은 뉴스검색메뉴를 출력 후 입력받은 번호를 C action에 담음
						
// ========================================== 뉴스검색 - 랭킹순위검색 ==========================================	
						
						if (action == 1) {
							
							view.printNewsRank(); // 뉴스 랭킹 출력문
							
							NewsVO nVO = new NewsVO(0, "랭킹순위", null); // "랭킹순위"를 검색할 nVO 객체 생성
							ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO); // "랭킹순위"에 해당하는 nVO객체들을 ndatas에 저장
							view.printPopularNews(ndatas); // 저장된 ndatas를 출력
							
							/* 뉴스보기 */
							int num = view.getPickNum(); // 사용자가 입력한 뉴스번호를 num에 저장
							NewsVO ndata = new NewsVO(num, null, null); // 고른 뉴스번호를 M에 전달해 줄 ndata 생성
							NewsVO res = nDAO.selectOne(ndata); // ndata에 해당하는 뉴스를 res에 저장

							if (res == null) { // 해당하는 뉴스번호가 없다면
								view.printFalseNum(); // 해당번호 존재 x 출력문
								continue;
							}

							nDAO.update(res); // 뉴스보기 실행이 되면 조회수 1증가
							view.printNews(res); // 해당 뉴스 출력문
							
							MemberVO mVO = new MemberVO(member.getMid(), null, Integer.toString(res.getPK())); // 조회했던 뉴스를 담을 mVO객체 생성
							mDAO.update(mVO); // 마이페이지에 조회했던 뉴스 담기
						}
						
// ========================================== 뉴스검색 - 분야검색 ==========================================
						
						else if (action == 2) {
							String gnere = view.getNewsGenre(); // 사용자가 입력한 분야를 genre에 저장
							
							NewsVO nVO = new NewsVO(0, null, gnere); // 입력한 분야를 M에 전달해 줄 nVO 객체 생성
							ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO); // 입력한 분야에 해당하는 nVO 객체들을 ndatas에 저장
							view.printNewsList(ndatas); // 저장된 ndatas 출력
						}
						
// ========================================== 뉴스검색 - 제목검색 ==========================================
						
						else if (action == 3) {
							String title = view.getNewsTitle(); // 사용자가 입력한 제목을 title에 저장
							
							NewsVO nVO = new NewsVO(0, title, null); // 입력한 제목을 M에 전달해 줄 nVO 객체 생성
							ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO); // 입력한 제목을 포함하는 nVO 객체들을 ndatas에 저장
							view.printNewsList(ndatas); // 저장된 ndatas 출력
						}
					}
					
// ========================================== 사용자 메뉴 - 인기있는 뉴스출력 ==========================================	
					
					else if (action == 3) {
						NewsVO nVO = new NewsVO(0, "인기글", null); // 인기있는 뉴스를 M에 전달해 줄 nVO 객체 생성
						ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO); // 조회수가 높은 nVO 객체들을 ndatas에 저장
						view.printPopularNews(ndatas); // 저장된 ndatas 출력
					}
					
// ========================================== 사용자 메뉴 - 뉴스보기 ==========================================	
					
					else if (action == 4) {
						ArrayList<NewsVO> ndatas = nDAO.selectAll(null); // 기사 전체 목록을 담은 배열리스트 선언후 초기화
						view.printNewsList(ndatas); // 담겨져있는 배열리스트를 출력
						
						int num = view.getPickNum(); // 사용자가 고른 뉴스번호를 num에 저장
						NewsVO ndata = new NewsVO(num, null, null); // 해당 뉴스번호를 M에 전달할 ndata 객체 생성
						NewsVO res = nDAO.selectOne(ndata); // ndata에 해당하는 뉴스를 res에 저장
						
						if (res == null) { // 해당하는 뉴스번호가 없다면
							view.printFalseNum(); // 해당번호 존재 x 출력문
							continue;
						}

						nDAO.update(res); // 뉴스보기 실행이 되면 조회수 1증가
						view.printNews(res); // 해당 뉴스 출력문
						
						MemberVO mVO = new MemberVO(member.getMid(), null, Integer.toString(res.getPK())); // 조회했던 뉴스를 담을 mVO객체 생성
						mDAO.update(mVO); // 마이페이지에 조회했던 뉴스 담기
					}
					
// ========================================== 사용자 메뉴 - 마이페이지 ==========================================
					
					else if (action == 5) {
						action = view.printMyPage(3); // V에서 받은 마이페이지 메뉴를 출력 후 입력받은 번호를 C action에 담음
						
// ========================================== 마이페이지 - 조회했던 뉴스 ==========================================
						
						if (action == 1) {
							if (member.getCart().size() == 0) { // 마이페이지에 조회했던 뉴스가 없다면
								view.noVisitedNews(); // 조회한 뉴스 x 출력문
								continue;
							}
							
							// 마이페이지에 조회했던 뉴스가 있다면
							for(int i = 0; i < member.getCart().size(); i++) { // 조회했던 뉴스 개수만큼 for문 실행
								NewsVO nVO = new NewsVO(member.getCart().get(i), null, null); // 조회했던 뉴스번호를 M에 전달해줄 nVO 객체 생성
								NewsVO ndata = nDAO.selectOne(nVO); // 뉴스번호에 해당하는 뉴스를 ndata에 저장
								view.printNews(ndata); // 저장된 ndata 출력
							}
						}
						
// ========================================== 마이페이지 - 비밀번호 변경 ==========================================
						
						else if (action == 2) {
							String mpw = view.getMpw(); // 사용자가 입력한 비밀번호를 mpw에 담음
							if (!member.getMpw().equals(mpw)) { // 만약 기존 비밀번호와 일치하지 않다면
								view.printMpwFalse(); // 비밀번호 일치 x 출력문
								continue;
							}
							
							String npw = view.getChangeMpw(); // 사용자가 입력한 새로운 비밀번호를 npw에 담음
							MemberVO mVO = new MemberVO(member.getMid(), npw, null); // 현재 로그인한 아이디와 새로운 비밀번호를 M에 전달해줄 mVO 객체 생성
							
							if(!view.getRealChangeMpw()) { // 비밀번호 변경을 진행하지 않으면
								view.printChangeMpwFalse(); // 비밀번호 변경 실패 출력문
								continue;
							}
							
							if (!mDAO.update(mVO)) { // 비밀번호 변경을 실패했다면
								view.printChangeMpwFalse(); // 비밀번호 변경 실패 출력문
								continue;
							}
							
							view.printChangeMpwTrue(); // 비밀번호 변경 성공 출력문
							
						}
						
// ========================================== 마이페이지 - 회원탈퇴 ==========================================
						
						else if (action == 3) {
							String mpw = view.getMpw(); // 사용자가 입력한 비밀번호를 mpw에 담음
							if (!member.getMpw().equals(mpw)) { // 만약 기존 비밀번호와 일치하지 않다면
								view.printMpwFalse(); // 비밀번호 일치 x 출력문
								continue;
							}
							
							if(!view.getRealDelete()) { // 회원탈퇴를 진행하지 않으면
								view.printMemberDeleteFalse(); // 회원탈퇴 실패 출력문
								continue;
							}
							
							if (!mDAO.delete(member)) { // 회원탈퇴를 실패했다면
								view.printMemberDeleteFalse(); // 회원탈퇴 실패 출력문 
								continue;
							}
							
							view.printMemberDeleteTrue(); // 회원탈퇴 성공 출력문
							view.printEndMypage(); // 마이페이지 종료 출력문
							break;
						}
					}
					
// ========================================== 사용자 메뉴 - 로그아웃 ==========================================
					
					else if (action == 6) {
						member = null; // 현재 로그인 정보 초기화
						view.printSeeUAgain(); // 로그아웃 출력문
						break;
					}
				}
			}
			
// ========================================== 프로그램 메뉴 - 회원가입 ==========================================
			
			else if (action == 2) {
				MemberVO mVo = view.signUp(); // 사용자가 입력한 아이디 비밀번호를 M에 전달해줄 mVO 객체 생성
				
				if (!view.askSignUp()) { // 회원가입을 진행하지 않으면
					view.signUpFalse(); // 회원가입 실패 출력문
					continue;
				}
				
				if (!mDAO.insert(mVo)) { // 회원가입을 실패했다면
					view.signUpFalse(); // 회원가입 실패 출력문			
				}
				
				view.signUpTrue(); // 회원가입 성공 출력문
			}
			
// ========================================== 프로그램 메뉴 - 프로그램 종료 ==========================================
			
			else if (action == 3) {
				view.printProgramEnd(); // 프로그램 종료 출력문
				break;
			}
		}
	}
}

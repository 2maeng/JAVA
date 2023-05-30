package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminView admin;
	private ClientView client;
	private MemberVO member; // 현재 로그인한 회원정보

	public Ctrl() {
		mDAO = new MemberDAO();
		pDAO = new ProductDAO();
		admin = new AdminView();
		client = new ClientView();
		member = null; // 세션 로그인 데이터
		// 프로그램을 실행한다고해서, 자동 로그인이 되지는 않기 때문에  -> 초기화를 안함 null로 초기화!
	}

	public void startApp() {
		while(true) {
			int action = client.printClientMenu01();
			if(action == 1234) { // 관리자모드실행
				while(true) { // 관리자모드 진입
					action = admin.printAdminMenu();
					if(action == 1) { // 회원목록출력
						ArrayList<MemberVO> mdatas = mDAO.selectAll(null); // 7
						admin.printMemberList(mdatas); // 8

						// 1. 사용자가 관리자인 상황
						// 2. 관리자가 회원 목록 볼래
						// 3. V가 C한테 말합니다. 회원 목록 보겠다.
						// 4. C가 회원 목록 데이터 필요하구나? ㅇㅋ
						// 5. M한테 회원 목록 좀 줘
						// 6. M이 selectAll() 합니다.
						// 7. ArrayList<MemberVO>가 반환되고 C는 그걸
						// 8. V한테 줍니다.
					}
					else if(action == 2) { // 관리자모드종료
						admin.printAdminEnd();
						break;
					}
				}
			}
			else if(action == 1) { // 회원가입
				//				MemberVO mVO = client.signUp(); // 4 ~ 7
				//				
				//				boolean flag = mDAO.insert(mVO); // 8 ~ 10
				//				
				//				if(flag) {
				//					client.signUpTrue();
				//				}
				//				else {
				//					client.signUpFalse();
				//				}
				// 1. 사용자가 console에 회원가입 할래 1번 입력
				// 2. V는 입력한 값을 C한테 전달
				// 3. C는 아~ 회원가입 하고 싶구나? ㅇㅋ
				// 4. C는 V한테 회원가입할 정보를 입력 받아오라고 지시
				// 5. V는 사용자한테 회원가입창 보여줌
				// 6. 사용자는 정보를 입력
				// 7. V는 사용자가 입력한 정보를 C한테 전달
				// 8. C는 이 정보를 M한테 전달
				// 9. M은 회원가입을 수행
				// 10. M은 insert()가 잘 되었는지 아닌지를 T,F를 반환
				// 11. C는 결과에따라 맞는 V화면을 보여줄 수 있또록 지시
				// 12. 사용자가 V가 보여주는 화면을 보게됌

				if(mDAO.insert(client.signUp())) { // 11 ~  12
					client.signUpTrue();
				}
				else {
					client.signUpFalse();
				}
			}
			else if(action == 2) { // 로그인

				// 아이디 입력 해봐! 라고 V가 사용자에게 요청
				// 비밀번호도 같이 입력해
				MemberVO mVO = client.signIn();

				// mdata에는 유효한 사용자 정보 or null
				// 유효한 사용자 정보 == 현재 로그인한 회원
				// C는 이 정보가 있는지, 그리고 맞는지(== 유효한지)
				// 위의 여부를 M한테 판단을 부탁함
				// --->> selectOne()
				member = mDAO.selectOne(mVO);

				// M은 VO를 반환 == 존재하는 회원
				// -> 로그인 성공 V
				//	=> 다음 스텝으로 이동
				// 	  null을 반환 == 없거나, 비밀번호가 틀림!
				// -> 로그인 실패 V
				//	=> 프로그램 모드에 계속 있어야함...
				if(member == null) {
					client.signInFalse(); // 로그인 실패 V
					continue; // 포르그램 모드에 계속 존재
				}
				client.signInTrue(); // 로그인 성공 V
				while(true) { // 사용자모드 진입 // 다음 스텝으로 이동
					action = client.printClientMenu02(member);
					if(action == 1) { // 로그아웃

						// 사용자가 로그아웃을 원하면,
						// C에 mdata가 현재 존재하는데, 이걸
						// 제거하고
						member = null;

						client.logout();
						client.printClientEnd02(); // 로그아웃이 되었음을 사용자에게 알려주자!
						break;
					}
					else if(action == 2) { // 마이페이지
						
						String mpw = client.getMpw();
						
						if(!member.getMpw().equals(mpw)) {
							client.printFalse();
							continue; 
						}
						
						String mpw2 = client.getChangeMpw();
						
//						member.setMpw(mpw2);
						
						if(!mDAO.update(member)) {
							// 비밀번호 변경 실패
							client.printChangeMpwFalse();
							continue;
						}
						client.printChangeMpwTrue();
						
						client.printClientEnd02();
						break;
					}
					else if(action == 3) { // 회원탈퇴
						// 비밀번호를 한번더 확인하는 로직
						// 비밀번호가 불일치 -> 회원탈퇴 X
						String mpw = client.getMpw();
						if(!member.getMpw().equals(mpw)) { // 현재 로그인한 사람의 비밀번호와 사용자가 입력한 비밀번호를 확인하는 로직
							client.printFalse();
							continue;
						}
						
						// 비밀번호가 일치
						// ->
						// 로그인이 되어있는 회원을
						// 전체 회원 목록에서 제거
						if(!mDAO.delete(member)) {
							// 회원탈퇴 실패
							client.printMemberDeleteFalse();
							continue;
						}
						// 회원탈퇴 성공
						client.printMemberDeleteTrue();

						client.printClientEnd02();
						break;
					}
					else if(action == 4) { // 상품 목록 출력
						ArrayList<ProductVO> pdatas = pDAO.selectAll(null);
						client.printProductList(pdatas);
					}
					else if(action == 5) { // 상품목록검색_이름으로 검색
						String name = client.getSearchContent();
						ProductVO pVO = new ProductVO(0, name, 0, 0);
						ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
						client.printProductList(pdatas);
					}
					else if(action == 6) {
						ProductVO pVO = client.getSearchFilter();
						ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
						client.printProductList(pdatas);
					}
					else if(action == 7) { // 상품 검색_최고가 검색
						ProductVO pVO = new ProductVO(0, "최고가", 0, 0);
						ProductVO data = pDAO.selectOne(pVO);
						client.printProduct(data);
					}
					else if(action == 8) { // 상품 검색_최저가 검색
						ProductVO pVO = new ProductVO(0, "최저가", 0, 0);
						ProductVO data = pDAO.selectOne(pVO);
						client.printProduct(data);
					}
				} 

			}
			else if(action == 3) { // 프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}

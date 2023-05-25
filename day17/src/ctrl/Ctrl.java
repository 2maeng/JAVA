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
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
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
				if(true) { // mDAO.selectOne(client.signIn())!= null
					client.signInTrue();
					while(true) { // 사용자모드 진입
						action = client.printClientMenu02();
						if(action == 1) { // 로그아웃
							client.logout();
							client.printClientEnd02();
							break;
						}
						else if(action == 2) { // 마이페이지

						}
						else if(action == 3) { // 회원탈퇴
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
				else {
					client.signInFalse();
				}
			}
			else if(action == 3) { // 프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}

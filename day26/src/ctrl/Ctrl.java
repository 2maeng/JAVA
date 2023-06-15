package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.View;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private View view;
	private MemberVO member; // 현재 로그인한 회원의 정보를 저장할 변수

	public Ctrl() {
		mDAO = new MemberDAO();
		pDAO = new ProductDAO();
		view = new View();
		member = null;
	}

	public void startApp() {
		while(true) {

			int action = view.printMenu();

			if(action == 1) {
				// v가 상품목록을 보여달래~
				// 알겠어
				// M한테 있어
				// 가져올게
				// 가져왔다면, V에게 전달
				
				view.printList(pDAO.selectAll(new ProductVO()));
			}
			else if(action == 2) {
				
				view.printList(pDAO.selectAll(view.funcC()));
				
				// [ 내 풀이 ]
//				while(true) {
//					int num = view.PrintSearchMenu();
//
//					if(num == 1) {
//						String name = view.getName();
//
//						ProductVO pVO = new ProductVO(0, name, 0, 0);
//						
//						pVO.setSearchCondition("이름검색");
//
//						view.printList(pDAO.selectAll(pVO));
//					}
//					else if(num == 2) {
//						ProductVO pVO = view.getPrice();
//						
//						pVO.setSearchCondition("가격검색");
//						
//						view.printList(pDAO.selectAll(pVO));
//					}
//				}
			}
			else if(action == 3) {
				// V가 상품뭐 구매했는지 입력을 받아옴
				// 그럼 그거 상품 구매가 가능한지 확인
				// 상품구매 가능여부 확인
				// 1. 없는 상품인지
				// 2. 재고 있는지
				// 	-> 실패화면
				// 구매가 가능하다면
				// 구매를 진행
				// 구매를하면 재고--
				// 사용자 total++
				// 	-> 성공화면
				int proNum = view.getNum();

				ProductVO pVO = new ProductVO(proNum, null, 0, 0);
				ProductVO pdata = pDAO.selectOne(pVO);

				if(pdata == null) {
					System.out.println("로그: 해당 상품없음");
					view.printFalse();
					continue;
				}

				if(pdata.getCnt() <= 0) {
					System.out.println("로그: 상품 재고 없음");
					view.printFalse();
					continue;
				}

				if(!pDAO.update(pdata)) {
					System.out.println("로그: P update() 안됨");
					view.printFalse();
					continue;
				}

				member.setTmpPrice(pdata.getPrice());
				// 개발 편의성 때문에 새로 만든 VO의 멤버변수를 활용한 로직 -> 오직 CTRL에서만 사용

				member.setAction("토탈변경");
				if(!mDAO.update(member)) {
					System.out.println("로그: M update() 안됨");
					view.printFalse();
					continue;
				}

				view.printTrue();
			}
			else if(action == 4) {
				// V에서 회원가입할 정보를 입력
				// V가 입력한 정보를 C가 받아서
				// M에게 건네줌
				// M에게 결과를 반환 받아서
				// 맞는 결과를 V와 연결

				if(!mDAO.insert(view.signIn())) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}

			else if(action == 5) {
				// V에서 로그인을 시도
				// 로그인 정보 줘
				// 그거 M한테 줘서
				// 확인
				// member에 로그인된 정보저장
				// 없으면 로그인 실패!
				member = mDAO.selectOne(view.signIn());

				if(member == null) {
					view.printFalse();
					continue;
				}

				view.printTrue();
			}

			else if(action == 6) {
				member = null;
			}

			else if(action == 7) {
				// 로그인 했어?
				// 했어
				// 비번 확인부터 하자
				// 비번 맞아?
				// 맞아
				// 비번 바꾸자
				// [ 선생님 풀이 ]
				if(member == null) { // 로그인 안했다면
					view.printFalse();
					continue;
				}
				
				String mpw = view.getMpw(member);
				
				// C가 "현재 로그인한 회원의 정보"를 알고 있기때문에
				if(!member.getMpw().equals(mpw)) { 
					view.printFalse();
					continue;
				}
				
				String npw = view.getChangeMpw(member.getMpw());
				member.setTmpMpw(npw);
				
				member.setAction("비번변경");
				if(!mDAO.update(member)) {
					view.printFalse();
					continue;
				}
				
				member = null;
				view.printTrue();
			
//				[ 내풀이 ] 
//				String mpw = view.getMpw();
//
//				if(!member.getMpw().equals(mpw)) {
//					view.printFalse();
//					continue;
//				}
//
//				String npw = view.getChangeMpw();
//				MemberVO mVO = new MemberVO(member.getMid(), npw);
//				
//				mVO.setTmpPrice(-1);
//
//				if(!mDAO.update(mVO)) {
//					view.printFalse();
//					continue;
//				}
//
//				view.printTrue();
			}

			else if(action == 8) {
				// 야 회원이 탈퇴하겠대
				// 그래? 그럼 M한테 누가 탈퇴할지 알려줘
				// 그럼 M이 탈퇴해줄거야

				if(member == null) {
					view.printFalse();
					continue;
				}

				if(!mDAO.delete(member)) {
					view.printFalse();
					continue;
				}

				member = null;
				view.printTrue();
			}

			else {
				break;
			}

		}
	}

}

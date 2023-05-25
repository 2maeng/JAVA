package controller;

import java.util.ArrayList;

import model.DrinkDAO;
import model.DrinkVO;
import view.DrinkView;

public class DrinkCtrl {
	private DrinkView view;
	private DrinkDAO dao;

	public DrinkCtrl() {
		view = new DrinkView();
		dao = new DrinkDAO();
	}

	public void startApp() {
		while(true) {
			
			System.out.println(" 로그: 사용자가 새로 입장합니다.\n");
			// 로그
			// : 확인을 위한 것
			// : 실제 서비스에서는 출력X
			
			// 장바구니 장바구니 = 초기화;
			ArrayList<DrinkVO> cart = new ArrayList<DrinkVO>();
			
			// 음료 여러개 구매할때 -> ArrayList
			// Set X -> 콜라 3개 -> 콜라를 추가하는 건 로직
			
			while(true) {
				int action = view.printMenu();

				if(action == 1) { // 음료추가
					String name = view.getDrinkName();
					int price = view.getDrinkPrice();
					int cnt = view.getDrinkCnt();
					DrinkVO vo = new DrinkVO(0, name, price, cnt);
					System.out.println("CTRL: vo: " + vo);
					// DAO의 CRUD에게 전달해야하는 값만 설정
					// 전달하지 않아도되는 값은 0, null 등으로 설정
					if(dao.insert(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action == 2) { // 음료 목록 출력
					ArrayList<DrinkVO> datas = dao.selectAll(new DrinkVO(0, null, 0, 0));
					view.printDrinkList(datas);
				}
				else if(action == 3) { // 음료 구매하기
					int num = view.getDrinkNum();
					int cnt = 1;
					DrinkVO vo = new DrinkVO(num, null, 0, -cnt);
					if(dao.update(vo)) {
						// 구매에 성공 했을때에만 장바구니에 해당 상품을 추가
						DrinkVO data = dao.selectOne(vo);
						data.setCnt(cnt); // PK, name, price는 자판기에 저장된 상품 정보로 가능하지만,
						// cnt는 사용자가 입력했떤 정보로 변경해야함
						
						boolean flag = false;
						int index = 0;
						for(int i = 0; i < cart.size(); i++) {
							if(data.equals(cart.get(i))) { // 사용자가 선택한 제품 == cart.get(i)
								index = i;
								flag = true;
							}
						}
						if(flag) {
							cart.get(index).setCnt(cart.get(index).getCnt() + cnt);
						}
						 else {
							cart.add(data); // 장바구니.add(내가 구매한 상품);
						}
						view.printDrinkList(cart);
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action == 4) { // 음료 삭제
					int num = view.getDrinkNum();
					DrinkVO vo = new DrinkVO(num, null, 0, 0);
					if(dao.delete(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action == 5) { // 음료 재고 추가
					int num = view.getDrinkNum();
					int cnt = view.getDrinkCnt();
					DrinkVO vo = new DrinkVO(num, null, 0, cnt);
					if(dao.delete(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action == 6) { // 음료 검색
					String name = view.getDrinkName();
					ArrayList<DrinkVO> datas = dao.selectAll(new DrinkVO(0, name, 0, 0 ));
					view.printDrinkList(datas);
				}

				if(action == 7) { // 프로그램 종료
					view.printEnd();
					break;
				}
			}
			
			System.out.println(" 로그: 사용자가 종료했습니다.\n");
			cart.clear(); // 필수는 아님
		}

	}
}

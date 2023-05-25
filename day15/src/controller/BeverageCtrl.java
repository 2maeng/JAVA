package controller;

import java.util.ArrayList;

import model.BeverageDAO;
import model.BeverageVO;
import view.BeverageView;

public class BeverageCtrl {

	private BeverageView view;
	private BeverageDAO dao; // 

	public BeverageCtrl() {
		this.view = new BeverageView();
		this.dao = new BeverageDAO();
	}

	public void startApp() {
		while(true) {

			// 사용자한테 메뉴 보여주기
			view.printMenu();
			// 사용자가 뭐 할지 입력 받기
			int menuNum = view.getMenuNum();

			if(menuNum == 1) {
				// 음료 목록 출력
				ArrayList<BeverageVO> datas = dao.selectAll();
				view.printBeverageList(datas);
			}
			else if(menuNum == 2) {
				// 음료 추가
				view.addInfo();
				String name = view.getBeverageName();
				int price = view.getBeveragePrice();
				dao.add(name, price);
				view.addSuccess();
			}
			else if(menuNum == 3) {
				// 구매하기
				ArrayList<BeverageVO> datas = dao.selectAll();
				view.printBeverageList(datas);
				int num = view.getBeverageNum();
				int cnt = view.getCnt();
				if(dao.buy(num, cnt) == false) {
					view.buyFail();
				} else {
					view.buySuccess();
				}
			}
			else if(menuNum == 4) {
				// 삭제하기
				ArrayList<BeverageVO> datas = dao.selectAll();
				view.printBeverageList(datas);
				int num = view.getBeverageNum();
				if(dao.delete(num)) {
					view.deleteSuccess();
				} else {
					view.printFalse();
				}
			}
		}
	}




































}

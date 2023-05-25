package controller;

import java.util.ArrayList;

import model.StudentDAO;
import model.StudentVO;
import view.StudentView;

public class StudentCtrl {
	private StudentView view;
	private StudentDAO dao; // model
	
	public StudentCtrl(){
		this.view = new StudentView();
		this.dao = new StudentDAO();
	}
	
	public void startApp() {
		while(true) {
			
			// 사용자한테 메뉴 보여줘!
			view.printMenu();
			// 사용자가 뭐 할지 입력 받아봐
			int menuNum = view.getMenuNum();
			
			if(menuNum == 1) {
				// 목록 출력해
				ArrayList<StudentVO> datas = dao.selectAll(); // 학생 목록 데이터를 모델이 가져옴
				view.printStudentList(datas); // 가져온 데이터를 뷰에 넘겨줌
			}
			else if(menuNum == 2) {
				// 1명 출력해
				int num = view.getStudentNum();
				StudentVO data = dao.selectOne(num);
				view.printStudent(data);
			}
			else if(menuNum == 3) {
				// 변경해
				int num = view.getStudentNum();
				int score = view.getStudentScore();
				dao.update(num, score);
				view.printInfo();
			}
			else if(menuNum == 4) {
				// 추가해
				view.printInfo_C_Start();
				String name = view.getStudentName();
				int score = view.getStudentScore();
				dao.insert(name, score);
				view.printInfo_C_End();
			}
			else if(menuNum == 5) {
				// 제거해
				int num = view.getStudentNum();
				if(dao.delete(num)) {
					view.printInfo_D_End();
				} else {
					view.printFalse();
				}
				// CRUD(비즈니스 메서드, 핵심 로직)이 성공했는지, 실패했는지를 알아야함!
			}
			else if(menuNum == 6) {
				view.printEnd();
				break;
			}
			
		}
	}
}

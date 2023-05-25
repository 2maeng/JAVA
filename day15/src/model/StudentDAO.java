package model;

import java.util.ArrayList;

// CRUD(비즈니스 메서드, 핵심 로직)
// : 일반적으로 output이 boolean 타입입니다! ★★★★★
// 로그들만 syso() 가능 -> 나중에 로그는 주석으로 제거함!
// 나머지 syso() --->> VIEW 기능
// 기능은 다른데 어떻게 하나 오버로딩 !
public class StudentDAO {

	
	private ArrayList<StudentVO> datas;
	private static int PK = 1001;
	
	public StudentDAO(){
		this.datas = new ArrayList<StudentVO>();
		this.datas.add(new StudentVO(PK++, "김임형", 85));
		this.datas.add(new StudentVO(PK++, "엄마", 92));
		this.datas.add(new StudentVO(PK++, "아빠", 11));
	}
	
	// C
	public boolean insert(String name, int score) {
		this.datas.add(new StudentVO(PK++, name, score));
		return true;
	}
	
	// R : 목록 출력
	public ArrayList<StudentVO> selectAll() {
		return this.datas;
	}
	
	// R : 1개 출력
	public StudentVO selectOne(int num) { // PK를 받아서
		for(int i = 0;i <  this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == num) {
				return this.datas.get(i);
			}
		}
		System.out.println(" 로그: model: StudentDAO: selectOne(): 반환할 학생이 없습니다!");
		return null; // 해당 PK를 가진 학생이 없는 상태
	}
	
	// U
	public boolean update(int num, int score) {
		for(int i = 0;i < this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == num) {
				this.datas.get(i).setScore(score);
				return true;
			}
		}
		System.out.println("로그: model: StudentDAO: update(): 성적 변경할 학생이 없습니다!");
		return false;
	}
	
	// D
	public boolean delete(int num) {
		for(int i = 0;i < this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == num) {
				this.datas.remove(i);
				return true;
			}
		}
		System.out.println("로그: model: StudentDAO: update(): 제거할 학생이 없습니다!");
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

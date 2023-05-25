package model;

import java.util.ArrayList;

// CRUD(비즈니스 메서드, 핵심 로직)

public class BeverageDAO {

	private ArrayList<BeverageVO> datas;
	// 사용자가 사용할 수 없게 미리 고유넘버 지정
	// 사용자가 절대로 건드려선 안됌
	private static int PK =1001;

	public BeverageDAO() {
		this.datas = new ArrayList<BeverageVO>();
		this.datas.add(new BeverageVO(PK++, "몬스타", 2000));
		this.datas.add(new BeverageVO(PK++, "핫세븐", 3000));
		this.datas.add(new BeverageVO(PK++, "삐리빠리뽕", 4000));
	}

	// C : 음료 추가
	public boolean add(String name, int price) {
		this.datas.add(new BeverageVO(PK++, name, price));
		return true;
	}

	// R : 목록 출력
	public ArrayList<BeverageVO> selectAll(){
		return datas;
	}

	// U : 구매
	public boolean buy(int num, int cnt) {
		
		if(datas.size() == 0) {
			return false;
		}

		for(int i = 0; i < this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == num) {
				int cnt2 = this.datas.get(i).getCnt() - cnt;
				if(this.datas.get(i).getCnt() < cnt) {
					continue;
				} else if(cnt < 0) {
					continue;
				} else {
					this.datas.get(i).setCnt(cnt2);
					return true;
				}
			}
		}
		System.out.println("로그: model: BeverageDAO: update(): 구매할 음료가 없습니다!");
		return false;
	}
	
	// D : 음료 삭제
	public boolean delete(int num) {
		if(datas.size() == 0) {
			return false;
		}
		
		for(int i = 0; i < this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == num) {
				this.datas.remove(i);
				return true;
			}
		}
		System.out.println("로그: model: BeverageDAO: delete(): 삭제할 음료가 없습니다!");
		return false;
	}

























}

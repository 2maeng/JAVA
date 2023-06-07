package model;

import java.util.ArrayList;

public class MemberVO {
	private String mid; // PK --> 중복 검사 필수
	private String mpw; // 비밀번호
	private String name; // 이름
	private ArrayList<Integer> cart;
	
	// ========================================================== 생 성 자 ==========================================================================
	
	public MemberVO(String mid, String mpw, String name) {
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
		this.cart = new ArrayList<Integer>();
	}

	// ===================================================== getter & setter ==========================================================================
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getCart() {
		return cart;
	}
	
	public void setCart(ArrayList<Integer> cart) {
		this.cart = cart;
	}
	
	// ====================================================== toString 재 정 의 ========================================================================
	@Override
	public String toString() {
		return this.name + "님";
	}
	// ======================================================= equals 재 정 의 ==========================================================================
	@Override
	public boolean equals(Object obj) {
		
		MemberVO mVO = (MemberVO)obj;
		if(this.mid.equals(mVO.mid)) {
			return true;
		}
		return false;
	}
}

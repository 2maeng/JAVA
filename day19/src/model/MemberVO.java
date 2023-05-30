package model;

public class MemberVO {
	private String mid; // PK
	// : 일반적으로 PK는 시스템에서 부여함
	// : 사용자가 등록 --->> 중복검사필수 ☆
	private String mpw;
	private String name;
	
	public MemberVO(String mid,String mpw,String name) {
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
	}
	
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

	@Override
	public String toString() {
		return this.name + "님";
	}

	@Override
	public boolean equals(Object obj) {
		// 아이디(mid)가 같다면, 같은 객체!
		MemberVO mVO = (MemberVO)obj;
		if(this.mid.equals(mVO.mid)) { // 스트링이라 equals // PK 값이 같다면, 동일한 객체이다
			return true;
		}
		return false;
	}
	
}

package model;

public class MemberVO {
	private String mid;
	private String mpw;
	private int total;
	private int tmpPrice; // 테이블에는 없지만 개발 편의성 때문에 JAVA_VO에서 구현한 멤버변수
	private String tmpMpw;
	private String action;
	
	public MemberVO(String mid, String mpw) {
		this(mid, mpw, 0);
	}
	
	public MemberVO(String mid, String mpw, int total) {
		this.mid = mid;
		this.mpw = mpw;
		this.total = total;
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
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTmpPrice() {
		return tmpPrice;
	}

	public void setTmpPrice(int tmpPrice) {
		this.tmpPrice = tmpPrice;
	}

	public String getTmpMpw() {
		return tmpMpw;
	}

	public void setTmpMpw(String tmpMpw) {
		this.tmpMpw = tmpMpw;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return mid + " 회원 비번 [" + mpw + "] 총 구매금액 [" + total + "]";
	}
}

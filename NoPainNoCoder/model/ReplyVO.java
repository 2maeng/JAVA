package model;

import java.sql.Timestamp;
import java.util.Date;

public class ReplyVO {
	
	// 변수
	private int num;
	private int cNum;
	private String mId;
	private String comment;
	private Timestamp createDT;
	private boolean check;
	private String select;
	
	// 생성자
	public ReplyVO(int num) { // 단일 객체 검색, 객체 삭제
		this(num, 0, "", "", null, false);
	}
	public ReplyVO(int num, String comment) { // 댓글 내용 변경용
		this(num, 0, "", comment, null, false);
	}
	public ReplyVO(int cNum, String mId, String comment) { // DB에 저장, 다중 객체 정보 검색
		this(0, cNum, mId, comment, null, false);
	}
	public ReplyVO(int num, int cNum, String mId, String comment, Timestamp createDT, boolean check) { // DB에서 정보 받아오는 용도
		this.num = num;
		this.cNum = cNum;
		this.mId = mId;
		this.comment = comment;
		this.createDT = createDT;
		this.check = check;
	}
	
	// ======================================================================== Override

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// ======================================================================== getter,setter

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateDT() {
		return createDT;
	}

	public void setCreateDT(Timestamp createDT) {
		this.createDT = createDT;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

}

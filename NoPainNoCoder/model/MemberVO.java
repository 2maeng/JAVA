package model;

public class MemberVO {
   private String mId; // 아이디(PK)
   private String mName; // 이름
   private String mPw; // 비밀번호
   private int warnCnt; // 경고 카운트
   private boolean admin; // 관리자 회원 구별할 변수 false(user)/true(admin)
   // =======================================
   private String select; // 기능 선택할 임시변수
   private String tmpMpw; // 비번변경할때 담아둘 임시변수
   private int cnt;
   
   public MemberVO(String mId, String mName, String mPw) {
      this(mId, mName, mPw, 0, false);
   }
   
   public MemberVO(String mId, String mName, String mPw, int warnCnt, boolean admin) {
      this.mId = mId;
      this.mName = mName;
      this.mPw = mPw;
      this.warnCnt = warnCnt;
      this.admin = admin;
      this.select="";
   }
   
   public String getmId() {
      return mId;
   }
   
   public void setmId(String mId) {
      this.mId = mId;
   }
   
   public String getmPw() {
      return mPw;
   }
   
   public void setmPw(String mPw) {
      this.mPw = mPw;
   }
   
   public String getmName() {
      return mName;
   }
   
   public void setmName(String mName) {
      this.mName = mName;
   }
   
   public int getWarnCnt() {
      return warnCnt;
   }
   
   public void setWarnCnt(int warnCnt) {
      this.warnCnt = warnCnt;
   }
   
   public boolean isAdmin() {
      return admin;
   }

   public void setAdmin(boolean admin) {
      this.admin = admin;
   }

   public String getSelect() {
      return select;
   }
   
   public void setSelect(String select) {
      this.select = select;
   }

   public String getTmpMpw() {
      return tmpMpw;
   }

   public void setTmpMpw(String tmpMpw) {
      this.tmpMpw = tmpMpw;
   }

   public int getCnt() {
      return cnt;
   }

   public void setCnt(int cnt) {
      this.cnt = cnt;
   }

   @Override
   public String toString() {
      return this.mName + " 회원님 아이디 [" + this.mId + "] 경고횟수 : [" + this.warnCnt + "]"; 
   }
   
   
}
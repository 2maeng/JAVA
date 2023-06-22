package model;

public class BookMarkVO {
   private int num;    // PK
   private String mId;   // member아이디 FK
   private int cNum;   // champ번호 FK

   
   public BookMarkVO(String mId,int cNum) {
      this(0,mId,cNum);
   }
   public BookMarkVO(int num,String mId,int cNum) {
      this.num=num;
      this.mId=mId;
      this.cNum=cNum;
   }

   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getmId() {
      return mId;
   }
   public void setmId(String mId) {
      this.mId = mId;
   }
   public int getcNum() {
      return cNum;
   }
   public void setcNum(int cNum) {
      this.cNum = cNum;
   }
   
}
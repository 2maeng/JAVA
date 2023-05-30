package model;

public class ProductVO {
   private int PK; // PK
   private String name; // 이름
   private int price; // 가격
   private int cnt; // 재고
   public ProductVO(int PK, String name, int price, int cnt) {
      this.PK = PK;
      this.name = name;
      this.price = price;
      this.cnt = cnt;
   }
   public int getPK() {
      return PK;
   }
   public void setPK(int PK) {
      this.PK = PK;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public int getCnt() {
      return cnt;
   }
   public void setCnt(int cnt) {
      this.cnt = cnt;
   }
   @Override
   public String toString() {   // cnt가 0일경우에는 품점을 출력
      String msg = this.PK + ". " + this.name + " " + this.price + "원 [" + (this.cnt == 0 ? "품절" : this.cnt) + "]";
      return msg;
   }
   @Override
   public boolean equals(Object obj) {   // PK번호가 같다면 같은 상품
      ProductVO productvo = (ProductVO)obj;
      if(this.PK == productvo.PK) {
         return true;
      }
      return false;
   }

}
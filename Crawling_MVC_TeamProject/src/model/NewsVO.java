package model;

import java.util.Random;

public class NewsVO implements Comparable<NewsVO> {// 조회수 비교를 위한 NewsVO(비교 타입이 NewsVO) 타입의 Comparable 인터페이스 상속
   // 필드
   static Random rand = new Random();// 조회수를 위한 랜덤
   private int PK;// 기사 고유 번호 (PK)
   private String title;// 기사 제목
   private String genre;// 기사 분야
   private int cnt;// 기사 조회수
   // 생성자=====================================================================

   public NewsVO(int PK, String title, String genre) {
      this.PK = PK;
      this.title = title;
      this.genre = genre;
      this.cnt = rand.nextInt(5);// 조회수는 랜덤으로 설정
   }

   // getter & setter ==========================================================

   public int getPK() {
      return PK;
   }

   public void setPK(int pK) {
      PK = pK;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public int getCnt() {
      return cnt;
   }

   public void setCnt(int cnt) {
      this.cnt = cnt;
   }

   // Override==================================================================
   @Override
   public String toString() { // 출력 오버로딩
      // TODO Auto-generated method stub
      return this.PK + ". [" + this.genre + "] " + this.title + "조회수 [" + this.cnt + "]\n";
   }

   @Override
   public boolean equals(Object obj) { // PK번호가 같다면 같은 기사
      NewsVO nVO = (NewsVO) obj;
      if (this.PK == nVO.PK) {
         return true;
      }
      return false;
   }

   // 조회수를 비교하여 랭킹순위로 정렬하기 위해
   // sort메서드에서 사용되는 compareTo를 조회수(cnt)끼리 비교하도록 오버라이딩
   // ↓
   @Override
   public int compareTo(NewsVO o) {
      return o.getCnt() - this.getCnt();
   }
}
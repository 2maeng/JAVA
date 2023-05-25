package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.DrinkVO;

public class DrinkView {

   private static Scanner sc=new Scanner(System.in);

   public int tryCatch() {
      while(true) {
         try {
            System.out.print("입력) ");
            int action=sc.nextInt();

            return action;
         }
         catch(Exception e) {
            sc.nextLine();
            System.out.println("정수로 입력해주세요!");
         }
      }
   }

   public int printMenu() {
      System.out.println("=== 자 판 기 ===");
      System.out.println("1. 음료추가");
      System.out.println("2. 음료목록출력");
      System.out.println("3. 음료구매");
      System.out.println("4. 음료제거");
      System.out.println("5. 음료재고추가");
      System.out.println("6. 음료검색"); // selectAll(2개이상)
      System.out.println("7. 프로그램 종료");
      while(true) {
         int action=tryCatch();
         if(1 <= action && action <= 7) {
            return action; // "유효성 검사" == 사용자의 입력값 검사
            // : 사용자의 입력값에 대하여 자료형(타입),범위 등을 확인하는 것
         }
      }
   }

   public String getDrinkName() {
      System.out.print("음료이름 ");
      String name = sc.next();
      return name;
   }
   
   public int getDrinkCnt() {
      System.out.print("음료재고입력) ");
      int cnt = sc.nextInt();
      return cnt;
   }
   
   public int getDrinkPrice() {
      System.out.print("음료가격입력) ");
      int price=sc.nextInt();
      return price;
   }
   
   public void printDrinkList(ArrayList<DrinkVO> datas) {
	  if(datas.isEmpty()) {
		  System.out.println("출력할 음료가 없습니다.");
	  }
      for(DrinkVO v:datas) {
         System.out.println(v);
      }
   }
   
   public int getDrinkNum() {
      System.out.print("음료번호입력) ");
      int num = sc.nextInt();
      return num;
   }

   public void printTrue() {
      System.out.println("요청하신 서비스를 완료했습니다.");
   }
   
   public void printFalse() {
      System.out.println("요청하신 서비스는 현재 이용이 어렵습니다.");
      System.out.println("다음에 다시 이용해주시기 바랍니다.");
   }

   public void printEnd() {
      System.out.println("프로그램 종료...");
   }

}
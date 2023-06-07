package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.NewsVO;


public class View {
   private static Scanner sc=new Scanner(System.in);

   //============= 트 라 이 캐 치 ( 유 효 성 ) ===============================   

   public int menuTryCatch(int num) { //사용자 선택의 최대값을 입력받음
      while (true) { //사용자 입력 무한 루프
         try {
            System.out.print("입력) ");
            int select = sc.nextInt(); // 사용자가 입력한 번호
            if(select<1 || select >num) { //메뉴는 1~num 까지 입력 가능
               //메뉴가 1보다 작거나 num 보다 크다면 잘못된 입력값으로 확인
               System.out.println("정확한 메뉴를 입력해주세요");//안내 멘트후
               continue; //범위 벗어날시 다시 입력
            } //end if(범위 확인)

            return select; //예외가 발생하지 않는다면 값 리턴
         } catch (Exception e) {
            sc.nextLine();//버퍼 처리
            System.out.println("정수를 입력!");
         } //end try-catch

      } // end while

   } // end tryCatch(예외처리)

   public int numTrycatch() {// 뉴스번호 예외
      while (true) {// 사용자 입력 무한 루프
         try {
            System.out.print("선택할 뉴스 번호 입력) ");
            int num = sc.nextInt();// 사용자가 입력한 번호
            return num;// 예외가 발생하지 않는다면 값 리턴
         } catch (Exception e) {
            sc.nextLine();// 버퍼 처리
            System.out.println("정수를 입력");
         } // end try-catch

      } // end while
   }

   public int checkYesNo() {
      while (true) {// 사용자 입력 무한 루프
         try {
            System.out.print("입력) ");
            int select = sc.nextInt();// 사용자가 입력한 번호
            if (select < 1 || select > 2) {// 메뉴는 1~2 까지 입력 가능
               // 메뉴가 1보다 작거나 2 보다 크다면 잘못된 입력값으로 확인
               System.out.println("정확하게 입력해주세요");// 안내 멘트후
               continue;// 범위 벗어날시 다시 입력
            } // end if(범위 확인)

            return select;// 예외가 발생하지 않는다면 값 리턴
         } catch (Exception e) {
            sc.nextLine();// 버퍼 처리
            System.out.println("정수를 입력");
         } // end try-catch

      } // end while
   }

   //===============목 록 출 력 관 련========================

   public void printNewsList(ArrayList<NewsVO> ndatas) { // 뉴스목록출력
      System.out.println();
      if(ndatas.isEmpty()) { // 뉴스 배열리스트에 저장된 뉴스가 없다면?
         System.out.println("출력할 뉴스가 없습니다.\n");
         return;
      }
      System.out.println("===뉴스목록출력===");
      for(NewsVO data:ndatas) {
         System.out.println(data);
      }
      System.out.println();
   }

   //============= 프 로 그 램 메 뉴 View ==============


   public int printProgramMenu(int num) { // 프로그램 메뉴 출력
      System.out.println("=== 프로그램 메뉴 ===");
      System.out.println("1. 로그인");
      System.out.println("2. 회원가입");
      System.out.println("3. 프로그램 종료");
      return menuTryCatch(num);
   }

   public MemberVO signIn() { // 1. 로그인
      System.out.println();
      System.out.println("=== 로 그 인 ===");
      System.out.print("아이디입력) ");
      String mid=sc.next();
      System.out.print("비밀번호입력) ");
      String mpw=sc.next();
      return new MemberVO(mid,mpw,null);
   }

   public void signInTrue() { // 로그인 성공 안내멘트
      System.out.println();
      System.out.println("로그인 성공!\n");
   }
   public void signInFalse() { // 로그인 실패 안내멘트
      System.out.println();
      System.out.println("로그인 실패...\n");
   }

   public MemberVO signUp() { // 2. 회원가입
      System.out.println();
      System.out.println("=== 회 원 가 입 ===");
      System.out.print("아이디입력) ");
      String mid=sc.next();
      System.out.print("비밀번호입력) ");
      String mpw=sc.next();
      System.out.print("이름입력) ");
      String name=sc.next();
      return new MemberVO(mid, mpw, name);
   }
   public boolean askSignUp() { // 회원가입 확인 (boolean)
      System.out.println();
      System.out.println("정말 회원가입을 진행하시겠어요?");
      System.out.println("1. Yes   2. NO) ");
      int select = checkYesNo();
      if(select==1) {
         return true;
      }
      return false;
   }
   public void signUpTrue() { // 회원가입 성공 안내 멘트
      System.out.println();
      System.out.println("회원가입 성공!\n");
   }
   public void signUpFalse() { // 회원가입 실패 안내 멘트
      System.out.println();
      System.out.println("중복된 아이디가 존재합니다.\n");
      System.out.println("회원가입 실패...\n");
   }

   public void printProgramEnd() { // 프로그램 종료 멘트
      System.out.println();
      System.out.println("프로그램을 종료합니다...\n");
   }
   //===========사 용 자 메 뉴 View ==================
   public int printUserMenu(int num) { // 사용자 메뉴 출력
      System.out.println("=== 사용자 메뉴 ===");
      System.out.println("1. 뉴스 목록출력");
      System.out.println("2. 뉴스 검색");
      System.out.println("3. 가장 인기있는 뉴스출력");
      System.out.println("4. 뉴스보기");
      System.out.println("5. 마이페이지");
      System.out.println("6. 로그아웃");
      return menuTryCatch(num);
   }

   public int getSearchNews(int num) { // 뉴스 검색
      System.out.println("=== 뉴스 검색 ===");
      System.out.println("1. 뉴스랭킹");
      System.out.println("2. 분야별");
      System.out.println("3. 제목별");
      return menuTryCatch(num);
   }

   public void printNewsRank() { // 뉴스 랭킹 출력
      System.out.println();
      System.out.println("=== 뉴스랭킹 ===");
   }

   public String getNewsTitle() { // 제목검색
      System.out.println();
      System.out.println("제목으로 검색합니다.");
      System.out.print("검색어입력) ");
      String name = sc.next();
      return name;
   }

   public String getNewsGenre() { // 장르검색
      System.out.println();
      System.out.println("분야로 검색합니다.");
      System.out.print("검색어입력) ");
      String genre = sc.next();
      return genre;
   }

   public void printPopularNews(ArrayList<NewsVO> ndatas) {// 인기뉴스 하나 출력
      System.out.println();
      if (ndatas == null) {
         System.out.println("출력할 뉴스가 없습니다.\n");
         return;
      }
      for (NewsVO v : ndatas) {
         System.out.println(v);         
      }
   }
   
   public void noVisitedNews() { // 조회할 뉴스가 없을 시 안내 멘트
      System.out.println();
      System.out.println("조회하신 뉴스가 없습니다.\n");
   }

   public void printNews(NewsVO ndata) {// 뉴스 하나 출력
      System.out.println();
      if (ndata == null) {
         System.out.println("출력할 뉴스가 없습니다.\n");
         return;
      }
      System.out.println(ndata);
   }

   public void printFalseNum() { // 존재하지 않는 뉴스 번호를 입력시 안내 멘트
      System.out.println("해당 뉴스번호는 존재하지 않습니다...\n");
   }

   public void printNewsTrue() { // 뉴스 출력 완료 멘트
      System.out.println("뉴스 출력이 완료되었습니다.\n");
   }

   public int getPickNum() { // 뉴스 하나 선택해서 보기
      return numTrycatch();
   }

   public int printMyPage(int num) { // 마이페이지 메뉴
      System.out.println("=== 마이페이지 ===");
      System.out.println("1. 최근 조회했던 뉴스출력");
      System.out.println("2. 비밀번호 변경");
      System.out.println("3. 회원탈퇴");
      return menuTryCatch(num);
   }

   public void printChangeMpw() { // 비번 변경 안내 멘트
      System.out.println();
      System.out.println("비밀번호를 변경합니다.\n");
   }

   public String getMpw() { // 기존 비밀번호 확인 과정 안내 멘트
      System.out.println();
      System.out.println("=== 비 밀 번 호 확 인 ===");
      System.out.print("비밀번호입력) ");
      String mpw=sc.next();
      return mpw;
   }

   public String getChangeMpw() { // 비밀번호 변경 과정 안내 멘트
      System.out.println();
      System.out.println("=== 새로운 비밀번호 설정 ===");
      System.out.print("비밀번호입력) ");
      String mpw=sc.next();
      return mpw;
   }

   public void printChangeMpwTrue() { // 비번 변경 성공 멘트
      System.out.println();
      System.out.println("비밀번호 변경 성공!\n");
   }

   public void printChangeMpwFalse() { // 비번 변경 실패 멘트
      System.out.println();
      System.out.println("비밀번호 변경 실패!\n");
   }

   public void printMpwFalse() { // 비번 불일치 멘트
      System.out.println();
      System.out.println("비밀번호가 일치하지 않습니다!\n");
   }

   public void printByeBye() { // 회원탈퇴 절차 안내 멘트
      System.out.println();
      System.out.println("회원탈퇴를 진행합니다.ㅠㅠ\n");
   }

   public boolean getRealChangeMpw() { // 비번 변경 확인 멘트 (boolean)
      System.out.println();
      System.out.println("정말 비번 변경을 진행하시겠어요?");
      System.out.println("1. Yes   2. NO) ");
      int select = checkYesNo();
      if(select==1) {
         return true;
      }
      return false;
   }


   public boolean getRealDelete() { // 회원탈퇴 확인 멘트 (boolean)
      System.out.println();
      System.out.println("정말 회원탈퇴를 진행하시겠어요?");
      System.out.println("1. Yes   2. NO) ");
      int select = checkYesNo();
      if(select==1) {
         return true;
      }
      return false;
   }

   public void printMemberDeleteFalse() { // 회원탈퇴 실패 안내 멘트
      System.out.println();
      System.out.println("회원탈퇴 실패...\n");
   }

   public void printMemberDeleteTrue() { // 회원탈퇴 성공 안내 멘트
      System.out.println();
      System.out.println("회원탈퇴 성공!\n");
   }

   public void printEndMypage() { // 마이페이지 종료 안내 멘트
      System.out.println();
      System.out.println("마이페이지를 종료합니다\n");
   }

   public void printSeeUAgain() { // 로그아웃 완료 안내 멘트
      System.out.println();
      System.out.println("로그아웃이 완료되었습니다.\n");
   }
}
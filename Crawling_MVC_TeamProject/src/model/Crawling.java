package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//1. 타겟 사이트의 구조를 분석한 내용
//2. 받아온 데이터를 어떻게 가공했는지 설명한 내용

public class Crawling {
   // static을 쓴 이유
   // 1. Crawling 클래스의 객체가 불필요한 상황(멤버변수가 없는 클래스)
   // 2. 어떤 메서드가 많아야 2번 정도 사용되는 경우(메서드 자체가 별로 안쓰이는 경우, 현재 1번 사용)
   // →객체를 생성해서 메모리를 굳이 할당해서 사용할 필요가 없다.
   public static ArrayList<NewsVO> sample() {
      ArrayList<String> genreList = new ArrayList<String>(); // 분야를 담을 배열 리스트
      ArrayList<String> titleList = new ArrayList<String>(); // 제목을 담을 배열 리스트

// 웹 페이지 코드를 JAVA로 가져오기=============================================================================
      final String url = "https://media.naver.com/press/215/ranking?type=section&date=20230602"; // 크롤링 할 웹사이트
      // ↓ 해당 url의 페이지 코드를 받아오기 위해, 연결통로(stream)를 open , connect() 사용
      Connection conn = Jsoup.connect(url); // url 연결

      // ↓ connect() 가 정상적으로 수행되었다면, get()(getter)을 통하여
      // 해당 페이지의 코드를 받아옴
      Document doc = null; // scope 이슈 해결
      try {// 예외 처리
         doc = conn.get();
      } catch (IOException e) {
         e.printStackTrace();
      } // end try catch
// 페이지 스크랩핑 완료=======================================================================================

      
//페이지 코드를 분석(파싱)========================================================================================
      Elements genreElems = doc.select("div > div > strong.press_ranking_tit"); // 분야가 담겨있는 코드 경로
      Elements titleElems = doc.select("div > div > ul > li > a > div > strong.list_title"); // 제목이 담겨있는 코드 경로

//거대한 컬렉션(elems) 에 있는 데이터를 작은 단위의 컬렉션(elem)으로 나눠 저장할 수 있도록 Iterator 컬렉션 사용
      Iterator<Element> itr = genreElems.iterator(); // 분야 itr
      Iterator<Element> itr2 = titleElems.iterator(); // 제목 itr

      ArrayList<NewsVO> mdatas = new ArrayList<NewsVO>(); // DAO에 넘겨줄 sample을 담을 배열 리스트
      int PK = 1; // PK 값 시작
      while (itr.hasNext()) {// 분야
         String str = itr.next().text(); // 분야 정보 가공
         for (int i = 0; i < 3; i++) { // 기사가 3개씩이기 때문에 분야가 3번씩 반복
            genreList.add(str); // 분야 리스트에 분야 저장
         }

      } // end while(분야 담기)

      while (itr2.hasNext()) {// 제목
         String str = itr2.next().text();// 제목 정보 가공
         if (str == null) {// 만약 기사가 없다면
            titleList.add("기사 없음");

         }
         titleList.add(str);// 기사 리스트에 기사 저장

      } // end while(기사 담기)

      for (int i = 0; i < titleList.size(); i++) { // 기사 + 분야 합치기
         mdatas.add(new NewsVO(PK++, titleList.get(i), genreList.get(i)));
      }
      return mdatas; // 저장된 sample data 반환
   }// end sample

}// end Crawling
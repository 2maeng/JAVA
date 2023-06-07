package model;

import java.util.ArrayList;
import java.util.Arrays;

public class NewsDAO {
   // 필드===========================================================
   private ArrayList<NewsVO> datas;// VO 정보를 담는 ArrayList

   // 생성자==========================================================
   public NewsDAO() {
      // this.datas = new ArrayList<NewsVO>();
      this.datas = Crawling.sample();
   }

   // 메서드=========================================================
   // R
   public ArrayList<NewsVO> selectAll(NewsVO mVO) { // 배열 리스트 출력
      if (mVO == null) { // 전체 목록 출력
         return datas;
      } else if (mVO.getTitle() != null) { // 제목에 담겨오는 값이 null이 아니라면(랭킹순위, 인기글,기사제목)

         if (mVO.getTitle().equals("랭킹순위")) { // 랭킹 순위 검색(title에 담겨오는 값이 "랭킹순위")

            NewsVO[] arr = new NewsVO[datas.size()]; // 정렬을 위한 NewsVO 타입의 배열(배열 리스트에 담겨 있는 기사들 넣어줌)
            // →배열 리스트의 타입이 NewsVO 라서 sort() 사용 불가
            // sort() 사용을 위해서 배열로 변경
            for (int i = 0; i < datas.size(); i++) { // 배열 리스트에 있는 값을 배열에 담아주는 작업
               arr[i] = datas.get(i);
            }
            Arrays.sort(arr); // 배열 정렬
            // →compareTo 재정의로 인하여 기사의 조회수 값 순(높은 순)으로 정렬
            ArrayList<NewsVO> ndatas = new ArrayList<NewsVO>(); // 배열에서 정렬된 데이터를 담을 배열 리스트
            for (int i = 0; i < arr.length; i++) { // 배열에서 정렬된 데이터를 배열리스트에 순차적으로 추가하는 작업
               ndatas.add(arr[i]);
            }
            return ndatas; // 정렬된 값이 담겨진 배열 리스트 반환
//end 랭킹순위=============================================================================================================
         } else if (mVO.getTitle().equals("인기글")) { // 가장 인기있는 뉴스 출력 (title에 담겨오는 값이 "인기글")

            ArrayList<NewsVO> mdatas = new ArrayList<NewsVO>(); //조회수가 제일 높은 기사들을 담을 배열 리스트
            int max = datas.get(0).getCnt(); // 최대값에 0번째 기사의 조회수 값 저장
            for (int i = 1; i < datas.size(); i++) { // datas 길이만큼 조회수가 제일 큰 값 비교
               if (datas.get(i).getCnt() >= max) { // 현재 비교하는 기사의 조회수가 max에 들어있는 값보다 크다면
                  max = datas.get(i).getCnt(); // max 값에 현재 기사의 조회수 대입
               }
            } // end for(최대값 갱신)
            for (int i = 0; i < datas.size(); i++) { //조회수가 제일 높은 글들을 배열 리스트에 담는 작업
               if (datas.get(i).getCnt() == max) { //현재 글의 조회수가 max 값과 같다면
                  mdatas.add(datas.get(i)); //배열 리스트에 추가
               }
            }
            return mdatas; //조회수가 제일 높은 글들이 담긴 배열 리스트 반환
//end 인기글=============================================================================================================
         } else if (mVO.getGenre() == null) { // 기사 제목 검색(이름이 null이 아니고 분야가 null일 경우)
            ArrayList<NewsVO> tdatas = new ArrayList<NewsVO>(); //입력한 문자열이 포함된 기사들을 담을 배열 리스트
            for (int i = 0; i < datas.size(); i++) { //입력한 문자열이 포함된 기사들을 배열 리스트에 담는 작업
               if (datas.get(i).getTitle().contains(mVO.getTitle())) { //현재 기사 제목에 입력한 문자열이 포함되어 있다면
                  tdatas.add(datas.get(i)); //추가
               }
            }
            return tdatas; //입력한 문자열이 포함된 기사들을 배열 리스트 반환
         }
//end 기사 제목 검색=============================================================================================================

      } // end else if(title != null)

      else if (mVO.getTitle() == null) { // 분야 검색(기사 제목이 null)
         ArrayList<NewsVO> gdatas = new ArrayList<NewsVO>(); //검색한 분야와 같은 기사들을 담을 배열 리스트
         for (int i = 0; i < datas.size(); i++) { //검색한 분야와 같은 기사들을 배열 리스트에 담는 작업
            if (mVO.getGenre().equals(datas.get(i).getGenre())) { //현재 기사의 분야가 입력한 분야와 같다면
               gdatas.add(datas.get(i)); //추가
            }
         }
         return gdatas; //검색한 분야와 같은 기사들을 담은 배열 리스트 반환
      }
      return null;//일치하는 결과가 없다면 null 반환

   } // end selectAll

   // =====================================================================================================================
   public NewsVO selectOne(NewsVO mVO) { //배열 리스트에 담겨있는 기사 하나 출력

      for (int i = 0; i < datas.size(); i++) { // PK가 있는지 확인하는 작업
         if (mVO.equals(datas.get(i))) { //입력한 PK값과 기사의 PK값이 같다면(재정의 된 equals() 사용)
            return datas.get(i);
         }
      } // end for(PK 찾기)
      return null; // PK가 일치하지 않는다면 null 반환

   }// end selectOne
   
      // =====================================================================================================================
      // C

   public boolean insert(NewsVO mVO) {
      return false;
   }// end insert
   
      // =====================================================================================================================
      // U

   public boolean update(NewsVO mVO) { //조회수 증가
      for (int i = 0; i < datas.size(); i++) { //  PK가 있는지 확인하는 작업
         if (mVO.equals(datas.get(i))) { //입력한 PK값과 기사의 PK값이 같다면(재정의 된 equals() 사용)
            datas.get(i).setCnt(datas.get(i).getCnt() + 1); // 현재 기사의 조회수 하나 증가
            return true;
         }

      } //end for

      return false;
   } // end update
      // =====================================================================================================================

   // D
   public boolean delete(NewsVO mVO) {
      return false;
   } // end delete

}
package model;

import java.util.ArrayList;

// 목록출력,목록검색_이름,목록검색_가격순,목록검색_조회수
public class ProductDAO {
   private ArrayList<ProductVO> datas;
   private static int PK=1;
   public ProductDAO() {
      datas=new ArrayList<ProductVO>();
      datas.add(new ProductVO(PK++, "아메리카노", 1800, 2));
      datas.add(new ProductVO(PK++, "카페라떼", 2500, 1));
      datas.add(new ProductVO(PK++, "카라멜 마끼야또", 5000, 1));
      datas.add(new ProductVO(PK++, "아이스티", 3000, 0));
      datas.add(new ProductVO(PK++, "바닐라라뗴", 5500, 2));
      datas.add(new ProductVO(PK++, "바스크치즈케이크", 17000, 2));
   }

   public ArrayList<ProductVO> selectAll(ProductVO pVO){
      if(pVO == null) {   // 상품리스트를 출력하기 위해
         // input pVO가 null값이면
         // 상품 리스트(datas)를 반환
         return datas;
      }

      else if(pVO.getName().equals("5")) {   // 상품 필터검색 최대가격과 최소가격입력후 사이 가격들 반환
         //         반환해줄 배열 만들고
         ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
         //         가격범위에 들어가는 데이터들을 추가해서
         for(ProductVO data : datas) {
            if(pVO.getPrice() <= data.getPrice() && data.getPrice() <= pVO.getCnt()) {
               // 입력받은 가격은 최소가격을 나타내고 , 재고량에 최대 가격을 입력해서 
               // 사이 가격들을 반환
               pdatas.add(data);   // 사이 가격들을 가진 상품들을 pdatas에 추가
            }
         }
         return pdatas;   // 사이가격들을 가진 상품 반환
      }

      else if(pVO.getName().equals("3")) {   // 입력한 가격보다 비싼 상품들 반환
         ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();   // 입력한 가격보다 비싼 상품들을 넣을 배열
         for(ProductVO data : datas) {
            if(pVO.getPrice() < data.getPrice()) {   
               pdatas.add(data);   // 입력한 가격보다 비싼 상품들을 pdatas 배열에 추가
            }
         }
         return pdatas;   // 입력한 가격보다 비싼 상품들 반환
      }

      else if(pVO.getName().equals("4")) {   // 입력한 가격보다 싼 상품들 반환
         ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();   // 입력한 가격보다 싼 상품들을 넣을 배열
         for(ProductVO data : datas) {
            if(pVO.getPrice() > data.getPrice()) {
               pdatas.add(data);   // 입력한 가격보다 싼 상품들을 pdatas 배열에 추가
            }
         }
         return pdatas;   // 입력한 가격보다 싼 상품들 반환
      }

      else if(pVO.getName() != null) {   // 상품 이름으로 검색
         ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();   // 입력한 이름을 포함한 상품들을 넣을 배열
         for(ProductVO data : datas) {
            if(data.getName().contains(pVO.getName())) {
               //pVO.getName() == 사용자가 검색한 단어
               pdatas.add(data);   // 입력한 이름을 포함한 상품들을 pdatas 배열에 추가
            }
         }
         return pdatas;   // // 입력한 이름을 포함한 상품들을 반환
      }
      return null;
   }

   public ProductVO selectOne(ProductVO pVO){


      for(int i = 0; i < datas.size(); i++) {   // 입력한 PK번호를 가진 상품이 있는지 확인하는 반복문
         if(pVO.getPK() == datas.get(i).getPK()) {   // 입력한 PK번호를 가진 상품이 있다면
            if((pVO.getName() == null) && pVO.getCnt() != 0) {   // 입력한 이름이 존재하지않고, 입력한 재고가 있다면
                  if(pVO.getPK() == datas.get(i).getPK()) {   
                     // 해당 PK를 가진 상품의 입력한 재고만 덮어씌어서 객체를 반환 (장바구니용)
                     ProductVO pdata = new ProductVO(datas.get(i).getPK(), datas.get(i).getName(), datas.get(i).getPrice(), (-1) * pVO.getCnt());
                     return pdata;
               }
            }
            else if(pVO.getName() == null) {   // PK만 입력할 경우
                     ProductVO pdata = new ProductVO(datas.get(i).getPK(), datas.get(i).getName(), datas.get(i).getPrice(), datas.get(i).getCnt());
                     return pdata;   // 해당 PK를 가진 상품을 반환
                  } 
            }
      }
      
      if(pVO.getName()!=null) {

         if(pVO.getName().equals("2")) {   // 가장 비싼 상품 반환
            int max = datas.get(0).getPrice();   // 0번 인덱스가 가장 비싼 가격이라고 가정
            int maxIndex = 0;   // 가장 비싼 상품의 인덱스
            for(int i = 0; i<datas.size(); i++) {
               if(max < datas.get(i).getPrice()) {   // 현재 비싼 상품보다 비싼 가격의 상품이 존재한다면
                  max = datas.get(i).getPrice();   // max값에 더 비싼 상품의 가격을 저장
                  maxIndex = i;   // 인덱스도 더비싼 상품의 인덱스로 변경
               }
            }
            return datas.get(maxIndex);   // 최고가 상품 반환
         }
         else if(pVO.getName().equals("1")) { // 가장 싼 상품 반환
            int min = datas.get(0).getPrice();      // 0번 인덱스가 가장 싼 가격이라고 가정
            int minIndex = 0;      // 가장 싼 상품의 인덱스
            for(int i = 1;i < datas.size();i++) { 
               if(min > datas.get(i).getPrice()) {   // 현재 가장 싼 상품보다 싼 가격의 상품이 존재한다면
                  min = datas.get(i).getPrice();   // min값에 더 싼 상품의 가격을 저장
                  minIndex = i;   // 인덱스도 더 싼 상품의 인덱스로 변경
               }
            }
            return datas.get(minIndex); // 최저가 상품 반환
         }
      }
      return null;
   }

   public boolean insert(ProductVO pVO) { // 상품 추가
      datas.add(new ProductVO(PK++, pVO.getName(), pVO.getPrice(), pVO.getCnt()));
                        // PK의 중복을 방지하기 위해 시스템에서 PK를 지정
      return true;
   }
   public boolean update(ProductVO pVO) {// 상품 구매 및 재고 변경
      for (ProductVO data:datas) {
         if (data.getPK() == pVO.getPK()) {
            // 구매할때에는 절대값이랑 내 재고랑 비교
//            if (pVO.getCnt() < 0) { // 구매하거나 재고가 감소되는 경우
//               int cnt = pVO.getCnt() * (-1); // 구매하려는 양 또는 재고가 감소되는 양
//               if (cnt>data.getCnt()) {
//                  return false;
//               }
//            }
            data.setCnt(data.getCnt() + pVO.getCnt());
            return true;      
         }
      }
      return false;



   }
   public boolean delete(ProductVO pVO) {   // 상품 삭제
      for(int i = 0; i < datas.size(); i++) {
         if(datas.get(i).getPK() == pVO.getPK()) {
            datas.remove(i);   // 입력한 PK와 같은 값을 가진 상품이 존재하다면
                           // 해당 상품의 인덱스로 삭제
            return true;
         }
      }
      return false;
   }
}
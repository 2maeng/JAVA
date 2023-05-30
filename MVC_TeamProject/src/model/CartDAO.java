package model;

import java.util.ArrayList;

public class CartDAO {
   private ArrayList<ProductVO> cart;
   
   public CartDAO() {
      cart = new ArrayList<ProductVO>();
   }
   
   public ArrayList<ProductVO> selectAll(ProductVO pVO){
      return cart;
   }
   
   public ArrayList<ProductVO> selectOne(ProductVO pVO) {
      return null;
   }

   public boolean insert(ProductVO pVO) {   // 장바구니에 추가
      boolean flag = false;   // 플래그 알고리즘
      int index = 0;
      for (int i = 0; i < cart.size(); i++) {
         if (pVO.equals(cart.get(i))) {   // equals 오버라이딩으로 PK넘버 비교
                                 // PK가 같다면 flag가 true로 변경
            index = i;
            flag = true;
         }
      }
      if (flag) { // 구매목록에 이미 한번 구매했던 상품이 있을 때
         cart.get(index).setCnt(cart.get(index).getCnt() + pVO.getCnt());   // 재고만 추가
      } else {
         cart.add(pVO);   // 구매한 상품을 장바구니(cart)배열에 추가
      }
      return true;
   }

   public boolean update(ProductVO pVO) {
      return true;
   }

   public boolean delete(ProductVO pVO) {   // 사용자모드 종료시 장바구니 초기화
      cart.clear();
      return true;
   }
}
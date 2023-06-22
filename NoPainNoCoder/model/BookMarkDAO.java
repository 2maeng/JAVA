package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookMarkDAO {

   static final String sql_insert="INSERT INTO BOOKMARK (CNUM,MID) VALUES ( ? ,? )";
   static final String sql_delete="DELETE FROM BOOKMARK WHERE CNUM = ? AND MID=?";
   static final String sql_selectAll="SELECT NUM,MID,CNUM FROM BOOKMARK WHERE MID= ?";
   
   ResultSet rs;
   PreparedStatement pstmt;
   Connection conn;

   public ArrayList<BookMarkVO> selectAll(BookMarkVO bVO) {
      ArrayList<BookMarkVO> bdatas=new ArrayList<BookMarkVO>();
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(sql_selectAll);
//         System.out.println("로그 : bDAO : selectAll : pstmt에 selectAll 넣어서 실행1");
         pstmt.setString(1, bVO.getmId());
         rs=pstmt.executeQuery();
//         System.out.println("로그 : bDAO : selectAll : pstmt에 selectAll 넣어서 실행2");
         while(rs.next()) {
            bdatas.add(new BookMarkVO(rs.getInt("NUM"),rs.getString("MID"),rs.getInt("CNUM")));
         }
//         System.out.println("로그 : bDAO : selectAll : pstmt에 selectAll 데이터 추가 하고 난후");
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
//         System.out.println("로그 : bDAO : selectAll : pstmt에 selectAll에서 예외발생해서 반환되기 전");
         return null;
      }
      JDBCUtil.disconnect(rs, pstmt, conn);
//      System.out.println("로그 : bDAO : selectAll : pstmt에 selectAll실행해서 bdatas반환 하기전");
      return bdatas;
   }
   
   private BookMarkVO selectOne() {
      return null;
   }
   
   public boolean insert(BookMarkVO bVO) {

      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(sql_insert);
//         System.out.println("로그 : bDAO : insert : pstmt에 insert 넣어서 실행1");
         pstmt.setInt(1, bVO.getcNum());   
         pstmt.setString(2, bVO.getmId());
         pstmt.executeUpdate();
//         System.out.println("로그 : bDAO : insert : pstmt에 insert 넣어서 실행2");
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
//         System.out.println("로그 : bDAO : insert : pstmt에 insert에서 예외발생해서 반환되기 전");
         return false;
      }
      JDBCUtil.disconnect(pstmt, conn);
//      System.out.println("로그 : bDAO : insert : pstmt에 insert실행해서 boolean값 반환하기전");
      return true;
   }
   private boolean update() {
      return false;
   }
   public boolean delete(BookMarkVO bVO) {

      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(sql_delete);
//         System.out.println("로그 : bDAO : delete : pstmt에 delete 넣어서 실행1");
         pstmt.setInt(1, bVO.getcNum());
         pstmt.setString(2, bVO.getmId());
         int result=pstmt.executeUpdate();
//         System.out.println("로그 : bDAO : delete : pstmt에 delete 넣어서 실행1");

         if(result<=0) {
//            System.out.println("로그 : bDAO : delete : pstmt에 delete실행시 실패했을때");
            return false;
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
//         System.out.println("로그 : bDAO : delete : pstmt에 delete실행시 예외발생해서 반환되기 전");
         return false;
      }
      JDBCUtil.disconnect(pstmt, conn);
//      System.out.println("로그 : bDAO : delete : pstmt에 delete실행해서 boolean값 반환하기전");
      return true;
   }
}
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	final String sql_update = "UPDATE PRODUCT SET CNT = CNT - 1 WHERE NUM = ?";
	final String sql_selectAll_NAME="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE CONCAT('%', ?, '%')";
	final String sql_selectAll_PRICE="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE ? <= PRICE AND PRICE <= ?";
	final String sql_selectAll="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE CONCAT('%', ?, '%') AND ? <= PRICE AND PRICE <= ?";
	final String sql_selectOne = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NUM = ?";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private boolean insert(ProductVO pVO) {
		return false;
	}

	// 상품구매
	public boolean update(ProductVO pVO) {

		// 1. 자원로드
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, pVO.getNum());
			int result = pstmt.executeUpdate();

			if(result <= 0) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}

	public boolean delete(ProductVO pVO) {
		return false;
	}

	// 상품목록출력
	// 상품검색
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		// [ 선생님 풀이 ]
		ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
		
		// 1. 자원로드
		conn = JDBCUtil.connect();

		try {

			// [ 선생님 풀이 ]
			if(pVO.getSearchCondition().equals("이름")) {
				pstmt = conn.prepareStatement(sql_selectAll_NAME);
				pstmt.setString(1, pVO.getName());
				rs = pstmt.executeQuery();
			}
			else if(pVO.getSearchCondition().equals("가격")) {
				pstmt = conn.prepareStatement(sql_selectAll_PRICE);
				pstmt.setInt(1, pVO.getPrice());
				pstmt.setInt(1, pVO.getTmp());
				rs = pstmt.executeQuery();
			}
			else if(pVO.getSearchCondition().equals("이름가격")) {
				pstmt = conn.prepareStatement(sql_selectAll);
				pstmt.setString(1, pVO.getName());
				pstmt.setInt(2, pVO.getPrice());
				pstmt.setInt(3, pVO.getTmp());
				rs = pstmt.executeQuery();
			}
			
			while(rs.next()) {
				pdatas.add(new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		JDBCUtil.disconnect(rs, pstmt, conn);
		return pdatas;
	}

	// 상품선택(상품구매 시)
	public ProductVO selectOne(ProductVO pVO){

		ProductVO pdata = null;

		// 1. 자원로드
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, pVO.getNum());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				pdata = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		JDBCUtil.disconnect(rs, pstmt, conn);
		return pdata;
	}
}

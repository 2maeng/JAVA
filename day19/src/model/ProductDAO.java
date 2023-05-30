package model;

import java.util.ArrayList;

// 목록출력,목록검색_이름,목록검색_가격순,목록검색_조회수
public class ProductDAO {
	private ArrayList<ProductVO> datas;
	private static int PK=1001;
	
	public ProductDAO() {
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO(PK++, "장갑", 12000, 2));
		datas.add(new ProductVO(PK++, "화장지", 1000, 1));
		datas.add(new ProductVO(PK++, "장화", 23000, 0));
		datas.add(new ProductVO(PK++, "지갑", 120000, 1));
		datas.add(new ProductVO(PK++, "화분", 5500, 2));
	}
	
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		// 높은 응집도를 위해
		// 여러 기능을 하나의 메서드에서 작성
		if(pVO == null) {
			return datas;
		} else if(pVO.getName().equals("필터검색")) { // 이거 필터 검색이야? searchCondition, 설계 단계에서 미리
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>(); // 반환해줄 배열 만들고
			for(ProductVO data : datas) {
				if(pVO.getPrice() <= data.getPrice() && data.getPrice() <= pVO.getCnt()) { // 가격 범위에 들어가는 데이터들을 추가해서 
					mdatas.add(data);
				}
			}
			return mdatas; // 반환해
		}
		else {
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
			for(ProductVO data : datas) {
				if(data.getName().contains(pVO.getName())) { // 사용자가 입력한 이름을 가진 데이터야?
					// pVO.getName() == 사용자가 검색한 단어
					mdatas.add(data);
				}
			}
			return mdatas;
		}
	}
	
	public ProductVO selectOne(ProductVO pVO){
		if(pVO.getName().equals("최고가")) { // 지금 최고가 검색이야?
			int max = datas.get(0).getPrice();
			int maxIndex = 0;
			for(int i = 1; i < datas.size(); i++) {
				if(max < datas.get(i).getPrice()) {
					max = datas.get(i).getPrice();
					maxIndex = i;
				}
			}
			return datas.get(maxIndex);// 최고가 상품
		} else if(pVO.getName().equals("최저가")) { // 지금 최저가 검색이야?
			int min = datas.get(0).getPrice();
			int minIndex = 0;
			for(int i = 1; i < datas.size(); i++) {
				if(min > datas.get(i).getPrice()) {
					min = datas.get(i).getPrice();
					minIndex = i;
				}
			}
			return datas.get(minIndex); // 최저가 상품
		}
		return null;
	}
	
	public boolean insert(ProductVO pVO) {
		return true;
	}
	
	public boolean update(ProductVO pVO) {
		return true;
	}
	
	public boolean delete(ProductVO pVO) {
		return true;
	}
	
}

package model;

import java.util.ArrayList;

// DAO의 CRUD(비즈니스 메서드, 핵심 로직)는
// 어떤 추가 요청 사항에도 절대!
// "메서드 시그니처"가 변하지 않도록 코드를 작성해야함

// "메서드 시그니처"가 변경되면 다른 파트에 영향을 줘버림...
// '기능' 변경은 괜찮다 

// 결론) "메서드 시그니처"는 설계 단계에서 절대로 변경되면 안됌
public class DrinkDAO {

	private static int PK=1001;
	private ArrayList<DrinkVO> datas;
	public DrinkDAO() {
		datas = new ArrayList<DrinkVO>();
		datas.add(new DrinkVO(PK++, "콜라", 1200,3));
		datas.add(new DrinkVO(PK++, "사이다", 900,2));
		datas.add(new DrinkVO(PK++, "환타", 1500,1));
	}

	public boolean insert(DrinkVO vo) {
		System.out.println("MODEL(DAO): vo: " + vo);
		datas.add(new DrinkVO(PK++, vo.getName(), vo.getPrice(), vo.getCnt()));
		return true;
	}

	public ArrayList<DrinkVO> selectAll(DrinkVO vo) {
		if(vo.getName() == null) {
			return datas;
		}
		else {
			// 이름을 보고,
			// 새로운 datas를 만들어서,
			// 이름을 가진 애들을 넣어서 반환
			ArrayList<DrinkVO> datas = new ArrayList<DrinkVO>();
			for(DrinkVO data : this.datas) {
				if(data.getName().contains(vo.getName())) {
					datas.add(data);
				}
			}
			return datas;
		}
		
		// 1. 전체 목록 출력 => 그냥 내가가진 멤버변수 datas 반환
		// 2. 검색 결과 출력 => 이름을 보고, 그 이름을 가진 애들을 반환
	}

	public DrinkVO selectOne(DrinkVO vo) { // PK
		for(DrinkVO data : datas) {
			if(data.getNum() == vo.getNum()) {
				DrinkVO dVO = new DrinkVO(data.getNum(), data.getName(), data.getPrice(), data.getCnt());
				return dVO;
				// 실제 DB 데이터(==datas)를 전송 X
				// 새로 vo객체를 new(객체화)해서 전송 O
			}
		}
		System.out.println(" 로그: selectOne(): 해당 상품 없음");
		return null;
	}

	// 오버로딩이 불가능한 기능일 경우,
	// 기능이 매우 유사한 것이기 때문에 내부 로직에서 분리하여 관리
	// -> 유사한 기능끼리는 묶어서 관리하는 것이 용이하기 때문
	// 	  == 응집도를 높임 -> 유지보수에 용이
	public boolean update(DrinkVO vo) {
		for(DrinkVO data : datas) {
			if(data.getNum() == vo.getNum()) {
				// 구매할때에는 절대값이랑 내 재고랑 비교
				if(vo.getCnt() < 0) { // 구매할때
					int cnt = vo.getCnt() * (-1); // 구매하려는 양
					if(cnt > data.getCnt()) {
						System.out.println(" 로그: update(): 재고없음");
						return false;
					}
				}
				data.setCnt(data.getCnt() + vo.getCnt());
				return true;
			}
		}
		System.out.println(" 로그: selectOne(): 해당 상품 없음");
		return false;
	}

	public boolean delete(DrinkVO vo) {
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).getNum() == vo.getNum()) {
				datas.remove(i);
				return true;
			}
		}
		System.out.println(" 로그: selectOne(): 해당 상품 없음");
		return false;
	}

}
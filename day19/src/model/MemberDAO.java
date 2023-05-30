package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;
	
	public MemberDAO() {
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin", "1234", "관리자"));
		datas.add(new MemberVO("coding_helper", "teemo", "작은 티모"));
	}
		
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas; // 내가 가진 회원 목록 반환
	}
	
	public MemberVO selectOne(MemberVO mVO){
		for(MemberVO v : datas) {
			if(mVO.getMid().equals(v.getMid())) { // 내가 받은 값이 datas에 있어?
				if(mVO.getMpw().equals(v.getMpw())) { // 비밀번호 확인
					return v;
				}
				System.out.println(" 로그: MemberDAO: selectOne(): 비밀번호가 일치하지 않습니다.");
				return null;
			}
		}
		System.out.println(" 로그: MemberDAO: selectOne(): 해당 아이디가 없습니다.");
		return null;
	}
	
	public boolean insert(MemberVO mVO) {
//		mVO가 의미하는것 == 회원가입할 정보
//		mVO를 datas에 넣어줄예정
//		PK 중복검사를 해야하고, 성공하면 add()
//		실패하면 false 반환
		boolean flag = false;
		for(MemberVO data : datas) {
			if(data == mVO) { // data == mVO 객체 비교를 연산자로 X
				flag = true;
				System.out.println(" 로그: MemberDAO: insert(): 아이디 중복");
				break;
			}
		}
		if(flag) {
			return false;
		}
		datas.add(new MemberVO(mVO.getMid(), mVO.getMpw(), mVO.getName()));
//		1) datas.add(new MemberVO());
//			-> datas DB공간에 new 새로운 데이터를 추가
//		2) MemberVO(데이터1, 데이터2, 데이터3)
//			-> 데이터들을 mVO에서 추출하면됌
		return true;
	}
	
	public boolean update(MemberVO mVO) {
		for(MemberVO data : datas) {
			if(data.getMid().equals(mVO.getMid())) {
				mVO.setMpw(mVO.getMpw());
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(MemberVO mVO) {
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).equals(mVO)) {
				datas.remove(i);
				return true;
			}
		}
		return false;
	}
}

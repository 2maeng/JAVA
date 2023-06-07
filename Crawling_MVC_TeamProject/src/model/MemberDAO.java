package model;

import java.util.ArrayList;

public class MemberDAO { // MemberDAO 클래스 시작 [5 ~ 96]
	private ArrayList<MemberVO> datas;

	// ======================================================= 생 성 자 =============================================================================
	
	public MemberDAO() { // 생성자 시작 [10 ~ 14]
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO("junwon", "1234", "류준원"));
		datas.add(new MemberVO("1", "1", "류준원"));
	} // 생성자 시작 [10 ~ 14]

	//======================================================= 목 록 출 력 ==============================================================================
	
	public ArrayList<MemberVO> selectAll(MemberVO mVO) { // selectAll() 메소드 시작 [18 ~ 20]
		return datas;
	} // selectAll() 메소드 끝 [18 ~ 20]

	//======================================================= 로 그 인 ==================================================================================

	public MemberVO selectOne(MemberVO mVO) { // selectOne() 메소드 시작 [24 ~ 34]
		for(MemberVO v : datas) {
			if(mVO.getMid().equals(v.getMid())) { // 사용자가 입력한 id가 v의 id와 같다면
				if(mVO.getMpw().equals(v.getMpw())) { // 사용자가 입력한 password가 v의 password와 같다면
					return v; // v 반환
				}
			}
		}
//		System.out.println(" 로그 : MemberDAO : SelectOne() : 해당 아이디가 존재하지 않습니다.");
		return null;
	} // selectOne() 메소드 끝 [24 ~ 34]

	//==================================================== 회 원 가 입 ==================================================================================

	
	public boolean insert(MemberVO mVO) { // insert() 메소드 시작 [39 ~ 54]
		boolean flag = false; // id가 중복검사를 위해 flag 알고리즘 사용
		for(MemberVO v : datas) { 
			if(v.equals(mVO)) { // 사용자가 입력한 id가 기존이 배열리스트에 존재한다면
				flag = true; // 해당 id 중복됨
//				System.out.println(" 로그: MemberDAO: insert() : 해당 아이디가 이미 존재합니다.");
				break;
			}
		}
		if(flag) { // id 중복이므로
//			System.out.println(" 로그 : MemberDAO : insert() : 회원가입 실패.");
			return false; // false 반환
		} 
		datas.add(new MemberVO(mVO.getMid(), mVO.getMpw(), mVO.getName())); // 중복되지 않은 id라면 배열리스트에 저장
		return true;
	} // insert() 메소드 끝 [39 ~ 54]

	//=========================================== 비 밀 번 호 변 경 / 장 바 구 니 추 가 ================================================================================================
	
	public boolean update(MemberVO mVO) { // update() 메소드 시작 [58 ~ 84]
		// [비밀번호 변경]
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).getMid().equals(mVO.getMid())) { // id가 같은지 검사
				if(mVO.getName() == null) { // name에 null을 받아왔다면
					datas.get(i).setMpw(mVO.getMpw()); // 기존 datas 배열리스트의 비밀번호를 사용자가 입력한 값으로 변경
					return true;
				}
				// [News PK 담는 방법]
				else if(mVO.getMpw() == null) { // password에 null을 받아왔다면
					int mVOcnt = Integer.valueOf(mVO.getName()); // 이름에 담아온 값은 문자열 -> PK와 비교하기 위해 정수형으로 변환
					for(int j = 0; j < datas.get(i).getCart().size(); j++) { 
						if(datas.get(i).getCart().get(j) == mVOcnt) { // 사용자가 이미 봤던 News라면
							datas.get(i).getCart().remove(j); // 해당 News 삭제
							break; 
						}
					}
					datas.get(i).getCart().add(0, mVOcnt); // 기존의 배열리스트의 0번 인덱스에 NewsPK 추가
					return true;
				}
			}
		}
		return false;
	} // update() 메소드 끝 [58 ~ 81]

	//===================================================== 회 원 탈 퇴 =================================================================================

	public boolean delete(MemberVO mVO) { // delete() 메소드 시작 [88 ~ 97]
		for(int i = 0; i < datas.size(); i++) { 
			if(datas.get(i).equals(mVO)) { // 사용자에게 입력한 비밀번호와 기존의 배열리스트가 일치한다면
				datas.remove(i); // 회원 삭제
				return true; 
			}
		}
//		System.out.println(" 로그 : MemberDAO : delete() : 해당 아이디를 찾을 수 없습니다.");
		return false; // 아니라면 false 
	} // delete() 메소드 끝 [88 ~ 97]
} // MemberDAO 클래스 끝 [5 ~ 98]

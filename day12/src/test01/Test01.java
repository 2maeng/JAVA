package test01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class ProteinShake{
	private int PK; // 고유 프로튼 쉐이크 번호
	private String name; // 프로틴 쉐이크 이름
	private int price; // 가격
	private int cnt; // 재고
	
	ProteinShake(int PK, String name, int price){
		this.PK = PK;
		this.name = name;
		this.price = price;
		Random rand = new Random();
		this.cnt = rand.nextInt(6) + 5; // 5 ~ 10개로 재고 랜덤 설정
	}
	
	void sell(int cnt) { // 판매됐을때 실행할 메서드
		this.cnt -= cnt;
		System.out.println(this.name + "이(가) 판매되었습니다. 남은 재고는 " + this.cnt + "개 입니다.");
	}
	
	void changeCnt(int num) { // 재고를 추가할 경우
		this.cnt += num;
	}
	
	public int getPK() {
		return PK;
	}
	public void setPK(int pK) {
		PK = pK;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) { // 재고를 변경할 경우
		this.cnt = cnt;
	}

	@Override
	public String toString() { // toString()을 원하는 방식으로 바꿔쓰는 오버라이딩
		if(this.cnt == 0) { // 재고가 0일때 품절로 보이기위함
			return this.PK + "번 " + this.name + " [" + this.price + "원] " + "(재고 : 품절)\n";
		} else {
			return this.PK + "번 " + this.name + " [" + this.price + "원] " + "(재고 : " + this.cnt + "개)\n";
		}
	}
	
	
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 입력 받을 스캐너 생성
		
		// 몇 개를 출력할지 모르기에 ArrayList 사용
		ArrayList<ProteinShake> data = new ArrayList<ProteinShake>();
		int numPK = 1000; // 쉐이크 고유번호를 관리자가 미리 지정 안정성 때문
		
		while(true) { // 사용자 페이지
			System.out.println("1. 상품 목록 출력");
			System.out.println("2. 구매하기");
			System.out.println("3. 프로그램 종료");
			System.out.println("입력) ");
			
			int action = sc.nextInt();
			
			if(action == 1) { // 상품 목록 출력
				for(ProteinShake proteinShake : data) { // 프로틴 배열만큼
					System.out.println(proteinShake);
				}
			} 
			else if(action == 2) { // 구매하기
				for(ProteinShake proteinShake : data) { // 상품 목록
					System.out.println(proteinShake);
				}
				
				System.out.println("구매할 상품 번호 입력) ");
				int num = sc.nextInt();
				
				System.out.println("구매할 개수 입력) ");
				int cnt = sc.nextInt();
				
				for(int i = 0; i < data.size(); i++) {
					if(num == data.get(i).getPK()) { // 배열에 있는 쉐이크 번호
						System.out.println("구매할 상품의 가격은 " + (data.get(i).getPrice() * cnt) + "원 입니다.");
						System.out.println("낼 금액 입력) ");
						int money = sc.nextInt();
						System.out.println("잔돈은 " + (money - (data.get(i).getPrice() * cnt)) + "원 입니다.");
						data.get(i).sell(cnt);
						break;
					}
				}
				
			}
			else if(action == 3) { // 프로그램 종료
				break;
			} 
			else if(action == 1103) { // 관리자 모드
				System.out.print("Password : "); // 비밀번호
            	int password = sc.nextInt(); // 임시변수
            	
            	if(password == 971103) { // 비밀번호가 맞을시 관리자모드 진입
            		System.out.println("\n 관리자 모드입니다.");
            		
            		
            		while(true) { // 관리자 페이지
            			System.out.println("1. 상품 추가");
            			System.out.println("2. 상품 재고 변경");
            			System.out.println("3. 상품 삭제");
            			System.out.println("4. 관리자모드 종료");
            			System.out.println("입력) ");
            			
            			action = sc.nextInt();
            			
            			if(action == 1) { // 상품 추가
            				System.out.println("상품 이름 입력) ");
            				String name = sc.next();
            				sc.nextLine();
            				
            				System.out.println("상품 가격 입력) ");
            				int price = sc.nextInt();
            				data.add(new ProteinShake(numPK++, name, price)); // 고유번호, 이름, 가격을 프로틴 배열에 저장
            				
            				for(ProteinShake proteinShake : data) { // 상품 목록 출력
            					System.out.println(proteinShake);
            				}
            				
            			}
            			else if(action == 2) { // 상품 재고 설정
            				for(ProteinShake proteinShake : data) { // 상품 목록 출력
            					System.out.println(proteinShake);
            				}
            				
            				System.out.println("1.재고 변경 2.재고 추가");
            				int action2 = sc.nextInt();
            				
            				if(action2 == 1) { // 재고 변경
            					System.out.println("변경할 상품의 번호를 입력) ");
            					int num = sc.nextInt();
            					
            					
            					System.out.println("변경할 재고의 개수를 입력) ");
            					int cnt = sc.nextInt();
            					
            					for(int i = 0; i < data.size(); i++) {
            						if(num == data.get(i).getPK()) { // 배열에 있는 쉐이크 번호
            							data.get(i).setCnt(cnt); // 재고를 아예 변경
            							break;
            						}
            					}
            					
            					for(ProteinShake proteinShake : data) { // 상품 목록 출력
                					System.out.println(proteinShake);
                				}
            					
            				}
            				
            				if(action2 == 2) { // 재고 추가
            					System.out.println("추가할 상품의 번호를 입력) ");
            					int num = sc.nextInt();
            					
            					
            					System.out.println("추가할 재고의 개수를 입력) ");
            					int cnt = sc.nextInt();
            					
            					for(int i = 0; i < data.size(); i++) {
            						if(num == data.get(i).getPK()) { // 배열에 있는 쉐이크 번호
            							data.get(i).changeCnt(cnt); // 재고를 추가
            							break;
            						}
            					}
            					
            					for(ProteinShake proteinShake : data) { // 상품 목록 출력
                					System.out.println(proteinShake);
                				}
            					
            				}
            				
            				
            			}
            			else if(action == 3) { // 상품 삭제
            				for(ProteinShake proteinShake : data) { // 상품 목록 출력
            					System.out.println(proteinShake);
            				}
            				System.out.println("삭제할 상품의 번호를 입력) ");
            				int num = sc.nextInt();
            				for(int i = 0; i < data.size(); i++) {
            					if(num == data.get(i).getPK()) { // 배열에 있는 쉐이크 번호
            						data.remove(i);
            						break;
            					}
            				}
            				
            				for(ProteinShake proteinShake : data) { // 상품 목록 출력
            					System.out.println(proteinShake);
            				}
            				
            			}
            			else if(action == 4) { // 관리자 모드 종료
            				break;
            			} 
            		} // 관리자 end while
            	} 
			}
		} // 사용자 end while
		
	}
	
}

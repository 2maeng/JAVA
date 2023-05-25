package test02;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		System.out.println(this.name + "이(가) 판매되었습니다. 남은 재고는 " + this.cnt + "개 입니다.\n");
	}

	void changeCnt(int num) { // 재고를 추가할 경우
		this.cnt += num;
		System.out.println(this.name + " [" + this.price + "원] " + "(재고 : " + this.cnt + "개)");
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
		System.out.println(this.name + " [" + this.price + "원] " + "(재고 : " + this.cnt + "개)");
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

public class Test02 {
	
	static int ok() { // sc.nextInt() 정수 이외의 값을 받았을 때 처리해주는 메소드
		Scanner sc = new Scanner(System.in);
		try {
			int num = sc.nextInt();
			return num;
		} catch(InputMismatchException e) { // 정수이외 잘못된 값을 입력 받았을 때
			sc.nextLine();
			return -1;
		}
	}
	
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
			int action = ok();

			if(action == 1) { // 상품 목록 출력
				if(data.size() == 0) { // 등록된 상품이 없을때
					System.out.println("\n등록된 상품이 없습니다. \n");
					continue;
				}

				System.out.println("================ 메뉴 ================");
				for(ProteinShake proteinShake : data) { // 프로틴 배열만큼 상품 목록
					System.out.println(proteinShake.toString());
				}
				System.out.println("===================================== \n");
			} 
			else if(action == 2) { // 구매하기
				if(data.size() == 0) {
					System.out.println("\n구매할 수 있는 상품이 없습니다. \n");
					continue;
				}

				for(ProteinShake proteinShake : data) { // 프로틴 배열만큼 상품 목록
					System.out.println(proteinShake.toString());
				}

				int pk_idx = -1;
				while(true) { // 상품 번호 유효성 검사
					System.out.println("구매할 상품 번호 입력) ");
					int num = ok();

					for(int i = 0; i < data.size(); i++) {
						if(num == data.get(i).getPK()) { // 존재하는 상품을 찾았을때 
							System.out.println(data.get(i) + " 상품 선택하셨습니다.");
							pk_idx = i;
							break;
						} 
					}

					if(pk_idx != -1) { // 상품이 존재할 때
						break;
					} else { // 존재하지 않은 상품일때
						System.out.println("\n선택하신 상품은 없는 상품입니다. 다시 입력해주세요.\n");
					}
				}

				while (true) { // 재고 개수 유효성 검사
					System.out.println("구매할 개수 입력) ");
					int cnt = ok();

					if(cnt <= 0) { // 재고 개수 0 이하일때
						System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
					}

					if (cnt <= data.get(pk_idx).getCnt() && cnt > 0) { // 재고가 존재할때
						System.out.println("\n구매할 상품의 가격은 " + (data.get(pk_idx).getPrice() * cnt) + "원 입니다.");

						int total = (data.get(pk_idx).getPrice() * cnt); // 총 금액 저장
						
						while (true) { // 낼 금액 유효성 검사
							System.out.println("낼 금액 입력) ");
							int money = ok();

							if (money >= total) { // 낼 돈은 총 금액보다 크거나 같아야 구매 가능
								System.out.println("\n잔돈은 " + (money - total) + "원 입니다.");
								System.out.println("구매감사합니다! 또 오세요\n");
								data.get(pk_idx).sell(cnt);
								break;
							} else { // 낼 금액이 총 금액보다 작으면 안됌
								System.out.println("\n그 돈으로 사겠냐? 돈 다시 입력하소ㅋ\n");
							}
						}
						break;
					} else if (cnt > data.get(pk_idx).getCnt()) { // 재고가 존재하지 않을때
						System.out.println("\n재고가 부족합니다. 다시 입력 해주세요.\n");
					}
					
					for(ProteinShake proteinShake : data) { // 상품 목록 출력
    					System.out.println(proteinShake);
    				}
					
				}
			}
			else if(action == 3) { // 프로그램 종료
				break;
			} 

			else if(action == 1103) { // 관리자 모드
				System.out.print("Password : "); // 비밀번호
				int password = ok(); // 임시변수

				if(password == 971103) { // 비밀번호가 맞을시 관리자모드 진입
					System.out.println("\n 관리자 모드입니다.");


					while(true) { // 관리자 페이지
						System.out.println("1. 상품 추가");
						System.out.println("2. 상품 재고 변경");
						System.out.println("3. 상품 삭제");
						System.out.println("4. 관리자모드 종료");
						System.out.println("입력) ");

						action = ok();

						if(action == 1) { // 상품 추가

							String name;
							while (true) {// 상품이름 유효성 검사
								System.out.println("상품 이름 입력) ");
								name = sc.next(); // 이름 입력 받기
								sc.nextLine();
								int tmp;

								System.out.println("정말 " + name + "으로 하시겠습니까?\n");
								System.out.println("1.예 2.아니오");
								tmp = ok();

								if (tmp == 1) {// 예
									break;
								} else if (tmp == 2) {// 아니오
									name = "";
									System.out.println("이름을 다시 입력해주세요\n");
									continue;
								} else { // 입력값이 잘못되었다면
									System.out.println("잘못된 입력입니다.");
									System.out.println("다시 입력해주세요.\n");
									continue;// 잘못된 입력이라면 예 아니오 다시 물어보기
								} // end if
							} // end while

							if(name.equals("")) { // 이름이 비워져 있다면 입력부분으로 돌아가기
								continue;
							}

							int price;
							while (true) {
								System.out.println("상품 가격 입력) ");
								price = ok(); // 가격 입력 받기

								if (!(5000 <= price && price <= 10000)) {// 가격 유효성 검사
									System.out.println("가격은 5000원 ~ 10000원 사이로 입력해주세요.\n");
									continue; // 다시 입력
								} 
								break; // 점수 유효성 검사 완료
							} // end while

							data.add(new ProteinShake(numPK++, name, price)); // 고유번호, 이름, 가격을 프로틴 배열에 저장

							for(ProteinShake proteinShake : data) { // 상품 목록 출력
								System.out.println(proteinShake);
							}

						}
						else if(action == 2) { // 상품 재고 설정
							if(data.size() == 0) { // 등록된 상품이 없을때
								System.out.println("\n등록된 상품이 없습니다. \n");
								continue;
							}
							
							for(ProteinShake proteinShake : data) { // 상품 목록 출력
								System.out.println(proteinShake);
							}

							System.out.println("1.재고 변경 2.재고 추가");
							int action2 = ok();

							int pk_idx = -1; // 상품을 찾기위한 고유번호 변수
							int num;
							if(action2 == 1) {

								while(true) {
									System.out.println("변경할 상품의 번호를 입력) ");
									num = ok();

									for(int i = 0; i < data.size(); i++) {
										if(num == data.get(i).getPK()) { // 존재하는 상품을 찾았을때 
											System.out.println(data.get(i) + " 상품 선택하셨습니다.");
											pk_idx = i;
											break;
										} 
									}

									if(pk_idx == -1) { // 상품이 존재하지 않을때
										System.out.println("\n선택하신 상품은 없는 상품입니다. 다시 입력해주세요.\n");
										continue;
									} else {
										break;
									}
								}

								int cnt;
								while(true) {

									System.out.println("변경할 재고의 개수를 입력) ");
									cnt = ok();

									if(cnt <= 0) {
										System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
										continue;
									} else {
										break;
									}

								}

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

							int cnt;
							if(action2 == 2) {

								while(true) {
									System.out.println("추가할 상품의 번호를 입력) ");
									num = ok();

									for(int i = 0; i < data.size(); i++) {
										if(num == data.get(i).getPK()) { // 존재하는 상품을 찾았을때 
											System.out.println(data.get(i) + " 상품 선택하셨습니다.");
											pk_idx = i;
											break;
										} 
									}

									if(pk_idx == -1) { // 상품이 존재하지 않을때
										System.out.println("\n선택하신 상품은 없는 상품입니다. 다시 입력해주세요.\n");
										continue;
									} else {
										break;
									}
								}

								while(true) {
									System.out.println("추가할 재고의 개수를 입력) ");
									cnt = ok();

									if(cnt <= 0) {
										System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
										continue;
									} else {
										break;
									}
								}

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
							
							int num;
							int pk_idx = -1;
							while(true) {
								System.out.println("삭제할 상품의 번호를 입력) ");
								num = ok();
								
								for(int i = 0; i < data.size(); i++) {
									if(num == data.get(i).getPK()) { // 존재하는 상품을 찾았을때 
										System.out.println(data.get(i) + " 상품 선택하셨습니다.");
										pk_idx = i;
										break;
									} 
								}
	
								if(pk_idx == -1) { // 상품이 존재하지 않을때
									System.out.println("\n선택하신 상품은 없는 상품입니다. 다시 입력해주세요.\n");
									continue;
								} else {
									break;
								}
							
							}
							
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
						} else {
							System.out.println("유효하지 않은 값 입니다. 다시 입력하세요.\n");
							continue;
						}
					} // 관리자 end while
				} else {
					System.out.println("누구냐 넌 ㅡㅡ");
					continue;
				}
			} 
			else {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요.\n");
				continue;
			}
		} // 사용자 end while

	}

}

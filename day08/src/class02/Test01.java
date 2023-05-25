package class02;

import java.util.Scanner;

class Product{
	// 1. 멤버변수
	int num; // PK는 맨 상단에 작성
	String name;
	int cnt;
	int price;

	// 3. 생성자
	Product(int num, String name, int price){
		this.num = num;
		this.name = name;
		this.cnt = 5; // 재고의 디폴트의 값은 5
		this.price = price;
		System.out.println(this.name + " 생성완료!");
	}

	// 2. 메서드 -> 함수라서()
	// 1) 기능생각
	//		: 사용자가 3개 구매할건데, 구매가능?
	//		: 가능하다면 재고 마이너스
	//		: 총 가격안내
	//		: 불가능하다면 구매실패
	// 2) 메서드 시그니처 파악
	//		: INPUT -> int 구매할 상품의 개수
	//		: OUTPUT -> int 총가격, boolean
	//				 => int 총가격(구매실패시 0원)
	// 3) 기능구현
	int sell(int cnt) {
		int sum = 0;
		if(this.cnt >= cnt) {
			this.cnt-=cnt;
			sum = cnt * this.price;
			System.out.println("총 금앤은" + sum + "원 입니다.");
		} else {
			System.out.println(this.name + " 재고가 부족합니다.");
		}
		return sum;
	}

	// 1) 관리자가 ㅁㅁㅁ원으로 가격을 변경
	// 	  변경되었습니다.
	// 2) INPUT -> int 가격
	//	  OUTPUT - > void
	// 3) 구현
	void setPrice(int price) { // 멤버변수(인스턴스 변수)의 값을 새로 정의 하는 것 == setter
		this.price = price;
		System.out.println(this.name + " 가격 변경완료!");
	}

	void printInfo() {
		System.out.println(this.name + " [" + this.cnt + "] " + this.price + "원");
	}
}

public class Test01 {

	public static void main(String[] args) {
		// ※ main()에서 객체의 멤버변수에 직접적으로 접근 X

		Product[] data = new Product[3];
		// 현재 상품배열 data[]에 저장된 상품의 개수는 0개
		// data[]의 크기 == 3
		int index = 0; // 상품 배열에 저장되어있는 상품의 개수

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=== 자판기 ===");
			//			System.out.println("1. 메뉴추가");
			System.out.println("1. 메뉴출력");
			System.out.println("2. 메뉴구매");
			//			System.out.println("4. 가격변경");
			System.out.println("3. 프로그램 종료");
			System.out.println("=================");
			System.out.println("입력) ");
			int action = sc.nextInt();

			if(action == 3) {
				System.out.println("프로그램 종료.");
				break;
			} 
			else if(action == 1) { // R
				// 상품 배열에 저장되어있는 상품만큼 화면에 출력해줘
				for(int i = 0; i < index; i++) { // 상품 배열에 저장되어있는 상품의 개수
					// System.out.println((i + 1) + ". " + data[i].name + " [" + data[i].cnt + "] " + data[i].price);
					// 안정성(보안)의 문제로, 이런식으로 코딩 하지마
					System.out.println((i + 1) + ". ");
					data[i].printInfo();
				}
			} 
			else if(action == 2) { // U
				// 사용자가 구매할 상품번호 입력
				// 해당상품 구매를 진행
				System.out.println("구매할 상품번호 입력");
				System.out.println("입력) ");
				int num = sc.nextInt();
				System.out.println("구매할 상품의 개수입력");
				System.out.println("입력) ");
				int cnt = sc.nextInt();
				data[num-1].sell(cnt);
			}
			else if(action == 1234) { // 관리자 모드
				System.out.println("관리자 모드입니다.");
				System.out.println();

				System.out.println("=== 관리자 ===");
				System.out.println("1. 메뉴추가");
				System.out.println("2. 가격변경");
				System.out.println("=================");
				System.out.println("입력) ");
				action = sc.nextInt();


				if(action == 1) { // C
					// 상품 객체를 생성해서
					System.out.println("생성할 상품의 이름입력");
					System.out.println("입력) ");
					String name = sc.next();
					System.out.println("생성할 상품의 가격입력");
					System.out.println("입력) ");
					int price = sc.nextInt();

					// 상품 객체 배열에 저장해줘~
					data[index++] = new Product(index, name, price);
				}
				else if(action == 2) { // U
//					if(혹시 변경가능한 상품이 없어?) {
//						
//					}
				if(index <= 0) {
					System.out.println("저장된 상품이 없습니다!");
					continue;
				}

				System.out.println("가격을 변경할 상품번호 입력");
				System.out.println("입력) ");
				int num = sc.nextInt();
				if(num <= 0 || index < num) { // 혹시 num이 유효하지가 않아?
					// ☆ 경계값 검사
					System.out.println("없는 상품번호 입니다.");
					continue;
				}

				System.out.println("상품의 가격 입력");
				System.out.println("입력) ");
				int price = sc.nextInt();
				if(price <= 0) {
					System.out.println("올바르지않은 가격입니다!");
					continue;
				}
				data[num-1].setPrice(price);
			}
		}

		else { // 유효성 검사(사용자 입력값 검사)
			System.out.println("잘못된 번호입니다! 확인후 다시 이용해주세요");
		}
	}


































}

}


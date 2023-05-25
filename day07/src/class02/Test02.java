package class02;

import java.util.Random;
import java.util.Scanner;

class Po{
	// 멤버변수
	String name;
	int lv;
	int exp;

	// this 자기 자신을 활용하여 생성자를 초기화
	Po(String name, int lv, int exp){
		this.name = name;
		this.lv = lv;
		this.exp = exp;
	}

	
	void game(int g) { // int g는 게임을 의미함 1승리 0실패
		Random rand = new Random();
		if (g == 1) { // 승리
			System.out.println("성공");
			this.exp+=rand.nextInt(101) + 50;
		} else { // 1이 아니면 0이기에 실패
			System.out.println("실패");
			this.exp+=10;
		}
		while(this.exp >= 100) { // 경험치가 100초과했을 경우 100을 빼주는 작업
			System.out.println(this.name + " 레벨업!");
			this.lv++;
			this.exp-=100;
		}
	}

	void printInfo() { // 포켓몬 정보
		System.out.println(this.name + " " + "Lv." + this.lv + " [" + this.exp + "/" + "100]");
	}

}

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Random rand = new Random();

		Po[] po = new Po[3]; // 3마리의 포켓몬 저장

		int index = 0;
		while(true) {
			if(index == 3) { // 전부 완성하면 멈춰
				break;
			}
			System.out.println((index + 1) + "번째" + " 포켓몬과 레벨 : ");
			String name = sc.next(); // 문자열 입력
			int lv = sc.nextInt(); // 정수 입력
			System.out.println("위의 값이 맞나요?");
			System.out.println("1-YES 2-NO : ");
			int ans = sc.nextInt();
			
			if(ans != 1) { // YES가 아니라면 다시
				System.out.println("다시 입력해주세요!");
				continue;
			}
			
			System.out.println();
			
			index++;
		}

//		int ok = 0; // 유효성 검사 
//		while(ok < po.length) {
//			System.out.println("포켓몬과 레벨 입력) ");
//			String name = sc.next(); // 포켓몬 사용자 입력
//			int lv = sc.nextInt(); // 레벨 사용자 입력
//			
//			if(lv > 0) { // 레벨 유효성 검사 레벨은 음수이면 안돼
//				int exp = rand.nextInt(11);
//				po[ok] = new Po(name, lv, exp);
//				ok++; // 포켓몬 3마리 입력해야하기에 성공하면 하나씩 증가
//			} else {
//				System.out.println("입력 실패 다시 입력해주세요");
//			}
//		}
//		System.out.println("포켓몬 입력 성공");
		
		int i = 0;
		while(true) { // 게임
				int g = rand.nextInt(2); // 0이면 성공 1이면 실패 -> 위 클래스 함수에 대입
				po[index].game(g); // 포켓몬 랜덤으로 게임!
				System.out.println((index + 1) + ". " + po[index].name + "Lv." + po[index].lv + " [" + po[index].exp + "/" + "100]");
				System.out.println("==========================");
			if(po[1].lv == 15) { // 종료조건!
				break;
			}
			index++;
		}
		
		


	}

}

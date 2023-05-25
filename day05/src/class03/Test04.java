package class03;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	
	// 메서드 시그니처를 먼저 고려할 것
	// INPUT : int 1개, String 1개
	// OUTPUT : boolean
	// 정답과 사용자의 입력값을 비교해서,
	// 맞았는지 틀렸는지를 반환
	public static boolean check(int num, String user) {
		final int NUM = num; // final : 상수화 -> 항상 똑같음 안 바뀌고

		int cnt = 0; // 박수 횟수 카운트 할 변수

		// 1. 진짜 정답을 만들기 String ans
		int n = num / 1000; // 1000인 경우, 1을 의미함
		if(n == 3 || n == 6 || n == 9) {
			cnt++;
		}

		num = num % 1000; // 1312인 경우, 13을 의미하게 되므로 전처리가 필수!
		n = num / 100; // 1312 -> 312, 3을 의미함
		if(n == 3 || n == 6 || n == 9) {
			cnt++;
		}

		num = num % 100;
		n = num / 10; // 56인 경우, 5를 의미함
		if(n == 3 || n == 6 || n == 9) {
			cnt++;
		}

		num = num % 10;
		n = num / 1; // 8인 경우, 8을 의미함
		if(n == 3 || n == 6 || n == 9) {
			cnt++;
		}

		String ans = "";
		for(int i = 0; i < cnt; i++) {
			ans+="짝";
		}

		if(cnt == 0) { // 3 6 9가 하나도 없다면
			// 형변환(casting)
			ans = Integer.toString(NUM);
		}

		// 2. ans와 user를 비교
		System.out.println("ans: " + ans);
		System.out.println("user: " + user);
		if(ans.equals(user)) {
			return true;
		}
		return false;
		// 연산자는 기본 자료형(원시타입)에게만 적용되는 문법
		// 클래스(객체)들은 연산자로 비교 불가능
	}

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Random rand=new Random();

		// [2]의 게임을 통과한 사람들의 목록을 출력해주세요!
		// for(명예의 전당에 저장된 사람의 수만큼)
		// 배열 OK! String[] data = new String[5];
		String[] data=new String[5];
		for(int i=0;i<data.length;i++) {
			data[i]="_____";
		}
		
		int dataCnt=0; // 명예의 전당에 저장된 사람의 수
		while(dataCnt<data.length) {
			for(int i=0;i<data.length;i++) {
				System.out.println((i+1)+". "+data[i]);
			}
			System.out.println("--------------------");

			int i=0;
			while(i<2) {

				int randNum=rand.nextInt(1000)+1;
				System.out.print("["+randNum+"] : ");
				String userAns=sc.next();

				if(!check(randNum,userAns)) {
					System.out.println("오답입니다.....");
					break;
				}
				System.out.println("정답입니다!");
				i++;

			}

			if(i==2) {
				System.out.print("명예의 전당에 올릴 이름을 입력) ");
				data[dataCnt]=sc.next();
				System.out.println(data[dataCnt]+"님, 축하합니다! :D");
				dataCnt++;
			}

		}

	}

}

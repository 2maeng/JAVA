package Work01;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		int[] score = new int[6]; // 점수를 담을 배열 생성
		
		Scanner sc = new Scanner(System.in); // 입력시킬 스캐너 생성
		
		for(int i = 0; i < score.length; i++) { // 점수 배열의 길이만큼
			System.out.println((i + 1) + " 번 째의 학생 점수를 입력:"); // 인덱스는 0 부터 시작이니까
			score[i] = sc.nextInt(); // 점수 입력
			
		}
		
		for(int i = 0; i < score.length; i++) { // 점수를 비교하기위한 반복문 처음부터
			for(int j = i + 1; j < score.length; j++) { // 처음부터 비교할 필요 x
				if(score[i] > score[j]) { // 점수가 큰 학생이면 실행
					// 그 점수를 임시공간에 저장시켜 교환
					int tmp = score[i];
					score[i] = score[j];
					score[j] = tmp;
				}
			}
		}
		
		System.out.print("정렬 후 : ");
		for(int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		
	}
}

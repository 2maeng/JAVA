package class03;

import java.util.Random;

// 자동 임포트(Ctrl + Shift + O)
public class Test02 {
	public static void main(String[] args) {
		
		// 선생님 풀이
		int[] stu = new int[6];
//		stu[0] = 29;
//		stu[1] = 99;
//		stu[2] = 30;
//		stu[3] = 22;
//		stu[4] = 87;
//		stu[5] = 57;
		
		// 랜덤으로 점수를 생성해보자!
		Random rand = new Random();
		
		for(int i = 0; i < stu.length; i++) {
			// stu[i] = 랜덤수;
			stu[i]= rand.nextInt(101); // 랜덤 숫자가 저장 0 ~ 100까지
			System.out.print(stu[i] + " ");
		}
		System.out.println();
		
		
		// 1. 평균점수
		int sum = 0; // 총점을 저장 할 변수
		for(int i = 0; i < stu.length; i++) {
			sum+=stu[i];
		}
		double avg = sum * 1.0 / stu.length;
		System.out.println("평균 : " + avg);
		
		System.out.println("==================");
		
		// 2. 평균을 넘긴 학생수
		// 5. 평균을 못넘긴 번호 --->> 변수 xxx
		// 	: 저장공간을 예상하는 방법
		//	: 나중에 배열을 생성하는 방법
		int num = 0; // 평균 넘긴 학생수를 저장할 변수
		for(int i = 0; i < stu.length; i++) {
			if(avg < stu[i]) { // [내가 보고있는 학생]이 평균을 넘겼니?
				num++;
			} else {
				System.out.println((i + 1) + "번은 평균점수 이하입니다.");
			}
		}
		
		System.out.println("평균점수이상을 받은 학생수는 " + num + "명");
		
		System.out.println("==================");
		
		// 3. 6등의 번호
		// --->> [ 최대값찾기 알고리즘 ] 활용
		int min = stu[0];
		int minIndex = 0;
		for(int i = 1; i < stu.length; i++) {
			if(min > stu[i]) {
				min = stu[i];
				minIndex = i;
			}
		}
		System.out.println("6등은 " + (minIndex + 1) + "번 입니다.");
		
		System.out.println("==================");
		
		// 4. 짝수번째 학생들의 총점
		int res = 0;
		for(int i = 0; i < stu.length; i++) {
			if(i % 2 == 1) {
				res+=stu[i];
			}
		}
		System.out.println("짝수번째 학생들의 총점은 " + res + "점 입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

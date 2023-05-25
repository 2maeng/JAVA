package class01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {

		// 선생님 풀이
		// 예외 처리는 마지막에 하는걸 습관 들이기
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		final int CNT = 3; // 상수화 대문자
		while(data.size() < CNT) {
			int num; // ★ SCOPE 이슈 ★
			try { // 예외가 발생할 것같은 부분에 걸기
				System.out.println("정수 입력) ");
				num = sc.nextInt();
			}
			catch(InputMismatchException e){
				sc.nextLine();
				System.out.println("정수를 제대로 입력해주세요!");
				continue;
			}
			data.add(num);
		}
		System.out.println(data);


		int i = 0;
		while(i < data.size()) {
			if(data.get(i) <= 0) {
				data.remove(i);
				continue;
			}
			i++;
		}
		System.out.println(data);

		int maxIndex = 0;
		int max = data.get(0);
		for(i = 1; i < data.size(); i++) {
			if(data.get(i) > max) {
				max = data.get(i);
				maxIndex = i;
			}
		}
		System.out.println("최대값 = " + max);
		System.out.println("인덱스 = " + maxIndex);
		data.remove(maxIndex);

		int sum = 0;
		for(int v : data) {
			sum+=v;
		}

		double avg = (sum * 1.0) / data.size();

		System.out.println("총합 = " + sum);
		System.out.println("평균 = " + avg);










	}

}

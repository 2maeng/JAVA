package class01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		while(true) {
			System.out.println("입력) ");
			int num = sc.nextInt();
			if(num == 0) {
				break;
			}
			data.add(num);
		}
		
		int sum = 0;

		for(int v : data) {
			sum += v;
		}
		double avg = sum * 1.0 / data.size();
		System.out.println("평균 : " + avg);
		
		// 처음부터 끝까지 돌면서
		// data의 모든 요소를 확인할거야
		// [ a b c ] 요소 b를 삭제
		// [ a c ] 삭제한 인덱스부터 재확인!
//		for(int i = 0; i < data.size(); i++) {
//			if(data.get(i) % 2 == 1) {
//				data.remove(i);
//				i--;
//			}
//		}
		
		int index = 0;
		while(index < data.size()) {
			if(data.get(index) % 2 == 1) {
				data.remove(index);
				continue;
			}
			
			
			index++;
		}
		System.out.println(data);
	}
	
}

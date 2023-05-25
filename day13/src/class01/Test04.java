package class01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		int index = 0;
		while(index < 10) {
			try {
				System.out.println("정수 입력) ");
				int num = sc.nextInt();
				data.add(num);
				index++;
			}
			catch(InputMismatchException e) {
				sc.nextLine(); // 버퍼에 남아있는 쓰레기값을 제거하는 코드
				System.out.println("정수로만 입력하셔야 합니다");
			}
		}
		
//		for(int i = 0; i < data.size(); i++) {
//			if(data.get(i) <= 0) {
//				data.remove(i);
//				i--;
//			}
//		}
		
		int index2 = 0;
		while(index2 < data.size()) {
			if(data.get(index2) <= 0) {
				data.remove(index2);
				continue;
			}
			index2++;
		}
		System.out.println(data);
		
		int max = Collections.max(data);
        System.out.println("최대값은 " + max);
        
        System.out.println(max + "의 인덱스는 " + "[" + data.indexOf(max) + "] 번");
		
        data.remove(data.indexOf(max));
        
		int sum = 0;
		double avg;
		for(int v : data) {
			sum += v;
		}
		avg = (sum * 1.0) / data.size();
		System.out.println("평균은 " + avg + "입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

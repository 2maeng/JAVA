package class01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		HashSet <Integer> data = new HashSet<Integer>();
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i < 10; i++) {
			data.add(rand.nextInt(15) + 1);
		}
		
		System.out.println("랜덤수는 " + data.size() + "개 생성되었고 \n" + data + " 입니다.");
		
		double avg;
		int num;
		int sum = 0;
		int cnt = 0;
		int dataSize = 0;
		while(true) {
			System.out.println("정수 입력 : ");
			num = sc.nextInt();
	
			if(num == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				dataSize++;
				data2.add(num);
				sum+=num;
			}
			if(num % 2 == 0) {
				cnt++;
			} else {
				data2.remove(data2.size() - 1);
			}
		}
		
		avg = (sum * 1.0) / dataSize;
		System.out.println("짝수의 개수는" + cnt + "개이고 \n" + data2 + "입니다.");
		System.out.println("현재까지 입력한 정수들의 평균은" + avg +"입니다.");
		
		
	}
	
}

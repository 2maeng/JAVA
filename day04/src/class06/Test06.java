package class06;

import java.util.Random;

public class Test06 {
	
	public static void test1() {
		Random rand = new Random();
		int r = rand.nextInt(10)+10;
		System.out.println("r : " + r);
		System.out.println("==================");
		
		int[] data = new int[r];
		for(int i = 0; i < data.length; i ++) {
			data[i] = rand.nextInt(10) + 1;
		}
		
		int sum = 0;
		for(int v : data) {
			sum+=v;
		}
		System.out.println("총합 : " + sum);
	}
	
	public static void main(String[] args) {
		
		test1();
		
	}
}

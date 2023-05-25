package class01;

import java.util.Random;

// "참조에 의한 호출" 활용
public class Test04 {
	// 버블정렬
	public static void sort(int[] data) {
		for(int a = 0; a < data.length; a++) {
			for(int i = 0; i < data.length-1; i++) {
				if(data[i] > data[i + 1]) {
					int tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {

		Random rand = new Random();
		int[] data = new int[30];
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(50) + 1;
		}
		sort(data);
		for(int v : data) {
			System.out.print(v + " ");
		}
	}
}

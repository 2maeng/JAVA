package class04;

public class Test01 {
	public static void main(String[] args) {

		// 내 풀이
		//		int a = 33;
		//		int b = 29;
		//
		//		int i = b;
		//		while(true) {
		//			System.out.println(i);
		//			i++;
		//			if(i == 34) {
		//				break;
		//			}
		//		}

		// 선생님 풀이
		int a = 33;
		int b = 29;

		if(a > b) {
			int tmp = a;
			a = b; 
			b = tmp;
		}

		int num = a;
//		int num = a > b ? b : a; // 최솟값
		while(true) {
			System.out.println(num + " ");
			num++;

			if(num > b) {
				break;
			}
		}

	}
}

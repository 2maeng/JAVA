package class07;

public class Test01 {
	public static void main(String[] args) {
		
		// 내 풀이
//		int a = 100;
//		int b = 200;
//		int data2 = b > a ? b : a;
//		System.out.println(data2);
		
		// 선생님 풀이
		int a = 100;
		int b = 200;
		int res = a > b ? a: b;
		System.out.println(res);
		
		// 내 풀이
//		int c = 9;
//		if(c % 2 == 0)System.out.println("E");
//		else System.out.println("O");
		
		// 선생님 풀이
		int c = 9;
		char res2 = c % 2 == 0 ? 'E' : 'O';
		System.out.println(res2);
	}
}

package class02;

public class Test02 {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 5;
		
		// 반복문은 조건식에따라 단 한 번도 동작하지 않을 수도 있다!
		// : 에러가 아님!
		while(a > b) {
			System.out.println("★");
			a--;
			b++;
		}
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}

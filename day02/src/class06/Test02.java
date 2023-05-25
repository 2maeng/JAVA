package class06;

public class Test02 {
	public static void main(String[] args) {

		//		for(int a = 5; a > 0; a--) { // 5번 반복 
		//			for(int i = 0; i < a; i++) { // a 보다 커지면 공백
		//				System.out.print("★");
		//			}
		//			System.out.println(" ");
		//		}

//		for(int a = 1; a < 6; a++) { // 5번 반복
//			for(int i = 5; i > a ; i--) { // a보다 크면 T -> 공백 
//				System.out.print(" ");
//			}for(int i = 0; i < a; i++) { // a보다 작아지면 T -> 별
//				System.out.print("★");
//			}
//			System.out.println(" ");
//		}
	
		for(int a = 1; a < 6; a+=2) {
			for(int i = 5; i > a; i-=2) {
				System.out.print(" ");
			}
			for(int i = 0; i < a; i++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
}

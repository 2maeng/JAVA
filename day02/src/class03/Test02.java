package class03;


// while문은
// "무한루프(반복문)"일때 활용함
public class Test02 {
	public static void main(String[] args) {

		// 프로그램엥서 무한루프는 위험함!
		// 웹개발에서,
		// 프로그램 동작은 '서버자원'을 사용함
		// '비용'이 발생함!

		//		int i = 0;
		//		while(1 < 10) {
		//			break; // break문을 만나면 해당 반복문이 "즉시" 종료됩니다!
		//			System.out.println("안녕!");
		//		}

		// ★★★★★ 무한루프는 반드시 "종료조건"이 필요함
		// : 에러가 아님. 주의필요!

		int i = 0;
		while(true) {
			// 아~ 이거 무한루프네?
			// "종료조건" 꼭 있어야되겠구나!
			System.out.println("안녕!");
			i++;
			if(i == 3) {
				break; 
				// break문은 "반복문"과 함께 사용
				// 해당 "반복문"을 "즉시" 종료
			}
			System.out.println("★");
		}
	}
}	

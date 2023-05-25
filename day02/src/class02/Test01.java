package class02;

// [반복문]
// 동일한 수행을 "여러번" 호출(사용) 해야할때 사용
public class Test01 {
	public static void main(String[] args) {

//		int i = 0;
//		while(i < 3) {
//			// 조건식이 참일때 수행
//			System.out.println("안녕하세요! :D");
//			
//			i++;
//			
//		// 닫는 블록에 닿으면, while(조건식)으로 되돌아갑니다!
//		} // 닫는 블록 } 을 뚫고 나가는 일은 결코 없다!

		int data = 10;
		while(data > 5) {
			System.out.println("현재 data: " + data);
			data-=3; // data = data - 3;
		}
		
		System.out.println("최종 data: " + data);
		
	}
}

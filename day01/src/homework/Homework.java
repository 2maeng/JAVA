package homework;

public class Homework {
	public static void main(String[] args) {
		
//		1. 월이 저장된 데이터(==변수)가 있습니다.
//		3, 4, 5 -> 봄
//		6, 7, 8 -> 여름
//		9, 10, 11 -> 가을
//		12, 1, 2 -> 겨울
		
		int month;
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄입니다");
		} else if(month == 6 || month == 7 || month == 8) {
			System.out.println("여름입니다");
		} else if(month == 9 || month == 10 || month == 11) {
			System.out.println("가을입니다");
		} else(month == 12 || month == 1 || month == 2) {
			System.out.println("겨울입니다");
		}
		
//		2. 나이가 저장된 변수가 있습니다.
//		나이가 8~19이면 1000원
//		20~65이면 2000원
//		나머지는 무료! 라고 출력
		
		int age;
		if(8 <= age && age <= 19) {
			System.out.println("1000원 입니다");
		} else if(20 <= age && age <= 65) {
			System.out.println("2000원 입니다");
		} else {
			System.out.println("나머지는 무료!");
		}
		
	}
}

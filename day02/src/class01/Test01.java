package class01;

public class Test01 {
	public static void main(String[] args) {

		int month = -25;// 월이 저장된 데이터

		String season; // 결과를 저장할 변수

		if(1 <= month && month <= 12) { // 유효한 범위입니까?

			if(3<=month && month <= 5) {
				season = "봄";
			} else if(month == 6 || month == 7 || month == 8) {
				season = "여름";
			} else if(9<=month && month <= 11) {
				season = "가을";
			} else {
				season = "겨울";
			}
			System.out.println("현재: " + season);
		} else {
			System.out.println("잘못된 값입니다!");
		}


	}
}

package class06;

public class Test03 {
	// 내 풀이
	//	public static void printGrade(int num) {
	//		if(80 <= num && num <=100) {
	//			System.out.println(num + "점은 A등급 입니다.");
	//		} else if(60 <= num && num <= 79) {
	//			System.out.println(num + "점은 B등급 입니다.");
	//		} else {
	//			System.out.println(num + "점은 C등급 입니다.");
	//		}
	//	}

	// 선생님 풀이
	public static void printGrade(int score) {
		if(score < 0 || 100 < score) {
			System.out.println("점수가 유효하지 않습니다. 확인이 필요합니다");
			return; // 함수를 즉시 종료 하겠습니다.
		} 
		
		char grade = 'C';
		if(80 <= score) {
			grade = 'A';
		} else if(60 <= score) {
			grade = 'B';
		} 
		System.out.println(score + "점은" + grade + "등급입니다.");
	}
	
	public static void main(String[] args) {

		printGrade(150);
		printGrade(68);
		printGrade(1);
	}
}

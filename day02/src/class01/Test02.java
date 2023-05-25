package class01;

public class Test02 {
	public static void main(String[] args) {
		int age = 27;
		int res;


		if(0 < age || age < 200) {
			System.out.println("유효하지않은 값입니다!");
		} else {

			if(8 <= age && age <= 19) {
				res = 1000;
			} else if(20 <= age && age <= 65) {
				res = 2000;
			} else {
				res = 0;
			}

			if(res == 0) {
				System.out.println("무료!");
			} else {
				System.out.println(res + "원입니다.");
			}
		}
	}
}


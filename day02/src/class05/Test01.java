package class05;

//[ 중첩 반복문 ] (이중for문)
// 구구단
// 별찍기
public class Test01 {
	public static void main(String[] args) {

		for(int a = 2; a <= 9; a++) {

			for(int i = 1; i <= 9; i++) {
				System.out.println(a + " x " + i + " = " + (a * i));
			}
			// 어? 복붙하네? 반복문써야되나?
			// 1 ~ 9까지 범위를 알고있다
		}

	}
}

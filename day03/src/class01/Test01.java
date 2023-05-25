package class01;

public class Test01 {
	public static void main(String[] args) {

		for(int a = 0; a < 3; a++) {

			for(int i = 0; i < 2 - a; i++) {
				System.out.print("+");
			}
			for(int j = 0; j <= 2*a; j++) {

				System.out.println("★");
			}

			System.out.println();
		}

	}
}

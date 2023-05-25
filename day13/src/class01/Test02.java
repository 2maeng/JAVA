package class01;

public class Test02 {

	public static void main(String[] args) {
		
		int[] data = new int[3];
		for(int i = 0; i < 3; i++) {
			data[i] = i;
		}
		try {
			System.out.println(data[2] / data[0]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 인덱스는 없는 인덱스입니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("0으로는 나누기가 불가능 합니다!");
		}
		finally {
			System.out.println("예외 발생 여부와 무관하게 항상 수행되는 코드");
		}

	}
	
}

package class01;

public class Test01 {

	public static void main(String[] args) {
		
		int[] data = new int[3];
		data[0] = 10;
		data[1] = 20;
		data[2] = 30;
		System.out.println(data);
		
		data[3] = 40; // 없는 공간을 만들어 데이터를 저장할 수 없다.
		System.out.println(data[3]);
		
	}
	
}

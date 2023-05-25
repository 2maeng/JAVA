package class01;

// ★★★★★ 유 지 보 수 ★★★★★
public class Test03 {
	public static void main(String[] args) {
		
		// 자판기를 만들건데, 음료가 3종류
		// 재고 데이터를 저장할 공간
		int[] data = new int[5]; // 음료 종류의 개수
		data[0] = 5;
		data[1] = 2;
		data[2] = 3;
		data[3] = 100; 

		for(int i = 0; i < data.length; i++) { // 배열요소의 개수
			System.out.println("음료" + (i + 1) + "은" + data[i] + "개 있습니다.");
		}

	}
}

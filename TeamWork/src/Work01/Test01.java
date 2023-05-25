package Work01;

public class Test01 {
	public static void main(String[] args) {

		// 다음 숫자들을 선택정렬을 이용해 오름차순 출력
		// 5 4 2 1 3
		// 정렬 전 : 5 4 2 1 3
		// 정렬 후 : 1 2 3 4 5
		int[] arr = {5, 4, 2, 1, 3};
		
		System.out.print("정렬 전 : ");
		for(int i = 0; i < arr. length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.print("정렬 전 : ");
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		
		
		
		
	}
}

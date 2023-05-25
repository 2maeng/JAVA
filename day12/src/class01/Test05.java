package class01;

import java.util.HashSet;
import java.util.Random;

public class Test05 {

	public static void main(String[] args) {
		
		// 선생님 풀이
		// 1개씩 10번 VS 10개를 1번
		// -> 어떤 자료형을 선택하는지?
		// 배열 < 컬렉션(배열 리스트, 집합)
		// 배열 리스트 < 집합
		// 집합은 순서 개념이 없다 
		HashSet<Integer> data = new HashSet<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			int num = rand.nextInt(15) + 1;
			data.add(num);
			System.out.println("랜덤수 : " + num);
		}
		
		System.out.println(data.size() + "개");
		System.out.println(data);
		
		// +) 만약, 정렬이 하고싶다면?
		// 집합 X -> 배열 리스트로 이동해서 정렬
		
	}
	
}

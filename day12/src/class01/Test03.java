package class01;

import java.util.HashSet;

public class Test03 {

	public static void main(String[] args) {
		
		// 추상 클래스
		// Set류의 부모 클래스
		HashSet<Integer> data = new HashSet<Integer>();
		
		// 집합(Set)
		// 1. 순서가 없음(index X)
		// 2. 중복 허용 X
		// 3. 다양한 자료형 저장 가능
		//	-> 그러나 이렇게 사용하지 않음!
		//	=> 제네릭 <> 함께 사용
		data.add(10);
		data.add(10);
		data.add(10);
		data.add(1234);
		data.add(1);
		data.add(2);
		data.add(12);
		data.add(13);
		data.add(11);
//		data.add("apple");
		System.out.println(data);
		System.out.println(data.size());
		
		
	}
	
}

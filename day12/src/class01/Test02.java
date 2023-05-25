package class01;

import java.util.ArrayList;

public class Test02 {

	public static void main(String[] args) {
		
		// 향상된 배열 == 배열 리스트
		// 1. 데이터를 마음대로 저장가능
		// 2. toString() 오버라이딩 -> 예쁘게 출력
		// 3. add(), remove(), clear(), size(), get(), ... 과 같은 다양한 기능의 메서드를 기본제공
		// 4. 서로 다른 자료형(타입)들도 저장가능
		//	=> 그러나, 반드시 서로 같은 자료형만 취급!!!
		//	=> 그래서 "강제성"을 부여하여 사용합니다.
		// ★ 제네릭<> : 일반화, 배열 리스트에 저장될 타입 강제
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		Integer i = new Integer(10);
		int ii = 10;
		
		data.add(10);
		data.add(0, 20);
		data.add(0, 30);
		data.clear();
		data.add(10);
		System.out.println(data.isEmpty());
		System.out.println(data);
		System.out.println(data.get(0));
		data.remove(0);
		System.out.println(data.size());
		
		data.add("사과");
		data.add(10);
		data.add(3.14);
		System.out.println(data);
		
	}
	
}

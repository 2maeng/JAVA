package class05;

public class Test02 {
	public static void main(String[] args) {
		
		// 변수 만들어보기
		// 1. 공간 2. 주소 3. 이름
		int data; // 변수 생성완료된 모습!
		// 여기까지가 변수의 필수 3요소
		
		// 이제, 변수가 생겼으니까
		// "데이터(값, value)"를 저장해볼까
		data = -321; // --->> [초기화]
		// = : 대입 연산자
		
		System.out.println("data라는 이름의 변수에 저장된 값은");
		System.out.println(data);
		// 값이 저장된게 없는데, 어떻게 보여줘요
		// => "초기화"라는 작업을 해야함!
		// : 변수에 최초로 값을 저장하는 직업
		System.out.println("입니다");
		
		
		
		// [연습문제]
		// 문자열 "안녕하세요"를 저장하고싶어요.
		// 저장된 공간의 이름을 hello라고 해주세요.
		// 이 변수 hello를 활용하여 console창에 "안녕하세요"를 두번 출력하세요!
		
		String hello = "안녕하세요";
		System.out.println(hello);
		System.out.println(hello);

		
		
		
		
		
	}
}

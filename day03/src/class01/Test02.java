package class01;

// 변수 3요소, 함수 3요소,
// 주석, 가독성
// 연산자-우선순위
// 제어문 : 조건문, 반복문 <<--- 어떤 상황에 어떤 문법을 사용하는지!
// 디버깅표

// [ 배열 ]

public class Test02 {
	public static void main(String[] args) {

		// '배열'을 사용할수있는 상황이구나!
		int[] stu = new int[3];
		// new 연산 : 메모리에 공간을 생성해줘!
		
		// [ 인덱스 ] 
		// [ index ]
		// ★ 0부터 시작 함 ★
		stu[0] = 20;
		stu[1] = 50;
		stu[2] = 75;
		
		for(int i = 0; i <= 3; i++) {
			System.out.println("학생 1의 점수는 " + stu[i] + "점입니다.");
		}

	}
}

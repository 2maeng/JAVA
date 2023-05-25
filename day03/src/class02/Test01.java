package class02;

public class Test01 {
	public static void main(String[] args) {
		
		// 상황) 학생 N며
		// 총점수합
		// 평균점수
		// 1등이 몇번인지?
		
		int[] stu = new int[5];
		stu[0] = 20;
		stu[1] = 44;
		stu[2] = 66;
		stu[3] = 68;
		stu[4] = 93;
		
		// 출력
		System.out.println("=== 학생 명단");
		for(int i = 0; i < stu.length; i++) {
			System.out.println("학생" + (i + 1) + "번은 " + stu[i] + "점 입니다.");
		}
		System.out.println("==================");
		
		// 총점수합
		int sum = 0;
		for(int i = 0; i < stu.length; i++) {
			sum+=stu[i];
		}
		System.out.println("총점은 " + sum + "점 입니다.");
		
		double avg = sum * 1.0 / stu.length; // 형변환(casting)
		System.out.println("평균점수는 " + avg + "점 입니다.");
		
		System.out.println("==================");
		
		
		// [최대값 찾기 알고리즘]
		
		int max = stu[0]; // 현재 최대값이[0]에 존재하는 값이다!
		int maxIndex = 0; // 최대값이 저장된 index를 기억할 변수
		
		// [1]부터 차례대로 '현재 최대값'과 비교
		for(int i = 1; i < stu.length; i++) {
			if(max < stu[i]) { // 최대값이 현재비교값보다 작다면,
				// 변화 발생!
				max = stu[i];
				maxIndex = i;
			}
		}
		System.out.println("1등은 " + (maxIndex + 1) + "번 학생이고, 점수는 " + max + "점 입니다.");
		
		
		
		
		
		
	}
}

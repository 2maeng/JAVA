package class03;

// 내 풀이
public class Test01 {
	public static void main(String[] args) {
		
		// 학생 6명
		// 29 99 30 
		// 22 87 57

		// 평균점수
		// 평균을 넘긴 학생 수
		// 6등의 번호
		// 짝수번째 학생들의 총점
		// 평균을 못넘긴 학생들의 번호
		
		int[] stu = new int[6];
		stu[0] = 29;
		stu[1] = 99;
		stu[2] = 30;
		stu[3] = 22;
		stu[4] = 87;
		stu[5] = 57;
		
		// 평균점수
		int sum = 0;
		for(int i = 0; i < stu.length; i++) {
			sum+=stu[i];
		}
		int avg = sum / stu.length;
		System.out.println("평균점수는 " + avg + "점");
		
		System.out.println("==================");
		
		// 평균을 넘긴 학생 수
		int cnt = 0;
		for(int i = 0; i < stu.length; i++) {
			if(avg < stu[i]) {
				cnt++;
			}
		}
		System.out.println(cnt + "명 입니다");
		
		System.out.println("==================");
		
		// 6등의 번호
		int min = stu[0];
		int minIndex = 0;
		for(int i = 1; i < stu.length; i++) {
			if(min > stu[i]) {
				min = stu[i];
				minIndex = i;
			}
		}
		System.out.println("6등의 번호는 " + (minIndex + 1) + "번 학생입니다.");
		
		System.out.println("==================");
		
		// 짝수번째 학생들의 총점
		int sum2 = 0;
		for(int i =  0; i < stu.length; i++) {
			if(i % 2 == 1) {
				sum2+=stu[i];
			}
		}
		System.out.println("짝수번째 학생들의 총점은 " + sum2 + "점 입니다.");
	}
}

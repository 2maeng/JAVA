package class01;

public class Test03 {
	public static void main(String[] args) {
		
		int h = 3;
		int m = 47;
		
		System.out.println(h + "시" + m + "분의 1시간 20분 전 시간은");
		
		h--;
		m = m - 20; // m-=20; 복합대입 연산자
		
		if(m < 0) {
			m+=60;
			h--;
		}
		
		if(h < 1) {
			h+=12;
		}
		
		System.out.println(h + "시" + m + "분입니다.");
		
	}
}

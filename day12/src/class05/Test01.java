package class05;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
	private int num; // PK
	private String name;
	private int score;
	
	Student(int num, String name){
		this.num = num;
		this.name = name;
		Random rand = new Random();
		this.score = rand.nextInt(101);
	}
	
	void test() {
		Random rand = new Random();
		this.score = rand. nextInt(101);
		System.out.println(this.name + "학생은" + score + "점 입니다.");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return this.num + "번 학생 " + this.name + " " + this.score + "점";
	}
	
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 몇 명 출력할지 모르기에
		ArrayList<Student> data = new ArrayList<Student>();
		int numPK = 1001; // 1001번부터 순서대로 부여, 안정성을 위해 지정
		// PK "사용자"로부터 입력받는 경우, 반드시 "중복 검사"를 해야함!
		// ex) ID
		while(true) {
			System.out.println("1. 학생목록 출력");
			System.out.println("2. 재시험 보기");
			System.out.println("3. 학생 추가");
			System.out.println("4. 학생 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.println("입력) ");
			int action = sc.nextInt();
			
			if(action == 1) {
				for(Student student : data) {
					System.out.println(student);
				}
			}
			else if(action == 2) {
				System.out.println("학생 번호 입력) ");
				int num = sc.nextInt();
				for(int i = 0; i < data.size(); i++) {
					if(num == data.get(i).getNum()) { // 배열에 있는 학생의 번호
						data.get(i).test();
						break;
					}
				}
			}
			else if(action == 3) {
				System.out.println("학생 이름 입력) ");
				String name = sc.next();
				data.add(new Student(numPK++, name));
			}
			else if(action == 4) {
				System.out.println("학생 번호 입력) ");
				int num = sc.nextInt();
				for(int i = 0; i < data.size(); i++) {
					if(num == data.get(i).getNum()) { // 배열에 있는 학생의 번호
						data.remove(i);
						break;
					}
				}
			}
			else {
				break;
			}
		}
		
	}
	
}

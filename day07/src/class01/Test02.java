package class01;

import java.util.Random;

class Student{
	String name;
	int[] score;
	double avg;
	char grade;
	
	Student(String name){
		this(name, 2);
	}
	
	Student(String name, int cnt){
		this.name = name;
		this.score = new int[cnt];
		
		this.makeScore();
		
		System.out.println(this.name + "는 시험을" + this.score.length + "번 봅니다.");
	}
	
	void makeScore() {
		Random rand = new Random();
		int sum = 0;
		for(int i = 0; i < this.score.length; i++) {
			this.score[i] = rand.nextInt(101);
			sum+=this.score[i];
		}
		this.avg = sum * 1.0 / this.score.length;
		this.grade = 'C';
		if(this.avg >= 80.0) {
			this.grade = 'A';
		} else if(this.avg >= 60.0) {
			this.grade = 'B';
		}
	}
	
	void printInfo() {
		System.out.println(this.name);
		for(int i = 0; i < this.score.length; i++) {
			System.out.println((i + 1) + "번 시험" + this.score[i] + "점");
		}
		System.out.println("평균 : " + this.avg + "점 [" + this.grade + "]");
	}
	
	void test() {
		this.makeScore();
		
		System.out.println(this.name + "가 재시험을 봅니다.");
	}
	
}

public class Test02 {

	public static void main(String[] args) {
		
		Student s1 = new Student("럭스", 3);
		Student s2 = new Student("티모", 4);
		
		s1.printInfo();
		s2.printInfo();
	}
	
}

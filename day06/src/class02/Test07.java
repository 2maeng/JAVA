package class02;

class Car{
	String name;
	int speed;
	int max;
	
	// this() == 생성자 함수
	// 인자가 가장 많은 생성자 만들어놓고 다른 생성자가 가져다가 씀
	Car(){
		this("무명", 120);
		System.out.println("확인 1");
	}

	Car(String name){
		this(name, 120);
		System.out.println("확인 2");
	}
	
	Car(String name, int max){
		this.name = name;
		this.speed = 0;
		this.max = max;
		System.out.println("확인 3");
	}
	
	void printInfo() {
		System.out.println(this.name + "님의 차는 [" + this.speed + "/" + this.max + "] 입니다.");
	}
	
	void speedUp()	{
		this.speed+=100;
		if(this.speed>this.max) {
			this.speed = this.max;
			System.out.println("과속");
		}
	}
	
	void speedUp(int speed) { // 오버로딩
		this.speed+=speed;
		if(this.speed>this.max) {
			this.speed = this.max;
			System.out.println("과속!");
		}
	}
	
	void speedDown() {
		this.speed = 5;
		if(this.speed <= 0) {
			this.speed = 0;
			System.out.println("정지");
		}
	}
}

public class Test07 {
	
	public static void main(String[] args) {
		
		Car c1 = new Car();
		Car c2 = new Car("홍길동");
		Car c3 = new Car("아무무", 200);
		
		c1.printInfo();
		c1.speedDown();
		c2.printInfo();
		c2.speedUp();
		c2.speedUp();
		c2.speedUp();
		c3.printInfo();
		
	}
}

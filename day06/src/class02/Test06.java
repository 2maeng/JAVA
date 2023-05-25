package class02;

class Car{
	String name;
	int slow;
	int speed;

	
	Car(String name, int slow, int speed){
		this.name = name;
		this.slow = slow;
		this.speed= speed;
	}
	
	Car(){
		this.name = "무명";
		this.slow = 0;
		this.speed = 120;
	}
	
	Car(String name){
		this.name = name;
		this.slow = 0;
		this.speed = 120;
	}
	
	
	Car(String name, int speed){
		this.name = name;
		this.slow = 0;
		this.speed = 200;
	}
	
	void speedUp() {
		if(this.slow == 0 && this.speed < 120) {
			System.out.println("부스터!");
			this.slow = 100;
			System.out.println(this.name + "님의 차는" + " /" + this.slow + "/" + this.speed);
		} else if(this.speed > 120) {
			System.out.println("과속!");
			this.speed = 120;
			System.out.println(this.name + "님의 차는" + " /" + this.slow + "/" + this.speed);
		}
	}
	
	void speedDown() {
		if(this.slow == 5) {
			System.out.println("감속");
			this.slow = 0;
			System.out.println("정지");
			System.out.println(this.name + "님의 차는" + " /" + this.slow + "/" + this.speed);
		} else if(this.slow > 0) {
			System.out.println("감속!");
			this.slow-=10;
			System.out.println(this.name + "님의 차는" + " /" + this.slow + "/" + this.speed);
		}
		
	}
	
	
	void printInfo() {
		System.out.println(this.name + "님의 차는" + " /" + this.slow + "/" + this.speed);
	}
}

public class Test06 {
	public static void main(String[] args) {
		
		Car audi = new Car("김임형", 5, 120);
		Car benz = new Car("홍길동");
		Car bmw = new Car("아무무", 200);
		
		audi.printInfo();
		audi.speedDown();
		benz.printInfo();
		bmw.printInfo();
		bmw.speedUp();
		
	}
}

package class02;

// 클래스
class Book{
	// 멤버 변수
	String title;
	int price;
	int cnt;
	
	
	Book(String title, int price, int cnt){
		this.title = title;
		this.price = price;
		this.cnt = 0;
		System.out.println(title + " 생성완료");
	}
	
	Book(String title, int price, int cnt){
		this.title = title;
		this.price = price;
		this.cnt = cnt;
		System.out.println(title + " 생성완료");
	}
	
	// 메서드
	void printInfo() {
		System.out.println(this.title + "은(는)" + price + "원 입니다. 판매량 : " + cnt);
	}
	
	void sell() {
		cnt+=10;
		System.out.println(this.title + "판매 되었습니다.");
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Book b1 = new Book("어린왕자", 7800, 0); 
		Book b2 = new Book("해리포터", 23000, 0);
		Book b3 = new Book("자바부수기", 4000, 0);
		
		b1.printInfo();
		b2.printInfo();
		b3.sell();
		b3.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

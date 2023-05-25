package model;

// 음료 데이터 그 자체를 의미
// 멤버변수 + getter, setter
// toString() 오버라이딩
// 생성자(오버로딩)
public class BeverageVO {
	private int num;
	private String name;
	private int price;
	private int cnt;
	
	// 음료 생성자
	BeverageVO(int num, String name, int price){
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = 10;
		System.out.println(this.num + "번 " + this.name + 
				" " + this.price + "원 " + "[" + this.cnt + "개] 생성완료" );
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		if(this.cnt == 0) {
			return this.num + "번 " + this.name + " " + this.price + "원 " + "[품절]";
		}
		return this.num + "번 " + this.name + " " + this.price + "원 " + "[" + this.cnt + "개]"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

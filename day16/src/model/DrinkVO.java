package model;

public class DrinkVO {
	private int num;
	private String name;
	private int price;
	private int cnt;
	
	public DrinkVO(int num, String name, int price, int cnt) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
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
		String msg = num + "번 " + name + " " + price + "원 ";
		if(this.cnt == 0) {
			msg += "[X]";
		}
		else {
			msg += "["+cnt+"개]";
		}
		return msg;
	}
	
	@Override
	public boolean equals(Object obj) {
		DrinkVO drinkVO = (DrinkVO)obj;
		if(this.num == drinkVO.num) { // 내 PK == 비교대상자 PK
			return true;
		}
		return false;
	}



}
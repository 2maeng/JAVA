package model;

public class ProductVO {
	private int num; // PK
	private String name;
	private int price;
	private int cnt; // 조회수
	
	public ProductVO(int num,String name,int price,int cnt) {
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
		String msg = num + ". " + name + " " + price + "원 [" + cnt + "]";
		if(cnt == 0) {
			msg += "품절]";
		}
		else {
			msg += cnt + "]";
		}
		return msg;
	}
	
}

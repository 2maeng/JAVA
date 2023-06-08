package class02;

public class ItemVO {
	private int num; 
	private String name;
	private String price;
	
	public ItemVO(int num, String name, String price) {
		this.num = num;
		this.name = name;
		this.price = price;
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
	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.num + "번 " + this.name + " 상품 [" + this.price + "원]";
	}
	
}

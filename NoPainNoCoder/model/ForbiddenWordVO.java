package model;

public class ForbiddenWordVO {
	
	private int num; //PK
	private String block; // 금지어
	
	public ForbiddenWordVO(int num, String block) {
		this.num=num;
		this.block=block;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	
}

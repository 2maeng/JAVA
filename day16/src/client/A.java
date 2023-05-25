package client;

import java.util.ArrayList;

class B{
	private int b;
	
	B(int b){
		this.b = b;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return this.b + "b";
	}
	
	
}

public class A {

	public static void main(String[] args) {
		
		ArrayList<B> datas = new ArrayList<B>();
		for(int i = 1; i <= 5; i++) {
			datas.add(new B(i));
		}
		
		System.out.println(datas);
		
		for(B v : datas) { // 1차 시도 datas.get(0) == v
			if(v.getB() == 2) {
				v.setB(100);
			}
			System.out.println(v);
		}
		
		System.out.println("====");
		for(int i = 0; i < datas.size(); i ++) {
			if(datas.get(i).getB() == 3) {
				datas.get(i).setB(200);
			}
			System.out.println(datas.get(i));
		}
		
		
		
	}
	
}

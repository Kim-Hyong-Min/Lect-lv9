package System;

public class Cha {
	// 차 이름, 가격 , 옵션 , 수량
	private String name;
	private int price;
	private int option1; // cold/hot
	private int option2; // ice
	private int option3; // sweet
	private int num;
	
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
	public int getOption1() {
		return option1;
	}
	public void setOption1(int option1) {
		this.option1 = option1;
	}
	public int getOption2() {
		return option2;
	}
	public void setOption2(int option2) {
		this.option2 = option2;
	}
	public int getOption3() {
		return option3;
	}
	public void setOption3(int option3) {
		this.option3 = option3;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}

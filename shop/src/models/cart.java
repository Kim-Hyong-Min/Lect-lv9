package models;

import java.util.ArrayList;

public class cart {
	private String items;
	private int userCode;
	private int categoryCode;
	private int itemCode;
	private int itemNum;
	private int totalPrice;
	
	
	private cart (){
	}
	
	public cart (String items, int userCode, int categoryCode, int itemCode , int itemNum, int Price) {
		this.items = items;
		this.userCode = userCode;
		this.categoryCode = categoryCode;
		this.itemCode = itemCode;
		this.itemNum = itemNum;
		this.totalPrice += Price*itemNum;
	}
	
	public String getItems() {
		return this.items;
	}
	
	public int getUserCode() {
		return this.userCode;
	}
	
	public int getCategoryCode() {
		return this.categoryCode;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public int getItemNum() {
		return this.itemNum;
	}
	
	public int getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setItemNum(int num) {
		this.itemNum+=num;
	}
	
}

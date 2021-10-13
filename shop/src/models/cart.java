package models;

import java.util.ArrayList;

public class cart {
	private int userCode;
	private int categoryCode;
	private int itemCode;
	private int itemNum;
	private int totalPrice;
	
	
	private cart (){
	}
	public cart (int userCode, int categoryCode, int itemCode , int itemNum, int Price) {
		this.userCode = userCode;
		this.categoryCode = categoryCode;
		this.itemCode = itemCode;
		this.itemNum = itemNum;
		this.totalPrice += Price*itemNum;
	}
	
	
	//장바구니
	
}

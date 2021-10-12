package models;

import java.util.ArrayList;

class items {
	private int itemCode;
	private String items;
	private int price;
	private int cnt;
	
	private items() {
	}
	
	public items(String items, int price, int cnt, int itemCode) {
		this.items = items;
		this.price = price;
		this.cnt = cnt;
		this.itemCode = itemCode;
	}
	
	public String getItems() {
		return this.items;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getCnt() {
		return this.cnt;
	}
	
}

public class item {
	private String category;
	private int categoryCode;
	ArrayList<items>list = new ArrayList<>();
	
	private item() {
	}
	
	public item(String category, int categoryCode) {
		this.category = category;
		this.categoryCode = categoryCode;
	}
	
	public item(items items) {
		this.list.add(items);
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public int getCategoryCode() {
		return this.categoryCode;
	}
	
	public int getListSize() {
		return this.list.size();
	}
	
	
}

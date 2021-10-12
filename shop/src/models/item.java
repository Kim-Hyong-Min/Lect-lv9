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
	
	
	public String getCategory() {
		return this.category;
	}
	
	public ArrayList getList() {
		return this.list;
	}
	
	public int getCategoryCode() {
		return this.categoryCode;
	}
	
	public int getListSize() {
		return this.list.size();
	}
	
	public String getItems(int idx) {
		return this.list.get(idx).getItems();
	}
	
	public int getItemCode(int idx) {
		return this.list.get(idx).getItemCode();
	}
	
	public int getPrice(int idx) {
		return this.list.get(idx).getPrice();
	}
	
	public int getCnt(int idx) {
		return this.list.get(idx).getCnt();
	}
	
	public void setItem(String items, int price, int cnt, int itemCode) {
		items data = new items(items, price, cnt, itemCode);
		this.list.add(data);
	}
	
	public void setItem(int idx) {
		this.list.remove(idx);
	}
}

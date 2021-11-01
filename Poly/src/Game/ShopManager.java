package Game;

import java.util.Vector;

public class ShopManager {
	Vector<Inventory>inven = new Vector<>();
	Vector<Shop>shop = new Vector<>();
	
	public void shopSet() {
		Shop item = new Shop("´ë°Ë", 1001, 150, 50, 0, 0, 0);
		shop.add(item);
		item = new Shop("È­¿°°Ë", 1002, 300, 80, 0, 0, 0);
		shop.add(item);
		item = new Shop("´ÙÀÌ¾Æ°Ë", 1003, 550, 120, 0, 0, 0);
		shop.add(item);
		item = new Shop("Ã¶°©¿Ê", 2001, 100, 0, 300, 0, 0);
		shop.add(item);
		item = new Shop("»ç½½°©¿Ê", 2002, 300, 0, 500, 0, 0);
		shop.add(item);
		item = new Shop("È­¿°°©¿Ê", 2003, 500, 0, 1000, 0, 0);
		shop.add(item);
		item = new Shop("¸¶¹ýÆÈÂî", 3001, 200, 0, 0, 10, 0);
		shop.add(item);
		item = new Shop("ÀºÆÈÂî", 3002, 350, 0, 0, 50, 0);
		shop.add(item);
		item = new Shop("±ÝÆÈÂî", 3003, 700, 0, 0, 100, 0);
		shop.add(item);
		item = new Shop("»¡°£Æ÷¼Ç", 4001, 50, 0, 0, 0, 100);
		shop.add(item);
		item = new Shop("ÆÄ¶õÆ÷¼Ç", 4002, 100, 0, 0, 0, 300);
		shop.add(item);
		item = new Shop("°ËÁ¤Æ÷¼Ç", 4003, 200, 0, 0, 0, 500);
		shop.add(item);
	}
	
	public void printShopList() {
		for(int i=0; i<this.shop.size(); i++) {
			if(this.shop.get(i).getItemCode()/1000==1) { // ¹«±â
				
			}
			else if(this.shop.get(i).getItemCode()/1000==2) { // ¹æ¾î±¸
				
			}
			else if(this.shop.get(i).getItemCode()/1000==3) { // ÆÈÂî
				
			}
			else if(this.shop.get(i).getItemCode()/1000==4) { // Æ÷¼Ç
				
			}
		}
	}
	
	public void shopMenu() {
		
	}
}

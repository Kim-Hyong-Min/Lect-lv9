package Game;

import java.util.Vector;

public class ShopManager {
	Vector<Inventory>inven = new Vector<>();
	Vector<Shop>shop = new Vector<>();
	
	public void shopSet() {
		Shop item = new Shop("���", 1001, 150, 50, 0, 0, 0);
		shop.add(item);
		item = new Shop("ȭ����", 1002, 300, 80, 0, 0, 0);
		shop.add(item);
		item = new Shop("���̾ư�", 1003, 550, 120, 0, 0, 0);
		shop.add(item);
		item = new Shop("ö����", 2001, 100, 0, 300, 0, 0);
		shop.add(item);
		item = new Shop("�罽����", 2002, 300, 0, 500, 0, 0);
		shop.add(item);
		item = new Shop("ȭ������", 2003, 500, 0, 1000, 0, 0);
		shop.add(item);
		item = new Shop("��������", 3001, 200, 0, 0, 10, 0);
		shop.add(item);
		item = new Shop("������", 3002, 350, 0, 0, 50, 0);
		shop.add(item);
		item = new Shop("������", 3003, 700, 0, 0, 100, 0);
		shop.add(item);
		item = new Shop("��������", 4001, 50, 0, 0, 0, 100);
		shop.add(item);
		item = new Shop("�Ķ�����", 4002, 100, 0, 0, 0, 300);
		shop.add(item);
		item = new Shop("��������", 4003, 200, 0, 0, 0, 500);
		shop.add(item);
	}
	
	public void printShopList() {
		for(int i=0; i<this.shop.size(); i++) {
			if(this.shop.get(i).getItemCode()/1000==1) { // ����
				
			}
			else if(this.shop.get(i).getItemCode()/1000==2) { // ��
				
			}
			else if(this.shop.get(i).getItemCode()/1000==3) { // ����
				
			}
			else if(this.shop.get(i).getItemCode()/1000==4) { // ����
				
			}
		}
	}
	
	public void shopMenu() {
		
	}
}

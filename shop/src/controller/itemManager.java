package controller;

import java.util.ArrayList;

import models.item;
import models.shop;

public class itemManager {
	public static itemManager instance = new itemManager();
	
	ArrayList<item>items = new ArrayList<>();
	//ī�װ� ���� - ��ü ī�װ�, ī�װ� �߰�, ī�װ� ����
	public void printManage() {
		System.out.println("1.ī�װ� ����\n2.������ ����\n3.��ٱ��� ����");
	}
	
	
	public void printAllCategory() {
		if(this.items.size()>0) {
			for(int i=0; i<this.items.size(); i++) {
				System.out.println((i+1)+". "+this.items.get(i).getCategory()+" / ������ ���� : "+this.items.get(i).getListSize());
			}
		}
		else System.out.println("ī�װ��� �������� �ʽ��ϴ�.");
	}
	
	
	//ī�װ� �߰�
	public void categoryAdd() {
		System.out.print("ī�װ��� �Է� : ");
		String name = shop.sc.next();
		
		if(this.items.size()==0) {
			int rNum = shop.rn.nextInt(899)+100;
			item cate = new item(name, rNum);
			this.items.add(cate);
			System.out.println("�߰� �Ϸ�!");
		}
		else {
			int check = -1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getCategory().equals(name)) {
					check = i;
				}
			}
			
			if(check == -1) {
				while(true) {
					int rNum = shop.rn.nextInt(899)+100;
					int rNumCheck = -1;
					for(int i=0; i<this.items.size(); i++) {
						if(this.items.get(i).getCategoryCode() == rNum) {
							rNumCheck = i;
						}
					}
					if(rNumCheck==-1) {
						item cate = new item(name, rNum);
						this.items.add(cate);
						System.out.println("�߰� �Ϸ�!");
						break;
					}
				}
			}
			else System.out.println("�ߺ��� ī�װ��� �����մϴ�.");
		}
	}
	
	//ī�װ� ����
	public void categoryRemove() {
		if(this.items.size()>0) {
			System.out.print("ī�װ��� �Է� : ");
			String name = shop.sc.next();
			int check = -1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getCategory().equals(name)) {
					check = i;
				}
			}
			if(check != -1) {
				this.items.remove(check);
				System.out.println("���� �Ϸ�!");
			}
			else System.out.println("�Է��Ͻ� ī�װ��� �������� �ʽ��ϴ�.");
			
		}
		else System.out.println("�Էµ� ī�װ��� �������� �ʽ��ϴ�.");
	}
	
	//������ ���� - ��ü ������, ������ �߰�, ������ ����
		
	//��ٱ��� ���� - ��ü ��ٱ���, ��ü �����, 
	
	
}

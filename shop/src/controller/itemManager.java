package controller;

import java.util.ArrayList;

import models.item;
import models.shop;

public class itemManager {
	public static itemManager instance = new itemManager();
	private int num = -1;
	
	ArrayList<item>items = new ArrayList<>();
	//ī�װ� ���� - ��ü ī�װ�, ī�װ� �߰�, ī�װ� ����
	public void manageMenu() {
		while(true) {
			printManage();
			String menu = shop.sc.next();
			if(this.num==-1) { // ��ü �Ŵ�
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //ī�װ� ����
						this.num=1;
					}
					else if(num == 2) { //������ ����
						this.num=2;
					}
					else if(num == 3) { //��ٱ��� ����
						this.num=3;
					}
					else if(num == 4) { //�ڷΰ���
						break;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==1){// ī�װ�
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //ī�װ� �߰�
						categoryAdd();
					}
					else if(num == 2) { //ī�װ� ����
						categoryRemove();
					}
					else if(num == 3) { //��ü ī�װ�
						printAllCategory();
					}
					else if(num == 4) { //�ڷΰ���
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==2){
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //������ �߰�
						itemMenu(num);
					}
					else if(num == 2) { //������ ����
						itemMenu(num);
					}
					else if(num == 3) { //��ü ������
						printAllItem();
					}
					else if(num == 4) { //�ڷΰ���
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==3){
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //��ٱ��� �߰�
						
					}
					else if(num == 2) { //��ٱ��� ����
						
					}
					else if(num == 3) { //��ٱ��� ����
						
					}
					else if(num == 4) { //�ڷΰ���
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
		}
	}
	
	public void printManage() {
		if(this.num==-1) {
			System.out.println("1.ī�װ� ����\n2.������ ����\n3.��ٱ��� ����\n4.�ڷΰ���");
		}
		else if(this.num==1) {
			System.out.println("1.ī�װ� �߰�\n2.ī�װ� ����\n3.��ü ī�װ�\n4.�ڷΰ���");
		}
		else if(this.num==2) {
			System.out.println("1.������ �߰�\n2.������ ����\n3.��ü ������\n4.�ڷΰ���");
		}
		else if(this.num==3) {
			System.out.println("1.��ٱ��� �߰�\n2.��ٱ��� ����\n3.��ü ��ٱ���\n4.�ڷΰ���");
		}
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
	public void itemMenu(int menu) {
		if(this.items.size()>0) {
			for(int i=0; i<this.items.size(); i++) {
				System.out.println((i+1)+". "+this.items.get(i).getCategory());
			}
			System.out.print("��ȣ �Է� : ");
			String idx = shop.sc.next();
			try {
				int num = Integer.parseInt(idx)-1;
				
				if(num>=0 && num<this.items.size()) {
					if(menu == 1) {
						itemAdd(num);
					}
					else if(menu == 2) {
						itemRemove(num);
					}
				}
			}catch (Exception e) {
			}
			
		}
	}
	
	public void itemAdd(int idx) { // ������ �߰�
		System.out.print("�����۸� �Է� : ");
		String name = shop.sc.next();
		System.out.print("������ ���� �Է� : ");
		String cnt = shop.sc.next();
		System.out.print("������ ���� �Է� : ");
		String price = shop.sc.next();
		try {
			int num = Integer.parseInt(cnt);
			int money = Integer.parseInt(price);
			
			if(num>0 && money>0) {
				if(this.items.get(idx).getListSize()==0) {
					int rNum = shop.rn.nextInt(8999)+1000;
					this.items.get(idx).setItem(name, num, money, rNum);
					System.out.println("������ �߰� �Ϸ�!");
				}
				else {
					int check = -1;
					for(int i=0; i<this.items.get(idx).getListSize(); i++) {
						if(this.items.get(idx).getItems(i).equals(name)) {
							check = i;
						}
					}
					if(check == -1) {
						while(true) {
							int rNum = shop.rn.nextInt(8999)+1000;
							int rNumCheck = -1;
							for(int i=0; i<this.items.get(idx).getListSize(); i++) {
								if(this.items.get(idx).getItemCode(i) == rNum) {
									rNumCheck = i;
								}
							}
							if(rNumCheck ==-1) {
								this.items.get(idx).setItem(name, num, money, rNum);
								System.out.println("������ �߰� �Ϸ�!");
								break;
							}
						}
					}
					else System.out.println("�ߺ��Ǵ� ��ǰ�� ī�װ� ���� �����մϴ�.");
				}
			}
		}catch (Exception e) {
		}
	}
	
	public void itemRemove(int idx) { 
		if(this.items.get(idx).getListSize()>0) {
			System.out.print("�����۸� �Է� : ");
			String name = shop.sc.next();
			int check = -1;
			for(int i=0; i<this.items.get(idx).getListSize(); i++) {
				if(this.items.get(idx).getItems(i).equals(name)) {
					check = i;
				}
			}
			if(check!=-1) {
				this.items.get(idx).setItem(check);
				System.out.println("������ ���� �Ϸ�!");
			}
			else System.out.println("������ ��ǰ�� �����ϴ�.");
		}
		else System.out.println("�ش� ī�װ����� ��ǰ�� �����ϴ�.");
	}
	
	public void printAllItem() {
		if(this.items.size()>0) {
			int cnt = 1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getListSize()>0) {
					for(int j=0; j<this.items.get(i).getListSize(); j++) {
						System.out.println(cnt+". �����۸� : "+this.items.get(i).getItems(j)+" / ���� : "+this.items.get(i).getCnt(j)+"�� / ���� : "+this.items.get(i).getPrice(j)+"��");
						cnt++;
					}
				}
			}
		}
		else System.out.println("������ �������� �ʽ��ϴ�.");
	}
		
	//��ٱ��� ���� - ��ü ��ٱ���, ��ü �����, 
	
	
}

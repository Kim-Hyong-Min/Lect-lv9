package controller;

import java.util.ArrayList;

import models.item;
import models.shop;
import models.user;

public class itemManager {
	public static itemManager instance = new itemManager();
	private userManager um = userManager.instance;
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
					else if(num == 4) { //���� ����
						this.num=4;
					}
					else if(num == 5) { //�ڷΰ���
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
					if(num == 1) { // ��ü ��ٱ���
						printAllCart();
					}
					else if(num == 2) { // ��ٱ��� ����
						cartRemove();
					}
					else if(num == 3) { // ��ü ����
						printTotalMoney();
					}
					else if(num == 4) { //�ڷΰ���
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==4){
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { // ��ü ����
						um.allUser();
					}
					else if(num == 2) { // ���� �߰�
						um.joinUser();
					}
					else if(num == 3) { // ���� ����
						um.userRemove();
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
			System.out.println("1.ī�װ� ����\n2.������ ����\n3.�̰��� ��ǰ �� ���� ����\n4.���� ����\n5.�ڷΰ���");
		}
		else if(this.num==1) {
			System.out.println("1.ī�װ� �߰�\n2.ī�װ� ����\n3.��ü ī�װ�\n4.�ڷΰ���");
		}
		else if(this.num==2) {
			System.out.println("1.������ �߰�\n2.������ ����\n3.��ü ������\n4.�ڷΰ���");
		}
		else if(this.num==3) {
			System.out.println("1.��ü ��ٱ���\n2.��ٱ��� ����\n3.��ü ����\n4.�ڷΰ���");
		}
		else if(this.num==4) {
			System.out.println("1.��ü ����\n2.���� �߰�\n3.���� ����\n4.�ڷΰ���");
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
	
	//ī�װ� �ʱ�ȭ
	public void categorySet() {
		item cate = new item("����", 111);
		this.items.add(cate);
		cate = new item("����", 222);
		this.items.add(cate);
		cate = new item("����ǰ", 333);
		this.items.add(cate);
		cate = new item("������ǰ", 444);
		this.items.add(cate);
		
		this.items.get(0).setItem("�Ұ��", 100, 10000, 1111);
		this.items.get(0).setItem("�������", 100, 20000, 2222);
		this.items.get(1).setItem("����", 100, 5000, 3333);
		this.items.get(1).setItem("��ġ", 100, 8000, 4444);
		this.items.get(2).setItem("����", 100, 3000, 5555);
		this.items.get(2).setItem("ġ��", 100, 2000, 6666);
		this.items.get(3).setItem("����", 100, 1000, 7777);
		this.items.get(3).setItem("�����", 100, 500, 8888);
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
	
	public void printAllCart() {
		int check = 0;
		System.out.println("[��ٱ���]");
		for(int i=0; i<um.cart.size(); i++) {// ��ٱ��� ���
				check++;
				System.out.println(check+". "+um.cart.get(i).getItems()+" / ���� : "+um.cart.get(i).getItemNum()+"�� / ID : "+getUserId(um.cart.get(i).getUserCode()));
		}
		if(check==0) System.out.println("��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�.");
	}
	
	public String getUserId(int code) {
		String data = "";
		for(int i=0; i<um.users.size(); i++) {
			if(um.users.get(i).getUserCode()==code) {
				data=um.users.get(i).getId();
			}
		}
		return data;
	}
	
	
	public void cartRemove() {
		int check = 0;
		System.out.println("[��ٱ���]");
		for(int i=0; i<um.cart.size(); i++) {// ��ٱ��� ���
				check++;
				System.out.println(check+". "+um.cart.get(i).getItems()+" / ���� : "+um.cart.get(i).getItemNum()+"�� / ID : "+getUserId(um.cart.get(i).getUserCode()));
		}
		
		if(check!=0) {
			String idx = shop.sc.next();
			try {
				int num = Integer.parseInt(idx)-1;
				if(num>=0 && num<um.cart.size()) {
					um.cart.remove(num);
					System.out.println("���� �Ϸ�");
				}
				
			}catch (Exception e) {
			}
		}
		else {
			System.out.println("��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}
	
	public void printTotalMoney() {
		System.out.println("����� : "+shop.totalSales+"��");
	}
	
}

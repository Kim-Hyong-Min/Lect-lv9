package controller;

import models.cart;
import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	private int check = -1;
	//����
	
	private boolean finish() {
		if(this.check==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void run() {
		im.categorySet();
		while(finish()) {
			printMenu();
			menuSelect();
		}
	}
	//�޴�
	private void printMenu() {

		System.out.println("===="+shop.getName()+"====");
		if(shop.log!=-1) um.printLoginUser();
		if(this.cnt==-1) {
			System.out.println("1.����\n2.Ż��\n3.�α���\n4.�α׾ƿ�\n5.���� �Ŵ�\n6.������\n7.����");
		}
		else {
			System.out.println("1.����\n2.��ٱ��� ���\n3.�ڷΰ���");
		}
	}
	
	private void shoppingIn() {
		if(shop.log!=-1) {
			this.cnt = 1;
		}
		else System.out.println("�α��� �� �̿� �ٶ��ϴ�.");
	}
	
	//�Է�
	private void menuSelect() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(this.cnt==-1) {
				if(num == 1) { //����
					um.joinUser();
				}
				else if(num == 2) {//Ż��
					um.outUser();
				}
				else if(num == 3) {//�α���
					um.loginUser();
				}
				else if(num == 4) {//�α׾ƿ�
					um.logoutUser();
				}
				else if(num == 5) {//���� �Ŵ�
					shoppingIn();
				}
				else if(num == 6) {//������
					shop.log = -1;
					im.manageMenu();
				}
				else if(num == 7) {//����
					this.check = 1;
				}
				
			}
			else{
				if(num == 1) { //����
					shopping();
				}
				else if(num == 2) {//��ٱ��� ���
					cartMenu();
				}
				else if(num == 3) {//�ڷΰ���
					this.cnt=-1;
				}
			}
			
		}catch (Exception e) {
		}
	}
	
	
	// ����
	
	public void shopping() {
		if(im.items.size()>0) {
			printShoppingMenu();
			while(true) {
				String menu = shop.sc.next();
				try {
					int num = Integer.parseInt(menu)-1;
					
					if(num>=0 && num<im.items.size()) {//ī�װ� ����
						itemChoice(num);
						break;
					}
					else if(num==im.items.size()) {//�ڷΰ���
						break;
					}
					else System.out.println("�߸��� �Է� �Դϴ�.");
					
				}catch (Exception e) {
				}
			}
			
		}
		else System.out.println("����� ��ǰ�� �����ϴ�.");
	}
	
	public void itemChoice(int idx) {
		if(im.items.get(idx).getListSize()>0) {
			printItemMenu(idx);
			while(true) {
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu)-1;
				if(num>=0 && num<im.items.get(idx).getListSize()) {//������ ����
					itemNumChoice(idx, num);
					break;
				}
				else if(num==im.items.get(idx).getListSize()) {//�ڷΰ���
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			}catch (Exception e) {
			}
			}
		}
		else System.out.println("�ش� ī�װ��� ��ǰ�� �����ϴ�.");
	}
	
	public void printShoppingMenu() {
		System.out.println("[ī�װ�]");
		for(int i=0; i<im.items.size(); i++) {// ī�װ� ���
			System.out.println((i+1)+". ["+im.items.get(i).getCategory()+"]");
		}
		System.out.println((im.items.size()+1)+".[�ڷΰ���]");
		System.out.print("��ȣ �Է� : ");
	}
	
	// ��ǰ ���
	public void printItemMenu(int idx) {
		System.out.println("["+im.items.get(idx).getCategory()+"]");
		System.out.println("[��ǰ���]");
		for(int i=0; i<im.items.get(idx).getList().size(); i++) {// ��ǰ ���
			System.out.println((i+1)+". ["+im.items.get(idx).getItems(i)+"] ���� : "+im.items.get(idx).getCnt(i)+"�� / ���� : "+im.items.get(idx).getPrice(i)+"��");
		}
		System.out.println((im.items.get(idx).getListSize()+1)+".[�ڷΰ���]");
		System.out.print("��ȣ �Է� : ");
	}
	
	// ���� ����
	public void itemNumChoice(int cateIdx, int itemIdx) {
		System.out.print("���� ���� : ");
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			
			if(num>0 && num<=im.items.get(cateIdx).getCnt(itemIdx)) {
				if(um.cart.size()==0) {
					cart addItem = new cart(im.items.get(cateIdx).getItems(itemIdx), um.getUserCode(), im.items.get(cateIdx).getCategoryCode(), im.items.get(cateIdx).getItemCode(itemIdx), num, im.items.get(cateIdx).getPrice(itemIdx));
					im.items.get(cateIdx).setCnt(itemIdx, -num);// ��ǰ ���� ����
					um.cart.add(addItem);
					System.out.println("��ǰ�� ��ҽ��ϴ�!");
				}
				else {
					sameItemCheck(cateIdx, itemIdx, num);
				}
			}
			else System.out.println("�߸��� ���� �Դϴ�.");
			
		}catch (Exception e) {
		}
	}
	
	// �ߺ� üũ
	public void sameItemCheck(int cateIdx, int itemIdx, int num) {
		int check = -1;
		for(int i=0; i<um.cart.size(); i++) {// ��ٱ��� ���
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode() && um.cart.get(i).getCategoryCode()==im.items.get(cateIdx).getCategoryCode() && um.cart.get(i).getItemCode()==im.items.get(cateIdx).getItemCode(itemIdx)) {
				im.items.get(cateIdx).setCnt(itemIdx, -num);
				um.cart.get(i).setItemNum(num);
				check = i;
			}
		}
		
		if(check == -1) {
			cart addItem = new cart(im.items.get(cateIdx).getItems(itemIdx), um.getUserCode(), im.items.get(cateIdx).getCategoryCode(), im.items.get(cateIdx).getItemCode(itemIdx), num, im.items.get(cateIdx).getPrice(itemIdx));
			im.items.get(cateIdx).setCnt(itemIdx, -num);// ��ǰ ���� ����
			um.cart.add(addItem);
		}
	}
	
	
	// ��ٱ��� ���
	public void cartMenu() {
		System.out.println("1.��ٱ��� ����\n2.�����ϱ�\n3.��ǰ ����\n4.�ڷΰ���");
		while(true) {
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu);
				if(num == 1) { //��ٱ��� ����
					cart();
					break;
				}
				else if(num == 2) {//�����ϱ�
					cartPaying();
					break;
				}
				else if(num == 3) {//��ǰ����
					cartRemove();
					break;
				}
				else if(num == 4) {//�ڷΰ���
					break;
				}
				
			}catch (Exception e) {
			}
		}
	}
	
	//��ٱ��� ����
	
	public void cart() {
		if(um.cart.size()>0) {
			printCart();
		}
		else System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
	}
	
	public void printCart() {
		int check = 0;
		System.out.println("[��ٱ���]");
		for(int i=0; i<um.cart.size(); i++) {// ��ٱ��� ���
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". ǰ�� : "+um.cart.get(i).getItems()+"/ ���� : "+um.cart.get(i).getItemNum()+"/ ���� : "+um.cart.get(i).getTotalPrice());
			}
		}
		if(check==0) System.out.println("��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�.");
	}
	
	// �����ϱ�
	public void cartPaying() {
		int check = 0;
		System.out.println("[��ٱ���]");
		for(int i=0; i<um.cart.size(); i++) {
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". ǰ�� : "+um.cart.get(i).getItems()+"/ ���� : "+um.cart.get(i).getItemNum()+"/ ���� : "+um.cart.get(i).getTotalPrice());
			}
		}
		if(check==0) {
			System.out.println("��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
		else {
			System.out.println("���� ��ٱ��Ͽ� �ִ� ��ǰ�� ���� �Ͻðڽ��ϱ�?[Yes:1][No:2]");
			cartReset();
		}
	}
	
	public void cartReset() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(num == 1) {
				int total = 0;
				for(int i=0; i<um.cart.size(); i++) {
					if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
						shop.setTotalSales(um.cart.get(i).getTotalPrice());
						total+=um.cart.get(i).getTotalPrice();
						um.cart.remove(i);
					}
				}
				System.out.printf("�� �ݾ� : %d��\n���� �Ϸ�!\n",total);
			}
			else if(num == 2) {
				
			}
		}catch (Exception e) {
		}
	}
	
	
	// ��ٱ��� �޴� - ��ǰ ����
	public void cartRemove() {
		int check = 0;
		System.out.println("[��ٱ���]");
		for(int i=0; i<um.cart.size(); i++) {
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". ǰ�� : "+um.cart.get(i).getItems()+"/ ���� : "+um.cart.get(i).getItemNum()+"/ ���� : "+um.cart.get(i).getTotalPrice());
			}
		}
		System.out.println((check+1)+".[�ڷΰ���]");
		if(check==0) {
			System.out.println("��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
		else {
			System.out.print("��ȣ �Է� : ");
			String choice = shop.sc.next();
			try {
				int num = Integer.parseInt(choice)-1;
				if(num>=0 && num<check) {
					int cnt=0;
					for(int i=0; i<um.cart.size(); i++) {
						if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
							if(num==cnt) {
								um.cart.remove(i);
								System.out.println("���� �Ϸ�!");
								break;
							}
							cnt++;
						}
					}
				}
				else if(num==check) {
					
				}
			}catch (Exception e) {
			}
		}
	}
	
	
	
}

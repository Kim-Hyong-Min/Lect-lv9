package controller;

import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	
	//����
	public void run() {
		while(true) {
			printMenu();
			menuSelect();
		}
	}
	//�޴�
	private void printMenu() {
		System.out.println("===="+shop.getName()+"====");
		um.check();                                          //���� �˻繮
		System.out.println(cnt);
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
					im.manageMenu();
				}
				else if(num == 7) {//����
					
				}
				
			}
			else{
				if(num == 1) { //����
					
				}
				else if(num == 2) {//��ٱ��� ���
					
				}
				else if(num == 3) {//�ڷΰ���
					this.cnt=-1;
				}
			}
			
		}catch (Exception e) {
		}
	}
	
	
	// ����
	// ī�װ� ���
	// ī�װ� ����
	// ��ǰ ���
	// ��ǰ ����
	// ���� ����
	
	// ��ٱ��� ���
	// ��ٱ��� �޴� - ��ٱ��� ����, �����ϱ�, ��ǰ ����
}

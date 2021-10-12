package controller;

import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
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
		if(cnt==-1) {
			System.out.println("1.����\n2.Ż��\n3.�α���\n4.�α׾ƿ�\n5.������\n6.����");
		}
		else {
			System.out.println("1.����\n2.��ٱ��� ���\n3.�ڷΰ���");
		}
	}
	
	//�Է�
	private void menuSelect() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(shop.log==-1) {
				if(num == 1) { //����
					um.joinUser();
				}
				else if(num == 2) {//Ż��
					
				}
				else if(num == 3) {//�α���
					um.loginUser();
				}
				else if(num == 4) {//�α׾ƿ�
					um.logoutUser();
				}
				else if(num == 4) {//���� �Ŵ�
					this.cnt=1;
				}
				else if(num == 5) {//������
					
				}
				else if(num == 6) {//����
					
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
			System.out.println("�߸��� �Է� �Դϴ�.");
		}
	}
}

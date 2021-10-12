package controller;

import java.util.ArrayList;

import models.shop;
import models.user;

public class userManager {
	public static userManager instance = new userManager();
	private shopManager sm = shopManager.instance;
	private ArrayList<user>users = new ArrayList<>();
	
	//����
	public void check() {
		System.out.println(this.users.size());
		if(this.users.size()>0) {
			for(int i=0; i<this.users.size(); i++) {
				System.out.println(this.users.get(i).getId()+"/"+this.users.get(i).getUserCode());
			}
		}
	}
	
	public void joinUser() {
		System.out.print("ID �Է� : ");
		String id = shop.sc.next();
		System.out.print("PW �Է� : ");
		String pw = shop.sc.next();
		
		if(this.users.size()==0) {
			int rNum = shop.rn.nextInt(8999)+1000;//�ڵ�ο�
			user data = new user(id,pw,rNum);
			this.users.add(data);
			System.out.println("���� �Ϸ�!");
		}
		else {
			joinUserCheck(id, pw);
		}
	}
	
	private void joinUserCheck(String id, String pw) { // ���� �˻� �� ����ó��
		int check = -1;
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id)){
				check = i;
			}
		}
		if(check == -1) {
			while(true) {
				int rNum = shop.rn.nextInt(8999)+1000;//�ڵ�ο�
				int rNumCheck = -1;
				for(int i=0; i<this.users.size(); i++) {
					if(this.users.get(i).getUserCode()==rNum){
						rNumCheck = i;
					}
				}
				if(rNumCheck==-1) {
					user data = new user(id,pw,rNum);
					this.users.add(data);
					System.out.println("���� �Ϸ�!");
					break;
				}
			}
		}
		else System.out.println("�ߺ��� ���̵� �����մϴ�.");
	}
	
	//�α���
	public void loginUser() {
		if(shop.log==-1) {
			if(this.users.size()>0) {
				System.out.print("ID �Է� : ");
				String id = shop.sc.next();
				System.out.print("PW �Է� : ");
				String pw = shop.sc.next();
				
				int check = -1;
				for(int i=0; i<this.users.size(); i++) {
					if(this.users.get(i).getId().equals(id)){
						check = i;
					}
				}
				if(check != -1 && this.users.get(check).getPw().equals(pw)) {
					shop.log=check;
					System.out.println(id+"�� �α��� ����!");
				}
				else System.out.println("���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
				
			}
			else System.out.println("���Ե� �ο��� �����ϴ�.");
		}
		else System.out.println("�α��� ���Դϴ�.");
	}
	
	public void printLoginUser() {
		System.out.println(this.users.get(shop.log).getId()+"�� �α�����...");
	}
	
	//�α׾ƿ�
	public void logoutUser() {
		if(shop.log!=-1) {
			System.out.println(this.users.get(shop.log).getId()+"�� �α׾ƿ� ����!");
			shop.log = -1;
		}
		else System.out.println("�α��� �� �̿밡�� �մϴ�.");
	}
	
	//Ż��
	public void outUser() {
		if(this.users.size()>0) {
			if(shop.log!=-1) {
				System.out.println("Ż�� �Ͻðڽ��ϱ�?[Yes:1][No:2]");
				String select = shop.sc.next();
				try {
					int num = Integer.parseInt(select);
					if(num == 1) {
						this.users.remove(shop.log);
						shop.log=-1;
						System.out.println("Ż�� �Ϸ�!");
					}
					else if(num == 2) {
						System.out.println("���� �̿� ��Ź�帳�ϴ�~");
					}
					
				}catch (Exception e) {
					System.out.println("�߸��� �Է� �Դϴ�.");
				}
				
			}
			else System.out.println("�α��� �� �̿밡�� �մϴ�.");
		}
		else System.out.println("���Ե� �ο��� �����ϴ�.");
	}
	
	//�����ڸ�� - �������� : ��ü����, �����߰�, ��������
}

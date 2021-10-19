package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	public static Shop instance = new Shop();
	private Guild gd = Guild.instance;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Item>item = new ArrayList<>();
	
//	����
//	�� ����, ����, ����
	
	public void shopReset() {
		this.item.clear();
	}
	
	public void shopMenu() {
		while(true) {
			gd.printGuild();
			System.out.println("1.����\n2.����\n3.����\n4.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//����
					weapon();
				}
				else if(num==2) {//����
					armor();
				}
				else if(num==3) {//����
					ring();
				}
				else if(num==4) {//�ڷΰ���
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void weaponSet() {// �ʱ� ��������
		Item newItem = new Item("������", 1, 0, 100, 1001);
		item.add(newItem);
		newItem = new Item("ö��", 3, 0, 300, 1002);
		item.add(newItem);
		newItem = new Item("�����Ǿ�", 5, 0, 450, 1003);
		item.add(newItem);
		newItem = new Item("���", 7, 0, 600, 1004);
		item.add(newItem);
		newItem = new Item("���ð�", 9, 0, 800, 1005);
		item.add(newItem);
		newItem = new Item("Ȳ�ݰ�", 11, 0, 1000, 1006);
		item.add(newItem);
		newItem = new Item("ȭ���ǰ�", 15, 0, 1500, 1007);
		item.add(newItem);
	}
	
	public void armorSet() {// �ʱ� ��������
		Item newItem = new Item("���", 0, 1, 100, 2001);
		item.add(newItem);
		newItem = new Item("���׿�", 0, 2, 300, 2002);
		item.add(newItem);
		newItem = new Item("ö����", 0, 5, 450, 2003);
		item.add(newItem);
		newItem = new Item("���谩��", 0, 8, 600, 2004);
		item.add(newItem);
		newItem = new Item("Ȳ�ݰ���", 0, 10, 800, 2005);
		item.add(newItem);
		newItem = new Item("��񰩿�", 0, 12, 1000, 2006);
		item.add(newItem);
		newItem = new Item("���̾ư���", 0, 18, 1500, 2007);
		item.add(newItem);
	}
	
	public void ringSet() {// �ʱ� ��������
		Item newItem = new Item("��������", 1, 1, 200, 3001);
		item.add(newItem);
		newItem = new Item("ö����", 1, 2, 350, 3002);
		item.add(newItem);
		newItem = new Item("������", 2, 3, 600, 3003);
		item.add(newItem);
		newItem = new Item("�ݹ���", 4, 4, 850, 3004);
		item.add(newItem);
		newItem = new Item("�����̾����", 1, 8, 1000, 3005);
		item.add(newItem);
		newItem = new Item("���޶������", 10, 2, 1500, 3006);
		item.add(newItem);
		newItem = new Item("���̾ƹ���", 8, 8, 2000, 3007);
		item.add(newItem);
	}
	
	public void weapon() {//����
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==1) { // ���� �ڵ� üũ
				System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)�ڷΰ���\n",cnt+1);
		while(true) {
		System.out.print("��ȣ �Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==1) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
			
		}catch (Exception e) {
		}
		}
		
	}
	
	public void armor() {//����
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==2) { // ���� �ڵ� üũ
				System.out.printf("(%d) [%s] ���� : %d / ���� : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getDef(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)�ڷΰ���\n",cnt+1);
		while(true) {
		System.out.print("��ȣ �Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==2) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
			
		}catch (Exception e) {
		}
		}
	}
	
	public void ring() {//����
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==3) { // ���� �ڵ� üũ
				System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %d / ���� : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)�ڷΰ���\n",cnt+1);
		while(true) {
		System.out.print("��ȣ �Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==3) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
			
		}catch (Exception e) {
		}
		}
	}
}
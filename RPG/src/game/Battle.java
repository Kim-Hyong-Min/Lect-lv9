package game;

import java.util.ArrayList;

public class Battle {
	public static Battle instance = new Battle();
	public static ArrayList<Monster> Monster = new ArrayList<>();
	
	private void monsterSet() {
		Monster py = new Monster("����", 1, 15, 1, 1, 10);
		Monster.add(py);
		py = new Monster("���", 2, 20, 2, 2, 10);
		Monster.add(py);
		py = new Monster("����", 3, 25, 3, 3, 10);
		Monster.add(py);
		py = new Monster("ȣ����", 4, 30, 4, 4, 10);
		Monster.add(py);
		py = new Monster("������", 5, 35, 5, 6, 10);
		Monster.add(py);
		py = new Monster("�����", 6, 40, 6, 5, 10);
		Monster.add(py);
		py = new Monster("����", 7, 45, 7, 7, 10);
		Monster.add(py);
		py = new Monster("����", 8, 50, 8, 8, 10);
		Monster.add(py);
		py = new Monster("�Ǹ�", 9, 65, 9, 9, 10);
		Monster.add(py);
		py = new Monster("����", 10, 100, 10, 10, 10);
		Monster.add(py);
	}
	
	// ����� : 1,2/3,4/5,6/7,8,9/10
	
	public void battleMap() {
		System.out.println("1.�ʺ��� �����(Lv.1~2)\n2.��(Lv.3~4)\n3.Ȳ��(Lv.5~6)\n4.����(Lv.7~9)\n5.���ռ�(Lv.10)\n6.�ڷΰ���");
		while(true) {
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num>=1 && num<=5) {// �ʺ���
				
			}
			else if(num==6) {// �ڷΰ���
				
			}
			
		} catch (Exception e) {
		}
	}
	}
	
	public void battleStart(int num) { // 0,1 / 2,3 / 4,5 / 6,7,8 / 9
		if(num==1) {// �ʺ���
			
		}
		else if(num==2) {// ��
			
		}
		else if(num==3) {// Ȳ��
			
		}
		else if(num==4) {// ����
			
		}
		else if(num==5) {// ���ռ�
			
		}
		int rNum = Main.rn.nextInt();
	}
	
	public void battleUi() {
		
	}
	
	
	
	
}

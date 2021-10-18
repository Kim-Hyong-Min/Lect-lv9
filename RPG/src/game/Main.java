package game;
import java.util.Random;

public class Main {
	public static Random rn = new Random();
	public static Shop sp = new Shop();
	public static Guild gd = new Guild();
	private Unit ut = Unit.instance;
	
// ���θ޴�
// �� ������, ����, �κ��丮, ����, �ε�
	public void run() {
		ut.playerSet();
		gd.guildSet();
		sp.weaponSet();
		sp.armorSet();
		sp.ringSet();
		while(true) {
			gd.guildTitle();
			printMenu();
			menuInput();
		}
	}
	
	public void printMenu() {
		System.out.println("1.������\n2.����\n3.�κ��丮\n4.����\n5.�ε�\n6.����");
	}
	
	public void menuInput() {
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {//������
				gd.guildMenu();
			}
			else if(num==2) {//����
				sp.shopMenu();
			}
			else if(num==3) {//�κ��丮
				gd.inventoryMenu();
			}
			else if(num==4) {//����
				
			}
			else if(num==5) {//�ε�
				
			}
			else if(num==6) {//����
				
			}
			
		} catch (Exception e) {
		}
		
	}
	

	
//	��ȣ, �̸�, ����, ä��, ���ݷ�, ����, ��Ƽ����
	
	

	
//	��ȣ, �̸�, ���ݷ�, ����
	
//	�κ��丮
//	�� ����, �Ǹ�
	
//	�̸�, ����, ü��, ���ݷ�, ����, ��Ƽ����
//	����
//	��
//	����
	
	
//	����
//	���
//	�κ��丮
//	������
//	����
//	�÷��̾�
//	����
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
}
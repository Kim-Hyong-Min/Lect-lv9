package game;
import java.util.Random;

public class Main {
	public static Random rn = new Random();
	private Shop sp = Shop.instance;
	private Guild gd = Guild.instance;
	private Unit ut = Unit.instance;
	private file fl = file.instance;
	private boolean isRun = true;
	
// ���θ޴�
// �� ������, ����, �κ��丮, ����, �ε�
	public void run() {
		ut.playerSet();
		gd.guildSet();
		sp.weaponSet();
		sp.armorSet();
		sp.ringSet();
		while(isRun) {
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
				save();
				System.out.println("���� �Ϸ�!");
			}
			else if(num==5) {//�ε�
				load();
				System.out.println("�ҷ����� �Ϸ�!");
			}
			else if(num==6) {//����
				System.out.println("�����մϴ�");
				this.isRun = false;
			}
			
		} catch (Exception e) {
		}
		
	}
	
	
	public void save() {
		fl.guildSave();
		fl.playerSave();
		fl.itemSave();
		fl.inventorySave();
	}
	
	public void load() {
		fl.playerLoad();
		fl.itemLoad();
		fl.guildLoad();
		fl.inventoryLoad();
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
}
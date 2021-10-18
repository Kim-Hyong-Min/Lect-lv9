package game;
import java.util.ArrayList;

public class Guild {
	public static Guild instance = new Guild();
	private Unit ut = Unit.instance;
	ArrayList<Inventory> inven = new ArrayList<>();
	private String gulidName;
	private int playerCode;
	private int guildMoney;
	private final int maxParty = 4;
	
	Guild(){
	}
	
	public int getGuildMoney() {
		return this.guildMoney;
	}
	
	public void setGuildMoney(int itemCode, int money) {
		if(this.guildMoney-money>=0) {
			if(this.inven.size()==0) {
				this.guildMoney-= money;
				Inventory it = new Inventory(itemCode, 1);
				this.inven.add(it);
				System.out.println("���� �Ϸ�!");
			}
			else {
				int check = -1;
				for(int i=0; i<this.inven.size(); i++) {
					if(this.inven.get(i).getItemCode()== itemCode) {
						check = i;
					}
				}
				if(check != -1) {
					this.inven.get(check).setItemCnt(1);
					this.guildMoney-= money;
					System.out.println("���� �Ϸ�!");
				}
				else {
					Inventory it = new Inventory(itemCode, 1);
					this.inven.add(it);
					this.guildMoney-= money;
					System.out.println("���� �Ϸ�!");
				}
			}
			
		}
		else System.out.println("�����ݾ��� �����մϴ�.");
	}
	
	public void setGuildInven(int itemCode) {
		if(this.inven.size()==0) {
			Inventory it = new Inventory(itemCode, 1);
			this.inven.add(it);
		}
		else {
			int check = -1;
			for(int i=0; i<this.inven.size(); i++) {
				if(this.inven.get(i).getItemCode()== itemCode) {
					check = i;
				}
			}
			if(check != -1) {
				this.inven.get(check).setItemCnt(1);
			}
			else {
				Inventory it = new Inventory(itemCode, 1);
				this.inven.add(it);
			}
		}
	}
	
	public void guildTitle() {
		System.out.printf("========[%s]========\n",this.gulidName);
	}
	
	public void printGuildMoney() {
		System.out.printf("��� �����ݾ� : %dg\n",this.guildMoney);
	}
	
//	������
//	�� �����, �����߰�, ��������, ��Ƽ����ü, ����
	public void guildMenu() {
		while(true) {
			System.out.println("1.���� ���\n2.���� ����\n3.���� �ذ�\n4.����\n5.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//���� ���
					guildList();
				}
				else if(num==2) {//���� ����
					guildAdd();
				}
				else if(num==3) {//���� �ذ�
					guildRemove();
				}
				else if(num==4) {//����
					guildLineup();
				}
				else if(num==5) {//�ڷΰ���
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	
	public void guildSet(){ // ��� ������ ����Ʈ
		this.gulidName = "�׸���ǻ��";
		this.guildMoney = 100000;
	}
	
	public void inventoryMenu() {
		while(true) {
			System.out.println("1.��� ���\n2.��� �Ա�\n3.��� ����\n4.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//��� ���
					itemList();
				}
				else if(num==2) {//��� �Ա�
					ut.PlayerItemAdd();
				}
				else if(num==3) {//��� ����
					ut.PlayerItemRemove();
				}
				else if(num==4) {//�ڷΰ���
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void itemList(){ // ��� ������ ����Ʈ
		if(this.inven.size()>0) {
			for(int i=0; i<this.inven.size(); i++){
				for(int j=0; j<Shop.item.size(); j++) {
					if(this.inven.get(i).getItemCode()==Shop.item.get(j).getItemCode()) {
						if(this.inven.get(i).getItemCode()/1000==1) {//����
							System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %d��\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getAtk(), this.inven.get(i).getItemCnt());
						}
						else if(this.inven.get(i).getItemCode()/1000==2) {//����
							System.out.printf("(%d) [%s] ���� : %d / ���� : %d��\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getDef(), this.inven.get(i).getItemCnt());
						}
						else if(this.inven.get(i).getItemCode()/1000==3) {//����
							System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %d / ���� : %d��\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getAtk(), Shop.item.get(j).getDef(), this.inven.get(i).getItemCnt());
						}
					}
				}
			}
		}
		else System.out.println("�������� ��� �����ϴ�.");
	}
	
	public void guildList() {//���� ���
		System.out.println("====================================================================");
		System.out.printf("��ü ���� : %d��\n",ut.player.size());
		ut.allPlayer();
		System.out.println("====================================================================");
	}
	
	public void guildAdd() {//���� ����
		ut.playerAdd();
	}
	
	public void guildRemove() {//���� �ذ�
		ut.playerRemove();
	}
	
	public void guildLineup() {//����
		ut.PlayerLineUp();
	}
}